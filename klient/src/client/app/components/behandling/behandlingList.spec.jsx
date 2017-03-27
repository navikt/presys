import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import BehandlingList from './BehandlingList';

describe('<BehandlingList>', () => {
  const behandling = {
    id: 1,
    type: {
      kode: 'BT-001',
      navn: 'Endringssøknad',
    },
    opprettet: '1486976062', /* ‎13‎.‎02‎.‎2017‎ ‎09‎:‎54‎:‎22 */
    avsluttet: '1486976062', /* ‎13‎.‎02‎.‎2017‎ ‎09‎:‎54‎:‎22 */
    endret: '1486976062',    /* ‎13‎.‎02‎.‎2017‎ ‎09‎:‎54‎:‎22 */
    status: {
      kode: 'OPPR',
      navn: 'Opprettet',
    },
  };

  it('skal vise Label:ingen behandlinger når ingen behandlinger er valgt', () => {
    const clickHandler = sinon.spy();
    const wrapper = shallow(<BehandlingList
      behandlinger={[]}
      showAllBehandlinger={false}
      selectBehandlingCallback={clickHandler}
      toggleShowAllBehandlingerCallback={clickHandler}
    />);

    expect(wrapper.find('Label')).to.have.length(1);
    expect(wrapper.find('BehandlingListItem')).to.have.length(0);
  });

  it('skal vise kun en BehandlingListItem når det finnes kun en behandling og denne er valgt', () => {
    const selectBehandlingClickHandler = sinon.spy();
    const showAllClickHandler = sinon.spy();
    const wrapper = shallow(<BehandlingList
      behandlinger={[behandling]}
      selectedBehandling={behandling}
      showAllBehandlinger={false}
      selectBehandlingCallback={selectBehandlingClickHandler}
      toggleShowAllBehandlingerCallback={showAllClickHandler}
    />);

    expect(wrapper.find('Label')).to.have.length(0);
    const behandlingListItem = wrapper.find('BehandlingListItem');
    expect(behandlingListItem).to.have.length(1);
    expect(behandlingListItem.prop('onlyOneBehandling')).to.eql(true);
    expect(behandlingListItem.prop('showAllBehandlinger')).to.eql(false);
    expect(behandlingListItem.prop('toggleShowAllBehandlingerCallback')).to.eql(null);
    expect(behandlingListItem.prop('selectBehandlingCallback')).to.eql(selectBehandlingClickHandler);
    expect(behandlingListItem.prop('id')).to.eql(behandling.id);
    expect(behandlingListItem.prop('type')).to.eql(behandling.type.navn);
    expect(behandlingListItem.prop('opprettetDato')).to.eql(behandling.opprettet);
    expect(behandlingListItem.prop('avsluttetDato')).to.eql(behandling.avsluttet);
    expect(behandlingListItem.prop('behandlingsstatus')).to.eql(behandling.status.navn);
  });

  it('skal sortere og vise flere BehandlingListItem når det finnes flere behandlinger', () => {
    const behandling2 = {
      id: 2,
      type: {
        kode: 'BT-001',
        navn: 'Endringssøknad',
      },
      opprettet: '1086992121', /* 16‎.‎07‎.‎2004‎ ‎17‎:‎35‎:‎21 */
      endret: '1089992121',
      avsluttet: '1089992121',
      status: {
        kode: 'OPPR',
        navn: 'Opprettet',
      },
    };
    const behandling3 = {
      id: 3,
      type: {
        kode: 'BT-001',
        navn: 'Endringssøknad',
      },
      opprettet: '1486976062', /* ‎13‎.‎02‎.‎2017‎ ‎09‎:‎54‎:‎22 */
      endret: '1486976062',
      avsluttet: '1486976062',
      status: {
        kode: 'OPPR',
        navn: 'Opprettet',
      },
    };

    const selectBehandlingClickHandler = sinon.spy();
    const toggleClickHandler = sinon.spy();

    const wrapper = shallow(<BehandlingList
      behandlinger={[behandling, behandling2, behandling3]}
      selectedBehandling={behandling}
      showAllBehandlinger
      selectBehandlingCallback={selectBehandlingClickHandler}
      toggleShowAllBehandlingerCallback={toggleClickHandler}
    />);

    const behandlingListItem = wrapper.find('BehandlingListItem');
    expect(behandlingListItem).to.have.length(3);
    const listItem = behandlingListItem.first();
    expect(listItem.prop('onlyOneBehandling')).to.eql(false);
    expect(listItem.prop('showAllBehandlinger')).to.eql(true);
    expect(listItem.prop('toggleShowAllBehandlingerCallback')).to.eql(toggleClickHandler);
    expect(listItem.prop('selectBehandlingCallback')).to.eql(selectBehandlingClickHandler);
    expect(listItem.prop('id')).to.eql(behandling.id);
    expect(listItem.prop('type')).to.eql(behandling.type.navn);
    expect(listItem.prop('opprettetDato')).to.eql(behandling.opprettet);
    expect(listItem.prop('avsluttetDato')).to.eql(behandling.avsluttet);
    expect(listItem.prop('behandlingsstatus')).to.eql(behandling.status.navn);

    const listItem3 = behandlingListItem.last();
    expect(listItem3.prop('id')).to.eql(behandling2.id);
  });
});
