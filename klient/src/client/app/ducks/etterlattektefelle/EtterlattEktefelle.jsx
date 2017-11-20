import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import InfoTable from 'components/elements/InfoTable';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';
import { FormattedNumber, FormattedMessage } from 'react-intl';


const EtterlattEktefelle = ({ omsorgAvdBa,
                      vilkaarPar10Pkt5,
                      hjemmelPar10Pkt8,
                      gpBrutto,
                      gpNetto,
                      st,
                      kt,
                      tpBrutto,
                      tpNetto,
                      sptAvd,
                      optAvd,
                      paaAvd,
                      tpProsent,
                      forventet,
                      stiAMD,
                      stBrutto,
                      fradrag2G }) => <Row>
                        <Column size={6}>
                          <div>&nbsp;<h4>Etterlatt ektefelle:</h4></div>
                          <InfoTable>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.omsorgAvdBa" /></td>
                              <td>{omsorgAvdBa !== ' ' ? <FormattedMessage id={`kodeverk.ja.nei.${omsorgAvdBa}`} /> : ''}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.vilkaarPar10Pkt5" /></td>
                              <td>{vilkaarPar10Pkt5 !== ' ' ? <FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar10Pkt5}`} /> : ''}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.hjemmelPar10Pkt8" /></td>
                              <td>{hjemmelPar10Pkt8 !== ' ' ? <FormattedMessage id={`kodeverk.ja.nei.${hjemmelPar10Pkt8}`} /> : ''}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.gpBrutto" /></td>
                              <td>{gpBrutto}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.gpNetto" /></td>
                              <td>{gpNetto}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.st" /></td>
                              <td>{st}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.kt" /></td>
                              <td>{kt}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.tpBrutto" /></td>
                              <td>{tpBrutto}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.tpNetto" /></td>
                              <td>{tpNetto}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.sptAvd" /></td>
                              <td><FormattedNumber value={sptAvd} /></td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.optAvd" /></td>
                              <td><FormattedNumber value={optAvd} /></td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.paaAvd" /></td>
                              <td>{paaAvd}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.tpProsent" /></td>
                              <td>{tpProsent}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.forventet" /></td>
                              <td>{forventet}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.stiAMD" /></td>
                              <td><DsfDate value={stiAMD}><ISO8601 /></DsfDate></td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.stBrutto" /></td>
                              <td>{stBrutto}</td>
                            </tr>
                            <tr>
                              <td><FormattedMessage id="EtterlattEktefelle.fradrag2G" /></td>
                              <td>{fradrag2G !== ' ' ? <FormattedMessage id={`kodeverk.ja.nei.${fradrag2G}`} /> : ''}</td>
                            </tr>
                          </InfoTable>
                        </Column>
                      </Row>;


EtterlattEktefelle.propTypes = {
  omsorgAvdBa: React.PropTypes.string.isRequired,
  vilkaarPar10Pkt5: React.PropTypes.string.isRequired,
  hjemmelPar10Pkt8: React.PropTypes.string.isRequired,
  gpBrutto: React.PropTypes.number.isRequired,
  gpNetto: React.PropTypes.number.isRequired,
  st: React.PropTypes.number.isRequired,
  kt: React.PropTypes.number.isRequired,
  tpBrutto: React.PropTypes.number.isRequired,
  tpNetto: React.PropTypes.number.isRequired,
  sptAvd: React.PropTypes.string.isRequired,
  optAvd: React.PropTypes.string.isRequired,
  paaAvd: React.PropTypes.number.isRequired,
  tpProsent: React.PropTypes.number.isRequired,
  forventet: React.PropTypes.number.isRequired,
  stiAMD: React.PropTypes.number.isRequired,
  stBrutto: React.PropTypes.number.isRequired,
  fradrag2G: React.PropTypes.string.isRequired,
};

export default EtterlattEktefelle;
