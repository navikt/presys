import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import MessagePanel from './MessagePanel';

describe('<MessagePanel>', () => {
  it('skal vise feilmelding', () => {
    const wrapper = shallow(<MessagePanel
      errorMessage="Error!"
    />);

    const div = wrapper.find('div');
    expect(div).to.have.length(1);
    expect(div.text()).to.eql('Error!');
  });
});
