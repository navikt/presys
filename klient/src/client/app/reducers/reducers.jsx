import { combineReducers } from 'redux';
import { routerReducer } from 'react-router-redux';

import errorHandlingContext from './errorHandlingReducer';
import saksbehandlerContext from './saksbehandlerReducer';
import formContext from './formReducer';
import fagsakContext from './fagsakReducer';
import person from './personReducer';


export default combineReducers({
  routing: routerReducer,
  errorHandlingContext,
  saksbehandlerContext,
  formContext,
  fagsakContext,
  person,
});
