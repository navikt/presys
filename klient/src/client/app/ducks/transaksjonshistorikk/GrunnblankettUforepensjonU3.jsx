import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';

import InfoTable from 'components/elements/InfoTable';
import VernepliktsAar from './VernepliktsAar';


const Trygdetid = ({ trygdetidFra1937Aar,
             trygdetidFra1937Maaneder,
             trygdetidFor1967Aar,
             trygdetidEtter1966Aar,
             trygdetidEtter1966Maaneder,
             trygdetidFor1967AarEktefelle,
             trygdetidEtter1966AarEktefelle,
             trygdetidEtter1966MaanederEktefelle,
             trygdetidLikPoengaar,
             trygdetidEndres,
             trygdetidAnnetNordiskLand,
             trygdetidKonvensjonAar,
             grunnPensjonBeregnetPaaTrygdetidLikPoengaar,
             beregneFramtidigTrygdetid,
             beregneFaktiskTrygdetid,
             teoretiskTrygdetidEOSAar,
             teoretiskTrygdetidEOSMaaneder,
             prorataTrygdetidEOSAar,
             prorataTrygdetidEOSMaaneder,
             faktiskNordiskTrygdetidAar,
             faktiskNordiskTrygdetidMaaneder }) => <Row>
               <Column size={12}>
                 <InfoTable>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.trygdetidFra1937" /></td>
                     <td>{trygdetidFra1937Aar} år og {trygdetidFra1937Maaneder} måneder</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.trygdetidFor1967" /></td>
                     <td>{trygdetidFor1967Aar} år</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.trygdetidEtter1966" /></td>
                     <td>{trygdetidEtter1966Aar} år og {trygdetidEtter1966Maaneder} måneder</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.trygdetidFor1967AarEktefelle" /></td>
                     <td>{trygdetidFor1967AarEktefelle} år</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.trygdetidEtter1966Ektefelle" /></td>
                     <td>{trygdetidEtter1966AarEktefelle} år og {trygdetidEtter1966MaanederEktefelle} måneder</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.trygdetidLikPoengaar" /></td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${trygdetidLikPoengaar}`} /></td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.trygdetidEndres" /></td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${trygdetidEndres}`} /></td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.trygdetidAnnetNordiskLand" /></td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${trygdetidAnnetNordiskLand}`} /></td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.trygdetidKonvensjonAar" /></td>
                     <td>{trygdetidKonvensjonAar}</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.grunnPensjonBeregnetPaaTrygdetidLikPoengaar" /></td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${grunnPensjonBeregnetPaaTrygdetidLikPoengaar}`} /></td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.beregneFramtidigTrygdetid" /></td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${beregneFramtidigTrygdetid}`} /></td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.beregneFaktiskTrygdetid" /></td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${beregneFaktiskTrygdetid}`} /></td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.teoretiskTrygdetidEOS" /></td>
                     <td>{teoretiskTrygdetidEOSAar} år og {teoretiskTrygdetidEOSMaaneder} måneder</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.prorataTrygdetidEOS" /></td>
                     <td>{prorataTrygdetidEOSAar} år og {prorataTrygdetidEOSMaaneder} måneder</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettUforepensjonU3.faktiskNordiskTrygdetid" /></td>
                     <td>{faktiskNordiskTrygdetidAar} år og {faktiskNordiskTrygdetidMaaneder} måneder</td>
                   </tr>
                 </InfoTable>
               </Column>
             </Row>;

Trygdetid.propTypes = {
  trygdetidLikPoengaar: React.PropTypes.string.isRequired,
  trygdetidFra1937Aar: React.PropTypes.number.isRequired,
  trygdetidFra1937Maaneder: React.PropTypes.number.isRequired,
  trygdetidFor1967Aar: React.PropTypes.number.isRequired,
  trygdetidEtter1966Aar: React.PropTypes.number.isRequired,
  trygdetidEtter1966Maaneder: React.PropTypes.number.isRequired,
  trygdetidFor1967AarEktefelle: React.PropTypes.number.isRequired,
  trygdetidEtter1966AarEktefelle: React.PropTypes.number.isRequired,
  trygdetidEtter1966MaanederEktefelle: React.PropTypes.number.isRequired,
  trygdetidEndres: React.PropTypes.string.isRequired,
  trygdetidAnnetNordiskLand: React.PropTypes.string.isRequired,
  trygdetidKonvensjonAar: React.PropTypes.number.isRequired,
  grunnPensjonBeregnetPaaTrygdetidLikPoengaar: React.PropTypes.string.isRequired,
  teoretiskTrygdetidEOSAar: React.PropTypes.number.isRequired,
  teoretiskTrygdetidEOSMaaneder: React.PropTypes.number.isRequired,
  prorataTrygdetidEOSAar: React.PropTypes.number.isRequired,
  prorataTrygdetidEOSMaaneder: React.PropTypes.number.isRequired,
  beregneFramtidigTrygdetid: React.PropTypes.string.isRequired,
  beregneFaktiskTrygdetid: React.PropTypes.string.isRequired,
  faktiskNordiskTrygdetidAar: React.PropTypes.number.isRequired,
  faktiskNordiskTrygdetidMaaneder: React.PropTypes.number.isRequired,


};

const GrunnblankettUforepensjonFortsetter3 = ({
    fodselsnummerEktefelle,
    navnEktefelle,
    statsborgerskap,
    bosattLand,
    unntakPar12Pkt2,
    stonadstilfelleDato3B,
    fravikPar2Pkt1Ledd3BokstavC,
    stonadstilfelleDato3C,
    pensjonstrygdet,
    minst20Aar,
    folgerKonvensjonMedAndreLand,
    konvensjonsLand,
    fravikPar8Pkt1,
    godkjentFlyktningUDI,
    overkompensert,
    fravikpar19Pkt3 }) => <Row>
      <Column size={12}>
        <InfoTable>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.fodselsnummerEktefelle" /></td>
            <td>{fodselsnummerEktefelle}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.navnEktefelle" /></td>
            <td>{navnEktefelle}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.statsborgerskap" /></td>
            <td><FormattedMessage id={`kodeverk.land.${statsborgerskap}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.bosattLand" /></td>
            <td><FormattedMessage id={`kodeverk.land.${bosattLand}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.unntakPar12Pkt2" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${unntakPar12Pkt2}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.stonadstilfelleDato3B" /></td>
            <td>{stonadstilfelleDato3B}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.fravikPar2Pkt1Ledd3BokstavC" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar2Pkt1Ledd3BokstavC}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.stonadstilfelleDato3C" /></td>
            <td>{stonadstilfelleDato3C}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.pensjonstrygdet" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${pensjonstrygdet}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.minst20Aar" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${minst20Aar}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.folgerKonvensjonMedAndreLand" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${folgerKonvensjonMedAndreLand}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.konvensjonsLand" /></td>
            <td><FormattedMessage id={`kodeverk.land.${konvensjonsLand}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.fravikPar8Pkt1" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar8Pkt1}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.godkjentFlyktningUDI" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${godkjentFlyktningUDI}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.overkompensert" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensert}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.fravikpar19Pkt3" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikpar19Pkt3}`} /></td>
          </tr>
        </InfoTable>
      </Column>
    </Row>;

GrunnblankettUforepensjonFortsetter3.propTypes = {
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  unntakPar12Pkt2: React.PropTypes.string.isRequired,
  stonadstilfelleDato3B: React.PropTypes.number.isRequired,
  fravikPar2Pkt1Ledd3BokstavC: React.PropTypes.string.isRequired,
  stonadstilfelleDato3C: React.PropTypes.number.isRequired,
  pensjonstrygdet: React.PropTypes.string.isRequired,
  minst20Aar: React.PropTypes.string.isRequired,
  folgerKonvensjonMedAndreLand: React.PropTypes.string.isRequired,
  konvensjonsLand: React.PropTypes.number.isRequired,
  fravikPar8Pkt1: React.PropTypes.string.isRequired,
  godkjentFlyktningUDI: React.PropTypes.string.isRequired,
  overkompensert: React.PropTypes.string.isRequired,
  fravikpar19Pkt3: React.PropTypes.string.isRequired,
};


const GrunnblankettUforepensjonFortsetter2 = ({ ikkeBeregneGrunnpensjon,
    avkorteSaertillegg,
    tilleggspensjonFraAnnetNordiskland,
    tilleggspensjonsland,
    beregningKonvensjon,
    beregneFolketrygd,
    faktiskeNordiskePoengaar,
    ektefelleInntektOver2G,
    garantiTilleggspensjon,
    reduksjonGrunnpensjonEtterPar3Pkt2Ledd5 }) => <Row>
      <Column size={12}>
        <InfoTable>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.ektefelleInntektOver2G" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelleInntektOver2G}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.reduksjonGrunnpensjonEtterPar3Pkt2Ledd5" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${reduksjonGrunnpensjonEtterPar3Pkt2Ledd5}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.ikkeBeregneGrunnpensjon" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${ikkeBeregneGrunnpensjon}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.avkorteSaertillegg" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${avkorteSaertillegg}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.tilleggspensjonFraAnnetNordiskland" /></td>
            <td>{tilleggspensjonFraAnnetNordiskland}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.tilleggspensjonsland" /></td>
            <td><FormattedMessage id={`kodeverk.land.${tilleggspensjonsland}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.beregningKonvensjon" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${beregningKonvensjon}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.beregneFolketrygd" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${beregneFolketrygd}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.faktiskeNordiskePoengaar" /></td>
            <td>{faktiskeNordiskePoengaar}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.garantiTilleggspensjon" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${garantiTilleggspensjon}`} /></td>
          </tr>
        </InfoTable>
      </Column>
    </Row>;

GrunnblankettUforepensjonFortsetter2.propTypes = {
  ikkeBeregneGrunnpensjon: React.PropTypes.string.isRequired,
  avkorteSaertillegg: React.PropTypes.string.isRequired,
  tilleggspensjonFraAnnetNordiskland: React.PropTypes.number.isRequired,
  tilleggspensjonsland: React.PropTypes.number.isRequired,
  beregningKonvensjon: React.PropTypes.string.isRequired,
  beregneFolketrygd: React.PropTypes.string.isRequired,
  faktiskeNordiskePoengaar: React.PropTypes.number.isRequired,
  ektefelleInntektOver2G: React.PropTypes.string.isRequired,
  garantiTilleggspensjon: React.PropTypes.string.isRequired,
  reduksjonGrunnpensjonEtterPar3Pkt2Ledd5: React.PropTypes.string.isRequired,
};

const EOS = ({
    eosPar8Pkt4Ledd3BokstavA,
    pensjonEOS,
    poengaarIEOS,
    poengaarIEOSIkkeMedIProrata,
    eosOpplysning,
    fravikBosattEOS }) => <Row>
      <Column size={12}>
        <InfoTable>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.eosPar8Pkt4Ledd3BokstavA" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${eosPar8Pkt4Ledd3BokstavA}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.pensjonEOS" /></td>
            <td>Kr {pensjonEOS}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.poengaarIEOS" /></td>
            <td><ul>{poengaarIEOS.map(e => <li key={e}>{e}</li>)}</ul></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.poengaarIEOSIkkeMedIProrata" /></td>
            <td><ul>{poengaarIEOSIkkeMedIProrata.map(e => <li key={e}>{e}</li>)}</ul></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.eosOpplysning" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${eosOpplysning}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.fravikBosattEOS" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikBosattEOS}`} /></td>
          </tr>
        </InfoTable>
      </Column>
    </Row>;

EOS.propTypes = {
  eosPar8Pkt4Ledd3BokstavA: React.PropTypes.string.isRequired,
  pensjonEOS: React.PropTypes.number.isRequired,
  poengaarIEOS: React.PropTypes.arrayOf(React.PropTypes.bool).isRequired,
  poengaarIEOSIkkeMedIProrata: React.PropTypes.arrayOf(React.PropTypes.bool).isRequired,
  eosOpplysning: React.PropTypes.string.isRequired,
  fravikBosattEOS: React.PropTypes.string.isRequired,
};


const GrunnblankettUforepensjonFortsetter = ({
    friinntektDato,
    inntektForUforepensjon,
    unntakVentetid,
    reaktivisering,
    frysp5AarArbeid,
    fryspTidsb,
    lonnstilskudd }) => <Row>
      <Column size={12}>
        <InfoTable>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.friinntektDato" /></td>
            <td><DsfDate value={friinntektDato}><ISO8601 /></DsfDate></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.inntektForUforepensjon" /></td>
            <td>Kr {inntektForUforepensjon}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.unntakVentetid" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${unntakVentetid}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.reaktivisering" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${reaktivisering}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.frysp5AarArbeid" /></td>
            <td><FormattedMessage id={`Uforepensjon.frys.${frysp5AarArbeid}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.fryspTidsb" /></td>
            <td><FormattedMessage id={`Uforepensjon.frys.${fryspTidsb}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU3.lonnstilskudd" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${lonnstilskudd}`} /></td>
          </tr>
        </InfoTable>
      </Column>
    </Row>;


GrunnblankettUforepensjonFortsetter.propTypes = {
  friinntektDato: React.PropTypes.number.isRequired,
  inntektForUforepensjon: React.PropTypes.number.isRequired,
  unntakVentetid: React.PropTypes.string.isRequired,
  reaktivisering: React.PropTypes.string.isRequired,
  frysp5AarArbeid: React.PropTypes.string.isRequired,
  fryspTidsb: React.PropTypes.string.isRequired,
  lonnstilskudd: React.PropTypes.string.isRequired,
};

const finnVernepliktsAar = ({ vernepliktaar1, vernepliktaar2, vernepliktaar3, vernepliktaar4 }) =>
[vernepliktaar1, vernepliktaar2, vernepliktaar3, vernepliktaar4].filter(elementIListe => elementIListe > 0);

const GrunnblankettUforepensjonU3 = ({
          attforingUfor,
          navn,
          bosattNorge,
          ektefelletillegg,
          barnetillegg,
          vilkaarPar8Pkt4Ledd3BokstavA,
          pensjonsgivendeInntekt,
          yngsteBarnFodselsaar,
          yrkesskadetillegg,
          yrkesmessigAttforing,
          utdanning,
          yrke,
          uforegrad,
          uforetidspunkt,
          ungUfor,
        ...ubehandlede }) => <Row>
          <Column size={6}>
            <div>&nbsp;<h4>Uforepensjon:</h4></div>
            <InfoTable>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.attforingUfor" /></td>
                <td><FormattedMessage id={`Uforepensjon.attforingUfore.${attforingUfor}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.navn" /></td>
                <td>{navn}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.bosattNorge" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${bosattNorge}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.ektefelletillegg" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelletillegg}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.barnetillegg" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${barnetillegg}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.vilkaarPar8Pkt4Ledd3BokstavA" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar8Pkt4Ledd3BokstavA}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.pensjonsgivendeInntekt" /></td>
                <td>{pensjonsgivendeInntekt}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.yngsteBarnFodselsaar" /></td>
                <td>{yngsteBarnFodselsaar}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.yrkesskadetillegg" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${yrkesskadetillegg}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.yrkesmessigAttforing" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${yrkesmessigAttforing}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.utdanning" /></td>
                <td><FormattedMessage id={`Uforepensjon.utdanning.${utdanning}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.yrke" /></td>
                <td><FormattedMessage id={`kodeverk.yrke.${yrke}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.uforegrad" /></td>
                <td>{uforegrad}%</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.uforetidspunkt" /></td>
                <td><DsfDate value={uforetidspunkt}><ISO8601 /></DsfDate></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU3.ungUfor" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${ungUfor}`} /></td>
              </tr>
            </InfoTable>
            <GrunnblankettUforepensjonFortsetter {...ubehandlede} />
            <GrunnblankettUforepensjonFortsetter2 {...ubehandlede} />
            <GrunnblankettUforepensjonFortsetter3 {...ubehandlede} />
          </Column>
          <Column size={6}>
            <div>&nbsp;<h4>EØS:</h4></div>
            <EOS {...ubehandlede} />
            <div>&nbsp;<h4>Trygdetid:</h4></div>
            <Trygdetid {...ubehandlede} />
            <div>&nbsp;<h4>Vernepliktsår:</h4></div>
            <VernepliktsAar vernepliktaar={finnVernepliktsAar(ubehandlede)} />
          </Column>
        </Row>;


GrunnblankettUforepensjonU3.propTypes = {
  attforingUfor: React.PropTypes.string.isRequired,
  navn: React.PropTypes.string.isRequired,
  bosattNorge: React.PropTypes.string.isRequired,
  ektefelletillegg: React.PropTypes.string.isRequired,
  barnetillegg: React.PropTypes.string.isRequired,
  vilkaarPar8Pkt4Ledd3BokstavA: React.PropTypes.string.isRequired,
  pensjonsgivendeInntekt: React.PropTypes.number.isRequired,
  yngsteBarnFodselsaar: React.PropTypes.number.isRequired,
  yrkesskadetillegg: React.PropTypes.string.isRequired,
  yrkesmessigAttforing: React.PropTypes.string.isRequired,
  utdanning: React.PropTypes.number.isRequired,
  yrke: React.PropTypes.number.isRequired,
  uforegrad: React.PropTypes.number.isRequired,
  uforetidspunkt: React.PropTypes.number.isRequired,
  ungUfor: React.PropTypes.string.isRequired,
};


export default GrunnblankettUforepensjonU3;
