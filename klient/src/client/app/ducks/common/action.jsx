import { PERSON_ENDPOINT } from 'constants/serverApi';
import { replace } from 'react-router-redux';
import { get } from 'services/restMethods';
import { showErrorMessage } from 'actions/errorActions';


export const actionsFor = type => ({
  fetch: {
    started: `${type}\\FETCH_STARTED`,
    received: `${type}\\RECEIVED`,
    failed: `${type}\\FETCH_FAILED`,
  },
});

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

const handleError = (dispatch, fetchTypes) => (ajax) => {
  dispatch(action(fetchTypes.failed));
  switch (ajax.response.status) {
    case 404:
      dispatch(replace('/'));
      return showErrorMessage(ajax);
    default:
      return showErrorMessage(ajax);
  }
};

const actionCreator = (url, fetchTypes) => fnr => (dispatch) => {
  dispatch(action(fetchTypes.started));
  return get(`${PERSON_ENDPOINT}/${fnr}/${url}`, {}, dispatch, dataReceived(fetchTypes.received, fnr), handleError(dispatch, fetchTypes));
};

export default actionCreator;
