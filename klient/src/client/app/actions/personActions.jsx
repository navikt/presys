import { push } from 'react-router-redux';
import { get } from 'services/restMethods';
import { PERSON_FETCH_STARTED, PERSON_RECEIVED, UFOREHISTORIKK_RECEIVED, UFOREHISTORIKK_FETCH_STARTED } from 'constants/actionTypes';
import { PERSON_ENDPOINT } from 'constants/serverApi';
import { showErrorMessage, removeErrorMessage } from './errorActions';


function dataReceived(datatype) {
  return json => ({
    type: datatype,
    data: json,
  });
}

function action(actionType) {
  return {
    type: actionType,
  };
}

const handleError = dispatch => (ajax) => {
  switch (ajax.response.status) {
    case 404:
      dispatch(push('/'));
      return showErrorMessage(ajax);
    default:
      return showErrorMessage(ajax);
  }
};

export function fetchUforeHistorikk(fnr) {
  return (dispatch) => {
    dispatch(removeErrorMessage());
    dispatch(action(UFOREHISTORIKK_FETCH_STARTED));
    return get(`${PERSON_ENDPOINT}/${fnr}/uforeHistorikk`, {}, dispatch, dataReceived(UFOREHISTORIKK_RECEIVED), handleError(dispatch));
  };
}


export default function fetchPerson(fnr) {
  return (dispatch) => {
    dispatch(removeErrorMessage());
    dispatch(action(PERSON_FETCH_STARTED));
    return get(`${PERSON_ENDPOINT}/${fnr}`, {}, dispatch, dataReceived(PERSON_RECEIVED), handleError(dispatch));
  };
}
