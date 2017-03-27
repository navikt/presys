import axios from 'axios';

export const get = function get(url, params, dispatch, successCallback, failedCallback) {
  return axios({
    url,
    params,
    method: 'get',
    timeout: 20000,
    responseType: 'json',
  }).then((response) => {
    dispatch(successCallback(response.data));
  }).catch((response) => {
    dispatch(failedCallback(response));
  });
};

export const post = function post(url, data, dispatch, successCallback, failedCallback) {
  return axios({
    url,
    data: JSON.stringify(data),
    method: 'post',
    timeout: 20000,
    headers: {
      'Content-Type': 'application/json',
    },
    responseType: 'json',
  }).then((response) => {
    dispatch(successCallback(response.data));
  }).catch((response) => {
    dispatch(failedCallback(response));
  });
};

// TODO (tor) denne skal brukast til å henta pdf. Må sikkert endrast...
export const getByteStream = function getByteStream(url, params, dispatch, successCallback, failedCallback) {
  return axios({
    url,
    params,
    method: 'get',
    timeout: 20000,
    responseType: 'stream',
  }).then((response) => {
    dispatch(successCallback(response.data));
  }).catch((response) => {
    dispatch(failedCallback(response));
  });
};
