import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';
import { FormattedMessage, FormattedNumber } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

const YrkesskadeHistorikk = ({ yrkeUforetidspunkt,
             yrkeUforegrad,
             skadetidspunkt,
             antattAarligArbeidsinntekt,
             yrke11,
             vilkaarPar1Pkt2Ledd2,
             kap11Pkt7Utlost,
             opphorsdato,
             opphorskode,
             sluttpoengtall }) => <Row>
               <Column size={6}>
                 <InfoTable>
                   <div>&nbsp;<h4>Yrkesskadehistorikk:</h4></div>
                   <tr>
                     <td>Yrkesuforetidspunkt</td>
                     <td><DsfDate value={yrkeUforetidspunkt}><ISO8601 /></DsfDate></td>
                   </tr>
                   <tr>
                     <td>Yrkesuføregrad</td>
                     <td>{yrkeUforegrad}</td>
                   </tr>
                   <tr>
                     <td>Skadetidspunkt</td>
                     <td><DsfDate value={skadetidspunkt}><ISO8601 /></DsfDate></td>
                   </tr>
                   <tr>
                     <td>Antatt årlig arbeidsinntekt</td>
                     <td>{antattAarligArbeidsinntekt}</td>
                   </tr>
                   <tr>
                     <td>Yrke 11</td>
                     <td><FormattedMessage id={`kodeverk.yrke11.${yrke11}`} /></td>
                   </tr>
                   <tr>
                     <td>Vilkår §1_2_2</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar1Pkt2Ledd2}`} /></td>
                   </tr>
                   <tr>
                     <td>Kapittel 11_7 utløst</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${kap11Pkt7Utlost}`} /></td>
                   </tr>
                   <tr>
                     <td>Opphørsdato</td>
                     <td><DsfDate value={opphorsdato}><ISO8601 /></DsfDate></td>
                   </tr>
                   <tr>
                     <td>Opphørskode</td>
                     <td><FormattedMessage id={`yrkesskadehistorikk.opphorskode.${opphorskode}`} /></td>
                   </tr>
                   <tr>
                     <td>Sluttpoengtall</td>
                     <td><FormattedNumber value={sluttpoengtall} /></td>
                   </tr>
                 </InfoTable>
               </Column>
             </Row>;

YrkesskadeHistorikk.propTypes = {
  yrkeUforetidspunkt: React.PropTypes.number.isRequired,
  yrkeUforegrad: React.PropTypes.number.isRequired,
  skadetidspunkt: React.PropTypes.number.isRequired,
  antattAarligArbeidsinntekt: React.PropTypes.number.isRequired,
  yrke11: React.PropTypes.string.isRequired,
  vilkaarPar1Pkt2Ledd2: React.PropTypes.string.isRequired,
  kap11Pkt7Utlost: React.PropTypes.string.isRequired,
  opphorsdato: React.PropTypes.number.isRequired,
  opphorskode: React.PropTypes.string.isRequired,
  sluttpoengtall: React.PropTypes.string.isRequired,
};

export default YrkesskadeHistorikk;
