import { LOGIN_SUCCESS } from 'constants/actionTypes';

const reducer = (action, actionTypes, state = { loading: false, failed: false }) => {
  switch (action.type) {
    case actionTypes.fetch.started:
      return { loading: true, failed: false, fnr: action.fnr };
    case actionTypes.fetch.received:
      return state.fnr === action.fnr ? { ...state, data: action.data, loading: false, failed: false } : state;
    case actionTypes.fetch.failed:
      return state.fnr === action.fnr ? { ...state, loading: false, failed: true } : state;
    case LOGIN_SUCCESS:
      return { loading: false, failed: false };
    default:
      return state;
  }
};

const personDependentReducer = actionTypes => (state, action) => reducer(action, actionTypes, state);

export default personDependentReducer;
