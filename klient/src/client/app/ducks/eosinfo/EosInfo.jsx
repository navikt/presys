import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import InfoTable from 'components/elements/InfoTable';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';
import { FormattedNumber } from 'react-intl';

const Alternativ = ({ alternativGrunnpensjon,
                   alternativSaertillegg,
                   alternativTjenestepensjon,
                   alternativBarnetrygd,
                   alternativEktefelletillegg,
                   alternativSumPensjon,
                   alternativtSaertilleggBrutto,
                   alternetivGrunnpensjonBrutto,
                   alternetivTjenestepensjonBrutto }) => <Row>
                     <Column size={6}>
                       <div>&nbsp;<h4>Alternativ:</h4></div>
                       <InfoTable>
                         <tr>
                           <td>Alternativ grunnpensjon</td>
                           <td>{alternativGrunnpensjon}</td>
                         </tr>
                         <tr>
                           <td>Alternativ særtillegg</td>
                           <td>{alternativSaertillegg}</td>
                         </tr>
                         <tr>
                           <td>Alternativ tjenestepensjon</td>
                           <td>{alternativTjenestepensjon}</td>
                         </tr>
                         <tr>
                           <td>Alternativ barnetrygd</td>
                           <td>{alternativBarnetrygd}</td>
                         </tr>
                         <tr>
                           <td>Alternativt ektefelletillegg</td>
                           <td>{alternativEktefelletillegg}</td>
                         </tr>
                         <tr>
                           <td>Alternativ sum pensjon</td>
                           <td>{alternativSumPensjon}</td>
                         </tr>
                         <tr>
                           <td>Alternativt særtillegg brutto</td>
                           <td>{alternativtSaertilleggBrutto}</td>
                         </tr>
                         <tr>
                           <td>Alternativ grunnpensjon brutto</td>
                           <td>{alternetivGrunnpensjonBrutto}</td>
                         </tr>
                         <tr>
                           <td>Alternativ tjenestepensjon brutto</td>
                           <td>{alternetivTjenestepensjonBrutto}</td>
                         </tr>
                       </InfoTable>
                     </Column>
                   </Row>;

Alternativ.propTypes = {
  alternativGrunnpensjon: React.PropTypes.number.isRequired,
  alternativSaertillegg: React.PropTypes.number.isRequired,
  alternativTjenestepensjon: React.PropTypes.number.isRequired,
  alternativBarnetrygd: React.PropTypes.number.isRequired,
  alternativEktefelletillegg: React.PropTypes.number.isRequired,
  alternativSumPensjon: React.PropTypes.number.isRequired,
  alternativtSaertilleggBrutto: React.PropTypes.number.isRequired,
  alternetivGrunnpensjonBrutto: React.PropTypes.number.isRequired,
  alternetivTjenestepensjonBrutto: React.PropTypes.number.isRequired,

};

const Trygdetid = ({ trygdetidProRataMaaneder,
                   trygdetidTeoretiskEosMaaneder,
                   trygdetidEosFramtidigMaaneder,
                   trygdetidEosAnvendtMaaneder,
                   trygdetidEosAnvendtAAr,
                   trygdetidNordiskFaktiskMaaneder,
                   trygdetidNordiskFramtidigBrutto,
                   trygdetidNordiskFramtidigNetto,
                   trygdetidFaktiskNorskMaaneder }) => <Row>
                     <Column size={6}>
                       <div>&nbsp;<h4>Trygdetid:</h4></div>
                       <InfoTable>
                         <tr>
                           <td>Trygdetid pro rata i måneder</td>
                           <td>{trygdetidProRataMaaneder}</td>
                         </tr>
                         <tr>
                           <td>Teoretisk EØS trygdetid i måneder</td>
                           <td>{trygdetidTeoretiskEosMaaneder}</td>
                         </tr>
                         <tr>
                           <td>Framtidig EØS trygdetid i måneder</td>
                           <td>{trygdetidEosFramtidigMaaneder}</td>
                         </tr>
                         <tr>
                           <td>Anvendt EØS trygdetid</td>
                           <td>{trygdetidEosAnvendtAAr} år og {trygdetidEosAnvendtMaaneder} måneder</td>
                         </tr>
                         <tr>
                           <td>Faktisk nordisk trygdetid i måneder</td>
                           <td>{trygdetidNordiskFaktiskMaaneder}</td>
                         </tr>
                         <tr>
                           <td>Framtidig nordisk trygdetid brutto</td>
                           <td>{trygdetidNordiskFramtidigBrutto}</td>
                         </tr>
                         <tr>
                           <td>Framtidig nordisk trygdetid netto</td>
                           <td>{trygdetidNordiskFramtidigNetto}</td>
                         </tr>
                         <tr>
                           <td>Faktisk norsk trygdetid i måneder</td>
                           <td>{trygdetidFaktiskNorskMaaneder}</td>
                         </tr>
                       </InfoTable>
                     </Column>
                   </Row>;

Trygdetid.propTypes = {
  trygdetidProRataMaaneder: React.PropTypes.number.isRequired,
  trygdetidTeoretiskEosMaaneder: React.PropTypes.number.isRequired,
  trygdetidEosFramtidigMaaneder: React.PropTypes.number.isRequired,
  trygdetidEosAnvendtMaaneder: React.PropTypes.number.isRequired,
  trygdetidEosAnvendtAAr: React.PropTypes.number.isRequired,
  trygdetidNordiskFaktiskMaaneder: React.PropTypes.number.isRequired,
  trygdetidNordiskFramtidigBrutto: React.PropTypes.number.isRequired,
  trygdetidNordiskFramtidigNetto: React.PropTypes.number.isRequired,
  trygdetidFaktiskNorskMaaneder: React.PropTypes.number.isRequired,
};


const Nordisk = ({ nordiskKonvensjon,
                   pensjonsAarNordiskFaktisk,
                   pensjonsAarNordiskFramtidigBrutto,
                   pensjonsAarNordiskFramtidigNetto,
                   sluttpoengtallNordiskArtikkel15,
                   overkompensasjonNordiskArtikkel15 }) => <Row>
                     <Column size={6}>
                       <div>&nbsp;<h4>Nordisk:</h4></div>
                       <InfoTable>
                         <tr>
                           <td>Nordisk konvensjon</td>
                           <td>{nordiskKonvensjon}</td>
                         </tr>
                         <tr>
                           <td>Faktisk nordisk pensjonsår</td>
                           <td>{pensjonsAarNordiskFaktisk}</td>
                         </tr>
                         <tr>
                           <td>Framtidig nordisk pensjonsår brutto</td>
                           <td>{pensjonsAarNordiskFramtidigBrutto}</td>
                         </tr>
                         <tr>
                           <td>Framtidig nordisk pensjonsår netto</td>
                           <td>{pensjonsAarNordiskFramtidigNetto}</td>
                         </tr>
                         <tr>
                           <td>Nordisk sluttpoengtall artikkel 15</td>
                           <td><FormattedNumber value={sluttpoengtallNordiskArtikkel15} /></td>
                         </tr>
                         <tr>
                           <td>Nordisk overkompensasjon artikkel 15</td>
                           <td>{overkompensasjonNordiskArtikkel15}</td>
                         </tr>
                       </InfoTable>
                     </Column>
                   </Row>;

Nordisk.propTypes = {
  nordiskKonvensjon: React.PropTypes.string.isRequired,
  pensjonsAarNordiskFaktisk: React.PropTypes.number.isRequired,
  pensjonsAarNordiskFramtidigBrutto: React.PropTypes.number.isRequired,
  pensjonsAarNordiskFramtidigNetto: React.PropTypes.number.isRequired,
  sluttpoengtallNordiskArtikkel15: React.PropTypes.number.isRequired,
  overkompensasjonNordiskArtikkel15: React.PropTypes.number.isRequired,
};


const EosInfo = ({ beregnFolketrygd,
                   proRataBeregning,
                   inntektsaarEos,
                   antallNorskePoengaar,
                   antallNorskePoengaarEtter1991,
                   sluttpoengtallEos,
                   overkompensasjonEos,
                   pensjonEos,
                   eosPar8Pkt4Ledd3BokstavA,
                   gunstigsteAlternativ,
                   pensjonsAarEos,
                   pensjonsAarEosEtter1991,
                   framtidigPensjonsAarEos,
                   grunnpensjonArtikkel13Virkedato,
                   tjenestepensjonArtikkel13Virkedato,
                   eosAarIkkeProRata1967Til2014,
                   inntektprovetEosPensjon,
                   beregnetUforePensjonsgradEos,
                   pensjonsaarEosFaktisk,
                   proRata21967Til2014, ...ubehandlede }) => <Row>
                     <Column size={6}>
                       <div>&nbsp;<h4>EØS informasjon:</h4></div>
                       <InfoTable>
                         <tr>
                           <td>Beregnet folketrygd</td>
                           <td>{beregnFolketrygd}</td>
                         </tr>
                         <tr>
                           <td>Pro rata beregning</td>
                           <td>{proRataBeregning}</td>
                         </tr>
                         <tr>
                           <td>EØS inntektsår</td>
                           <td><ul>{inntektsaarEos.map(e => <li key={e}>{e}</li>)}</ul></td>
                         </tr>
                         <tr>
                           <td>Antall norske poengår</td>
                           <td>{antallNorskePoengaar}</td>
                         </tr>
                         <tr>
                           <td>Antall norske poengår etter 1991</td>
                           <td>{antallNorskePoengaarEtter1991}</td>
                         </tr>
                         <tr>
                           <td>EØS sluttpoengtall</td>
                           <td><FormattedNumber value={sluttpoengtallEos} /></td>
                         </tr>
                         <tr>
                           <td>EØS overkompensasjon</td>
                           <td><FormattedNumber value={overkompensasjonEos} /></td>
                         </tr>
                         <tr>
                           <td>EØS pensjon</td>
                           <td>{pensjonEos}</td>
                         </tr>
                         <tr>
                           <td>EØS §8-4-3A</td>
                           <td>{eosPar8Pkt4Ledd3BokstavA}</td>
                         </tr>
                         <tr>
                           <td>Gunstigste alternativ</td>
                           <td>{gunstigsteAlternativ}</td>
                         </tr>
                         <tr>
                           <td>EØS pensjonsår</td>
                           <td>{pensjonsAarEos}</td>
                         </tr>
                         <tr>
                           <td>EØS pensjonsår etter 1991</td>
                           <td>{pensjonsAarEosEtter1991}</td>
                         </tr>
                         <tr>
                           <td>EØS framtidige pensjonsår</td>
                           <td>{framtidigPensjonsAarEos}</td>
                         </tr>
                         <tr>
                           <td>Grunnpensjon artikkel 13 virkedato</td>
                           <td><DsfDate value={grunnpensjonArtikkel13Virkedato}><ISO8601 /></DsfDate></td>
                         </tr>
                         <tr>
                           <td>Tjenestepensjon artikkel 13 virkedato</td>
                           <td><DsfDate value={tjenestepensjonArtikkel13Virkedato}><ISO8601 /></DsfDate></td>
                         </tr>
                         <tr>
                           <td>EØS-år, ikke pro rata 1967 til 2014</td>
                           <td><ul>{eosAarIkkeProRata1967Til2014.map(e => <li key={e}>{e}</li>)}</ul></td>
                         </tr>
                         <tr>
                           <td>EØS inntektprøvet pensjon</td>
                           <td>{inntektprovetEosPensjon}</td>
                         </tr>
                         <tr>
                           <td>EØS beregnet uførepensjonsgrad</td>
                           <td><FormattedNumber value={beregnetUforePensjonsgradEos} /></td>
                         </tr>
                         <tr>
                           <td>Faktisk EØS pensjonsår</td>
                           <td>{pensjonsaarEosFaktisk}</td>
                         </tr>
                         <tr>
                           <td>Pro rata 2 1967 til 2014</td>
                           <td><ul>{proRata21967Til2014.map(e => <li key={e}>{e}</li>)}</ul></td>
                         </tr>
                       </InfoTable>
                     </Column>
                     <Column size={6}>
                       <Alternativ {...ubehandlede} />
                       <Trygdetid {...ubehandlede} />
                       <Nordisk {...ubehandlede} />
                     </Column>

                   </Row>;

EosInfo.propTypes = {
  beregnFolketrygd: React.PropTypes.string.isRequired,
  proRataBeregning: React.PropTypes.string.isRequired,
  inntektsaarEos: React.PropTypes.arrayOf(React.PropTypes.bool).isRequired,
  antallNorskePoengaar: React.PropTypes.number.isRequired,
  antallNorskePoengaarEtter1991: React.PropTypes.number.isRequired,
  sluttpoengtallEos: React.PropTypes.number.isRequired,
  overkompensasjonEos: React.PropTypes.number.isRequired,
  pensjonEos: React.PropTypes.number.isRequired,
  eosPar8Pkt4Ledd3BokstavA: React.PropTypes.string.isRequired,
  gunstigsteAlternativ: React.PropTypes.string.isRequired,
  pensjonsAarEos: React.PropTypes.number.isRequired,
  pensjonsAarEosEtter1991: React.PropTypes.number.isRequired,
  framtidigPensjonsAarEos: React.PropTypes.number.isRequired,
  grunnpensjonArtikkel13Virkedato: React.PropTypes.number.isRequired,
  tjenestepensjonArtikkel13Virkedato: React.PropTypes.number.isRequired,
  eosAarIkkeProRata1967Til2014: React.PropTypes.arrayOf(React.PropTypes.bool).isRequired,
  inntektprovetEosPensjon: React.PropTypes.string.isRequired,
  beregnetUforePensjonsgradEos: React.PropTypes.number.isRequired,
  pensjonsaarEosFaktisk: React.PropTypes.number.isRequired,
  proRata21967Til2014: React.PropTypes.arrayOf(React.PropTypes.bool).isRequired,
};

export default EosInfo;
