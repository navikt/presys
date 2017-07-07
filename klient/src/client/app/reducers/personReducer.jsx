import { PERSON_FETCH_STARTED, PERSON_RECEIVED, PERSON_FETCH_FAILED } from 'constants/actionTypes';

export default function personReducer(state = { loading: false }, action) {
  switch (action.type) {
    case PERSON_RECEIVED:
      return { ...action.data, loading: false };
    case PERSON_FETCH_STARTED:
      return { loading: true };
    case PERSON_FETCH_FAILED:
      return { loading: false };
    default:
      return state;
  }
}
