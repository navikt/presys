import { push } from 'react-router-redux';
import { get } from 'services/restMethods';
import { debounce } from 'lodash';

import { PERSON_FETCH_STARTED, PERSON_RECEIVED, PERSON_FETCH_FAILED } from 'constants/actionTypes';
import { PERSON_ENDPOINT } from 'constants/serverApi';
import { showErrorMessage, removeErrorMessage } from './errorActions';
import { logout } from './saksbehandlerActions';

function dataReceived(datatype, fnr = null) {
  return json => ({
    type: datatype,
    data: json,
    fnr,
  });
}

function action(actionType) {
  return {
    type: actionType,
  };
}

const debounceRemoveError = debounce(dispatch => dispatch(removeErrorMessage()), 5000);

const handleError = dispatch => (ajax) => {
  if (ajax.response.status === 401) {
    return logout();
  }
  dispatch(action(PERSON_FETCH_FAILED));
  dispatch(push('/'));
  debounceRemoveError(dispatch);
  return showErrorMessage(ajax);
};


export default function fetchPerson(fnr) {
  return (dispatch) => {
    dispatch(removeErrorMessage());
    dispatch(action(PERSON_FETCH_STARTED));
    return get(`${PERSON_ENDPOINT}/${fnr}`, {}, dispatch, dataReceived(PERSON_RECEIVED), handleError(dispatch));
  };
}
