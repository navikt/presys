import React from 'react';
import injectTapEventPlugin from 'react-tap-event-plugin';
import { Provider } from 'react-redux';
import { Router as ReactRouter, IndexRoute, Route, hashHistory } from 'react-router';
import { syncHistoryWithStore } from 'react-router-redux';

import App from 'containers/app/App';
import PersonsokIndex from 'containers/person/PersonsokIndex';
import MissingPage from 'components/app/MissingPage';
import Person from 'containers/person/Personfrafnr';
import EoAfp from 'ducks/etteroppgjorAFP/LastEtteroppgjorAfp';
import Inntekter from 'ducks/inntekt/LastInntekter';
import Status from 'ducks/status/LastStatus';
import UforeHistorikk from 'ducks/uforehistorikk/LastUforeHistorikk';
import Transhist from 'ducks/transaksjonshistorikk/LastTransaksjonsHistorikk';

import LoginManager from 'containers/app/LoginManager';
import { loginOk, setTimeoutForJwtToken } from 'actions/saksbehandlerActions';
import configureStore from './store/store';

injectTapEventPlugin();

const store = configureStore(hashHistory);
const history = syncHistoryWithStore(hashHistory, store);

/* sjekk initiell tilstand */
const token = localStorage.getItem('jwt_token');
if (token && new Date(JSON.parse(atob(token.split('.')[1])).exp * 1000) > new Date()) {
  store.dispatch(loginOk(token));
  setTimeoutForJwtToken(store.dispatch, token);
}

const routes = (
  <Route path="/" component={App}>
    <IndexRoute component={PersonsokIndex} />
    <Route path="login" component={LoginManager} />
    <Route path="person/:fnr" component={Person}>
      <Route path="uforehistorikk" component={UforeHistorikk} >
        <IndexRoute />
        <Route path=":maaned" />
      </Route>
      <Route path="transaksjonshistorikk" component={Transhist}>
        <IndexRoute />
        <Route path=":vtpkey" />
      </Route>
      <Route path="inntekter" component={Inntekter}>
        <IndexRoute />
        <Route path=":aar" />
      </Route>
      <Route path="eoafp" component={EoAfp} />

      <Route path="status" component={Status}>
        <IndexRoute />
        <Route path=":valgtstatus" />
      </Route>
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
