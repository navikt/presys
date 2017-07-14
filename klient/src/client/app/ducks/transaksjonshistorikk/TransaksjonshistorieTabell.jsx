import Table from 'components/elements/Table';
import React from 'react';

export const TransaksjonshistorieListe = ({ transaksjonshistorie }) => <div>{!transaksjonshistorie ? null : <Table
  headerTextCodes={['Transaksjonshistorie.vtp_key',
    'Transaksjonshistorie.grunnblankettkode',
    'Transaksjonshistorie.prioritetskode',
    'Transaksjonshistorie.virkningsdato',
    'Transaksjonshistorie.registreringsdato',
    'Transaksjonshistorie.trygdekontornummer',
    'Transaksjonshistorie.sivilstand',
    'Transaksjonshistorie.spraak',
    'Transaksjonshistorie.transaksjonsreturkode',
    'Transaksjonshistorie.terminalId',
    'Transaksjonshistorie.autoTerminalId']}
  data={transaksjonshistorie.map(row => ({ key: row.vtp_key,
    columns: [
          { key: 'a', value: row.vtp_key },
          { key: 'b', value: row.grunnblankettkode },
          { key: 'c', value: row.prioritetskode },
          { key: 'd', value: row.virkningsdato },
          { key: 'e', value: row.registreringsdato },
          { key: 'f', value: row.trygdekontornummer },
          { key: 'g', value: row.sivilstand },
          { key: 'h', value: row.spraak },
          { key: 'i', value: row.transaksjonsreturkode },
          { key: 'j', value: row.terminalId },
          { key: 'k', value: row.autoTerminalId },
    ] }))}
/>
        }</div>;

TransaksjonshistorieListe.propTypes = {
  transaksjonshistorie: React.PropTypes.arrayOf(React.PropTypes.object),
};

TransaksjonshistorieListe.defaultProps = {
  transaksjonshistorie: [],
};

export default TransaksjonshistorieListe;

