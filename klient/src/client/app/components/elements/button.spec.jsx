import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import Button from './Button';

describe('<Button>', () => {
  it('skal inneholde en knapp med tekst', () => {
    const onButtonClick = sinon.spy();
    const wrapper = shallow(<Button textCode="" onClick={onButtonClick} />);
    expect(wrapper.find('button')).to.have.length(1);
    expect(wrapper.find('FormattedMessage')).to.have.length(1);
  });

  it('skal sjekke at alle props blir brukt korrekt', () => {
    const onClick = sinon.spy();
    const wrapper = shallow(<Button
      textCode="Button.Text"
      className="buttonClass"
      onClick={onClick}
      tabIndex="0"
      autoFocus={false}
    />);

    const button = wrapper.find('button');
    expect(button.prop('className')).to.eql('buttonClass');
    expect(button.prop('onClick')).to.eql(onClick);
    expect(button.prop('tabIndex')).to.eql('0');
    expect(button.prop('autoFocus')).to.eql(false);

    const formattedMessage = wrapper.find('FormattedMessage');
    expect(formattedMessage.prop('id')).to.eql('Button.Text');
  });

  it('skal sjekke at knappe-callback blir trigget', () => {
    const onButtonClick = sinon.spy();
    const wrapper = shallow(<Button textCode="" onClick={onButtonClick} />);

    wrapper.find('button').simulate('click');

    expect(onButtonClick).to.have.property('callCount', 1);
  });
});
