import { push } from 'react-router-redux';
import { get } from 'services/restMethods';
import { PERSON_FETCH_STARTED, PERSON_RECEIVED } from 'constants/actionTypes';
import { PERSON_ENDPOINT } from 'constants/serverApi';
import { showErrorMessage, removeErrorMessage } from './errorActions';

function searchStarted() {
  return {
    type: PERSON_FETCH_STARTED,
  };
}

function fagsakSearchResultReceived(json) {
  return {
    type: PERSON_RECEIVED,
    data: json,
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

export default function fetchPerson(fnr) {
  return (dispatch) => {
    dispatch(removeErrorMessage());
    dispatch(searchStarted());
    return get(`${PERSON_ENDPOINT}/${fnr}`, {}, dispatch, fagsakSearchResultReceived, handleError(dispatch));
  };
}
