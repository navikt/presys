import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import InfoTable from 'components/elements/InfoTable';
import { FormattedMessage } from 'react-intl';


const Trygdetid = ({ trygdetidFramtidigUforetrygd,
             trygdetidFramtidigVentetidFravikPar8Pkt1,
             trygdetidFramtidigDod,
             trygdetidFramtidigVentetidFravikPar10Pkt1,
             trygdetidFramtidigVentetidUtland,
             ikkeTrygdetidFramtidigDod,
             trygdetidKonvensjonAar,
             trygdetidPoengaar,
             trygdetidFramtidig,
             trygdetidFaktisk }) => <Row>
               <Column size={6}>
                 <InfoTable>
                   <div>&nbsp;<h4>Trygdetid:</h4></div>
                   <tr>
                     <td>Trygdetid framtidig uforetrygd</td>
                     <td>{trygdetidFramtidigUforetrygd}</td>
                   </tr>
                   <tr>
                     <td>Trygdetid framtidig ventetid fravik §8_1</td>
                     <td>{trygdetidFramtidigVentetidFravikPar8Pkt1}</td>
                   </tr>
                   <tr>
                     <td>Trygdetid framtidig død</td>
                     <td>{trygdetidFramtidigDod}</td>
                   </tr>
                   <tr>
                     <td>Trygdetid framtidig ventetid fravik §10_1</td>
                     <td>{trygdetidFramtidigVentetidFravikPar10Pkt1}</td>
                   </tr>
                   <tr>
                     <td>Trygdetid framtidig ventetid utland</td>
                     <td>{trygdetidFramtidigVentetidUtland}</td>
                   </tr>
                   <tr>
                     <td>Ikke trygdetid framtidig død</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${ikkeTrygdetidFramtidigDod}`} /></td>
                   </tr>
                   <tr>
                     <td>Trygdetid konvensjons, antall år</td>
                     <td>{trygdetidKonvensjonAar}</td>
                   </tr>
                   <tr>
                     <td>Trygdetid poengår</td>
                     <td>{trygdetidPoengaar}</td>
                   </tr>
                   <tr>
                     <td>Trygdetid framtidig</td>
                     <td>{trygdetidFramtidig}</td>
                   </tr>
                   <tr>
                     <td>Trygdetid faktisk</td>
                     <td>{trygdetidFaktisk}</td>
                   </tr>
                 </InfoTable>
               </Column>
             </Row>;

Trygdetid.propTypes = {
  trygdetidFramtidigUforetrygd: React.PropTypes.number.isRequired,
  trygdetidFramtidigVentetidFravikPar8Pkt1: React.PropTypes.number.isRequired,
  trygdetidFramtidigDod: React.PropTypes.number.isRequired,
  trygdetidFramtidigVentetidFravikPar10Pkt1: React.PropTypes.number.isRequired,
  trygdetidFramtidigVentetidUtland: React.PropTypes.number.isRequired,
  ikkeTrygdetidFramtidigDod: React.PropTypes.string.isRequired,
  trygdetidKonvensjonAar: React.PropTypes.number.isRequired,
  trygdetidPoengaar: React.PropTypes.string.isRequired,
  trygdetidFramtidig: React.PropTypes.string.isRequired,
  trygdetidFaktisk: React.PropTypes.string.isRequired,
};


const Fravik = ({ fravikFlyktning,
             fravikBosatt,
             fravikTrygdet3Aar,
             fravikPar19Pkt3,
             fravikPar8Pkt1,
             fravikPar10Pkt1,
             konvensjon,
             fravikBosattKonvensjon,
             konvensjonsland,
             fravikBosattEos,
             unntakPar12Pkt2,
             fravikPar5Pkt1 }) => <Row>
               <Column size={6}>
                 <InfoTable>
                   <div>&nbsp;<h4>Fravik:</h4></div>
                   <tr>
                     <td>Fravik flyktning</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${fravikFlyktning}`} /></td>
                   </tr>
                   <tr>
                     <td>Fravik bosatt</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${fravikBosatt}`} /></td>
                   </tr>
                   <tr>
                     <td>Fravik trygdet 3 år</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${fravikTrygdet3Aar}`} /></td>
                   </tr>
                   <tr>
                     <td>Fravik §19_3</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar19Pkt3}`} /></td>
                   </tr>
                   <tr>
                     <td>Fravik §8_1</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar8Pkt1}`} /></td>
                   </tr>
                   <tr>
                     <td>Fravik §10_1</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar10Pkt1}`} /></td>
                   </tr>
                   <tr>
                     <td>Konvensjon</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${konvensjon}`} /></td>
                   </tr>
                   <tr>
                     <td>Fravik bosattkonvensjon</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${fravikBosattKonvensjon}`} /></td>
                   </tr>
                   <tr>
                     <td>Konvensjonsland</td>
                     <td><FormattedMessage id={`kodeverk.land.${konvensjonsland}`} /></td>
                   </tr>
                   <tr>
                     <td>Fravik bosatt EØS</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${fravikBosattEos}`} /></td>
                   </tr>
                   <tr>
                     <td>Unntak §12_2</td>
                     <td>{unntakPar12Pkt2}</td>
                   </tr>
                   <tr>
                     <td>Fravik §5_1</td>
                     <td>{fravikPar5Pkt1}</td>
                   </tr>
                 </InfoTable>
               </Column>
             </Row>;

Fravik.propTypes = {
  fravikFlyktning: React.PropTypes.string.isRequired,
  fravikBosatt: React.PropTypes.string.isRequired,
  fravikTrygdet3Aar: React.PropTypes.string.isRequired,
  fravikPar19Pkt3: React.PropTypes.string.isRequired,
  fravikPar8Pkt1: React.PropTypes.string.isRequired,
  fravikPar10Pkt1: React.PropTypes.string.isRequired,
  konvensjon: React.PropTypes.string.isRequired,
  fravikBosattKonvensjon: React.PropTypes.string.isRequired,
  konvensjonsland: React.PropTypes.number.isRequired,
  fravikBosattEos: React.PropTypes.string.isRequired,
  unntakPar12Pkt2: React.PropTypes.string.isRequired,
  fravikPar5Pkt1: React.PropTypes.string.isRequired,
};


const SpesielleOpplysninger = ({ statsborgerskap,
             overkompensasjonUtland,
             bosattLand,
             ikkeGrunnpensjon,
             trygdetDod,
             trygdet3AarDod,
             uforUnderBotid,
             pensjonstrygdet,
             minst20AarBotid,
             tjenestepensjonNordisk,
             tjenestepensjonNordiskLand,
             ungUfor,
             konvensjonTjenestepensjon, ...ubehandlede }) => <Row>
               <Column size={6}>
                 <InfoTable>
                   <div>&nbsp;<h4>Spesielle opplysninger:</h4></div>
                   <tr>
                     <td>Statsborgerskap</td>
                     <td>{statsborgerskap}</td>
                   </tr>
                   <tr>
                     <td>Overkompensasjon utland</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonUtland}`} /></td>
                   </tr>
                   <tr>
                     <td>Bosatt i</td>
                     <td><FormattedMessage id={`kodeverk.land.${bosattLand}`} /></td>
                   </tr>
                   <tr>
                     <td>Ikke grunnpensjon</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${ikkeGrunnpensjon}`} /></td>
                   </tr>
                   <tr>
                     <td>Trygdet død</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${trygdetDod}`} /></td>
                   </tr>
                   <tr>
                     <td>Trygdet 3 år død</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${trygdet3AarDod}`} /></td>
                   </tr>
                   <tr>
                     <td>Ufør under botid</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${uforUnderBotid}`} /></td>
                   </tr>
                   <tr>
                     <td>Pensjonstrygdet</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${pensjonstrygdet}`} /></td>
                   </tr>
                   <tr>
                     <td>Minst 20 år botid</td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${minst20AarBotid}`} /></td>
                   </tr>
                   <tr>
                     <td>Nordisk tjenestepensjon</td>
                     <td>{tjenestepensjonNordisk}</td>
                   </tr>
                   <tr>
                     <td>Nordisk tjenestepensjonsland</td>
                     <td>{tjenestepensjonNordiskLand}</td>
                   </tr>
                   <tr>
                     <td>Ung ufør</td>
                     <td>{ungUfor}</td>
                   </tr>
                   <tr>
                     <td>Konvensjon tjenestepensjon</td>
                     <td>{konvensjonTjenestepensjon}</td>
                   </tr>
                 </InfoTable>
               </Column>
               <Column size={6}>
                 <Trygdetid {...ubehandlede} />
                 <Fravik {...ubehandlede} />
               </Column>

             </Row>;

SpesielleOpplysninger.propTypes = {
  statsborgerskap: React.PropTypes.number.isRequired,
  overkompensasjonUtland: React.PropTypes.string.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  ikkeGrunnpensjon: React.PropTypes.string.isRequired,
  trygdetDod: React.PropTypes.string.isRequired,
  trygdet3AarDod: React.PropTypes.string.isRequired,
  uforUnderBotid: React.PropTypes.string.isRequired,
  pensjonstrygdet: React.PropTypes.string.isRequired,
  minst20AarBotid: React.PropTypes.string.isRequired,
  tjenestepensjonNordisk: React.PropTypes.number.isRequired,
  tjenestepensjonNordiskLand: React.PropTypes.number.isRequired,
  ungUfor: React.PropTypes.string.isRequired,
  konvensjonTjenestepensjon: React.PropTypes.string.isRequired,
};

export default SpesielleOpplysninger;
