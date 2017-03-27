import { /* PERSON_FETCH_STARTED,*/ PERSON_RECEIVED } from 'constants/actionTypes';

export default function saksbehandlerReducer(state = { fnr: 'aaa', navn: 'cda', alder: 0, kjonn: 'MANN' }, action) {
  switch (action.type) {
    case PERSON_RECEIVED:
      return action.data;
    default:
      return state;
  }
}
