import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import AntallBarnForm, { getModel } from './AntallBarnForm';

describe('<AntallBarnForm>', () => {
  const model = {
    foedselsdatoSoeknad: '15.10.2017',
    antallBarn: 2,
    antallBarnTps: 1,
    brukAntallBarnFraTps: false,
  };

  it('skal sette opp modell gitt behandling', () => {
    const behandling = {
      soknad: {
        fodselsdato: '15.10.2017',
        antallBarn: 2,
      },
      tpsData: {
        antallBarn: 1,
      },
    };
    const antallBarnModel = getModel(behandling);

    expect(antallBarnModel).to.eql(model);
  });

  it('skal vise modelldata med defaultverdier i form', () => {
    const wrapper = shallow(<AntallBarnForm
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

    const foedselsdatoSoeknadDateLabel = wrapper.find('DateLabel');
    expect(foedselsdatoSoeknadDateLabel).to.have.length(1);
    expect(foedselsdatoSoeknadDateLabel.prop('dateString')).to.eql('15.10.2017');

    const numberOfChildrenTextField = wrapper.find('TextField');
    expect(numberOfChildrenTextField).to.have.length(1);
    expect(numberOfChildrenTextField.prop('value')).to.eql('2');

    const numberOfChildrenTps = wrapper.find('p');
    expect(numberOfChildrenTps).to.have.length(1);
    expect(numberOfChildrenTps.text()).to.eql('1');

    const selectedSourceRadio = wrapper.find('RadioButton');
    expect(selectedSourceRadio).to.have.length(2);

    const applicationRadio = selectedSourceRadio.first();
    const tpsRadio = selectedSourceRadio.last();
    expect(applicationRadio.prop('value')).to.eql('false');
    expect(applicationRadio.prop('checked')).to.true;
    expect(tpsRadio.prop('value')).to.eql('true');
    expect(tpsRadio.prop('checked')).to.false;
  });

  it('skal oppdatere modell ved endring i tekstfelt', () => {
    const textFieldOnChangeCallback = sinon.spy();
    const wrapper = shallow(<AntallBarnForm
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

    wrapper.find('TextField').simulate('change', { target: { value: '2' } });
    expect(textFieldOnChangeCallback).to.have.property('callCount', 1);
    const args = textFieldOnChangeCallback.getCalls()[0].args;
    expect(args).to.eql(['testForm', 2, 'antallBarn']);
  });

  it('skal validere modell når fokus forlater tekstfelt', () => {
    const textFieldOnBlurCallback = sinon.spy();
    const wrapper = shallow(<AntallBarnForm
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

  it('skal oppdatere modell ved endring i radioButtons', () => {
    const radioButtonOnChangeCallback = sinon.spy();
    const wrapper = shallow(<AntallBarnForm
      code="testForm"
      model={model}
      errorMessages={{}}
    />, {
      context: {
        showErrors: false,
        updateModel: radioButtonOnChangeCallback,
        validateModel: sinon.spy(),
      },
    });

    wrapper.find('RadioButton').first().simulate('change', { target: { value: 'APPLICATION' } });
    expect(radioButtonOnChangeCallback).to.have.property('callCount', 1);
    let args = radioButtonOnChangeCallback.getCalls()[0].args;
    expect(args).to.eql(['testForm', false, 'brukAntallBarnFraTps']);

    wrapper.find('RadioButton').last().simulate('change', { target: { value: 'TPS' } });
    expect(radioButtonOnChangeCallback).to.have.property('callCount', 2);
    args = radioButtonOnChangeCallback.getCalls()[1].args;
    expect(args).to.eql(['testForm', true, 'brukAntallBarnFraTps']);
  });

  it('skal validere modell når fokus forlater tekstfelt', () => {
    const radioButtonOnBlurCallback = sinon.spy();
    const wrapper = shallow(<AntallBarnForm
      code="testForm"
      model={model}
      errorMessages={{}}
    />, {
      context: {
        showErrors: false,
        updateModel: sinon.spy(),
        validateModel: radioButtonOnBlurCallback,
      },
    });

    wrapper.find('RadioButton').first().simulate('blur');
    expect(radioButtonOnBlurCallback).to.have.property('callCount', 1);

    wrapper.find('RadioButton').last().simulate('blur');
    expect(radioButtonOnBlurCallback).to.have.property('callCount', 2);
  });
});
