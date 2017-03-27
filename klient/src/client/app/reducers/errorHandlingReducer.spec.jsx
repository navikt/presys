import { expect } from 'chai';

import { showErrorMessage, removeErrorMessage } from 'actions/errorActions';
import reducer from './errorHandlingReducer';

describe('ErrorHandling-reducer', () => {
  it('skal returnere initial state', () => {
    expect(reducer(undefined, {})).to.eql({ errorMessage: '' });
  });

  it('skal oppdatere state med feilmelding og så fjerne den', () => {
    const addAction = showErrorMessage('login error');
    expect(reducer(undefined, addAction)).to.eql({ errorMessage: 'login error' });

    const removeAction = removeErrorMessage();
    expect(reducer(undefined, removeAction)).to.eql({ errorMessage: '' });
  });

  it('skal oppdatere state med feilmelding fra response', () => {
    const action = showErrorMessage({
      response: {
        data: {
          entity: 'test error',
        },
      },
    });
    expect(reducer(undefined, action)).to.eql({ errorMessage: 'test error' });
  });
});
