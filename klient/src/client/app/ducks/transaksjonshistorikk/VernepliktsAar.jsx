import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';

import InfoTable from 'components/elements/InfoTable';

const VernepliktsAar = ({ vernepliktaar,
                            }) => <Row>
                              <Column size={12}>
                                <InfoTable>
                                  <tr>
                                    <td>Vernepliktår</td>
                                    <td><ul>
                                      {vernepliktaar.map(e => <li>{e}</li>)}
                                    </ul></td>
                                  </tr>
                                </InfoTable>
                              </Column>
                            </Row>;
VernepliktsAar.propTypes = {
  vernepliktaar: React.PropTypes.arrayOf(React.PropTypes.number).isRequired,
};

export default VernepliktsAar;
