import { SAKSBEHANDLER_RECEIVED } from 'constants/actionTypes';

export default function saksbehandlerReducer(state = {
  saksbehandlerName: '',
},
  action = null) {
  switch (action.type) {
    case SAKSBEHANDLER_RECEIVED:
      return { ...state, saksbehandlerName: action.data.navn };
    default:
      return state;
  }
}
