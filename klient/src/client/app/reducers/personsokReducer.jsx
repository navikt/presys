import { SET_SEARCH_STRING } from 'constants/actionTypes';

export default function personsokReducer(state = { searchString: '' }, action) {
  switch (action.type) {
    case SET_SEARCH_STRING:
      return { searchString: action.data };
    default:
      return state;
  }
}
