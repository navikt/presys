import React from 'react';
import { FormattedMessage } from 'react-intl';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import styles from './UforeHistorikk.less';


const UforeHistorikk = ({ uftMaaned, ufg, ufKriterie, bup, bupGarantiKode, opphørsdatoMaaned,
 opphørsdatoKode, redusertAntallBupAar, foedselsaarYngsteBarn, virkningsdatoUfrHistorie, uforegrader }) => (
   <Row>
     <Column size={8}>
       <table className={styles.infotable}>
         <tr><td><b>Historikk</b></td><td /></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.maaned" /></td><td>{uftMaaned}</td></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.ufKriterie" /></td><td>{ufKriterie}</td></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.bup" /></td><td>{bup}</td></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.bupGarantiKode" /></td><td>{bupGarantiKode}</td></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.opphørsdatoMaaned" /></td><td>{opphørsdatoMaaned}</td></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.opphørsdatoKode" /></td><td>{opphørsdatoKode}</td></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.redusertAntallBupAar" /></td><td>{redusertAntallBupAar}</td></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.foedselsaarYngsteBarn" /></td><td>{foedselsaarYngsteBarn}</td></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.virkningsdatoUfrHistorie" /></td><td>{virkningsdatoUfrHistorie}</td></tr>
       </table>
     </Column><Column size={4}>
       <table className={styles.infotable}>
         <tr><td><b>Dato</b></td><td><b>Grad</b></td></tr>
         <tr><td>{uftMaaned}</td><td>{ufg}</td></tr>
         {uforegrader.map(grad => <tr><td>{grad.uforegradDato}</td><td>{grad.uforegradOvrige}</td></tr>)}
       </table>
     </Column>
   </Row>);

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
  uforegrader: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
};

UforeHistorikk.defaultProps = {
  uforehistorikk: [],
};

export default UforeHistorikk;
