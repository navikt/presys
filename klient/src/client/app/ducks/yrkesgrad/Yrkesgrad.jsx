import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';

import InfoTable from 'components/elements/InfoTable';

const Yrkesgrad = ({ gjeldendeYrkesgradDato,
              gjeldendeYrkesgradOvrig,
              }) => <Row>
                <Column size={6}>
                  <InfoTable>
                  <div>&nbsp;<h4>Yrkesgradsendringer:</h4></div>
                    <tr>
                      <td>Gjendende yrkesgradsdato</td>
                      <td><DsfDate value={gjeldendeYrkesgradDato}><ISO8601 /></DsfDate></td>
                    </tr>
                    <tr>
                      <td>gjeldendeYrkesgradOvrig</td>
                      <td>{gjeldendeYrkesgradOvrig}</td>
                    </tr>
                  </InfoTable>
                </Column>
              </Row>;
Yrkesgrad.propTypes = {
  gjeldendeYrkesgradDato: React.PropTypes.number.isRequired,
  gjeldendeYrkesgradOvrig: React.PropTypes.number.isRequired,
};

export default Yrkesgrad;
