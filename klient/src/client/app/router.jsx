import React from 'react';
import injectTapEventPlugin from 'react-tap-event-plugin';
import { Provider } from 'react-redux';
import { Router as ReactRouter, IndexRoute, Route, hashHistory } from 'react-router';
import { syncHistoryWithStore } from 'react-router-redux';

import App from 'containers/app/App';
import PersonsokIndex from 'containers/person/PersonsokIndex';
import MissingPage from 'components/app/MissingPage';
import Person from 'containers/person/Personfrafnr';
import EoAfp from 'containers/etteroppgorAFP/EtteroppgjorAfpListe';
import Inntekter from 'containers/inntekter/InntektListe';
import Status from 'containers/status/StatusListe';

import configureStore from './store/store';

injectTapEventPlugin();

const store = configureStore(hashHistory);
const history = syncHistoryWithStore(hashHistory, store);

const routes = (
  <Route path="/" component={App}>
    <IndexRoute component={PersonsokIndex} />
    <Route path="person/:fnr" component={Person}>
      <Route path="eoafp" component={EoAfp} />
      <Route path="inntekter" component={Inntekter}>
        <IndexRoute />
        <Route path=":aar" />
      </Route>
      <Route path="status" component={Status} />
    </Route>
    <Route path="*" component={MissingPage} />
  </Route>
);

const Router = () => (
  <Provider store={store}>
    <ReactRouter history={history}>
      {routes}
    </ReactRouter>
  </Provider>
);

export default Router;
