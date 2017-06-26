import React from 'react';
import { FormattedMessage } from 'react-intl';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import YyyyMmDd from 'components/elements/YyyyMmDd2MonthInYear';
import styles from './UforeHistorikk.less';

const UforeHistorikk = ({ uftMaaned, ufg, ufKriterie, bup, bupGarantiKode, opphørsdatoMaaned,
 opphørsdatoKode, redusertAntallBupAar, foedselsaarYngsteBarn, virkningsdatoUfrHistorie, uforegrader }) => (
   <Row>
     <Column size={7}>
       <table className={styles.infotable}><tbody>
         <tr><td><b>Uførehistorikk</b></td><td /></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.maaned" /></td><td><YyyyMmDd value={uftMaaned} /></td></tr>
         <tr>
           <td><FormattedMessage id="UforeHistorikk.ufKriterie" /></td>
           <td>{ufKriterie !== ' ' ? <FormattedMessage id={`kodeverk.ufKriterie.${ufKriterie}`} /> : ''}</td>
         </tr>
         <tr><td><FormattedMessage id="UforeHistorikk.bup" /></td><td>{bup}</td></tr>
         <tr>
           <td><FormattedMessage id="UforeHistorikk.bupGarantiKode" /></td>
           <td>{bupGarantiKode !== ' ' ? <FormattedMessage id={`kodeverk.bupGarantiKode.${bupGarantiKode}`} /> : ''}</td>
         </tr>
         <tr>
           <td><FormattedMessage id="UforeHistorikk.opphørsdatoMaaned" /></td>
           <td>{opphørsdatoKode !== ' ' ? <YyyyMmDd value={opphørsdatoMaaned} /> : '' }</td>
         </tr>
         <tr>
           <td><FormattedMessage id="UforeHistorikk.opphørsdatoKode" /></td>
           <td>{opphørsdatoKode !== ' ' ? <FormattedMessage id={`kodeverk.opphorsdato.${opphørsdatoKode}`} /> : ''}</td>
         </tr>
         <tr><td><FormattedMessage id="UforeHistorikk.redusertAntallBupAar" /></td><td>{redusertAntallBupAar}</td></tr>
         <tr><td><FormattedMessage id="UforeHistorikk.foedselsaarYngsteBarn" /></td><td>{foedselsaarYngsteBarn}</td></tr>
         <tr>
           <td><FormattedMessage id="UforeHistorikk.virkningsdatoUfrHistorie" /></td>
           <td>{virkningsdatoUfrHistorie !== 0 ? <YyyyMmDd value={virkningsdatoUfrHistorie} /> : '' }</td>
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
           <td>{<YyyyMmDd value={uftMaaned} />}</td>
           <td>{ufg}</td>
           <td>{foedselsaarYngsteBarn || ''}</td>
         </tr>
         {uforegrader.map(grad =>
           <tr key={grad.uforegradDato}>
             <td>{grad.uforegradDato !== 0 ? <YyyyMmDd value={grad.uforegradDato} /> : '' }</td>
             <td>{grad.uforegradOvrige}</td>
             <td>{grad.yngsteBarnFoerGrad !== 0 ? <YyyyMmDd value={grad.yngsteBarnFoerGrad} /> : '' }</td>
           </tr>)}
       </tbody></table>
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
