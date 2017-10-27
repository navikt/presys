import { PERSON_FETCH_STARTED, PERSON_RECEIVED, PERSON_FETCH_FAILED, LOGIN_SUCCESS } from 'constants/actionTypes';


function reducer(action, state = { loading: false }) {
  switch (action.type) {
    case PERSON_RECEIVED:
      return { ...action.data, loading: false };
    case PERSON_FETCH_STARTED:
      return { loading: true };
    case PERSON_FETCH_FAILED:
    case LOGIN_SUCCESS:
      return { loading: false };
    default:
      return state;
  }
}

export default function personReducer(state, action) {
  return reducer(action, state);
}

