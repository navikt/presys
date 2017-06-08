import React from 'react';
/*import { FormattedMessage } from 'react-intl';
import { connect } from 'react-redux';*/
/*

const UforeHistorikk = ({ uftMaaned, ufg, ufKriterie, bup, bupGarantiKode, opphørsdatoMaaned,
 opphørsdatoKode, redusertAntallBupAar, foedselsaarYngsteBarn, virkningsdatoUfrHistorie }) => <ul>
  <li><FormattedMessage id="UforeHistorikk.uftMaaned" />:{uftMaaned}</li>
  <li><FormattedMessage id="UforeHistorikk.ufg" />:{ufg}</li>
  <li><FormattedMessage id="UforeHistorikk.ufKriterie" />:{ufKriterie}</li>
  <li><FormattedMessage id="UforeHistorikk.bup" />:{bup}</li>
  <li><FormattedMessage id="UforeHistorikk.bupGarantiKode" />:{bupGarantiKode}</li>
  <li><FormattedMessage id="UforeHistorikk.opphørsdatoMaaned" />:{opphørsdatoMaaned}</li>
  <li><FormattedMessage id="UforeHistorikk.opphørsdatoKode" />:{opphørsdatoKode}</li>
  <li><FormattedMessage id="UforeHistorikk.redusertAntallBupAar" />:{redusertAntallBupAar}</li>
  <li><FormattedMessage id="UforeHistorikk.foedselsaarYngsteBarn" />:{foedselsaarYngsteBarn}</li>
  <li><FormattedMessage id="UforeHistorikk.virkningsdatoUfrHistorie" />:{virkningsdatoUfrHistorie}</li>

UforeHistorikk.propTypes = {
  uforehistorikk: React.PropTypes.arrayOf(React.PropTypes.object),
};

UforeHistorikk.defaultProps = {
  uforehistorikk: [],
};

/*export default connect(state => ({
  uforehistorikk: state.person.uforehistorikk,
}), { })(UforeHistorikk);
*/