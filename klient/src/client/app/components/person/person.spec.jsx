import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import Person from './Person';

describe('<Person>', () => {
  it('skal inneholde personinfo inkludert bilde', () => {
    const wrapper = shallow(<Person
      navn="frida"
      alder={40}
      personnummer="123"
      erKvinne
      hasLargeFont
    />);

    expect(wrapper.find('div')).to.have.length(2);
    expect(wrapper.find('img')).to.have.length(1);
    expect(wrapper.find('FormattedMessage')).to.have.length(1);
  });

  it('skal sjekke at props blir brukt korrekt', () => {
    const wrapper = shallow(<Person
      navn="frida"
      alder={40}
      personnummer="12345678910"
      erKvinne
      hasLargeFont
    />);

    const h2 = wrapper.find('h2');
    expect(h2.text()).to.eql('frida (40 <FormattedMessage />)');

    const p = wrapper.find('p');
    expect(p.text()).to.eql('12345678910');
  });
});
