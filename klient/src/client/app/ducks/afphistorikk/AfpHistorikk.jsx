import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';
import { FormattedMessage } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

const AfpHistorikk = ({ afpDato,
            tidligereErvervsinntektFaktor,
            framtidigErvervsinntekt,
            utbetalingsgrad,
            fullAFP,
            redusertAFP,
            etReg }) => <Row>
              <Column size={12}>
                <div>&nbsp;<h4>AfpHistorikk:</h4></div>
                <InfoTable>
                  <tr>
                    <td>AFP dato</td>
                    <td><DsfDate value={afpDato}><ISO8601 /></DsfDate></td>
                  </tr>
                  <tr>
                    <td>Tidligere ervervsinntektsfaktor</td>
                    <td>{tidligereErvervsinntektFaktor}</td>
                  </tr>
                  <tr>
                    <td>Framtidig ervervsinntekt</td>
                    <td>{framtidigErvervsinntekt}</td>
                  </tr>
                  <tr>
                    <td>Utbetalingsgrad</td>
                    <td>{utbetalingsgrad}</td>
                  </tr>
                  <tr>
                    <td>Full AFP</td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${fullAFP}`} /></td>
                  </tr>
                  <tr>
                    <td>Redusert AFP</td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${redusertAFP}`} /></td>
                  </tr>
                  <tr>
                    <td>etReg</td>
                    <td>{etReg}</td>
                  </tr>
                </InfoTable>
              </Column>
            </Row>;

AfpHistorikk.propTypes = {
  afpDato: React.PropTypes.number.isRequired,
  tidligereErvervsinntektFaktor: React.PropTypes.number.isRequired,
  framtidigErvervsinntekt: React.PropTypes.number.isRequired,
  utbetalingsgrad: React.PropTypes.number.isRequired,
  fullAFP: React.PropTypes.number.isRequired,
  redusertAFP: React.PropTypes.number.isRequired,
  etReg: React.PropTypes.string.isRequired,
};

export default AfpHistorikk;
