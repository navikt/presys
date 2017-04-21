import { SET_SEARCH_STRING } from 'constants/actionTypes';

export default function setSearchString(searchString) {
  return {
    type: SET_SEARCH_STRING,
    data: searchString,
  };
}
