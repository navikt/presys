import { combineReducers } from 'redux';

import errorHandlingContext from './errorHandlingReducer';
import saksbehandlerContext from './saksbehandlerReducer';
import formContext from './formReducer';
import fagsakContext from './fagsakReducer';


export default combineReducers({
  errorHandlingContext,
  saksbehandlerContext,
  formContext,
  fagsakContext,
});
