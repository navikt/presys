import { get } from 'services/restMethods';
import { SAKSBEHANDLER_RECEIVED } from 'constants/actionTypes';
import { GET_SAKSBEHANDLER_SERVER_URL } from 'constants/serverApi';
import { showErrorMessage } from './errorActions';

function saksbehandlerReceived(json) {
  return {
    type: SAKSBEHANDLER_RECEIVED,
    data: json,
  };
}

export default function fetchSaksbehandler() {
  return dispatch => (
    get(GET_SAKSBEHANDLER_SERVER_URL, undefined, dispatch, saksbehandlerReceived, showErrorMessage)
  );
}
