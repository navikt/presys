import React from 'react';

import { MEDLEM_AP_1 } from 'constants/aksjonspunktCodes';
import TempPlaceholderView from 'components/behandlingspunkt/TempPlaceholderView';

const createTempPlaceholder = (key, text) => ({
  code: 'TEMP',
  form: () => <TempPlaceholderView key={key} text={text} />,
  readOnly: true,
});

const aksjonspunktMap = new Map();
aksjonspunktMap.set(MEDLEM_AP_1, () => createTempPlaceholder('medlem_empty', 'Aksjonspunkt. Skal utvides i senere brukerhistorier'));

export function getUrl() {
  return '';
}

export function getAksjonspunktData(code) {
  return aksjonspunktMap.get(code);
}

export function getGodkjentData() {
  return createTempPlaceholder('medlem_godkjent', 'Innvilget. Skal utvides i senere brukerhistorier');
}

export function getAvslaattData() {
  return createTempPlaceholder('medlem_avslaatt', 'Avslått. Skal utvides i senere brukerhistorier');
}
