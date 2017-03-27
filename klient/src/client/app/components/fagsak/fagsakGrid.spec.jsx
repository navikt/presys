import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import FagsakGrid from './FagsakGrid';

describe('<FagsakGrid>', () => {
  const fagsak = {
    saksnummer: 12345,
    sakstype: {
      navn: 'Engangsstonad',
      kode: 'TEST',
    },
    status: {
      navn: 'Under behandling',
      kode: 'UBEH',
    },
    barnFoedt: '10.10.2016',
    opprettet: '10.10.2016',
    person: {
      navn: 'Frida',
      alder: 44,
      personnummer: '0405198632231',
      erKvinne: true,
    },
  };

  it('skal vise fagsak og person når fagsak er valgt', () => {
    const wrapper = shallow(<FagsakGrid
      selectedFagsak={fagsak}
      behandlingListePanel={<span />}
      infoPanel={<span />}
      behandlingspunktPanel={<span />}
    />);

    const person = wrapper.find('Person');
    expect(person).to.have.length(1);
    const fagsakComp = wrapper.find('Fagsak');
    expect(fagsakComp).to.have.length(1);
  });


  it('skal ikke vise fagsak og person når fagsak ikke er valgt', () => {
    const wrapper = shallow(<FagsakGrid
      behandlingListePanel={<span />}
      infoPanel={<span />}
      behandlingspunktPanel={<span />}
    />);

    const person = wrapper.find('Person');
    expect(person).to.have.length(0);
    const fagsakComp = wrapper.find('Fagsak');
    expect(fagsakComp).to.have.length(0);
  });

  it('skal rendre props', () => {
    const wrapper = shallow(<FagsakGrid
      behandlingListePanel={<behandlingListe />}
      infoPanel={<infoPanel />}
      behandlingspunktPanel={<vilkaarPanel />}
    />);

    expect(wrapper.find('behandlingListe')).to.have.length(1);
    expect(wrapper.find('infoPanel')).to.have.length(1);
    expect(wrapper.find('vilkaarPanel')).to.have.length(1);
  });
});
