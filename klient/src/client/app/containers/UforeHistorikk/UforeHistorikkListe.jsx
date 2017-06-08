import React from 'react';
import Table from 'components/elements/Table';
import { connect } from 'react-redux';


const UforeHistorikkListe = ({ uforehistorikk }) => <Table
  headerTextCodes={['UforeHistorikk.uftMaaned',
    'UforeHistorikk.ufg',
    'UforeHistorikk.ufKriterie',
    'UforeHistorikk.bup',
    'UforeHistorikk.bupGarantiKode',
    'UforeHistorikk.opphørsdatoMaaned',
    'UforeHistorikk.opphørsdatoKode',
    'UforeHistorikk.redusertAntallBupAar',
    'UforeHistorikk.foedselsaarYngsteBarn',
    'UforeHistorikk.virkningsdatoUfrHistorie']}
  data={uforehistorikk.map(row => ({ key: row.virkDato,
    columns: [
          { key: 'a', value: row.uftMaaned },
          { key: 'b', value: row.ufg },
          { key: 'c', value: row.ufKriterie },
          { key: 'd', value: row.bup },
          { key: 'e', value: row.bupGarantiKode },
          { key: 'f', value: row.opphørsdatoMaaned },
          { key: 'g', value: row.opphørsdatoKode },
          { key: 'h', value: row.redusertAntallBupAar },
          { key: 'i', value: row.foedselsaarYngsteBarn },
          { key: 'j', value: row.virkningsdatoUfrHistorie },
    ] }))}
/>;

UforeHistorikkListe.propTypes = {
  uforehistorikk: React.PropTypes.arrayOf(React.PropTypes.object),
};

UforeHistorikkListe.defaultProps = {
  uforehistorikk: [],
};

export default connect(state => ({
  uforehistorikk: state.person.status[0].uforehistorikk,
}), { })(UforeHistorikkListe);
