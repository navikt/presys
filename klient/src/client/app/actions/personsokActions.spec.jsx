import configureMockStore from 'redux-mock-store';
import thunk from 'redux-thunk';
import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import { expect } from 'chai';

import * as types from 'constants/actionTypes';
import { setSearchString } from './fagsakActions';

const middlewares = [thunk];
const mockStore = configureMockStore(middlewares);

describe('Personsok-action', () => {
  it('skal oppdatere søkestreng', () => {
    const action = setSearchString('test');

    const expectedAction = {
      type: types.SET_SEARCH_STRING,
      data: 'test',
    };

    expect(action).to.eql(expectedAction);
  });

});
