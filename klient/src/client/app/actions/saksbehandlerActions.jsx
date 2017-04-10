import { get, put } from 'services/restMethods';
import { SAKSBEHANDLER_RECEIVED, LOGIN_SUCCESS, LOGOUT_SUCCESS } from 'constants/actionTypes';
import { GET_SAKSBEHANDLER_SERVER_URL, SAKSBEHANDLER_ENDPOINT } from 'constants/serverApi';
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

export function login(username, password) {
  return dispatch => (
    put(`${SAKSBEHANDLER_ENDPOINT}/login`,
      { brukernavn: username, passord: password },
      dispatch,
      (json) => {
        localStorage.setItem('jwt', json.jwt);
        return { type: LOGIN_SUCCESS, data: json };
      },
      showErrorMessage)
  );
}

export function refresh() {
  return dispatch => (
    put(`${SAKSBEHANDLER_ENDPOINT}/refreshlogin`,
      { },
      dispatch,
      (json) => {
        localStorage.setItem('jwt', json.jwt);
        return { type: LOGIN_SUCCESS, data: json };
      },
      () => ({ type: 'REFRESH_FAILED' }),
    )
  );
}


export function logout() {
  return (dispatch) => {
    localStorage.removeItem('jwt');
    dispatch({ type: LOGOUT_SUCCESS });
  };
}
