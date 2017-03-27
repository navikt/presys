import React from 'react';

import Table from 'elements/Table';
import DateLabel from 'elements/DateLabel';
import fagsakPropType from 'constants/propTypes/fagsakPropType';

import styles from './fagsakList.less';

const headerTextCodes = [
  'FagsakList.Saksnummer',
  'FagsakList.Sakstype',
  'FagsakList.Status',
  'FagsakList.ChildBorn',
];

const FagsakList = ({
  fagsaker,
  selectFagsakCallback,
}) => {
  const sortedFagsaker = fagsaker.sort((fagsak1, fagsak2) => {
    if (fagsak1.status.kode === 'AVSLU' && fagsak2.status.kode !== 'AVSLU') {
      return 1;
    } else if (fagsak1.status.kode !== 'AVSLU' && fagsak2.status.kode === 'AVSLU') {
      return -1;
    }
    const changeTimeFagsak1 = fagsak1.endret ? fagsak1.endret : fagsak1.opprettet;
    const changeTimeFagsak2 = fagsak2.endret ? fagsak2.endret : fagsak2.opprettet;
    return new Date(parseInt(changeTimeFagsak1, 10)) < new Date(parseInt(changeTimeFagsak2, 10)) ? 1 : -1;
  });

  const tableData = sortedFagsaker.map(fagsak => ({
    key: fagsak.saksnummer,
    columns: [
        { key: `${fagsak.saksnummer}-1`, value: fagsak.saksnummer },
        { key: `${fagsak.saksnummer}-2`, value: fagsak.sakstype.navn },
        { key: `${fagsak.saksnummer}-3`, value: fagsak.status.navn },
        { key: `${fagsak.saksnummer}-4`, value: fagsak.barnFoedt ? <DateLabel dateString={fagsak.barnFoedt} /> : null },
    ],
  }));

  return (
    <Table
      headerTextCodes={headerTextCodes}
      data={tableData}
      onMouseDownRow={selectFagsakCallback}
      onKeyDownRow={selectFagsakCallback}
      tabIndex="0"
      classNameTable={styles.table}
    />
  );
};

FagsakList.propTypes = {
  fagsaker: React.PropTypes.arrayOf(fagsakPropType).isRequired,
  selectFagsakCallback: React.PropTypes.func.isRequired,
};

export default FagsakList;
