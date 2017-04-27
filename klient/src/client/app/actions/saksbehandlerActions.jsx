import { get, put } from 'services/restMethods';
import { LOGIN_SUCCESS, LOGOUT_SUCCESS } from 'constants/actionTypes';
import { SAKSBEHANDLER_ENDPOINT } from 'constants/serverApi';
import { showErrorMessage } from './errorActions';

export default function login(username, password) {
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
    get(`${SAKSBEHANDLER_ENDPOINT}/refreshlogin`,
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
