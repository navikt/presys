import configureMockStore from 'redux-mock-store';
import thunk from 'redux-thunk';
import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import { expect } from 'chai';

import * as types from 'constants/actionTypes';
import { SAVE_BEHANDLINGPUNKT_SERVER_URL } from 'constants/serverApi';
import { setModel, saveModel, setPreviousModel, clearFormData, showFormErrors, setFormErrors } from './formActions';

const middlewares = [thunk];
const mockStore = configureMockStore(middlewares);

describe('Form-action', () => {
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

  it('skal utføre tre actions ved lagring av modell', () => {
    mockAxios
      .onPost(SAVE_BEHANDLINGPUNKT_SERVER_URL)
      .reply(200);

    const expectedActions = [{
      type: types.REMOVE_ERROR_MESSAGE,
    }, {
      type: types.FORM_SAVE_STARTED,
    }, {
      type: types.FORM_POST_SUCCESS,
    }];

    const store = mockStore();

    return store.dispatch(saveModel(SAVE_BEHANDLINGPUNKT_SERVER_URL, '{test: 123 }'))
      .then(() => {
        expect(store.getActions()).to.eql(expectedActions);
      });
  });

  it('skal feile ved lagring av modell', () => {
    mockAxios
      .onGet(SAVE_BEHANDLINGPUNKT_SERVER_URL)
      .reply(500);

    const store = mockStore();

    return store.dispatch(saveModel(SAVE_BEHANDLINGPUNKT_SERVER_URL, '{test: 123 }'))
      .then(() => {
        expect(store.getActions()).to.have.length(3);
        expect(store.getActions()[0].type).to.eql(types.REMOVE_ERROR_MESSAGE);
        expect(store.getActions()[1].type).to.eql(types.FORM_SAVE_STARTED);
        expect(store.getActions()[2].type).to.eql(types.SHOW_ERROR_MESSAGE);
      });
  });

  it('skal lage action som oppdaterer modell', () => {
    const action = setModel('modellnavn', { test: 'test' });

    const expectedAction = {
      type: types.SET_MODEL,
      data: {
        code: 'modellnavn',
        model: {
          test: 'test',
        },
      },
    };

    expect(action).to.eql(expectedAction);
  });

  it('skal lage action som setter modell lik forrige modell', () => {
    const action = setPreviousModel();

    const expectedAction = {
      type: types.SET_PREVIOUS_MODEL,
    };

    expect(action).to.eql(expectedAction);
  });

  it('skal lage action som nuller ut modell', () => {
    const action = clearFormData();

    const expectedAction = {
      type: types.RESET_MODEL,
    };

    expect(action).to.eql(expectedAction);
  });

  it('skal lage action som viser feilmeldinger', () => {
    const action = showFormErrors();

    const expectedAction = {
      type: types.SHOW_FORM_ERRORS,
    };

    expect(action).to.eql(expectedAction);
  });

  it('skal lage action som legger til nye feilmeldinger', () => {
    const action = setFormErrors({ feil: 'dette er en feilmelding' });

    const expectedAction = {
      type: types.SET_FORM_ERRORS,
      data: { feil: 'dette er en feilmelding' },
    };

    expect(action).to.eql(expectedAction);
  });
});
