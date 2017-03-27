import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import FagsakSearch from './FagsakSearch';

describe('<FagsakSearch>', () => {
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
    barnFoedt: '1486976062', /* ‎13‎.‎02‎.‎2017‎ ‎09‎:‎54‎:‎22 */
    opprettet: '1486976062',
    endret: '1486976062',
    person: {
      navn: 'Frida',
      alder: 44,
      personnummer: '0405198632231',
      erKvinne: true,
    },
  };

  it('skal kun vise søkefelt før søk er startet', () => {
    const setSearchStringFunction = sinon.spy();
    const searchFagsakFunction = sinon.spy();
    const wrapper = shallow(<FagsakSearch
      searchString="12345"
      fagsaker={[]}
      setSearchStringCallback={setSearchStringFunction}
      searchFagsakCallback={searchFagsakFunction}
      searchResultReceived={false}
      selectFagsakCallback={sinon.spy()}
    />);

    const searchComp = wrapper.find('Search');
    expect(searchComp).to.have.length(1);
    expect(wrapper.find('Label')).to.have.length(0);
    expect(wrapper.find('Person')).to.have.length(0);
    expect(wrapper.find('FagsakList')).to.have.length(0);

    expect(searchComp.prop('searchString')).is.eql('12345');
    expect(searchComp.prop('setSearchStringCallback')).is.eql(setSearchStringFunction);
    expect(searchComp.prop('searchFagsakCallback')).is.eql(searchFagsakFunction);
  });

  it('skal vise søkefelt og label for ingen søketreff når ingen fagsaker blir hentet', () => {
    const wrapper = shallow(<FagsakSearch
      searchString="12345"
      fagsaker={[]}
      setSearchStringCallback={sinon.spy()}
      searchFagsakCallback={sinon.spy()}
      searchResultReceived
      selectFagsakCallback={sinon.spy()}
    />);

    expect(wrapper.find('Search')).to.have.length(1);
    const labelComp = wrapper.find('Label');
    expect(labelComp).to.have.length(1);
    expect(labelComp.prop('textCode')).to.eql('FagsakSearch.ZeroSearchResults');
  });

  it('skal vise søkefelt og søketreff der person og to fagsaker blir vist', () => {
    const setSearchStringFunction = sinon.spy();
    const searchFagsakFunction = sinon.spy();
    const selectFagsakFunction = sinon.spy();
    const wrapper = shallow(<FagsakSearch
      searchString="12345"
      setSearchStringCallback={setSearchStringFunction}
      fagsaker={[fagsak, fagsak]}
      searchFagsakCallback={searchFagsakFunction}
      searchResultReceived
      selectFagsakCallback={selectFagsakFunction}
    />);

    expect(wrapper.find('Search')).to.have.length(1);
    expect(wrapper.find('Label')).to.have.length(0);

    const personComp = wrapper.find('Person');
    expect(personComp).to.have.length(1);
    expect(personComp.prop('navn')).to.eql(fagsak.person.navn);
    expect(personComp.prop('alder')).to.eql(fagsak.person.alder);
    expect(personComp.prop('personnummer')).to.eql(fagsak.person.personnummer);
    expect(personComp.prop('erKvinne')).to.eql(fagsak.person.erKvinne);
    expect(personComp.prop('hasLargeFont')).to.eql(false);

    const fagsakListComp = wrapper.find('FagsakList');
    expect(fagsakListComp).to.have.length(1);
    expect(fagsakListComp.prop('fagsaker')).to.eql([fagsak, fagsak]);
    expect(fagsakListComp.prop('selectFagsakCallback')).to.eql(selectFagsakFunction);
  });
});
