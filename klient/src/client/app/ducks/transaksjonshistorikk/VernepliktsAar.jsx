import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';

import InfoTable from 'components/elements/InfoTable';

const VernepliktsAar = ({ vernepliktaar1,
                             vernepliktaar2,
                             vernepliktaar3,
                             vernepliktaar4 }) => <Row>
                               <Column size={12}>
                                 <InfoTable>
                                   <tr>
                                     <td>Vernepliktår</td>
                                     <td><ul>
                                       {[vernepliktaar1, vernepliktaar2, vernepliktaar3, vernepliktaar4].filter(e => e > 0).map(e => <li>{e}</li>)}
                                     </ul></td>
                                   </tr>
                                 </InfoTable>
                               </Column>
                             </Row>;
VernepliktsAar.propTypes = {
  vernepliktaar1: React.PropTypes.number.isRequired,
  vernepliktaar2: React.PropTypes.number.isRequired,
  vernepliktaar3: React.PropTypes.number.isRequired,
  vernepliktaar4: React.PropTypes.number.isRequired,
};

export default VernepliktsAar;
