import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import TextField from './TextField';

describe('<TextField>', () => {
  it('skal inneholde en knapp med tilhørende label når id er oppgitt', () => {
    const onChange = sinon.spy();
    const wrapper = shallow(<TextField
      id="1"
      labelClassName="labelTestClass"
      labelTextCode="testTextCode"
      textFieldClassName="textFieldTestClass"
      value="defaultvalue"
      onChange={onChange}
      onKeyDown={onChange}
      autoFocus
    />);

    expect(wrapper.find('label')).to.have.length(1);
    expect(wrapper.find('FormattedMessage')).to.have.length(1);
    expect(wrapper.find('input')).to.have.length(1);
  });

  it('skal inneholde en knapp uten tilhørende label når id mangler', () => {
    const onChange = sinon.spy();
    const wrapper = shallow(<TextField
      labelClassName="labelTestClass"
      labelTextCode="testTextCode"
      textFieldClassName="textFieldTestClass"
      value="defaultvalue"
      onChange={onChange}
      onKeyDown={onChange}
      autoFocus
    />);

    expect(wrapper.find('label')).to.have.length(0);
    expect(wrapper.find('FormattedMessage')).to.have.length(0);
    expect(wrapper.find('input')).to.have.length(1);
  });

  it('skal sjekke at alle props blir brukt korrekt', () => {
    const onChange = sinon.spy();
    const wrapper = shallow(<TextField
      id="1"
      labelClassName="labelTestClass"
      labelTextCode="testTextCode"
      textFieldClassName="textFieldTestClass"
      value="defaultvalue"
      onChange={onChange}
      onKeyDown={onChange}
      autoFocus
    />);

    const label = wrapper.find('label');
    expect(label.prop('className')).to.eql('labelTestClass');
    expect(label.prop('htmlFor')).to.eql('1');

    const formattedMessage = wrapper.find('FormattedMessage');
    expect(formattedMessage.prop('id')).to.eql('testTextCode');

    const input = wrapper.find('input');
    expect(input.prop('id')).to.eql('1');
    expect(input.prop('className')).to.eql('textFieldTestClass');
    expect(input.prop('type')).to.eql('text');
    expect(input.prop('value')).to.eql('defaultvalue');
    expect(input.prop('onChange')).to.eql(onChange);
    expect(input.prop('onKeyDown')).to.eql(onChange);
    expect(input.prop('autoFocus')).to.eql(true);
  });

  it('skal sjekke at tekstendrings-callback blir trigget', () => {
    const onChange = sinon.spy();
    const wrapper = shallow(<TextField
      labelTextCode="testTextCode"
      value="defaultvalue"
      onChange={onChange}
      onKeyDown={onChange}
    />);

    wrapper.find('input').simulate('change');
    expect(onChange).to.have.property('callCount', 1);

    wrapper.find('input').simulate('keyDown');
    expect(onChange).to.have.property('callCount', 2);
  });
});
