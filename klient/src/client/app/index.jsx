import React from 'react';
import { render } from 'react-dom';

import nb from 'react-intl/locale-data/nb';
import { IntlProvider, addLocaleData } from 'react-intl';

import nbMessages from 'messages/nb_NO.json';
import Router from './router';

addLocaleData(nb);

render((
  <IntlProvider locale={'nb-NO'} messages={nbMessages}>
    <Router />
  </IntlProvider>
), document.getElementById('app'));
