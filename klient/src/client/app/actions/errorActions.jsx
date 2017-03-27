import * as types from 'constants/actionTypes';

export function showErrorMessage(json) {
  return {
    type: types.SHOW_ERROR_MESSAGE,
    data: json,
  };
}

export function removeErrorMessage() {
  return {
    type: types.REMOVE_ERROR_MESSAGE,
  };
}
