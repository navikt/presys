import { get } from 'services/restMethods';
import { SET_SEARCH_STRING, SEARCH_STARTED, SEARCH_RESULT_RECEIVED, SELECT_FAGSAK } from 'constants/actionTypes';
import { SEARCH_FAGSAK_SERVER_URL } from 'constants/serverApi';
import { showErrorMessage, removeErrorMessage } from './errorActions';

function searchStarted() {
  return {
    type: SEARCH_STARTED,
  };
}

function fagsakSearchResultReceived(json) {
  return {
    type: SEARCH_RESULT_RECEIVED,
    data: json,
  };
}

export function setSearchString(searchString) {
  return {
    type: SET_SEARCH_STRING,
    data: searchString,
  };
}

export function searchFagsaker(params) {
  return (dispatch) => {
    /* TODO (tor) flytt til generell plass. Muligens inn i get */
    dispatch(removeErrorMessage());

    dispatch(searchStarted());
    return get(SEARCH_FAGSAK_SERVER_URL, params, dispatch, fagsakSearchResultReceived, showErrorMessage);
  };
}

export function setSelectedFagsak(fagsak) {
  return {
    type: SELECT_FAGSAK,
    data: fagsak,
  };
}
