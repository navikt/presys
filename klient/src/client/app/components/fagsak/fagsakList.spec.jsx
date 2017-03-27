import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import FagsakList from './FagsakList';

describe('<FagsakList>', () => {
  const person = {
    navn: 'Frida',
    alder: 44,
    personnummer: '0405198632231',
    erKvinne: true,
  };

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
    barnFoedt: null,
    opprettet: '1089992121', /* ‎16‎.‎07‎.‎2004‎ ‎17‎:‎35‎:‎21 */
    endret: '1089992121',
    person,
  };

  const headerTextCodes = [
    'FagsakList.Saksnummer',
    'FagsakList.Sakstype',
    'FagsakList.Status',
    'FagsakList.ChildBorn',
  ];

  it('skal vise en tabell med en rad og tilhørende kolonnedata', () => {
    const clickFunction = sinon.spy();
    const wrapper = shallow(<FagsakList fagsaker={[fagsak]} selectFagsakCallback={clickFunction} />);

    const table = wrapper.find('Table');
    expect(table).to.have.length(1);

    expect(table.prop('headerTextCodes')).to.eql(headerTextCodes);
    expect(table.prop('data')).to.eql([{
      key: 12345,
      columns: [{
        key: '12345-1',
        value: 12345,
      }, {
        key: '12345-2',
        value: 'Engangsstonad',
      }, {
        key: '12345-3',
        value: 'Under behandling',
      }, {
        key: '12345-4',
        value: null,
      }],
    }]);
    expect(table.prop('tabIndex')).to.eql('0');
  });

  it('skal sortere søkeresultat der avsluttede skal vises sist, mens sist endrede skal vises først', () => {
    const fagsak2 = {
      saksnummer: 23456,
      sakstype: {
        navn: 'Engangsstonad',
        kode: 'TEST',
      },
      status: {
        navn: 'Under behandling',
        kode: 'UBEH',
      },
      barnFoedt: null,
      opprettet: '1486976062', /* ‎13‎.‎02‎.‎2017‎ ‎09‎:‎54‎:‎22 */
      endret: '1486976062', /* ‎13‎.‎02‎.‎2017‎ ‎09‎:‎54‎:‎22 */
      person,
    };
    const fagsak3 = {
      saksnummer: 34567,
      sakstype: {
        navn: 'Engangsstonad',
        kode: 'TEST',
      },
      status: {
        navn: 'Avsluttet',
        kode: 'AVSLU',
      },
      barnFoedt: null,
      opprettet: '1486976062', /* ‎13‎.‎02‎.‎2017‎ ‎09‎:‎54‎:‎22 */
      endret: '1486976062', /* ‎13‎.‎02‎.‎2017‎ ‎09‎:‎54‎:‎22 */
      person,
    };
    const fagsaker = [fagsak, fagsak2, fagsak3];
    const wrapper = shallow(<FagsakList fagsaker={fagsaker} selectFagsakCallback={() => true} />);

    const table = wrapper.find('Table');
    expect(table.prop('data')).to.eql([{
      key: 23456,
      columns: [{
        key: '23456-1',
        value: 23456,
      }, {
        key: '23456-2',
        value: 'Engangsstonad',
      }, {
        key: '23456-3',
        value: 'Under behandling',
      }, {
        key: '23456-4',
        value: null,
      }],
    }, {
      key: 12345,
      columns: [{
        key: '12345-1',
        value: 12345,
      }, {
        key: '12345-2',
        value: 'Engangsstonad',
      }, {
        key: '12345-3',
        value: 'Under behandling',
      }, {
        key: '12345-4',
        value: null,
      }],
    }, {
      key: 34567,
      columns: [{
        key: '34567-1',
        value: 34567,
      }, {
        key: '34567-2',
        value: 'Engangsstonad',
      }, {
        key: '34567-3',
        value: 'Avsluttet',
      }, {
        key: '34567-4',
        value: null,
      }],
    }]);
  });

  it('skal vise DateLabel i tabell kun om barn er født', () => {
    const fagsak4 = {
      saksnummer: 23456,
      sakstype: {
        navn: 'Engangsstonad',
        kode: 'TEST',
      },
      status: {
        navn: 'Under behandling',
        kode: 'UBEH',
      },
      barnFoedt: '1486976062',
      opprettet: '1486976062', /* 13‎.‎02‎.‎2017‎ ‎09‎:‎54‎:‎22 */
      endret: '1486976062',
      person,
    };

    const clickFunction = sinon.spy();
    const wrapper = shallow(<FagsakList fagsaker={[fagsak, fagsak4]} selectFagsakCallback={clickFunction} />);

    const table = wrapper.find('Table');
    expect(table.prop('data')[0].columns[3].value).to.not.be.null;
    expect(table.prop('data')[1].columns[3].value).to.be.null;
  });
});
