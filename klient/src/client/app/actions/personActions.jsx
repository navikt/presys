import { replace } from 'react-router-redux';
import { get } from 'services/restMethods';
import { PERSON_FETCH_STARTED, PERSON_RECEIVED, PERSON_FETCH_FAILED } from 'constants/actionTypes';
import { PERSON_ENDPOINT } from 'constants/serverApi';
import { showErrorMessage, removeErrorMessage } from './errorActions';


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

const handleError = dispatch => (ajax) => {
  dispatch(action(PERSON_FETCH_FAILED));
  switch (ajax.response.status) {
    case 404:
      dispatch(replace('/'));
      return showErrorMessage(ajax);
    default:
      return showErrorMessage(ajax);
  }
};


export default function fetchPerson(fnr) {
  return (dispatch) => {
    dispatch(removeErrorMessage());
    dispatch(action(PERSON_FETCH_STARTED));
    return get(`${PERSON_ENDPOINT}/${fnr}`, {}, dispatch, dataReceived(PERSON_RECEIVED), handleError(dispatch));
  };
}
