import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';
import { FormattedMessage } from 'react-intl';


import InfoTable from 'components/elements/InfoTable';

const Trygdetid = ({ trygdetidFoer1967,
              trygdetidEtter1966,
              trygdetidFramTil,
              trygdetid1967Til1970,
              trygdetidAnvendt,
               trygdetidGaranti,
               trygdetid1666 }) => <Row>
                 <Column size={6}>
                   <div>&nbsp;<h4>Trygdetid:</h4></div>
                   <InfoTable>
                     <tr>
                       <td>Trygdetid før 1967 antall år</td>
                       <td>{trygdetidFoer1967}</td>
                     </tr>
                     <tr>
                       <td>Trygdetid etter 1966 antall måneder</td>
                       <td>{trygdetidEtter1966}</td>
                     </tr>
                     <tr>
                       <td>Framtidig trygdetid i måneder</td>
                       <td>{trygdetidFramTil}</td>
                     </tr>
                     <tr>
                       <td>Trygdetid fra 67. til 69. året, antall år</td>
                       <td>{trygdetid1967Til1970}</td>
                     </tr>
                     <tr>
                       <td>Anvendt trygdetid, antall år</td>
                       <td>{trygdetidAnvendt}</td>
                     </tr>
                     <tr>
                       <td>Trygdetidsgaranti, antall år</td>
                       <td>{trygdetidGaranti}</td>
                     </tr>
                     <tr>
                       <td>Trygdetid fra 16. til 66. året, antall måneder</td>
                       <td>{trygdetid1666}</td>
                     </tr>
                   </InfoTable>
                 </Column>
               </Row>;
Trygdetid.propTypes = {
  trygdetidFoer1967: React.PropTypes.number.isRequired,
  trygdetidEtter1966: React.PropTypes.number.isRequired,
  trygdetidFramTil: React.PropTypes.number.isRequired,
  trygdetid1967Til1970: React.PropTypes.number.isRequired,
  trygdetidAnvendt: React.PropTypes.number.isRequired,
  trygdetidGaranti: React.PropTypes.number.isRequired,
  trygdetid1666: React.PropTypes.number.isRequired,
};

const Pensjonstyper = ({ pensjonsType1,
              pensjonsType2,
              pensjonsType3 }) => <Row>
                <Column size={6}>
                  <div>&nbsp;<h4>Pensjonstyper:</h4></div>
                  <InfoTable>
                    <tr>
                      <td>Pensjonstype 1</td>
                      <td><FormattedMessage id={`StatusSegment.Pensjonstype1.${pensjonsType1}`} /></td>
                    </tr>
                    <tr>
                      <td>Pensjonstype 2</td>
                      <td><FormattedMessage id={`StatusSegment.Pensjonstype2.${pensjonsType2}`} /></td>
                    </tr>
                    <tr>
                      <td>Pensjonstype 3</td>
                      <td><FormattedMessage id={`StatusSegment.Pensjonstype3.${pensjonsType3}`} /></td>
                    </tr>
                  </InfoTable>
                </Column>
              </Row>;

Pensjonstyper.propTypes = {
  pensjonsType1: React.PropTypes.string.isRequired,
  pensjonsType2: React.PropTypes.string.isRequired,
  pensjonsType3: React.PropTypes.string.isRequired,
};


const StatusSegment = ({ virkDato,
              statusKode,
              statusKodeHistorie,
              sivilstand,
              foersteGangReg,
              sumYtelse,
              antallBarn,
              dodsddato,
              dodAvYrkesskade,
              vilkar843A,
              grunnbelopsDato,
              poengtilleggsDato,
              poengtilleggsKode,
              pensjonsrettFoer91,
              garantertTilleggsPensjonKode,
              gammelSammenstotsRegel,
              ektefelleInntektOver2g,
              pensjonFoer9802,
              redGrunnPensjon321,
              grunnPensjonReduksjonsKode,
              friinntektDato,
               ...ubehandlede }) => <Row>
                 <Column size={6}>
                   <div>&nbsp;<h4>Status:</h4></div>
                   <InfoTable>
                     <tr>
                       <td>Virkningsdato</td>
                       <td><DsfDate value={virkDato}><ISO8601 /></DsfDate></td>
                     </tr>
                     <tr>
                       <td>Statuskode</td>
                       <td><FormattedMessage id={`StatusSegment.statusKode.${statusKode}`} /></td>
                     </tr>
                     <tr>
                       <td>Statuskode historikk</td>
                       <td><FormattedMessage id={`StatusSegment.statuskodehistorikk.${statusKodeHistorie}`} /></td>
                     </tr>
                     <tr>
                       <td>Sivilstand</td>
                       <td><FormattedMessage id={`kodeverk.sivilstand.${sivilstand}`} /></td>
                     </tr>
                     <tr>
                       <td>Førstegangsregistrert</td>
                       <td><FormattedMessage id={`kodeverk.ja.nei.${foersteGangReg}`} /></td>
                     </tr>
                     <tr>
                       <td>Sum ytelse</td>
                       <td>{sumYtelse}</td>
                     </tr>
                     <tr>
                       <td>Antall barn</td>
                       <td>{antallBarn}</td>
                     </tr>
                     <tr>
                       <td>Dødsdato</td>
                       <td><DsfDate value={dodsddato}><ISO8601 /></DsfDate></td>
                     </tr>
                     <tr>
                       <td>Død av yrkesskade</td>
                       <td><FormattedMessage id={`kodeverk.ja.nei.${dodAvYrkesskade}`} /></td>
                     </tr>
                     <tr>
                       <td>Vilkår §8-4 3 a</td>
                       <td>{vilkar843A}</td>
                     </tr>
                     <tr>
                       <td>Grunnbeløpsdato, år og mnd</td>
                       <td><DsfDate value={grunnbelopsDato}><ISO8601 /></DsfDate></td>
                     </tr>
                     <tr>
                       <td>Poengtilleggsdato, år og mnd</td>
                       <td><DsfDate value={poengtilleggsDato}><ISO8601 /></DsfDate></td>
                     </tr>
                     <tr>
                       <td>Poengtillegg</td>
                       <td><FormattedMessage id={`StatusSegment.poengtilleggskode.${poengtilleggsKode}`} /></td>
                     </tr>
                     <tr>
                       <td>Pensjonsrett før 1991</td>
                       <td><FormattedMessage id={`kodeverk.ja.nei.${pensjonsrettFoer91}`} /></td>
                     </tr>
                     <tr>
                       <td>Garantert tilleggspensjon etter §3-22</td>
                       <td>{garantertTilleggsPensjonKode !== ' ' ?
                         <FormattedMessage id={`StatusSegment.garantertTilleggsPensjonKode.${garantertTilleggsPensjonKode}`} /> : ''} </td>
                     </tr>
                     <tr>
                       <td>Sammenstøtsregel før 1990</td>
                       <td><FormattedMessage id={`kodeverk.ja.nei.${gammelSammenstotsRegel}`} /></td>
                     </tr>
                     <tr>
                       <td>Ektefelle har inntekt over 2G</td>
                       <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelleInntektOver2g}`} /></td>
                     </tr>
                     <tr>
                       <td>Pensjon før 02 1998</td>
                       <td><FormattedMessage id={`kodeverk.ja.nei.${pensjonFoer9802}`} /></td>
                     </tr>
                     <tr>
                       <td>Reduksjon av grunnpensjon etter §3-2 5.</td>
                       <td><FormattedMessage id={`kodeverk.ja.nei.${redGrunnPensjon321}`} /></td>
                     </tr>
                     <tr>
                       <td>Grunnpensjonsreduksjon</td>
                       <td><FormattedMessage id={`StatusSegment.gpRedKode.${grunnPensjonReduksjonsKode}`} /></td>
                     </tr>
                     <tr>
                       <td>Friinntekt dato</td>
                       <td><DsfDate value={friinntektDato}><ISO8601 /></DsfDate></td>
                     </tr>
                   </InfoTable>
                 </Column>
                 <Column size={6}>
                   <Trygdetid {...ubehandlede} />
                   <Pensjonstyper {...ubehandlede} />
                 </Column>
               </Row>;

StatusSegment.propTypes = {
  virkDato: React.PropTypes.number.isRequired,
  statusKode: React.PropTypes.string.isRequired,
  statusKodeHistorie: React.PropTypes.string.isRequired,
  sivilstand: React.PropTypes.string.isRequired,
  foersteGangReg: React.PropTypes.string.isRequired,
  sumYtelse: React.PropTypes.number.isRequired,
  antallBarn: React.PropTypes.number.isRequired,
  dodsddato: React.PropTypes.number.isRequired,
  dodAvYrkesskade: React.PropTypes.string.isRequired,
  vilkar843A: React.PropTypes.string.isRequired,
  grunnbelopsDato: React.PropTypes.number.isRequired,
  poengtilleggsDato: React.PropTypes.number.isRequired,
  poengtilleggsKode: React.PropTypes.string.isRequired,
  pensjonsrettFoer91: React.PropTypes.string.isRequired,
  garantertTilleggsPensjonKode: React.PropTypes.string.isRequired,
  gammelSammenstotsRegel: React.PropTypes.string.isRequired,
  ektefelleInntektOver2g: React.PropTypes.string.isRequired,
  pensjonFoer9802: React.PropTypes.string.isRequired,
  redGrunnPensjon321: React.PropTypes.string.isRequired,
  grunnPensjonReduksjonsKode: React.PropTypes.string.isRequired,
  friinntektDato: React.PropTypes.number.isRequired,
};


export default StatusSegment;
