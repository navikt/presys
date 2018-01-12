import { PERSON_FETCH_STARTED, PERSON_RECEIVED, PERSON_FETCH_FAILED, LOGIN_SUCCESS } from 'constants/actionTypes';

const init = { loading: false, failed: false };

function reducer(action, state = init) {
  switch (action.type) {
    case PERSON_RECEIVED:
      return { ...action.data, ...init };
    case PERSON_FETCH_STARTED:
      return { ...init, loading: true };
    case PERSON_FETCH_FAILED:
      return { ...init, failed: true };
    case LOGIN_SUCCESS:
      return init;
    default:
      return state;
  }
}

export default function personReducer(state, action) {
  return reducer(action, state);
}

