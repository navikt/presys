import React from 'react';

import BeregningsgrunnlagView, { getModel } from 'components/behandlingspunkt/BeregningsgrunnlagView';
import TempPlaceholderView from 'components/behandlingspunkt/TempPlaceholderView';

export function getUrl() {
  return null;
}

export function getAksjonspunktData() {
  return null;
}

export function getGodkjentData(behandling) {
  return {
    code: 'BEREGNING',
    form: model => <BeregningsgrunnlagView key="BEREGNING" model={model} />,
    readOnly: true,
    model: getModel(behandling),
  };
}

export function getAvslaattData() {
  return {
    code: 'TEMP',
    form: () => <TempPlaceholderView key="ikke_beregnet" text="Ikke beregnet. Skal utvides i senere brukerhistorier" />,
    readOnly: true,
  };
}
