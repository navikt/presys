import React from 'react';

import { FOEDSEL_AP_1, FOEDSEL_AP_2, FOEDSEL_AP_3 } from 'constants/aksjonspunktCodes';
import { SAVE_BEHANDLINGPUNKT_SERVER_URL } from 'constants/serverApi';

import TermindatoForm, { getModel as getTermindatoModel, rules as termindatoRules } from 'components/behandlingspunkt/aksjonspunkt/TermindatoForm';
import FoedselForm, { getModel as getFoedselModel, rules as foedselRules } from 'components/behandlingspunkt/aksjonspunkt/FoedselForm';
import AntallBarnForm, { getModel as getAntallBarnModel, rules as antallBarnRules } from 'components/behandlingspunkt/aksjonspunkt/AntallBarnForm';

import TpsInformationView, { getModel as getTpsInfoModel } from 'components/behandlingspunkt/TpsInformationView';
import TempPlaceholderView from 'components/behandlingspunkt/TempPlaceholderView';

const aksjonspunktMap = new Map();
aksjonspunktMap.set(FOEDSEL_AP_1, (behandling, aksjonspunktId) => ({
  id: aksjonspunktId,
  code: FOEDSEL_AP_1,
  form: (model, errorMessages) => <TermindatoForm key="foedsel_termin" code={FOEDSEL_AP_1} model={model} errorMessages={errorMessages} />,
  readOnly: false,
  model: getTermindatoModel(behandling),
  rules: termindatoRules,
}));
aksjonspunktMap.set(FOEDSEL_AP_2, (behandling, aksjonspunktId) => ({
  id: aksjonspunktId,
  code: FOEDSEL_AP_2,
  form: (model, errorMessages) => <FoedselForm key="foedsel_foedsel" code={FOEDSEL_AP_2} model={model} errorMessages={errorMessages} />,
  readOnly: false,
  model: getFoedselModel(behandling),
  rules: foedselRules,
}));
aksjonspunktMap.set(FOEDSEL_AP_3, (behandling, aksjonspunktId) => ({
  id: aksjonspunktId,
  code: FOEDSEL_AP_3,
  form: (model, errorMessages) => <AntallBarnForm key="foedsel_antallBarn" code={FOEDSEL_AP_3} model={model} errorMessages={errorMessages} />,
  readOnly: false,
  model: getAntallBarnModel(behandling),
  rules: antallBarnRules,
}));

const innvilget = behandling => ({
  code: 'INNVILGET',
  form: model => <TpsInformationView key="foedsel_success" model={model} />,
  readOnly: true,
  model: getTpsInfoModel(behandling),
});

const tempPlaceholder = {
  code: 'TEMP',
  form: () => <TempPlaceholderView key="foedsel_godkjent" text="Innvilget. Skal utvides i senere brukerhistorier" />,
  readOnly: true,
};

export function getUrl() {
  return SAVE_BEHANDLINGPUNKT_SERVER_URL;
}

export function getAksjonspunktData(code) {
  return aksjonspunktMap.get(code);
}

export function getGodkjentData(behandling) {
  if (behandling.tpsData.fodselsdato
      && behandling.tpsData.antallBarn
      && behandling.tpsData.fodselsdato === behandling.soknad.fodselsdato
      && behandling.tpsData.antallBarn === behandling.soknad.antallBarn) {
    return innvilget(behandling);
  }

  return tempPlaceholder;
}

export function getAvslaattData() {
  return tempPlaceholder;
}
