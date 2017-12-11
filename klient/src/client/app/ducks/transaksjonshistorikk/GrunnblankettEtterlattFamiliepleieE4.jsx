import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';
import { FormattedMessage } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

const GrunnblankettEtterlattFamiliepleieE4 = ({ norskBosatt,
              forventetInntekt,
              overgangsstonadPensjonKode,
              framleggsdato,
              framleggskode,
              statsborgerskap,
              bosattLand,
              pensjonstrygdet,
              minst20Aar,
              fravikKonvensjon,
              erFlyktning,
              trygdetidFra1937Aar,
              trygdetidFra1937Maaned,
              trygdettidNordenAnnet,
              beregningKonvensjon,
              trygdetidKonvensjonAar,
              reduksjonGrunnpensjonPar3Pkt2Ledd5 }) => <Row>
                <Column size={6}>
                  <InfoTable>

                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.norskBosatt" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${norskBosatt}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.forventetInntekt" /></td>
                      <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                        {forventetInntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.overgangsstonadPensjonKode" /></td>
                      <td><FormattedMessage id={`GrunnblankettEtterlattFamiliepleieE4.overgangsstonadPensjonKode.${overgangsstonadPensjonKode}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.framleggsdato" /></td>
                      <td><DsfDate value={framleggsdato}><ISO8601 /></DsfDate></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.framleggskode" /></td>
                      <td>{framleggskode}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.statsborgerskap" /></td>
                      <td><FormattedMessage id={`kodeverk.land.${statsborgerskap}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.bosattLand" /></td>
                      <td><FormattedMessage id={`kodeverk.land.${bosattLand}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.pensjonstrygdet" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${pensjonstrygdet}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.minst20Aar" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${minst20Aar}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.fravikKonvensjon" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${fravikKonvensjon}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.erFlyktning" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${erFlyktning}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.trygdetidFra1937" /></td>
                      <td>{trygdetidFra1937Aar}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                        {trygdetidFra1937Maaned}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.trygdettidNordenAnnet" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${trygdettidNordenAnnet}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.beregningKonvensjon" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${beregningKonvensjon}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.trygdetidKonvensjon" /></td>
                      <td>{trygdetidKonvensjonAar}<FormattedMessage id="kodeverk.standardtekst.aar" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleieE4.reduksjonGrunnpensjonPar3Pkt2Ledd5" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${reduksjonGrunnpensjonPar3Pkt2Ledd5}`} /></td>
                    </tr>
                  </InfoTable>
                </Column>
              </Row>;

GrunnblankettEtterlattFamiliepleieE4.propTypes = {
  norskBosatt: React.PropTypes.string.isRequired,
  forventetInntekt: React.PropTypes.number.isRequired,
  overgangsstonadPensjonKode: React.PropTypes.string.isRequired,
  framleggsdato: React.PropTypes.number.isRequired,
  framleggskode: React.PropTypes.string.isRequired,
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  pensjonstrygdet: React.PropTypes.string.isRequired,
  minst20Aar: React.PropTypes.string.isRequired,
  fravikKonvensjon: React.PropTypes.string.isRequired,
  erFlyktning: React.PropTypes.string.isRequired,
  trygdetidFra1937Aar: React.PropTypes.number.isRequired,
  trygdetidFra1937Maaned: React.PropTypes.number.isRequired,
  trygdettidNordenAnnet: React.PropTypes.string.isRequired,
  beregningKonvensjon: React.PropTypes.string.isRequired,
  trygdetidKonvensjonAar: React.PropTypes.number.isRequired,
  reduksjonGrunnpensjonPar3Pkt2Ledd5: React.PropTypes.string.isRequired,
};

export default GrunnblankettEtterlattFamiliepleieE4;
