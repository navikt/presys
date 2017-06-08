import React from 'react';
import Table from 'components/elements/Table';
import { connect } from 'react-redux';


const UforegradListe = ({ uforegrad }) => <Table
  headerTextCodes={['Uforegrad.uforegradDato',
    'Uforegrad.uforegradOvrige',
    'Uforegrad.yngsteBarnFoerGrad',
    'Uforegrad.virkningsdatoUforegrad']}
  data={uforegrad.map(row => ({ key: row.virkDato,
    columns: [
          { key: 'a', value: row.uforegradDato },
          { key: 'b', value: row.uforegradOvrige },
          { key: 'c', value: row.yngsteBarnFoerGrad },
          { key: 'd', value: row.virkningsdatoUforegrad },
    ] }))}
/>;

UforegradListe.propTypes = {
  uforegrad: React.PropTypes.arrayOf(React.PropTypes.object),
};

UforegradListe.defaultProps = {
  uforegrad: [],
};

export default connect(state => ({
  uforegrad: state.person.status[0].uforehistorikk[1].uforegrader,
}), { })(UforegradListe);
