import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';
import { FormattedMessage } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

import VernepliktsAar from './VernepliktsAar';

const finnVernepliktsAar = ({ vernepliktaarFar1, vernepliktaarFar2, vernepliktaarFar3, vernepliktaarFar4 }) =>
[vernepliktaarFar1, vernepliktaarFar2, vernepliktaarFar3, vernepliktaarFar4].filter(elementIListe => elementIListe > 0);


const GrunnblankettForeldreloseBarn = ({ fodselsnummerMor,
            navnMor,
            dodsdatoMor,
            vilkaar843AMor,
            overkompensasjonUtlandMor,
            trygdetidFor1967Mor,
            trygdetidEtter1966MorAAr,
            trygdetidEtter1966MorMaaneder,
            pensjonsgivendeInntektMor,
            dodYrkesskadeMor,
            fodselsnummerFar,
            navnFar,
            dodsdatoFar,
            vilkaar843AFar,
            overkompensasjonUtlandFar,
            trygdetidFor1967far,
            trygdetidEtter1966FarAAr,
            trygdetidEtter1966FarMaaneder,
            pensjonsgivendeInntektFar,
            dodYrkesskadeFar,
            barneTabPos,
            ...ubehandlede }) => <Row>
              <Column size={6}>
                <div>&nbsp;<h4>Barnepensjon en foreldre død:</h4></div>
                <InfoTable>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.fodselsnummerMor" /></td>
                    <td>{fodselsnummerMor}</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.navnMor" /></td>
                    <td>{navnMor}</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.dodsdatoMor" /></td>
                    <td><DsfDate value={dodsdatoMor}><ISO8601 /></DsfDate></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.vilkaar843AMor" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaar843AMor}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.overkompensasjonUtlandMor" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonUtlandMor}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.trygdetidFor1967Mor" /></td>
                    <td>{trygdetidFor1967Mor}<FormattedMessage id="kodeverk.standardtekst.aar" /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.trygdetidEtter1966Mor" /></td>
                    <td>{trygdetidEtter1966MorAAr}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                      {trygdetidEtter1966MorMaaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.pensjonsgivendeInntektMor" /></td>
                    <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                      {pensjonsgivendeInntektMor}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.dodYrkesskadeMor" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${dodYrkesskadeMor}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.fodselsnummerFar" /></td>
                    <td>{fodselsnummerFar}</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.navnFar" /></td>
                    <td>{navnFar}</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.dodsdatoFar" /></td>
                    <td><DsfDate value={dodsdatoFar}><ISO8601 /></DsfDate></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.vilkaar843AFar" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaar843AFar}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.overkompensasjonUtlandFar" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonUtlandFar}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.trygdetidFor1967far" /></td>
                    <td>{trygdetidFor1967far}<FormattedMessage id="kodeverk.standardtekst.aar" /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.trygdetidEtter1966Far" /></td>
                    <td>{trygdetidEtter1966FarAAr}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                      {trygdetidEtter1966FarMaaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.pensjonsgivendeInntektFar" /></td>
                    <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                      {pensjonsgivendeInntektFar}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.dodYrkesskadeFar" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${dodYrkesskadeFar}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettForeldreloseBarn.barneTabPos" /></td>
                    <td>{barneTabPos}</td>
                  </tr>
                </InfoTable>
              </Column>
              <Column size={6}>
                <div>&nbsp;<h4>Vernepliktsår far:</h4></div>
                <VernepliktsAar vernepliktaar={finnVernepliktsAar(ubehandlede)} />
              </Column>
            </Row>;

GrunnblankettForeldreloseBarn.propTypes = {
  fodselsnummerMor: React.PropTypes.string.isRequired,
  navnMor: React.PropTypes.string.isRequired,
  dodsdatoMor: React.PropTypes.number.isRequired,
  vilkaar843AMor: React.PropTypes.string.isRequired,
  overkompensasjonUtlandMor: React.PropTypes.string.isRequired,
  trygdetidFor1967Mor: React.PropTypes.number.isRequired,
  trygdetidEtter1966MorAAr: React.PropTypes.number.isRequired,
  trygdetidEtter1966MorMaaneder: React.PropTypes.number.isRequired,
  pensjonsgivendeInntektMor: React.PropTypes.number.isRequired,
  dodYrkesskadeMor: React.PropTypes.string.isRequired,
  fodselsnummerFar: React.PropTypes.string.isRequired,
  navnFar: React.PropTypes.string.isRequired,
  dodsdatoFar: React.PropTypes.number.isRequired,
  vilkaar843AFar: React.PropTypes.string.isRequired,
  overkompensasjonUtlandFar: React.PropTypes.string.isRequired,
  trygdetidFor1967far: React.PropTypes.number.isRequired,
  trygdetidEtter1966FarAAr: React.PropTypes.number.isRequired,
  trygdetidEtter1966FarMaaneder: React.PropTypes.number.isRequired,
  pensjonsgivendeInntektFar: React.PropTypes.number.isRequired,
  dodYrkesskadeFar: React.PropTypes.string.isRequired,
  barneTabPos: React.PropTypes.string.isRequired,
};

export default GrunnblankettForeldreloseBarn;
