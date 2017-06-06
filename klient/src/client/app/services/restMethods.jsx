import axios from 'axios';


const addJwt = (headers) => {
  const jwt = localStorage.getItem('jwt_token') || null;
  return jwt ? { ...headers, Authorization: `Bearer ${jwt}` } : headers;
};

export const get = function get(url, params, dispatch, successCallback, failedCallback) {
  return axios({
    url,
    params,
    method: 'get',
    timeout: 20000,
    headers: addJwt({}),
    responseType: 'json',
  }).then((response) => {
    dispatch(successCallback(response.data, response));
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
    headers: addJwt({
      'Content-Type': 'application/json',
    }),
    responseType: 'json',
  }).then((response) => {
    dispatch(successCallback(response.data, response));
  }).catch((response) => {
    dispatch(failedCallback(response));
  });
};

export const put = function put(url, data, dispatch, successCallback, failedCallback) {
  return axios({
    url,
    data: JSON.stringify(data),
    method: 'put',
    timeout: 20000,
    headers: addJwt({
      'Content-Type': 'application/json',
    }),
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
