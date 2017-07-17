const reducer = actionTypes => (state = { loading: false, failed: false }, action) => {
  switch (action.type) {
    case actionTypes.fetch.started:
      return { loading: true, failed: false, fnr: action.fnr };
    case actionTypes.fetch.received:
      return state.fnr === action.fnr ? { ...state, data: action.data, loading: false, failed: false } : state;
    case actionTypes.fetch.failed:
      return state.fnr === action.fnr ? { ...state, loading: false, failed: true } : state;
    default:
      return state;
  }
};


export default reducer;
