import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import Home from './Home';

describe('<Home>', () => {
  it('skal vise children i div', () => {
    const wrapper = shallow(<Home
      saksbehandlerName="Per"
    ><span /></Home>);

    expect(wrapper.find('div')).to.have.length(1);
    expect(wrapper.find('span')).to.have.length(1);
  });

  it('skal ikke vise children i div', () => {
    const wrapper = shallow(<Home
      saksbehandlerName="Per"
    >{null}</Home>);

    expect(wrapper.find('div')).to.have.length(1);
    expect(wrapper.find('span')).to.have.length(0);
  });
});
