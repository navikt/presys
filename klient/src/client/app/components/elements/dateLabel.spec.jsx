import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import DateLabel from './DateLabel';

describe('<DateLabel>', () => {
  it('skal ha en FormattedDate-komponent', () => {
    const wrapper = shallow(<DateLabel dateString="1486976062" />);
    expect(wrapper.find('FormattedDate')).to.have.length(1);
  });

  it('skal sjekke at dato blir formatert korrekt', () => {
    const wrapper = shallow(<DateLabel dateString="1486976062" />);

    const div = wrapper.find('FormattedDate');
    expect(div.prop('value')).to.eql(new Date(parseInt(1486976062, 10)));
  });
});
