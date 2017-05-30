import { post } from 'services/restMethods';
import { LOGIN_SUCCESS, LOGOUT_SUCCESS, LOGIN_FAILED } from 'constants/actionTypes';
import { LOGIN_ENDPOINT } from 'constants/serverApi';
import { showErrorMessage, removeErrorMessage } from './errorActions';

export function loginOk(token) {
  localStorage.setItem('jwt_token', token);

  return {
    type: LOGIN_SUCCESS,
    payload: {
      token,
    },
  };
}

export function loginFeil(response) {
  localStorage.removeItem('jwt_token');

  return {
    type: LOGIN_FAILED,
    error: {
      statusCode: response.status,
      statusText: 'Feil brukernavn og eller passord',
    },
  };
}

export function login(username, password) {
  return (dispatch) => {
    post(`${LOGIN_ENDPOINT}`, { username, password }, dispatch,
          (json, response) => {
            dispatch(removeErrorMessage());
            return loginOk(response.headers.authorization);
          },
          (response) => {
            dispatch(showErrorMessage(response));
            return loginFeil(response);
          });
  };
}

export function logout() {
  return (dispatch) => {
    localStorage.removeItem('jwt_token');
    dispatch({
      type: LOGOUT_SUCCESS,
    });
  };
}
