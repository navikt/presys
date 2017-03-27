import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import ConfirmInformationForm from './ConfirmInformationForm';

describe('<ConfirmInformationForm>', () => {
  const model = {
    begrunnelse: 'test-begrunnelse',
  };

  it('skal vise modelldata med defaultverdier i form', () => {
    const cancelCallback = sinon.spy();
    const wrapper = shallow(<ConfirmInformationForm
      code="testForm"
      model={model}
      errorMessages={{}}
      readOnly={false}
      url="testurl"
    />, {
      context: {
        updateModel: sinon.spy(),
        validateModel: sinon.spy(),
        submitCallback: sinon.spy(),
        isSubmitting: false,
        cancelCallback,
        isDirty: false,
        showErrors: false,
      },
    });

    const infoTextArea = wrapper.find('TextArea');
    expect(infoTextArea.prop('value')).to.eql('test-begrunnelse');
    expect(infoTextArea).to.have.length(1);

    const submitButton = wrapper.find('SubmitOrCancelButtons');
    expect(submitButton).to.have.length(1);
    expect(submitButton.prop('readOnly')).to.eql(false);
    expect(submitButton.prop('cancelCallback')).to.eql(cancelCallback);
    expect(submitButton.prop('isDirty')).to.eql(false);
  });

  it('skal oppdatere modell ved endring i tekstfelt', () => {
    const textAreaOnChangeCallback = sinon.spy();
    const wrapper = shallow(<ConfirmInformationForm
      code="testForm"
      model={model}
      errorMessages={{}}
      readOnly={false}
      url="testurl"
    />, {
      context: {
        updateModel: textAreaOnChangeCallback,
        validateModel: sinon.spy(),
        submitCallback: sinon.spy(),
        isSubmitting: false,
        cancelCallback: sinon.spy(),
        isDirty: false,
        showErrors: false,
      },
    });

    wrapper.find('TextArea').simulate('change', { target: { value: 'dette er en ny test' } });
    expect(textAreaOnChangeCallback).to.have.property('callCount', 1);
    const args = textAreaOnChangeCallback.getCalls()[0].args;
    expect(args).to.eql(['testForm', 'dette er en ny test', 'begrunnelse']);
  });

  it('skal validere modell når fokus forlater tekstfelt', () => {
    const textAreaOnBlurCallback = sinon.spy();
    const wrapper = shallow(<ConfirmInformationForm
      code="testForm"
      model={model}
      errorMessages={{}}
      readOnly={false}
      url="testurl"
    />, {
      context: {
        updateModel: sinon.spy(),
        validateModel: textAreaOnBlurCallback,
        submitCallback: sinon.spy(),
        isSubmitting: false,
        cancelCallback: sinon.spy(),
        isDirty: false,
        showErrors: false,
      },
    });

    wrapper.find('TextArea').simulate('blur');
    expect(textAreaOnBlurCallback).to.have.property('callCount', 1);
  });
});
