import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';


import InfoTable from 'components/elements/InfoTable';

const GrunnblankettYrkesskadePensjon = ({ vilkaarPar1Pkt2Ledd2BokstavA,
              vilkaarPar1Pkt2Ledd2BokstavB,
              yrkesskadetidspunkt,
              yrkessykdom,
              yrkesskadeufor,
              kapittel11Pkt7Utlost,
              yrke11,
              aarligArbeidsinntekt,
              fodselsnummerEktefelle,
              fodselsnummerSamboer,
              fodselsnummerBarn,
              fodselsnummerPleiebarn }) => <Row>
                <Column size={6}>
                  <InfoTable>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.vilkaarPar1Pkt2Ledd2BokstavA" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar1Pkt2Ledd2BokstavA}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.vilkaarPar1Pkt2Ledd2BokstavB" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar1Pkt2Ledd2BokstavB}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.yrkesskadetidspunkt" /></td>
                      <td><DsfDate value={yrkesskadetidspunkt}><ISO8601 /></DsfDate></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.yrkessykdom" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${yrkessykdom}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.yrkesskadeufor" /></td>
                      <td>{(yrkesskadeufor !== 0) ? `${yrkesskadeufor}%` : ''}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.kapittel11Pkt7Utlost" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${kapittel11Pkt7Utlost}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.yrke11" /></td>
                      <td><FormattedMessage id={`kodeverk.yrke11.${yrke11}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.aarligArbeidsinntekt" /></td>
                      <td> kr {aarligArbeidsinntekt}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.fodselsnummerEktefelle" /></td>
                      <td>{fodselsnummerEktefelle}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.fodselsnummerSamboer" /></td>
                      <td>{fodselsnummerSamboer}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.fodselsnummerBarn" /></td>
                      <td>{fodselsnummerBarn}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettYrkesskadePensjon.fodselsnummerPleiebarn" /></td>
                      <td>{fodselsnummerPleiebarn}</td>
                    </tr>
                  </InfoTable>
                </Column>
              </Row>;

GrunnblankettYrkesskadePensjon.propTypes = {
  vilkaarPar1Pkt2Ledd2BokstavA: React.PropTypes.string.isRequired,
  vilkaarPar1Pkt2Ledd2BokstavB: React.PropTypes.string.isRequired,
  yrkesskadetidspunkt: React.PropTypes.number.isRequired,
  yrkessykdom: React.PropTypes.string.isRequired,
  yrkesskadeufor: React.PropTypes.number.isRequired,
  kapittel11Pkt7Utlost: React.PropTypes.string.isRequired,
  yrke11: React.PropTypes.string.isRequired,
  aarligArbeidsinntekt: React.PropTypes.number.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  fodselsnummerSamboer: React.PropTypes.string.isRequired,
  fodselsnummerBarn: React.PropTypes.string.isRequired,
  fodselsnummerPleiebarn: React.PropTypes.string.isRequired,
};

export default GrunnblankettYrkesskadePensjon;
