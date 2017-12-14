import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

const GrunnblankettAvtalefestetPensjon = ({ ektefelleTillegg,
              framtidigArbeidsinntekt,
              bosattNorge,
              statsborgerskap,
              bosattLand,
              erFlyktning,
              fravikPar19Pkt3,
              trygdetidFor1967,
              trygdetidEtter1966Aar,
              trygdetidEtter1966Maaneder,
              alderspensjonsdel,
              fodselsnummerEktefelle,
              navnEktefelle,
              overkompensasjonUtland,
              afpTilleggskode,
              afpOrdning,
              pensjonsinntekt }) => <Row>
                <Column size={6}>
                  <div>&nbsp;<h4>Avtalefestet pensjon:</h4></div>
                  <InfoTable>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.ektefelleTillegg" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelleTillegg}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.framtidigArbeidsinntekt" /></td>
                      <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                        {framtidigArbeidsinntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.bosattNorge" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${bosattNorge}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.statsborgerskap" /></td>
                      <td><FormattedMessage id={`kodeverk.land.${statsborgerskap}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.bosattLand" /></td>
                      <td><FormattedMessage id={`kodeverk.land.${bosattLand}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.erFlyktning" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${erFlyktning}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.fravikPar19Pkt3" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar19Pkt3}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.trygdetidFor1967" /></td>
                      <td>{trygdetidFor1967}<FormattedMessage id="kodeverk.standardtekst.aar" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.trygdetidEtter1966" /></td>
                      <td>{trygdetidEtter1966Aar}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                        {trygdetidEtter1966Maaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.alderspensjonsdel" /></td>
                      <td>{alderspensjonsdel}%</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.fodselsnummerEktefelle" /></td>
                      <td>{fodselsnummerEktefelle}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.navnEktefelle" /></td>
                      <td>{navnEktefelle}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.overkompensasjonUtland" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonUtland}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.afpTilleggskode" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${afpTilleggskode}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.afpOrdning" /></td>
                      <td><FormattedMessage id={`kodeverk.AFP.${afpOrdning}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAvtalefestetPensjon.pensjonsinntekt" /></td>
                      <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                        {pensjonsinntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                    </tr>
                  </InfoTable>
                </Column>
              </Row>;


GrunnblankettAvtalefestetPensjon.propTypes = {
  ektefelleTillegg: React.PropTypes.string.isRequired,
  framtidigArbeidsinntekt: React.PropTypes.number.isRequired,
  bosattNorge: React.PropTypes.string.isRequired,
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  erFlyktning: React.PropTypes.string.isRequired,
  fravikPar19Pkt3: React.PropTypes.string.isRequired,
  trygdetidFor1967: React.PropTypes.number.isRequired,
  trygdetidEtter1966Aar: React.PropTypes.number.isRequired,
  trygdetidEtter1966Maaneder: React.PropTypes.number.isRequired,
  alderspensjonsdel: React.PropTypes.number.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  overkompensasjonUtland: React.PropTypes.string.isRequired,
  afpTilleggskode: React.PropTypes.string.isRequired,
  afpOrdning: React.PropTypes.string.isRequired,
  pensjonsinntekt: React.PropTypes.number.isRequired,
};

export default GrunnblankettAvtalefestetPensjon;
