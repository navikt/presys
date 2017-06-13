import React from 'react';
import { FormattedMessage } from 'react-intl';


const UforeHistorikk = ({ uftMaaned, ufg, ufKriterie, bup, bupGarantiKode, opphørsdatoMaaned,
 opphørsdatoKode, redusertAntallBupAar, foedselsaarYngsteBarn, virkningsdatoUfrHistorie }) => <ul>
   <li><FormattedMessage id="UforeHistorikk.maaned" />:{uftMaaned}</li>
   <li><FormattedMessage id="UforeHistorikk.ufg" />:{ufg}</li>
   <li><FormattedMessage id="UforeHistorikk.ufKriterie" />:{ufKriterie}</li>
   <li><FormattedMessage id="UforeHistorikk.bup" />:{bup}</li>
   <li><FormattedMessage id="UforeHistorikk.bupGarantiKode" />:{bupGarantiKode}</li>
   <li><FormattedMessage id="UforeHistorikk.opphørsdatoMaaned" />:{opphørsdatoMaaned}</li>
   <li><FormattedMessage id="UforeHistorikk.opphørsdatoKode" />:{opphørsdatoKode}</li>
   <li><FormattedMessage id="UforeHistorikk.redusertAntallBupAar" />:{redusertAntallBupAar}</li>
   <li><FormattedMessage id="UforeHistorikk.foedselsaarYngsteBarn" />:{foedselsaarYngsteBarn}</li>
   <li><FormattedMessage id="UforeHistorikk.virkningsdatoUfrHistorie" />:{virkningsdatoUfrHistorie}</li>
 </ul>;

UforeHistorikk.propTypes = {
  uftMaaned: React.PropTypes.number.isRequired,
  ufg: React.PropTypes.number.isRequired,
  ufKriterie: React.PropTypes.number.isRequired,
  bup: React.PropTypes.number.isRequired,
  bupGarantiKode: React.PropTypes.string.isRequired,
  opphørsdatoMaaned: React.PropTypes.number.isRequired,
  opphørsdatoKode: React.PropTypes.string.isRequired,
  redusertAntallBupAar: React.PropTypes.number.isRequired,
  foedselsaarYngsteBarn: React.PropTypes.number.isRequired,
  virkningsdatoUfrHistorie: React.PropTypes.number.isRequired,
};

UforeHistorikk.defaultProps = {
  uforehistorikk: [],
};

export default UforeHistorikk;
