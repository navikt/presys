import { PERSON_FETCH_STARTED, PERSON_RECEIVED, UFOREHISTORIKK_RECEIVED, UFOREHISTORIKK_FETCH_STARTED } from 'constants/actionTypes';

export default function personReducer(state = { loading: false }, action) {
  switch (action.type) {
    case PERSON_RECEIVED:
      return { ...action.data, loading: false };
    case PERSON_FETCH_STARTED:
      return { loading: true };
    case UFOREHISTORIKK_FETCH_STARTED:
      return { ...state,
        uforehistorikkerIsLoading: true,
      };
    case UFOREHISTORIKK_RECEIVED:
      return { ...state,
        uforehistorikker: action.data,
        uforehistorikkerIsLoading: false,
      };
    default:
      return state;
  }
}
