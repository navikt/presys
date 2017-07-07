const reducer = actionTypes => (state = {}, action) => {
  switch (action.type) {
    case actionTypes.fetch.started:
      return { loading: true };
    case actionTypes.fetch.received:
      return { data: action.data, fnr: action.fnr, loading: false };
    case actionTypes.fetch.failed:
      return { loading: false };
    default:
      return state;
  }
};


export default reducer;
