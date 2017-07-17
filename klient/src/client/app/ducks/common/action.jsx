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


function action(type, fnr) {
  return { type, fnr };
}
function dataReceived(datatype, fnr) {
  return json => ({
    ...action(datatype, fnr),
    data: json,
  });
}

const handleError = (dispatch, fetchTypes, fnr) => (ajax) => {
  dispatch(action(fetchTypes.failed, fnr));
  switch (ajax.response.status) {
    case 404:
      dispatch(replace('/'));
      return showErrorMessage(ajax);
    default:
      return showErrorMessage(ajax);
  }
};

const actionCreator = (url, fetchTypes) => fnr => (dispatch) => {
  dispatch(action(fetchTypes.started, fnr));
  return get(`${PERSON_ENDPOINT}/${fnr}/${url}`, {}, dispatch, dataReceived(fetchTypes.received, fnr), handleError(dispatch, fetchTypes, fnr));
};

export default actionCreator;
