import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import InfoTable from 'components/elements/InfoTable';
import { FormattedNumber } from 'react-intl';

const Alternativ = ({ alternativGrunnpensjon,
                   alternativSaertillegg,
                   alternativTjenestepensjon,
                   alternativBarnetrygd,
                   alternativEktefelletillegg,
                   alternativSumPensjon,
                   alternativtSaertilleggBrutto }) => <Row>
                     <Column size={6}>
                       <InfoTable>
                         <div>&nbsp;<h4>Alternativ:</h4></div>
                         <tr>
                           <td>alternativGrunnpensjon</td>
                           <td>{alternativGrunnpensjon}</td>
                         </tr>
                         <tr>
                           <td>alternativSaertillegg</td>
                           <td>{alternativSaertillegg}</td>
                         </tr>
                         <tr>
                           <td>alternativTjenestepensjon</td>
                           <td>{alternativTjenestepensjon}</td>
                         </tr>
                         <tr>
                           <td>alternativBarnetrygd</td>
                           <td>{alternativBarnetrygd}</td>
                         </tr>
                         <tr>
                           <td>alternativEktefelletillegg</td>
                           <td>{alternativEktefelletillegg}</td>
                         </tr>
                         <tr>
                           <td>alternativSumPensjon</td>
                           <td>{alternativSumPensjon}</td>
                         </tr>
                         <tr>
                           <td>alternativtSaertilleggBrutto</td>
                           <td>{alternativtSaertilleggBrutto}</td>
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
                       <InfoTable>
                         <div>&nbsp;<h4>Trygdetid:</h4></div>
                         <tr>
                           <td>trygdetidProRataMaaneder</td>
                           <td>{trygdetidProRataMaaneder}</td>
                         </tr>
                         <tr>
                           <td>trygdetidTeoretiskEosMaaneder</td>
                           <td>{trygdetidTeoretiskEosMaaneder}</td>
                         </tr>
                         <tr>
                           <td>trygdetidEosFramtidigMaaneder</td>
                           <td>{trygdetidEosFramtidigMaaneder}</td>
                         </tr>
                         <tr>
                           <td>trygdetidEosAnvendtMaaneder</td>
                           <td>{trygdetidEosAnvendtMaaneder}</td>
                         </tr>
                         <tr>
                           <td>trygdetidEosAnvendtAAr</td>
                           <td>{trygdetidEosAnvendtAAr}</td>
                         </tr>
                         <tr>
                           <td>trygdetidNordiskFaktiskMaaneder</td>
                           <td>{trygdetidNordiskFaktiskMaaneder}</td>
                         </tr>
                         <tr>
                           <td>trygdetidNordiskFramtidigBrutto</td>
                           <td>{trygdetidNordiskFramtidigBrutto}</td>
                         </tr>
                         <tr>
                           <td>trygdetidNordiskFramtidigNetto</td>
                           <td>{trygdetidNordiskFramtidigNetto}</td>
                         </tr>
                         <tr>
                           <td>trygdetidFaktiskNorskMaaneder</td>
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
                       <InfoTable>
                         <div>&nbsp;<h4>Nordisk:</h4></div>
                         <tr>
                           <td>nordiskKonvensjon</td>
                           <td>{nordiskKonvensjon}</td>
                         </tr>
                         <tr>
                           <td>pensjonsAarNordiskFaktisk</td>
                           <td>{pensjonsAarNordiskFaktisk}</td>
                         </tr>
                         <tr>
                           <td>pensjonsAarNordiskFramtidigBrutto</td>
                           <td>{pensjonsAarNordiskFramtidigBrutto}</td>
                         </tr>
                         <tr>
                           <td>pensjonsAarNordiskFramtidigNetto</td>
                           <td>{pensjonsAarNordiskFramtidigNetto}</td>
                         </tr>
                         <tr>
                           <td>sluttpoengtallNordiskArtikkel15</td>
                           <td><FormattedNumber value={sluttpoengtallNordiskArtikkel15} /></td>
                         </tr>
                         <tr>
                           <td>overkompensasjonNordiskArtikkel15</td>
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
                   alternetivGrunnpensjonBrutto,
                   alternetivTjenestepensjonBrutto,
                   eosAarIkkeProRata1967Til2014,
                   inntektprovetEosPensjon,
                   beregnetUforePensjonsgradEos,
                   pensjonsaarEosFaktisk,
                   proRata21967Til2014, ...ubehandlede }) => <Row>
                     <Column size={6}>
                       <InfoTable>
                         <div>&nbsp;<h4>EØS informasjon:</h4></div>
                         <tr>
                           <td>beregnFolketrygd</td>
                           <td>{beregnFolketrygd}</td>
                         </tr>
                         <tr>
                           <td>proRataBeregning</td>
                           <td>{proRataBeregning}</td>
                         </tr>
                         <tr>
                           <td>inntektsaarEos</td>
                           <td>{inntektsaarEos}</td>
                         </tr>
                         <tr>
                           <td>antallNorskePoengaar</td>
                           <td>{antallNorskePoengaar}</td>
                         </tr>
                         <tr>
                           <td>antallNorskePoengaarEtter1991</td>
                           <td>{antallNorskePoengaarEtter1991}</td>
                         </tr>
                         <tr>
                           <td>sluttpoengtallEos</td>
                           <td><FormattedNumber value={sluttpoengtallEos} /></td>
                         </tr>
                         <tr>
                           <td>overkompensasjonEos</td>
                           <td><FormattedNumber value={overkompensasjonEos} /></td>
                         </tr>
                         <tr>
                           <td>pensjonEos</td>
                           <td>{pensjonEos}</td>
                         </tr>
                         <tr>
                           <td>eosPar8Pkt4Ledd3BokstavA</td>
                           <td>{eosPar8Pkt4Ledd3BokstavA}</td>
                         </tr>
                         <tr>
                           <td>gunstigsteAlternativ</td>
                           <td>{gunstigsteAlternativ}</td>
                         </tr>
                         <tr>
                           <td>pensjonsAarEos</td>
                           <td>{pensjonsAarEos}</td>
                         </tr>
                         <tr>
                           <td>pensjonsAarEosEtter1991</td>
                           <td>{pensjonsAarEosEtter1991}</td>
                         </tr>
                         <tr>
                           <td>framtidigPensjonsAarEos</td>
                           <td>{framtidigPensjonsAarEos}</td>
                         </tr>
                         <tr>
                           <td>grunnpensjonArtikkel13Virkedato</td>
                           <td>{grunnpensjonArtikkel13Virkedato}</td>
                         </tr>
                         <tr>
                           <td>tjenestepensjonArtikkel13Virkedato</td>
                           <td>{tjenestepensjonArtikkel13Virkedato}</td>
                         </tr>
                         <tr>
                           <td>alternetivGrunnpensjonBrutto</td>
                           <td>{alternetivGrunnpensjonBrutto}</td>
                         </tr>
                         <tr>
                           <td>alternetivTjenestepensjonBrutto</td>
                           <td>{alternetivTjenestepensjonBrutto}</td>
                         </tr>
                         <tr>
                           <td>eosAarIkkeProRata1967Til2014</td>
                           <td>{eosAarIkkeProRata1967Til2014}</td>
                         </tr>
                         <tr>
                           <td>inntektprovetEosPensjon</td>
                           <td>{inntektprovetEosPensjon}</td>
                         </tr>
                         <tr>
                           <td>beregnetUforePensjonsgradEos</td>
                           <td>{beregnetUforePensjonsgradEos}</td>
                         </tr>
                         <tr>
                           <td>pensjonsaarEosFaktisk</td>
                           <td>{pensjonsaarEosFaktisk}</td>
                         </tr>
                         <tr>
                           <td>proRata21967Til2014</td>
                           <td>{proRata21967Til2014}</td>
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
  inntektsaarEos: React.PropTypes.string.isRequired,
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
  alternetivGrunnpensjonBrutto: React.PropTypes.number.isRequired,
  alternetivTjenestepensjonBrutto: React.PropTypes.number.isRequired,
  eosAarIkkeProRata1967Til2014: React.PropTypes.string.isRequired,
  inntektprovetEosPensjon: React.PropTypes.string.isRequired,
  beregnetUforePensjonsgradEos: React.PropTypes.number.isRequired,
  pensjonsaarEosFaktisk: React.PropTypes.number.isRequired,
  proRata21967Til2014: React.PropTypes.string.isRequired,
};

export default EosInfo;
