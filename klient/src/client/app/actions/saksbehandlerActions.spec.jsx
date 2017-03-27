import configureMockStore from 'redux-mock-store';
import thunk from 'redux-thunk';
import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import { expect } from 'chai';

import * as types from 'constants/actionTypes';
import { GET_SAKSBEHANDLER_SERVER_URL } from 'constants/serverApi';
import fetchSaksbehandler from './saksbehandlerActions';

const middlewares = [thunk];
const mockStore = configureMockStore(middlewares);

describe('Saksbehandler-action', () => {
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

  it('skal lage SAKSBEHANDLER_RECEIVED når saksbehandler er hentet fra server', () => {
    mockAxios
      .onGet(GET_SAKSBEHANDLER_SERVER_URL)
      .reply(200, {
        navn: 'Fornavn Etternavn',
      },
    );

    const expectedActions = [{
      type: types.SAKSBEHANDLER_RECEIVED,
      data: {
        navn: 'Fornavn Etternavn',
      },
    }];

    const store = mockStore();

    return store.dispatch(fetchSaksbehandler())
      .then(() => {
        expect(store.getActions()).to.eql(expectedActions);
      });
  });

  it('skal feile ved henting av saksbehandler fra server', () => {
    mockAxios
      .onGet(GET_SAKSBEHANDLER_SERVER_URL)
      .reply(500);

    const store = mockStore();

    return store.dispatch(fetchSaksbehandler())
      .then(() => {
        expect(store.getActions()).to.have.length(1);
        expect(store.getActions()[0].type).to.eql(types.SHOW_ERROR_MESSAGE);
      });
  });
});
