import configureMockStore from 'redux-mock-store';
import thunk from 'redux-thunk';
import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import { expect } from 'chai';

import { SAVE_BEHANDLINGPUNKT_SERVER_URL } from 'constants/serverApi';
import { setModel, setPreviousModel, clearFormData, saveModel, showFormErrors, setFormErrors } from 'actions/formActions';
import reducer from './formReducer';

const middlewares = [thunk];
const mockStore = configureMockStore(middlewares);

describe('form-reducer', () => {
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
      models: {},
      previousModels: {},
      validationErrors: {},
      showErrors: false,
      isDirty: false,
      isSubmitting: false,
      submitSuccess: false,
    });
  });

  it('skal oppdatere både model og previousModel når en legger til ny modell', () => {
    const model = {
      termindato: '15.05.1999',
      antallBarn: '1',
    };
    const action = setModel('1', model);
    const result = reducer(undefined, action);

    expect(result.models).to.eql({
      1: model,
    });
    expect(result.previousModels).to.eql({
      1: model,
    });
  });

  it('skal oppdatere kun model og ikke previousModel ved oppdatering av felt', () => {
    const model = {
      termindato: '15.05.1999',
      antallBarn: '1',
    };
    const updatedModel = {
      termindato: '15.05.1999',
      antallBarn: '2',
    };
    const initState = {
      models: {
        1: model,
      },
      previousModels: {
        1: model,
      },
      showErrors: false,
      isDirty: false,
      validationErrors: {},
      isSubmitting: false,
      submitSuccess: false,
    };

    const action = setModel('1', updatedModel);
    const result = reducer(initState, action);

    expect(result.models).to.eql({
      1: updatedModel,
    });
    expect(result.previousModels).to.eql({
      1: model,
    });
  });

  it('skal legge til ny form-modell i state', () => {
    const model = {
      termindato: '15.05.1999',
      antallBarn: '1',
    };
    const nyModel = {
      termindato: '15.05.2017',
      antallBarn: '2',
    };
    const initState = {
      models: {
        en_modell: model,
      },
      previousModels: {
        en_modell: model,
      },
      showErrors: false,
      isDirty: false,
      validationErrors: {},
      isSubmitting: false,
      submitSuccess: false,
    };

    const action = setModel('annen_modell', nyModel);
    const result = reducer(initState, action);

    expect(result.models).to.eql({
      en_modell: model,
      annen_modell: nyModel,
    });
    expect(result.previousModels).to.eql({
      en_modell: model,
      annen_modell: nyModel,
    });
  });

  it('skal resette state', () => {
    const model = {
      termindato: '15.05.1999',
      antallBarn: '1',
    };
    const initState = {
      models: {
        en_modell: model,
      },
      previousModels: {
        en_modell: model,
      },
      showErrors: true,
      isDirty: true,
      validationErrors: { test: 'test' },
      isSubmitting: true,
      submitSuccess: true,
    };

    const action = clearFormData();
    const result = reducer(initState, action);

    expect(result).to.eql({
      models: {},
      previousModels: {},
      validationErrors: {},
      showErrors: false,
      isDirty: false,
      isSubmitting: false,
      submitSuccess: false,
    });
  });

  it('skal oppdatere state før og etter lagring av behandlingspunkter', () => {
    mockAxios
      .onPost(SAVE_BEHANDLINGPUNKT_SERVER_URL)
      .reply(200);

    const store = mockStore();

    return store.dispatch(saveModel(SAVE_BEHANDLINGPUNKT_SERVER_URL,
      {
        model: '123',
      }))
      .then(() => {
        expect(store.getActions()).to.eql([
          { type: 'REMOVE_ERROR_MESSAGE' },
          { type: 'FORM_SAVE_STARTED' },
          { type: 'FORM_POST_SUCCESS' },
        ]);

        const stateAfterFormSaveStarted = reducer(undefined, store.getActions()[1]);
        expect(stateAfterFormSaveStarted).to.eql({
          models: {},
          previousModels: {},
          validationErrors: {},
          showErrors: false,
          isDirty: false,
          isSubmitting: true,
          submitSuccess: false,
        });

        const stateAfterFormPostSuccess = reducer(undefined, store.getActions()[2]);
        expect(stateAfterFormPostSuccess).to.eql({
          models: {},
          previousModels: {},
          validationErrors: {},
          showErrors: false,
          isDirty: false,
          isSubmitting: false,
          submitSuccess: true,
        });
      });
  });

  it('skal ved avbryting av editering rulle tilbake til forrige state', () => {
    const model = {
      termindato: '15.05.1999',
      antallBarn: '1',
    };
    const previousModel = {
      termindato: '15.05.1999',
      antallBarn: '2',
    };
    const initState = {
      models: {
        en_modell: model,
      },
      previousModels: {
        en_modell: previousModel,
      },
      showErrors: false,
      isDirty: true,
      validationErrors: {},
      isSubmitting: false,
      submitSuccess: false,
    };

    const action = setPreviousModel();
    const result = reducer(initState, action);

    expect(result).to.eql({
      models: {
        en_modell: previousModel,
      },
      previousModels: {
        en_modell: previousModel,
      },
      validationErrors: {},
      showErrors: false,
      isDirty: false,
      isSubmitting: false,
      submitSuccess: false,
    });
  });

  it('skal sette ny status for visning av feil i state', () => {
    const initState = {
      models: {},
      previousModels: {},
      showErrors: false,
      isDirty: false,
      validationErrors: { },
      isSubmitting: false,
      submitSuccess: false,
    };

    const action = showFormErrors();
    const result = reducer(initState, action);

    expect(result).to.eql({
      models: {},
      previousModels: {},
      validationErrors: {},
      showErrors: true,
      isDirty: false,
      isSubmitting: false,
      submitSuccess: false,
    });
  });


  it('skal legge til nye feilmeldinger i state', () => {
    const initState = {
      models: {},
      previousModels: {},
      showErrors: false,
      isDirty: false,
      validationErrors: { },
      isSubmitting: false,
      submitSuccess: false,
    };

    const action = setFormErrors({ test: 'Dette er en feilmelding' });
    const result = reducer(initState, action);

    expect(result).to.eql({
      models: {},
      previousModels: {},
      validationErrors: { test: 'Dette er en feilmelding' },
      showErrors: false,
      isDirty: false,
      isSubmitting: false,
      submitSuccess: false,
    });
  });
});
