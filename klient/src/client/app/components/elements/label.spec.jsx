import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import Label from './Label';

describe('<Label>', () => {
  it('skal ha en div og en tekstkomponenet', () => {
    const wrapper = shallow(<Label textCode="tekstkode" />);
    expect(wrapper.find('div')).to.have.length(1);
    expect(wrapper.find('FormattedMessage')).to.have.length(1);
  });

  it('skal sjekke at alle props blir satt korrekt', () => {
    const wrapper = shallow(<Label textCode="tekstkode" className="test" />);

    const div = wrapper.find('div');
    expect(div.prop('className')).to.eql('test');

    const FormattedMessage = wrapper.find('FormattedMessage');
    expect(FormattedMessage.prop('id')).to.eql('tekstkode');
  });
});
