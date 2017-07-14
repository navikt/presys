import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import Header from './Header';

describe('<Header>', () => {
  it('skal vise MessagePanel når det finnes feilmelding', () => {
    const wrapper = shallow(<Header saksbehandlerName="Per" errorMessage="Error!" />);

    const messagePanel = wrapper.find('MessagePanel');
    expect(messagePanel).to.have.length(1);
    expect(messagePanel.prop('errorMessage')).to.eql('Error!');
  });

  it('skal ikke vise MessagePanel når det ikke finnes feilmelding', () => {
    const wrapper = shallow(<Header saksbehandlerName="Per" />);

    expect(wrapper.find('MessagePanel')).to.have.length(0);
  });
});
