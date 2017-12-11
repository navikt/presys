import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';
import { FormattedMessage } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

const GrunnblankettBarnepensjonEnForeldreDod = ({ fodselsnummerAvdod,
              navnYngsteBarn,
              dodsdato,
              dodAvYrkesskade,
              pleiebarn }) => <Row>
                <Column size={6}>
                  <div>&nbsp;<h4>Barnepensjon en foreldre død:</h4></div>
                  <InfoTable>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDod.fodselsnummerAvdod" /></td>
                      <td>{fodselsnummerAvdod}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDod.navnYngsteBarn" /></td>
                      <td>{navnYngsteBarn}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDod.dodsdato" /></td>
                      <td><DsfDate value={dodsdato}><ISO8601 /></DsfDate></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDod.dodAvYrkesskade" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${dodAvYrkesskade}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDod.pleiebarn" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${pleiebarn}`} /></td>
                    </tr>
                  </InfoTable>
                </Column>
              </Row>;

GrunnblankettBarnepensjonEnForeldreDod.propTypes = {
  fodselsnummerAvdod: React.PropTypes.string.isRequired,
  navnYngsteBarn: React.PropTypes.string.isRequired,
  dodsdato: React.PropTypes.number.isRequired,
  dodAvYrkesskade: React.PropTypes.string.isRequired,
  pleiebarn: React.PropTypes.string.isRequired,
};

export default GrunnblankettBarnepensjonEnForeldreDod;
