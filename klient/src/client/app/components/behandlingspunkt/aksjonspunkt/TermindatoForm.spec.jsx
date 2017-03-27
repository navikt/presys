import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import TermindatoForm, { getModel } from './TermindatoForm';

describe('<TermindatoForm>', () => {
  const model = {
    utstedtdato: '15.10.2017',
    termindato: '20.10.2017',
    antallBarn: 1,
  };

  it('skal sette opp modell gitt behandling', () => {
    const behandling = {
      soknad: {
        utstedtDato: '15.10.2017',
        termindato: '20.10.2017',
        antallBarn: 1,
      },
    };
    const termindatoModel = getModel(behandling);

    expect(termindatoModel).to.eql(model);
  });

  it('skal vise modelldata med defaultverdier i form', () => {
    const wrapper = shallow(<TermindatoForm
      code="testForm"
      model={model}
      errorMessages={{}}
    />, {
      context: {
        showErrors: false,
        updateModel: sinon.spy(),
        validateModel: sinon.spy(),
      },
    });

    const utstedtDatoDateField = wrapper.find('DateField').first();
    expect(utstedtDatoDateField).to.have.length(1);
    expect(utstedtDatoDateField.prop('value')).to.eql('15.10.2017');

    const termindatoDateField = wrapper.find('DateField').last();
    expect(termindatoDateField).to.have.length(1);
    expect(termindatoDateField.prop('value')).to.eql('20.10.2017');

    const numberOfChildrenTextField = wrapper.find('TextField');
    expect(numberOfChildrenTextField).to.have.length(1);
    expect(numberOfChildrenTextField.prop('value')).to.eql('1');
  });

  it('skal oppdatere modell ved endring i datofelt utstedtdato', () => {
    const dateFieldOnChangeCallback = sinon.spy();
    const wrapper = shallow(<TermindatoForm
      code="testForm"
      model={model}
      errorMessages={{}}
    />, {
      context: {
        showErrors: false,
        updateModel: dateFieldOnChangeCallback,
        validateModel: sinon.spy(),
      },
    });

    wrapper.find('DateField').first().simulate('change', { target: { value: 'test' } }, '15.11.2017');
    expect(dateFieldOnChangeCallback).to.have.property('callCount', 1);
    const args = dateFieldOnChangeCallback.getCalls()[0].args;
    expect(args).to.eql(['testForm', '15.11.2017', 'utstedtdato']);
  });

  it('skal validere modell når fokus forlater datofelt utstedtDato', () => {
    const dateFieldOnBlurCallback = sinon.spy();
    const wrapper = shallow(<TermindatoForm
      code="testForm"
      model={model}
      errorMessages={{}}
    />, {
      context: {
        showErrors: false,
        updateModel: sinon.spy(),
        validateModel: dateFieldOnBlurCallback,
      },
    });

    wrapper.find('DateField').first().simulate('blur');
    expect(dateFieldOnBlurCallback).to.have.property('callCount', 1);
  });

  it('skal oppdatere modell ved endring i datofelt termindato', () => {
    const dateFieldOnChangeCallback = sinon.spy();
    const wrapper = shallow(<TermindatoForm
      code="testForm"
      model={model}
      errorMessages={{}}
    />, {
      context: {
        showErrors: false,
        updateModel: dateFieldOnChangeCallback,
        validateModel: sinon.spy(),
      },
    });

    wrapper.find('DateField').last().simulate('change', { target: { value: 'test' } }, '15.11.2017');
    expect(dateFieldOnChangeCallback).to.have.property('callCount', 1);
    const args = dateFieldOnChangeCallback.getCalls()[0].args;
    expect(args).to.eql(['testForm', '15.11.2017', 'termindato']);
  });

  it('skal validere modell når fokus forlater datofelt termindato', () => {
    const dateFieldOnBlurCallback = sinon.spy();
    const wrapper = shallow(<TermindatoForm
      code="testForm"
      model={model}
      errorMessages={{}}
    />, {
      context: {
        showErrors: false,
        updateModel: sinon.spy(),
        validateModel: dateFieldOnBlurCallback,
      },
    });

    wrapper.find('DateField').last().simulate('blur');
    expect(dateFieldOnBlurCallback).to.have.property('callCount', 1);
  });

  it('skal oppdatere modell ved endring i tekstfelt antallBarn', () => {
    const textieldOnChangeCallback = sinon.spy();
    const wrapper = shallow(<TermindatoForm
      code="testForm"
      model={model}
      errorMessages={{}}
    />, {
      context: {
        showErrors: false,
        updateModel: textieldOnChangeCallback,
        validateModel: sinon.spy(),
      },
    });

    wrapper.find('TextField').last().simulate('change', { target: { value: '5' } });
    expect(textieldOnChangeCallback).to.have.property('callCount', 1);
    const args = textieldOnChangeCallback.getCalls()[0].args;
    expect(args).to.eql(['testForm', 5, 'antallBarn']);
  });

  it('skal validere modell når fokus forlater tekstfelt antallBarn', () => {
    const textFieldOnBlurCallback = sinon.spy();
    const wrapper = shallow(<TermindatoForm
      code="testForm"
      model={model}
      errorMessages={{}}
    />, {
      context: {
        showErrors: false,
        updateModel: sinon.spy(),
        validateModel: textFieldOnBlurCallback,
      },
    });

    wrapper.find('TextField').last().simulate('blur');
    expect(textFieldOnBlurCallback).to.have.property('callCount', 1);
  });
});
