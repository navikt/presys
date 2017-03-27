import configureMockStore from 'redux-mock-store';
import thunk from 'redux-thunk';
import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import { expect } from 'chai';

import * as types from 'constants/actionTypes';
import { SEARCH_FAGSAK_SERVER_URL } from 'constants/serverApi';
import { searchFagsaker, setSearchString, setSelectedFagsak } from './fagsakActions';

const middlewares = [thunk];
const mockStore = configureMockStore(middlewares);

describe('Fagsak-action', () => {
  let mockAxios;

  before(() => {
    mockAxios = new MockAdapter(axios);
  });

  afterEach(() => {
    mockAxios.reset();
  });

  after(() => {
    mockAxios.restore();
  });

  it('skal utføre diverse operasjoner når en søker etter fagsaker', () => {
    mockAxios
      .onGet(SEARCH_FAGSAK_SERVER_URL)
      .reply(200, {
        fagsaker: [],
      },
    );

    const expectedActions = [{
      type: types.REMOVE_ERROR_MESSAGE,
    }, {
      type: types.SEARCH_STARTED,
    }, {
      type: types.SEARCH_RESULT_RECEIVED,
      data: {
        fagsaker: [],
      },
    }];

    const store = mockStore();

    return store.dispatch(searchFagsaker('{snr: 123 }'))
      .then(() => {
        expect(store.getActions()).to.eql(expectedActions);
      });
  });

  it('skal feile ved søking etter fagsaker', () => {
    mockAxios
      .onGet(SEARCH_FAGSAK_SERVER_URL)
      .reply(500);

    const store = mockStore();

    return store.dispatch(searchFagsaker('{snr: 123 }'))
      .then(() => {
        expect(store.getActions()).to.have.length(3);
        expect(store.getActions()[0].type).to.eql(types.REMOVE_ERROR_MESSAGE);
        expect(store.getActions()[1].type).to.eql(types.SEARCH_STARTED);
        expect(store.getActions()[2].type).to.eql(types.SHOW_ERROR_MESSAGE);
      });
  });

  it('skal oppdatere søkestreng', () => {
    const action = setSearchString('test');

    const expectedAction = {
      type: types.SET_SEARCH_STRING,
      data: 'test',
    };

    expect(action).to.eql(expectedAction);
  });

  it('skal sette valgt fagsak', () => {
    const action = setSelectedFagsak('fagsak');

    const expectedAction = {
      type: types.SELECT_FAGSAK,
      data: 'fagsak',
    };

    expect(action).to.eql(expectedAction);
  });
});
