import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import Fagsak from './Fagsak';

describe('<Fagsak>', () => {
  it('skal vise en fagsak med tilhørende informasjon', () => {
    const wrapper = shallow(<Fagsak
      saksnummer={12345}
      sakstype="Engangstønad"
      status="Opprettet"
    />);

    const h2 = wrapper.find('h2');
    expect(h2).to.have.length(1);
    expect(h2.text()).is.eql('Engangstønad');

    const p = wrapper.find('p');
    expect(p).to.have.length(1);
    expect(p.text()).is.eql('12345 - Opprettet');
  });
});
