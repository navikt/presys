import { SAKSBEHANDLER_RECEIVED } from 'constants/actionTypes';

export default function saksbehandlerReducer(state = {
  saksbehandlerName: '',
},
  action = null) {
  switch (action.type) {
    case SAKSBEHANDLER_RECEIVED:
      return Object.assign({ }, state, { saksbehandlerName: action.data.navn });
    default:
      return state;
  }
}
