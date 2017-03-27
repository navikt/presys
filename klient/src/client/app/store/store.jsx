import { routerReducer, routerMiddleware } from 'react-router-redux';
import { createStore, combineReducers, compose, applyMiddleware } from 'redux';
import thunkMiddleware from 'redux-thunk';
import { composeWithDevTools } from 'redux-devtools-extension/developmentOnly';

import * as reducers from 'reducers/reducers';

const createLogger = process.env.NODE_ENV === 'development' ? require('redux-logger') : null;

const rootReducer = combineReducers({
  ...reducers,
  routing: routerReducer,
});

export default function configureStore(browserHistory) {
  const middleware = [thunkMiddleware, routerMiddleware(browserHistory)];
  if (process.env.NODE_ENV === 'development') {
    middleware.push(createLogger());
  }

  const initialState = {};
  const enhancer = compose(composeWithDevTools(applyMiddleware(...middleware)));
  return createStore(rootReducer, initialState, enhancer);
}
