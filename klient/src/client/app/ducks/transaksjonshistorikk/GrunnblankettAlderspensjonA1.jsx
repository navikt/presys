import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

const GrunnblankettAlderspensjonA1 = ({ statsborgerskap,
              bosattNorge,
              bosattLand,
              erFlyktning,
              overkompensasjonUtland,
              fravikTrygdetidUtland,
              trygdetidFra16Til66Aar,
              trygdetidFra16Til66AMaaneder,
              ikkeGrunnpensjon,
              alderspensjonIProsent,
              framtidigArbeidsinntekt,
              navnEktefelle,
              fodselsnummerEktefelle,
              tilleggEktefelle,
              inntektEktefelle,
              antallBarn,
              ektefelleMinst4G,
              ektefelleInntektOver2G,
              fravikKonvensjonTPOrdning,
              reduksjonGrunnpensjonPar3Pkt2Ledd5 }) => <Row>
                <Column size={6}>
                  <InfoTable>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.statsborgerskap" /></td>
                      <td><FormattedMessage id={`kodeverk.land.${statsborgerskap}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.bosattNorge" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${bosattNorge}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.bosattLand" /></td>
                      <td><FormattedMessage id={`kodeverk.land.${bosattLand}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.erFlyktning" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${erFlyktning}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.overkompensasjonUtland" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonUtland}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.fravikTrygdetidUtland" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${fravikTrygdetidUtland}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.trygdetidFra16Til66" /></td>
                      <td>{trygdetidFra16Til66Aar}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                        {trygdetidFra16Til66AMaaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.ikkeGrunnpensjon" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${ikkeGrunnpensjon}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.alderspensjonIProsent" /></td>
                      <td>{(alderspensjonIProsent !== 999) ? alderspensjonIProsent : 100} %</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.framtidigArbeidsinntekt" /></td>
                      <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                        {framtidigArbeidsinntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.navnEktefelle" /></td>
                      <td>{navnEktefelle}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.fodselsnummerEktefelle" /></td>
                      <td>{fodselsnummerEktefelle}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.tilleggEktefelle" /></td>
                      <td>{tilleggEktefelle}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.inntektEktefelle" /></td>
                      <td><FormattedMessage id="kodeverk.standardtekst.kr" />{inntektEktefelle}
                        <FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.antallBarn" /></td>
                      <td>{antallBarn}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.ektefelleMinst4G" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelleMinst4G}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.ektefelleInntektOver2G" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelleInntektOver2G}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.fravikKonvensjonTPOrdning" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${fravikKonvensjonTPOrdning}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettAlderspensjonA1.reduksjonGrunnpensjonPar3Pkt2Ledd5" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${reduksjonGrunnpensjonPar3Pkt2Ledd5}`} /></td>
                    </tr>
                  </InfoTable>
                </Column>
              </Row>;

GrunnblankettAlderspensjonA1.propTypes = {
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattNorge: React.PropTypes.string.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  erFlyktning: React.PropTypes.string.isRequired,
  overkompensasjonUtland: React.PropTypes.string.isRequired,
  fravikTrygdetidUtland: React.PropTypes.string.isRequired,
  trygdetidFra16Til66Aar: React.PropTypes.number.isRequired,
  trygdetidFra16Til66AMaaneder: React.PropTypes.number.isRequired,
  ikkeGrunnpensjon: React.PropTypes.string.isRequired,
  alderspensjonIProsent: React.PropTypes.number.isRequired,
  framtidigArbeidsinntekt: React.PropTypes.number.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  tilleggEktefelle: React.PropTypes.string.isRequired,
  inntektEktefelle: React.PropTypes.number.isRequired,
  antallBarn: React.PropTypes.number.isRequired,
  ektefelleMinst4G: React.PropTypes.string.isRequired,
  ektefelleInntektOver2G: React.PropTypes.string.isRequired,
  fravikKonvensjonTPOrdning: React.PropTypes.string.isRequired,
  reduksjonGrunnpensjonPar3Pkt2Ledd5: React.PropTypes.string.isRequired,
};

export default GrunnblankettAlderspensjonA1;
