import { LOGIN_SUCCESS, LOGOUT_SUCCESS } from 'constants/actionTypes';


const defaultState = {
  loggedIn: false,
  profile: null,
};

export default function saksbehandlerReducer(state = defaultState,
  action = null) {
  switch (action.type) {
    case LOGIN_SUCCESS:
      return {
        loggedIn: true,
        profile: { navn: action.data.navn },
      };
    case LOGOUT_SUCCESS:
      return defaultState;
    default:
      return state;
  }
}
