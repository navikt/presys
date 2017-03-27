import configureMockStore from 'redux-mock-store';
import thunk from 'redux-thunk';
import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import { expect } from 'chai';

import { SEARCH_FAGSAK_SERVER_URL } from 'constants/serverApi';
import { setSearchString, searchFagsaker, setSelectedFagsak } from 'actions/fagsakActions';
import reducer from './fagsakReducer';

const middlewares = [thunk];
const mockStore = configureMockStore(middlewares);

describe('Fagsak-reducer', () => {
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

  it('skal returnere initial state', () => {
    expect(reducer(undefined, {})).to.eql({
      searchString: '',
      searchStarted: false,
      searchResultReceived: false,
      fagsaker: [],
      selectedFagsak: null,
    });
  });

  it('skal oppdatere søkestreng i store', () => {
    const action = setSearchString('teststring');

    expect(reducer(undefined, action)).to.eql({
      searchString: 'teststring',
      searchStarted: false,
      searchResultReceived: false,
      fagsaker: [],
      selectedFagsak: null,
    });
  });

  it('skal oppdatere fagsaker i store', () => {
    mockAxios
      .onGet(SEARCH_FAGSAK_SERVER_URL)
      .reply(200, {
        fagsaker: 'testfagsak',
      });

    const store = mockStore();

    return store.dispatch(searchFagsaker({ snr: '123' }))
      .then(() => {
        expect(store.getActions()).to.have.length(3);

        const stateAfterSearchStarted = reducer(undefined, store.getActions()[1]);
        expect(stateAfterSearchStarted).to.eql({
          searchString: '',
          searchStarted: true,
          searchResultReceived: false,
          fagsaker: [],
          selectedFagsak: null,
        });

        const stateAfterSearchResultReceived = reducer(undefined, store.getActions()[2]);
        expect(stateAfterSearchResultReceived).to.eql({
          searchString: '',
          searchStarted: false,
          searchResultReceived: true,
          fagsaker: {
            fagsaker: 'testfagsak',
          },
          selectedFagsak: null,
        });
      });
  });

  it('skal sette valgt fagsak i store', () => {
    const action = setSelectedFagsak('fagsak');

    expect(reducer(undefined, action)).to.eql({
      searchString: '',
      searchStarted: false,
      searchResultReceived: false,
      fagsaker: [],
      selectedFagsak: 'fagsak',
    });
  });
});
