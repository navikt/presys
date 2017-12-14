import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import MessagePanel from './MessagePanel';

describe('<MessagePanel>', () => {
  it('skal vise feilmelding', () => {
    const wrapper = shallow(<MessagePanel
      errorMessage="Error!"
    />);

    const div = wrapper.find('FormattedMessage');
    expect(div).to.have.length(1);
    expect(div.props().id).to.equal('Error!');
  });
});
