import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';
import { FormattedMessage } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

const GrunnblankettUngUforFor1967 = ({ uforedato,
              fil }) => <Row>
                <Column size={6}>
                  <div>&nbsp;<h4>Ung ufør før 1967:</h4></div>
                  <InfoTable>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettUngUforFor1967.uforedato" /></td>
                      <td><DsfDate value={uforedato}><ISO8601 /></DsfDate></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettUngUforFor1967.fil" /></td>
                      <td>{fil}</td>
                    </tr>
                  </InfoTable>
                </Column>
              </Row>;

GrunnblankettUngUforFor1967.propTypes = {
  uforedato: React.PropTypes.number.isRequired,
  fil: React.PropTypes.string.isRequired,
};

export default GrunnblankettUngUforFor1967;
