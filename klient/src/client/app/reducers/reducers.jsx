import { combineReducers } from 'redux';
import { routerReducer } from 'react-router-redux';
import uforehistorikk from 'ducks/uforehistorikk/duck';
import inntekter from 'ducks/inntekt/duck';
import afpEtteroppgjor from 'ducks/etteroppgjorAFP/duck';
import status from 'ducks/status/duck';
import transaksjonshistorikk from 'ducks/transaksjonshistorikk/duck';

import errorHandlingContext from './errorHandlingReducer';
import saksbehandlerContext from './saksbehandlerReducer';
import personsok from './personsokReducer';
import person from './personReducer';

export default combineReducers({
  routing: routerReducer,
  errorHandlingContext,
  saksbehandlerContext,
  personsok,
  person,
  uforehistorikk,
  inntekter,
  afpEtteroppgjor,
  status,
  transaksjonshistorikk,
});
