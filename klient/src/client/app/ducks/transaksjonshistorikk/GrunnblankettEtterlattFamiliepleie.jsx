import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';

import InfoTable from 'components/elements/InfoTable';

const GrunnblankettEtterlattFamiliepleie = ({ forventetInntekt,
              hjemmelPar10Pkt8,
              framleggsdato,
              framleggskode,
              bosattNorge,
              overgangsstonadPensjonKode,
              statsborgerskap,
              bosattLand,
              fravikBosatt,
              trygd3,
              fravikTrygdet3Aar,
              fravikPar10Pkt1,
              konvensjon,
              fravikPar19Pkt3,
              erFlyktning,
              trygdetidEtterOpphor,
              trygdetidFor1967,
              trygdetidEtter1966Aar,
              trygdetidEtter1966Maaneder,
              ttfmt101all,
              dodAvYrkesskade }) => <Row>
                <Column size={6}>
                  <InfoTable>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.forventetInntekt" /></td>
                      <td><FormattedMessage id="kodeverk.standardtekst.kr" />{forventetInntekt}
                        <FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.hjemmelPar10Pkt8" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${hjemmelPar10Pkt8}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.framleggsdato" /></td>
                      <td><DsfDate value={framleggsdato}><ISO8601 /></DsfDate></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.framleggskode" /></td>
                      <td><FormattedMessage id={`GrunnblankettEtterlattFamiliepleie.framleggsKode.${framleggskode}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.bosattNorge" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${bosattNorge}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.overgangsstonadPensjonKode" /></td>
                      <td><FormattedMessage id={`GrunnblankettEtterlattFamiliepleie.overgangsstonadPensjonKode.${overgangsstonadPensjonKode}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.statsborgerskap" /></td>
                      <td><FormattedMessage id={`kodeverk.land.${statsborgerskap}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.bosattLand" /></td>
                      <td><FormattedMessage id={`kodeverk.land.${bosattLand}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.fravikBosatt" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${fravikBosatt}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.trygd3" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${trygd3}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.fravikTrygdet3Aar" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${fravikTrygdet3Aar}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.fravikPar10Pkt1" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar10Pkt1}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.konvensjon" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${konvensjon}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.fravikPar19Pkt3" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar19Pkt3}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.erFlyktning" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${erFlyktning}`} /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.trygdetidEtterOpphor" /></td>
                      <td>{trygdetidEtterOpphor}<FormattedMessage id="kodeverk.standardtekst.aar" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.trygdetidFor1967" /></td>
                      <td>{trygdetidFor1967}<FormattedMessage id="kodeverk.standardtekst.aar" /></td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.trygdetidEtter1966" /></td>
                      <td>{trygdetidEtter1966Aar}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                        {trygdetidEtter1966Maaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>

                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.ttfmt101all" /></td>
                      <td>{ttfmt101all}</td>
                    </tr>
                    <tr>
                      <td><FormattedMessage id="GrunnblankettEtterlattFamiliepleie.dodAvYrkesskade" /></td>
                      <td><FormattedMessage id={`kodeverk.ja.nei.${dodAvYrkesskade}`} /></td>
                    </tr>
                  </InfoTable>
                </Column>
              </Row>;

GrunnblankettEtterlattFamiliepleie.propTypes = {
  forventetInntekt: React.PropTypes.number.isRequired,
  hjemmelPar10Pkt8: React.PropTypes.string.isRequired,
  framleggsdato: React.PropTypes.number.isRequired,
  framleggskode: React.PropTypes.string.isRequired,
  bosattNorge: React.PropTypes.string.isRequired,
  overgangsstonadPensjonKode: React.PropTypes.string.isRequired,
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  fravikBosatt: React.PropTypes.string.isRequired,
  trygd3: React.PropTypes.string.isRequired,
  fravikTrygdet3Aar: React.PropTypes.string.isRequired,
  fravikPar10Pkt1: React.PropTypes.string.isRequired,
  konvensjon: React.PropTypes.string.isRequired,
  fravikPar19Pkt3: React.PropTypes.string.isRequired,
  erFlyktning: React.PropTypes.string.isRequired,
  trygdetidEtterOpphor: React.PropTypes.number.isRequired,
  trygdetidFor1967: React.PropTypes.number.isRequired,
  trygdetidEtter1966Aar: React.PropTypes.number.isRequired,
  trygdetidEtter1966Maaneder: React.PropTypes.number.isRequired,
  ttfmt101all: React.PropTypes.number.isRequired,
  dodAvYrkesskade: React.PropTypes.string.isRequired,
};

export default GrunnblankettEtterlattFamiliepleie;
