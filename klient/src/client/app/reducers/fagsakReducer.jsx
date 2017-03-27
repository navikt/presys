import * as types from 'constants/actionTypes';

export default function fagsakReducer(state = {
  searchString: '',
  searchStarted: false,
  searchResultReceived: false,
  fagsaker: [],
  selectedFagsak: null,
},
  action = null) {
  switch (action.type) {
    case types.SET_SEARCH_STRING:
      return Object.assign({ }, state, {
        searchString: action.data,
        searchStarted: state.searchStarted,
        searchResultReceived: state.searchResultReceived,
        fagsaker: state.fagsaker,
        selectedFagsak: null,
      });
    case types.SEARCH_STARTED:
      return Object.assign({ }, state, {
        searchString: state.searchString,
        searchStarted: true,
        searchResultReceived: false,
        fagsaker: [],
        selectedFagsak: null,
      });
    case types.SEARCH_RESULT_RECEIVED:
      return Object.assign({ }, state, {
        searchString: state.searchString,
        searchStarted: false,
        searchResultReceived: true,
        fagsaker: action.data,
        selectedFagsak: null,
      });
    case types.SELECT_FAGSAK:
      return Object.assign({ }, state, {
        searchString: state.searchString,
        selectedFagsak: action.data,
        searchStarted: false,
        fagsaker: state.fagsaker,
        searchResultReceived: false,
      });
    default:
      return state;
  }
}
