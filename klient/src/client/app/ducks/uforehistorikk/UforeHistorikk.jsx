import React from 'react';
import { FormattedMessage } from 'react-intl';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { MonthInYear } from 'components/elements/FormattedDate';
import styles from './UforeHistorikk.less';

const UforeHistorikk = ({ uftMaaned, ufg, ufKriterier, bup, bupGarantiKode, opphørsdatoMaaned,
 opphørsKode, redusertAntallBupAar, foedselsaarYngsteBarn, virkningsdatoUfrHistorie, uforegrader }) => (
   <Row>
     <Column size={7}>
       <table className={styles.infotable}><tbody>
         <tr><td><b>Uførehistorikk</b></td><td /></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.maaned" /></td><td> <DsfDate value={uftMaaned}><MonthInYear /></DsfDate></td></tr>
         <tr>
           <td><FormattedMessage id="UforeHistorikk.ufKriterier" /></td>
           <td>{ufKriterier !== ' ' ? <FormattedMessage id={`kodeverk.ufKriterier.${ufKriterier}`} /> : ''}</td>
         </tr>
         <tr><td><FormattedMessage id="UforeHistorikk.bup" /></td><td>{bup}</td></tr>
         <tr>
           <td><FormattedMessage id="UforeHistorikk.bupGarantiKode" /></td>
           <td>{bupGarantiKode !== ' ' ? <FormattedMessage id={`kodeverk.bupGarantiKode.${bupGarantiKode}`} /> : ''}</td>
         </tr>
         <tr>
           <td><FormattedMessage id="UforeHistorikk.opphørsdatoMaaned" /></td>
           <td>{opphørsKode !== ' ' ? <DsfDate value={opphørsdatoMaaned}><MonthInYear /></DsfDate> : '' }</td>
         </tr>
         <tr>
           <td><FormattedMessage id="UforeHistorikk.opphørsKode" /></td>
           <td>{opphørsKode !== ' ' ? <FormattedMessage id={`kodeverk.opphorsdato.${opphørsKode}`} /> : ''}</td>
         </tr>
         <tr><td><FormattedMessage id="UforeHistorikk.redusertAntallBupAar" /></td><td>{redusertAntallBupAar}</td></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.foedselsaarYngsteBarn" /></td><td>{foedselsaarYngsteBarn}</td></tr>
         <tr>
           <td><FormattedMessage id="UforeHistorikk.virkningsdatoUfrHistorie" /></td>
           <td>{virkningsdatoUfrHistorie !== 0 ? <DsfDate value={virkningsdatoUfrHistorie}><MonthInYear /></DsfDate> : '' }</td>
         </tr>
       </tbody></table>
     </Column><Column size={5}>
       <table className={styles.infotable}><tbody>
         <tr>
           <td><b>Dato</b></td>
           <td><b>Grad</b></td>
           <td><b>Fødselsår yngste barn</b></td>
         </tr>
         <tr>
           <td>{<DsfDate value={uftMaaned}><MonthInYear /></DsfDate>}</td>
           <td>{ufg}</td>
           <td>{foedselsaarYngsteBarn || ''}</td>
         </tr>
         {uforegrader.map(grad =>
           <tr key={grad.uforegradDato}>
             <td>{grad.uforegradDato !== 0 ? <DsfDate value={grad.uforegradDato}><MonthInYear /></DsfDate> : '' }</td>
             <td>{grad.uforegradOvrige}</td>
             <td>{grad.yngsteBarnFoerGrad !== 0 ? <DsfDate value={grad.yngsteBarnFoerGrad}><MonthInYear /></DsfDate> : '' }</td>
           </tr>)}
       </tbody></table>
     </Column>
   </Row>);

UforeHistorikk.propTypes = {
  uftMaaned: React.PropTypes.number.isRequired,
  ufg: React.PropTypes.number.isRequired,
  ufKriterier: React.PropTypes.number.isRequired,
  bup: React.PropTypes.number.isRequired,
  bupGarantiKode: React.PropTypes.string.isRequired,
  opphørsdatoMaaned: React.PropTypes.number.isRequired,
  opphørsKode: React.PropTypes.string.isRequired,
  redusertAntallBupAar: React.PropTypes.number.isRequired,
  foedselsaarYngsteBarn: React.PropTypes.number.isRequired,
  virkningsdatoUfrHistorie: React.PropTypes.number.isRequired,
  uforegrader: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
};

UforeHistorikk.defaultProps = {
  uforehistorikk: [],
};

export default UforeHistorikk;
