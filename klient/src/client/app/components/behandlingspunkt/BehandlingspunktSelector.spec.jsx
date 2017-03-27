import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import BehandlingspunktSelector from './BehandlingspunktSelector';

describe('<BehandlingspunktSelector>', () => {
  const behandlingspunkt = {
    navn: 'bpNavn',
    merknad: 'testmerknad',
    status: 'teststatus',
    aksjonspunkterData: {
      id: 1,
      readOnly: true,
      code: 'testkode',
      form: () => <div>test</div>,
      model: { test: '123' },
      rules: [],
    },
  };

  it('skal vise behandlingspunkt-navn og merknad', () => {
    const wrapper = shallow(<BehandlingspunktSelector
      behandlingspunkter={[behandlingspunkt]}
      selectedBehandlingspunkt={behandlingspunkt}
      selectBehandlingspunktCallback={sinon.spy()}
    />);

    const h3 = wrapper.find('h3');
    expect(h3.text()).to.eql('bpNavn');

    const p = wrapper.find('p');
    expect(p.text()).to.eql('testmerknad');
  });

  it('skal vise ett behandlingspunkt i tillegg til vedtaksikon', () => {
    const wrapper = shallow(<BehandlingspunktSelector
      behandlingspunkter={[behandlingspunkt]}
      selectedBehandlingspunkt={behandlingspunkt}
      selectBehandlingspunktCallback={sinon.spy()}
    />);

    const images = wrapper.find('Image');
    expect(images).to.have.length(2);
    expect(images.first().prop('alt')).to.eql('bpNavn');
    expect(images.last().prop('alt')).to.eql('vedtak');
  });

  it('skal vise to behandlingspunkt i tillegg til vedtaksikon', () => {
    const nyttBehandlingspunkt = {
      ...behandlingspunkt,
      navn: 'test',
    };
    const wrapper = shallow(<BehandlingspunktSelector
      behandlingspunkter={[behandlingspunkt, nyttBehandlingspunkt]}
      selectedBehandlingspunkt={behandlingspunkt}
      selectBehandlingspunktCallback={sinon.spy()}
    />);

    const images = wrapper.find('Image');
    expect(images).to.have.length(3);
    expect(images.first().prop('alt')).to.eql('bpNavn');
    expect(images.at(1).prop('alt')).to.eql('test');
    expect(images.last().prop('alt')).to.eql('vedtak');
  });

  it('skal ikke kunne velge allerede valgt behandlingspunkt med museklikk', () => {
    const selectCallback = sinon.spy();
    const wrapper = shallow(<BehandlingspunktSelector
      behandlingspunkter={[behandlingspunkt]}
      selectedBehandlingspunkt={behandlingspunkt}
      selectBehandlingspunktCallback={selectCallback}
    />);

    const image = wrapper.find('Image').first();
    image.simulate('mouseDown');
    expect(selectCallback).to.have.property('callCount', 0);
  });

  it('skal ikke kunne velge allerede valgt behandlingspunkt med tastetrykk', () => {
    const selectCallback = sinon.spy();
    const wrapper = shallow(<BehandlingspunktSelector
      behandlingspunkter={[behandlingspunkt]}
      selectedBehandlingspunkt={behandlingspunkt}
      selectBehandlingspunktCallback={selectCallback}
    />);

    const image = wrapper.find('Image').first();
    image.simulate('keyDown');
    expect(selectCallback).to.have.property('callCount', 0);
  });

  it('skal kunne velge annet behandlingspunkt med museklikk', () => {
    const selectCallback = sinon.spy();
    const nyttBehandlingspunkt = {
      ...behandlingspunkt,
      navn: 'test',
    };
    const wrapper = shallow(<BehandlingspunktSelector
      behandlingspunkter={[behandlingspunkt, nyttBehandlingspunkt]}
      selectedBehandlingspunkt={nyttBehandlingspunkt}
      selectBehandlingspunktCallback={selectCallback}
    />);

    const image = wrapper.find('Image').first();
    image.simulate('mouseDown');
    expect(selectCallback).to.have.property('callCount', 1);
  });

  it('skal kunne velge annet behandlingspunkt med tastetrykk', () => {
    const selectCallback = sinon.spy();
    const nyttBehandlingspunkt = {
      ...behandlingspunkt,
      navn: 'test',
    };
    const wrapper = shallow(<BehandlingspunktSelector
      behandlingspunkter={[behandlingspunkt, nyttBehandlingspunkt]}
      selectedBehandlingspunkt={nyttBehandlingspunkt}
      selectBehandlingspunktCallback={selectCallback}
    />);

    const image = wrapper.find('Image').first();
    image.simulate('keyDown');
    expect(selectCallback).to.have.property('callCount', 1);
  });
});
