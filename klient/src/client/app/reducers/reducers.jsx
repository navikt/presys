import { combineReducers } from 'redux';
import { routerReducer } from 'react-router-redux';

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
});
