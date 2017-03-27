import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import BehandlingListItem from './BehandlingListItem';

describe('<BehandlingListItem>', () => {
  it('skal ikke kunne toggle eller velge behandling ved mouseDown når det kun finnes en behandling', () => {
    const toggleFunction = sinon.spy();
    const selectFunction = sinon.spy();
    const wrapper = shallow(<BehandlingListItem
      onlyOneBehandling
      showAllBehandlinger={false}
      toggleShowAllBehandlingerCallback={toggleFunction}
      selectBehandlingCallback={selectFunction}
      id={1}
      type="Endringsbehandling"
      opprettetDato="22.05.2016"
      avsluttetDato="22.05.2016"
      behandlingsstatus="Under behandling"
    />);

    const div = wrapper.find('div').first();
    div.simulate('mouseDown');

    expect(toggleFunction).to.have.property('callCount', 0);
    expect(selectFunction).to.have.property('callCount', 0);
  });

  it('skal kunne toggle behandlingsvisning ved mouseDown når det finnes flere behandlinger og togglefunksjon finnes', () => {
    const toggleFunction = sinon.spy();
    const selectFunction = sinon.spy();
    const wrapper = shallow(<BehandlingListItem
      onlyOneBehandling={false}
      showAllBehandlinger={false}
      toggleShowAllBehandlingerCallback={toggleFunction}
      selectBehandlingCallback={selectFunction}
      id={1}
      type="Endringsbehandling"
      opprettetDato="22.05.2016"
      avsluttetDato="22.05.2016"
      behandlingsstatus="Under behandling"
    />);

    const div = wrapper.find('div').first();
    div.simulate('mouseDown');

    expect(toggleFunction).to.have.property('callCount', 1);
    expect(selectFunction).to.have.property('callCount', 0);
  });

  it('skal kunne velge behandling ved mouseDown når det finnes flere behandlinger og togglefunksjon ikke finnes', () => {
    const selectFunction = sinon.spy();
    const wrapper = shallow(<BehandlingListItem
      onlyOneBehandling={false}
      showAllBehandlinger={false}
      selectBehandlingCallback={selectFunction}
      id={1}
      type="Endringsbehandling"
      opprettetDato="22.05.2016"
      avsluttetDato="22.05.2016"
      behandlingsstatus="Under behandling"
    />);

    const div = wrapper.find('div').first();
    div.simulate('mouseDown');

    expect(selectFunction).to.have.property('callCount', 1);
  });

  it('skal kunne toggle visning av behandlinger ved keyDown når tast er enter eller space', () => {
    const preventDefaultFunction = sinon.spy();
    const toggleFunction = sinon.spy();
    const selectFunction = sinon.spy();
    const wrapper = shallow(<BehandlingListItem
      onlyOneBehandling={false}
      showAllBehandlinger={false}
      toggleShowAllBehandlingerCallback={toggleFunction}
      selectBehandlingCallback={selectFunction}
      id={1}
      type="Endringsbehandling"
      opprettetDato="22.05.2016"
      avsluttetDato="22.05.2016"
      behandlingsstatus="Under behandling"
    />);

    const div = wrapper.find('div').first();
    div.simulate('keyDown', { key: 'Enter', preventDefault: preventDefaultFunction });
    div.simulate('keyDown', { key: ' ', preventDefault: preventDefaultFunction });
    div.simulate('keyDown', { key: 'Back', preventDefault: preventDefaultFunction });

    expect(toggleFunction).to.have.property('callCount', 2);
  });

  it('skal ikke kunne toggle eller velge behandling ved keyDown når det kun finnes en behandling', () => {
    const preventDefaultFunction = sinon.spy();
    const toggleFunction = sinon.spy();
    const selectFunction = sinon.spy();
    const wrapper = shallow(<BehandlingListItem
      onlyOneBehandling
      showAllBehandlinger={false}
      toggleShowAllBehandlingerCallback={toggleFunction}
      selectBehandlingCallback={selectFunction}
      id={1}
      type="Endringsbehandling"
      opprettetDato="22.05.2016"
      avsluttetDato="22.05.2016"
      behandlingsstatus="Under behandling"
    />);

    const div = wrapper.find('div').first();
    div.simulate('keyDown', { key: 'Enter', preventDefault: preventDefaultFunction });

    expect(toggleFunction).to.have.property('callCount', 0);
    expect(selectFunction).to.have.property('callCount', 0);
  });

  it('skal kunne toggle behandlingsvisning ved keyDown når det finnes flere behandlinger og togglefunksjon finnes', () => {
    const preventDefaultFunction = sinon.spy();
    const toggleFunction = sinon.spy();
    const selectFunction = sinon.spy();
    const wrapper = shallow(<BehandlingListItem
      onlyOneBehandling={false}
      showAllBehandlinger={false}
      toggleShowAllBehandlingerCallback={toggleFunction}
      selectBehandlingCallback={selectFunction}
      id={1}
      type="Endringsbehandling"
      opprettetDato="22.05.2016"
      avsluttetDato="22.05.2016"
      behandlingsstatus="Under behandling"
    />);

    const div = wrapper.find('div').first();
    div.simulate('keyDown', { key: 'Enter', preventDefault: preventDefaultFunction });

    expect(toggleFunction).to.have.property('callCount', 1);
    expect(selectFunction).to.have.property('callCount', 0);
  });

  it('skal kunne velge behandling ved keyDown når det finnes flere behandlinger og togglefunksjon ikke finnes', () => {
    const preventDefaultFunction = sinon.spy();
    const selectFunction = sinon.spy();
    const wrapper = shallow(<BehandlingListItem
      onlyOneBehandling={false}
      showAllBehandlinger={false}
      selectBehandlingCallback={selectFunction}
      id={1}
      type="Endringsbehandling"
      opprettetDato="22.05.2016"
      avsluttetDato="22.05.2016"
      behandlingsstatus="Under behandling"
    />);

    const div = wrapper.find('div').first();
    div.simulate('keyDown', { key: 'Enter', preventDefault: preventDefaultFunction });

    expect(selectFunction).to.have.property('callCount', 1);
  });

  it('skal vise bilde som indikerer åpen eller lukket behandling-dropdown når toggle-funksjon finnes', () => {
    const toggleFunction = sinon.spy();
    const wrapper = shallow(<BehandlingListItem
      onlyOneBehandling={false}
      showAllBehandlinger={false}
      toggleShowAllBehandlingerCallback={toggleFunction}
      selectBehandlingCallback={sinon.spy()}
      id={1}
      type="Endringsbehandling"
      opprettetDato="22.05.2016"
      avsluttetDato="22.05.2016"
      behandlingsstatus="Under behandling"
    />);

    expect(wrapper.find('img')).to.have.length(1);
  });

  it('skal ikke vise bilde som indikerer åpen eller lukket behandling-dropdown når toggle-funksjon ikke finnes', () => {
    const wrapper = shallow(<BehandlingListItem
      onlyOneBehandling={false}
      showAllBehandlinger={false}
      selectBehandlingCallback={sinon.spy()}
      id={1}
      type="Endringsbehandling"
      opprettetDato="22.05.2016"
      avsluttetDato="22.05.2016"
      behandlingsstatus="Under behandling"
    />);

    expect(wrapper.find('img')).to.have.length(0);
  });

  it('skal vise avsluttet-dato når denne finnes', () => {
    const wrapper = shallow(<BehandlingListItem
      onlyOneBehandling={false}
      showAllBehandlinger={false}
      selectBehandlingCallback={sinon.spy()}
      id={1}
      type="Endringsbehandling"
      opprettetDato="22.05.2016"
      avsluttetDato="22.05.2016"
      behandlingsstatus="Under behandling"
    />);

    expect(wrapper.find('DateLabel')).to.have.length(2);
  });

  it('skal ikke vise avsluttet-dato når denne ikke finnes', () => {
    const wrapper = shallow(<BehandlingListItem
      onlyOneBehandling={false}
      showAllBehandlinger={false}
      selectBehandlingCallback={sinon.spy()}
      id={1}
      type="Endringsbehandling"
      opprettetDato="22.05.2016"
      behandlingsstatus="Under behandling"
    />);

    expect(wrapper.find('DateLabel')).to.have.length(1);
  });
});
