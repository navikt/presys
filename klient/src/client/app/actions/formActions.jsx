import { SET_MODEL, RESET_MODEL, SET_PREVIOUS_MODEL, SHOW_FORM_ERRORS, SET_FORM_ERRORS, FORM_SAVE_STARTED, FORM_POST_SUCCESS } from 'constants/actionTypes';
import { post } from 'services/restMethods';
import { showErrorMessage, removeErrorMessage } from './errorActions';

function saveStarted() {
  return {
    type: FORM_SAVE_STARTED,
  };
}

function postSuccess() {
  return {
    type: FORM_POST_SUCCESS,
  };
}


export function setModel(code, model) {
  return {
    type: SET_MODEL,
    data: {
      code,
      model,
    },
  };
}

export function setPreviousModel() {
  return {
    type: SET_PREVIOUS_MODEL,
  };
}

export function clearFormData() {
  return {
    type: RESET_MODEL,
  };
}

export function saveModel(url, aksjonspunktModels) {
  return (dispatch) => {
    /* TODO (tor) flytt til generell plass. Muligens inn i get */
    dispatch(removeErrorMessage());

    dispatch(saveStarted());
    return post(url, aksjonspunktModels, dispatch, postSuccess, showErrorMessage);
  };
}

export function showFormErrors() {
  return {
    type: SHOW_FORM_ERRORS,
  };
}

export function setFormErrors(validationErrors) {
  return {
    type: SET_FORM_ERRORS,
    data: validationErrors,
  };
}
