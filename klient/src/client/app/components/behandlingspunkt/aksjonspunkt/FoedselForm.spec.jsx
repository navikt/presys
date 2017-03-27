import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import FoedselForm, { getModel } from './FoedselForm';

describe('<FoedselForm>', () => {
  const model = {
    fodselsdato: '15.10.2017',
    antallBarn: 2,
  };

  it('skal sette opp modell gitt behandling', () => {
    const behandling = {
      soknad: {
        fodselsdato: '15.10.2017',
        antallBarn: 2,
      },
    };
    const foedselModel = getModel(behandling);

    expect(foedselModel).to.eql(model);
  });

  it('skal vise modelldata med defaultverdier i form', () => {
    const wrapper = shallow(<FoedselForm
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

    const foedselsdatoSoeknadDateField = wrapper.find('DateField');
    expect(foedselsdatoSoeknadDateField).to.have.length(1);
    expect(foedselsdatoSoeknadDateField.prop('value')).to.eql('15.10.2017');

    const numberOfChildrenTextField = wrapper.find('TextField');
    expect(numberOfChildrenTextField).to.have.length(1);
    expect(numberOfChildrenTextField.prop('value')).to.eql('2');
  });

  it('skal oppdatere modell ved endring i datofelt', () => {
    const dateFieldOnChangeCallback = sinon.spy();
    const wrapper = shallow(<FoedselForm
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

    wrapper.find('DateField').simulate('change', { target: { value: 'test' } }, '15.11.2017');
    expect(dateFieldOnChangeCallback).to.have.property('callCount', 1);
    const args = dateFieldOnChangeCallback.getCalls()[0].args;
    expect(args).to.eql(['testForm', '15.11.2017', 'fodselsdato']);
  });

  it('skal validere modell når fokus forlater datofelt', () => {
    const dateFieldOnBlurCallback = sinon.spy();
    const wrapper = shallow(<FoedselForm
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

    wrapper.find('DateField').simulate('blur');
    expect(dateFieldOnBlurCallback).to.have.property('callCount', 1);
  });

  it('skal oppdatere modell ved endring i tekstfelt', () => {
    const textFieldOnChangeCallback = sinon.spy();
    const wrapper = shallow(<FoedselForm
      code="testForm"
      model={model}
      errorMessages={{}}
    />, {
      context: {
        showErrors: false,
        updateModel: textFieldOnChangeCallback,
        validateModel: sinon.spy(),
      },
    });

    wrapper.find('TextField').simulate('change', { target: { value: 3 } });
    expect(textFieldOnChangeCallback).to.have.property('callCount', 1);
    const args = textFieldOnChangeCallback.getCalls()[0].args;
    expect(args).to.eql(['testForm', 3, 'antallBarn']);
  });

  it('skal validere modell når fokus forlater datofelt', () => {
    const textFieldOnBlurCallback = sinon.spy();
    const wrapper = shallow(<FoedselForm
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

    wrapper.find('TextField').simulate('blur');
    expect(textFieldOnBlurCallback).to.have.property('callCount', 1);
  });
});
