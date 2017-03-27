import React from 'react';

import BehandlingspunktStatus from 'constants/behandlingspunktStatus';
import { FOEDSELSVILKAARET, MEDLEMSVILKAARET, BEREGNING } from 'constants/behandlingspunktCodes';
import { getBehandlingspunktStatus } from 'helpers/behandlingspunktStatusHelper';
import ConfirmInformationForm, { getModel, rules } from 'components/behandlingspunkt/ConfirmInformationForm';

import * as foedselsvilkaaretBuilder from './foedselsvilkaaretBuilder';
import * as medlemsvilkaaretBuilder from './medlemsvilkaaretBuilder';
import * as beregningsgrunnlagBuilder from './beregningsgrunnlagBuilder';

const kodeTilBuilderMap = new Map();
kodeTilBuilderMap.set(FOEDSELSVILKAARET, foedselsvilkaaretBuilder);
kodeTilBuilderMap.set(MEDLEMSVILKAARET, medlemsvilkaaretBuilder);
kodeTilBuilderMap.set(BEREGNING, beregningsgrunnlagBuilder);

const createSubmitForm = url => ({
  code: 'submit',
  form: (model, errorMessages, readOnly) => <ConfirmInformationForm
    key="submit"
    code="submit"
    model={model}
    errorMessages={errorMessages}
    readOnly={readOnly}
    url={url}
  />,
  readOnly: false,
  model: getModel(),
  rules,
});

const getAksjonspunktData = (behandling, aksjonspunkter, builder) => {
  if (aksjonspunkter.length === 0) {
    return null;
  }

  const filtrerteAksjonspunkter = aksjonspunkter
    .map(ap => ({
      data: builder.getAksjonspunktData(ap.kode),
      ap,
    }))
    .filter(dataAndAp => dataAndAp.data)
    .map(dataAndAp => dataAndAp.data(behandling, dataAndAp.ap.id));

  const isSubmitNeeded = filtrerteAksjonspunkter.filter(apd => !apd.readOnly).length > 0;
  if (isSubmitNeeded) {
    return [...filtrerteAksjonspunkter, createSubmitForm(builder.getUrl())];
  }

  return filtrerteAksjonspunkter;
};

const findStatus = (behandlingspunkt) => {
  if (behandlingspunkt.aksjonspunkter.length > 0) {
    const statusAksjonspunkt = getBehandlingspunktStatus(behandlingspunkt.aksjonspunkter[0].status.kode);
    if (statusAksjonspunkt) {
      return statusAksjonspunkt;
    }
  }

  return getBehandlingspunktStatus(behandlingspunkt.statusKode);
};

const createResponse = (behandlingspunkt, aksjonspunkterData) => ({
  navn: behandlingspunkt.navn,
  merknad: behandlingspunkt.merknad,
  status: findStatus(behandlingspunkt),
  aksjonspunkterData,
});

export default function getBehandlingspunkter(behandling) {
  /* TODO (tor) definer rekkefølgen (kan truleg sortera etter id på server?) */
  return behandling.behandlingspunkter.map((bp) => {
    const builder = kodeTilBuilderMap.get(bp.typeKode);

    const aksjonspunkterData = getAksjonspunktData(behandling, bp.aksjonspunkter, builder);
    if (aksjonspunkterData) {
      return createResponse(bp, aksjonspunkterData);
    }

    const status = getBehandlingspunktStatus(bp.statusKode);
    if (status !== BehandlingspunktStatus.INNVILGET && status !== BehandlingspunktStatus.BEREGNET) {
      return createResponse(bp, [builder.getAvslaattData()]);
    }

    return createResponse(bp, [builder.getGodkjentData(behandling)]);
  });
}
