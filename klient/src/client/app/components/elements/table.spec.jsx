import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import Table from './Table';

describe('<Table>', () => {
  const tableData = [{
    key: 1,
    columns: [
      { key: '1', value: 12345 },
      { key: '2', value: 23446 },
    ],
  }];

  const headerTextCodes = [
    'FagsakList.Saksnummer',
    'FagsakList.Sakstype',
  ];

  it('skal vise korrekt antall kolonneheadere med korrekt tekst', () => {
    const callbackFunction = sinon.spy();
    const wrapper = shallow(<Table
      headerTextCodes={headerTextCodes}
      data={tableData}
      onMouseDownRow={callbackFunction}
      onKeyDownRow={callbackFunction}
      tabIndex="0"
    />);

    expect(wrapper.find('table')).to.have.length(1);
    const tableHeaderRow = wrapper.find('thead').children();
    expect(tableHeaderRow).to.have.length(1);

    const tableHeaderCols = tableHeaderRow.children();
    expect(tableHeaderCols).to.have.length(2);
    expect(tableHeaderCols.first().prop('textCode')).to.eql('FagsakList.Saksnummer');
    expect(tableHeaderCols.last().prop('textCode')).to.eql('FagsakList.Sakstype');
  });

  it('skal vise korrekt antall rader og kolonner', () => {
    const dataArray = [...tableData, {
      key: 2,
      columns: [
        { key: '1', value: 34567 },
        { key: '2', value: 45678 },
      ],
    }];

    const callbackFunction = sinon.spy();
    const wrapper = shallow(<Table
      headerTextCodes={headerTextCodes}
      data={dataArray}
      onMouseDownRow={callbackFunction}
      onKeyDownRow={callbackFunction}
      tabIndex="0"
    />);

    expect(wrapper.find('table')).to.have.length(1);
    const tableBodyRows = wrapper.find('tbody').children();
    expect(tableBodyRows).to.have.length(2);

    const tableBodyRow1 = tableBodyRows.first();
    expect(tableBodyRow1.prop('id')).to.eql(1);
    const tableBodyRow1Cols = tableBodyRow1.children();
    expect(tableBodyRow1Cols).to.have.length(2);
    expect(tableBodyRow1Cols.first().prop('value')).to.eql(12345);
    expect(tableBodyRow1Cols.last().prop('value')).to.eql(23446);

    const tableBodyRow2 = tableBodyRows.last();
    expect(tableBodyRow2.prop('id')).to.eql(2);
    const tableBodyRow2Cols = tableBodyRow2.children();
    expect(tableBodyRow2Cols).to.have.length(2);
    expect(tableBodyRow2Cols.first().prop('value')).to.eql(34567);
    expect(tableBodyRow2Cols.last().prop('value')).to.eql(45678);
  });
});
