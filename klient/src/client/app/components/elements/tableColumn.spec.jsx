import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import TableColumn from './TableColumn';

describe('<TableColumn>', () => {
  it('skal vise oversatt tekstverdi i kolonneheader', () => {
    const wrapper = shallow(<TableColumn textCode="Tekstkode" />);

    expect(wrapper.find('th')).to.have.length(1);
    expect(wrapper.find('FormattedMessage')).to.have.length(1);
    expect(wrapper.find('FormattedMessage').prop('id')).is.eql('Tekstkode');
  });

  it('skal vise verdi i kolonne', () => {
    const wrapper = shallow(<TableColumn value="Tekstverdi" />);

    expect(wrapper.find('td')).to.have.length(1);
    expect(wrapper.find('td').text()).is.eql('Tekstverdi');
  });
});
