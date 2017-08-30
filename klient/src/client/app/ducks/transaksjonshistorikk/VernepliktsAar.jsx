import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';

import styles from './Transaksjonshistorikk.less';

const VernepliktsAar = ({ vernepliktAar1,
                             vernepliktAar2,
                             vernepliktAar3,
                             vernepliktAar4 }) => <Row>
                               <Column size={12}>
                                 <table className={styles.infotable}><tbody>
                                   <tr>
                                     <td>Vernepliktår</td>
                                     <td><ul>
                                       {[vernepliktAar1, vernepliktAar2, vernepliktAar3, vernepliktAar4].filter(e => e > 0).map(e => <li>{e}</li>)}
                                     </ul></td>
                                   </tr>
                                 </tbody></table>
                               </Column>
                             </Row>;
VernepliktsAar.propTypes = {
  vernepliktAar1: React.PropTypes.number.isRequired,
  vernepliktAar2: React.PropTypes.number.isRequired,
  vernepliktAar3: React.PropTypes.number.isRequired,
  vernepliktAar4: React.PropTypes.number.isRequired,
};

export default VernepliktsAar;
