import configureMockStore from 'redux-mock-store';
import thunk from 'redux-thunk';
import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import { expect } from 'chai';

import { GET_SAKSBEHANDLER_SERVER_URL } from 'constants/serverApi';
import fetchSaksbehandler from 'actions/saksbehandlerActions';
import reducer from './saksbehandlerReducer';

const middlewares = [thunk];
const mockStore = configureMockStore(middlewares);

describe('Saksbehandler-reducer', () => {
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
    expect(reducer(undefined, {})).to.eql({ saksbehandlerName: '' });
  });

  it('skal oppdatere state med saksbehandlernavn', () => {
    mockAxios
      .onGet(GET_SAKSBEHANDLER_SERVER_URL)
      .reply(200, {
        navn: 'Fornavn Etternavn',
      });

    const store = mockStore();

    return store.dispatch(fetchSaksbehandler())
      .then(() => {
        expect(store.getActions()).to.have.length(1);
        const state = reducer([], store.getActions()[0]);
        expect(state.saksbehandlerName).to.eql('Fornavn Etternavn');
      });
  });
});
