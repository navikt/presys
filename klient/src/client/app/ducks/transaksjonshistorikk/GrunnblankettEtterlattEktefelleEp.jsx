import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import InfoTable from 'components/elements/InfoTable';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';
import VernepliktsAar from './VernepliktsAar';


const finnVernepliktsAar = ({ vernepliktaar1, vernepliktaar2, vernepliktaar3, vernepliktaar4 }) =>
[vernepliktaar1, vernepliktaar2, vernepliktaar3, vernepliktaar4].filter(elementIListe => elementIListe > 0);


const EtterlattEktefelleFortsetter2 = ({
    trygdetidVentUtland,
    ikkeGrunnpensjon,
    statsborgerskapEktefelle,
    bosattLandEktefelle,
    trygdet3AarForDodsfallEktefelle,
    erFlyktningEktefelle,
    overkompensasjonUtlandEktefelle,
    trygdetVedDodEktefelle,
    ikkeFramtidigTrygdetid,
    trygdetidFor1967Ektefelle,
    trygdetidEtter1966AarEktefelle,
    trygdetidEtter1966MaanederEktefelle,
    framtidigTrygdetidEktefelle,
    yrkesskadetillegg }) => <Row>
      <Column size={12}>
        <InfoTable>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.trygdetidVentUtland" /></td>
            <td>{trygdetidVentUtland}<FormattedMessage id="kodeverk.standardtekst.aar" /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.ikkeGrunnpensjon" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${ikkeGrunnpensjon}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.statsborgerskapEktefelle" /></td>
            <td><FormattedMessage id={`kodeverk.land.${statsborgerskapEktefelle}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.bosattLandEktefelle" /></td>
            <td><FormattedMessage id={`kodeverk.land.${bosattLandEktefelle}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.trygdet3AarForDodsfallEktefelle" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${trygdet3AarForDodsfallEktefelle}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.erFlyktningEktefelle" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${erFlyktningEktefelle}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.overkompensasjonUtlandEktefelle" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonUtlandEktefelle}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.trygdetVedDodEktefelle" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${trygdetVedDodEktefelle}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.ikkeFramtidigTrygdetid" /></td>
            <td>{ikkeFramtidigTrygdetid}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.trygdetidFor1967Ektefelle" /></td>
            <td>{trygdetidFor1967Ektefelle}<FormattedMessage id="kodeverk.standardtekst.aar" /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.trygdetidEtter1966Ektefelle" /></td>
            <td>{trygdetidEtter1966AarEktefelle}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
              {trygdetidEtter1966MaanederEktefelle}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.framtidigTrygdetidEktefelle" /></td>
            <td>{framtidigTrygdetidEktefelle}<FormattedMessage id="kodeverk.standardtekst.aar" /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.yrkesskadetillegg" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${yrkesskadetillegg}`} /></td>
          </tr>
        </InfoTable>
      </Column>
    </Row>;


EtterlattEktefelleFortsetter2.propTypes = {
  trygdetidVentUtland: React.PropTypes.number.isRequired,
  ikkeGrunnpensjon: React.PropTypes.string.isRequired,
  statsborgerskapEktefelle: React.PropTypes.number.isRequired,
  bosattLandEktefelle: React.PropTypes.number.isRequired,
  trygdet3AarForDodsfallEktefelle: React.PropTypes.string.isRequired,
  erFlyktningEktefelle: React.PropTypes.string.isRequired,
  overkompensasjonUtlandEktefelle: React.PropTypes.string.isRequired,
  trygdetVedDodEktefelle: React.PropTypes.string.isRequired,
  ikkeFramtidigTrygdetid: React.PropTypes.string.isRequired,
  trygdetidFor1967Ektefelle: React.PropTypes.number.isRequired,
  trygdetidEtter1966AarEktefelle: React.PropTypes.number.isRequired,
  trygdetidEtter1966MaanederEktefelle: React.PropTypes.number.isRequired,
  framtidigTrygdetidEktefelle: React.PropTypes.number.isRequired,
  yrkesskadetillegg: React.PropTypes.string.isRequired,
};

const EtterlattEktefelleFortsetter = ({
    statsborgerskap,
    bosattLand,
    fravikBosatt,
    trygdet3AarForDodsfall,
    fravikTrygdet3Aar,
    fravikPar19Pkt3,
    erFlyktning,
    konvensjon,
    fravikPar10Pkt1,
    overkompensasjonUtland,
    trygdetidFramTilDod,
    trygdetidFor1967,
    trygdetidEtter1966Aar,
    trygdetidEtter1966Maaneder,
    ttfmt101,
    trygdetVedDod }) => <Row>
      <Column size={12}>
        <InfoTable>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.statsborgerskap" /></td>
            <td><FormattedMessage id={`kodeverk.land.${statsborgerskap}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.bosattLand" /></td>
            <td><FormattedMessage id={`kodeverk.land.${bosattLand}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.fravikBosatt" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikBosatt}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.trygdet3AarForDodsfall" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${trygdet3AarForDodsfall}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.fravikTrygdet3Aar" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikTrygdet3Aar}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.fravikPar19Pkt3" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar19Pkt3}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.erFlyktning" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${erFlyktning}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.konvensjon" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${konvensjon}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.fravikPar10Pkt1" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar10Pkt1}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.overkompensasjonUtland" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonUtland}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.trygdetidFramTilDod" /></td>
            <td>{trygdetidFramTilDod}<FormattedMessage id="kodeverk.standardtekst.aar" /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.trygdetidFor1967" /></td>
            <td>{trygdetidFor1967}<FormattedMessage id="kodeverk.standardtekst.aar" /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.trygdetidEtter1966" /></td>
            <td>{trygdetidEtter1966Aar}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
              {trygdetidEtter1966Maaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.ttfmt101" /></td>
            <td>{ttfmt101}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.trygdetVedDod" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${trygdetVedDod}`} /></td>
          </tr>
        </InfoTable>
      </Column>
    </Row>;


EtterlattEktefelleFortsetter.propTypes = {
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  fravikBosatt: React.PropTypes.string.isRequired,
  trygdet3AarForDodsfall: React.PropTypes.string.isRequired,
  fravikTrygdet3Aar: React.PropTypes.string.isRequired,
  fravikPar19Pkt3: React.PropTypes.string.isRequired,
  erFlyktning: React.PropTypes.string.isRequired,
  konvensjon: React.PropTypes.string.isRequired,
  fravikPar10Pkt1: React.PropTypes.string.isRequired,
  overkompensasjonUtland: React.PropTypes.string.isRequired,
  trygdetidFramTilDod: React.PropTypes.number.isRequired,
  trygdetidFor1967: React.PropTypes.number.isRequired,
  trygdetidEtter1966Aar: React.PropTypes.number.isRequired,
  trygdetidEtter1966Maaneder: React.PropTypes.number.isRequired,
  ttfmt101: React.PropTypes.number.isRequired,
  trygdetVedDod: React.PropTypes.string.isRequired,
};

const GrunnblankettEtterlattEktefelleEp = ({
    bosattNorge,
    tpProsent,
    omsorgAvdodeBarn,
    vilkaarPar10Pkt5,
    forventetInntekt,
    hjemmelPar10Pkt8,
    framleggsdato,
    framleggskode,
    fodrselsnummerEktefelle,
    navnEktefelle,
    dodsdato,
    vilkaarPar4Pkt4Ledd3BokstavA,
    framtidigArbeidsinntekt,
    bosattNorgeEktefelle,
    pensjonsgivendeInntektAvdodSisteAar,
    overgangsstonadEllerPensjonKode,
    ...ubehandlede }) => <Row>
      <Column size={6}>
        <div>&nbsp;<h4>Etterlatt ektefelle:</h4></div>
        <InfoTable>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.bosattNorge" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${bosattNorge}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.tpProsent" /></td>
            <td>{tpProsent}%</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.omsorgAvdodeBarn" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${omsorgAvdodeBarn}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.vilkaarPar10Pkt5" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar10Pkt5}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.forventetInntekt" /></td>
            <td><FormattedMessage id="kodeverk.standardtekst.kr" />
              {forventetInntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.hjemmelPar10Pkt8" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${hjemmelPar10Pkt8}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.framleggsdato" /></td>
            <td><DsfDate value={framleggsdato}><ISO8601 /></DsfDate></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.framleggskode" /></td>
            <td><FormattedMessage id={`GrunnblankettEtterlattEktefelleEp.framleggsKode.${framleggskode}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.fodrselsnummerEktefelle" /></td>
            <td>{fodrselsnummerEktefelle}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.navnEktefelle" /></td>
            <td>{navnEktefelle}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.dodsdato" /></td>
            <td><DsfDate value={dodsdato}><ISO8601 /></DsfDate></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.vilkaarPar4Pkt4Ledd3BokstavA" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar4Pkt4Ledd3BokstavA}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.framtidigArbeidsinntekt" /></td>
            <td><FormattedMessage id="kodeverk.standardtekst.kr" />
              {framtidigArbeidsinntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>

          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.bosattNorgeEktefelle" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${bosattNorgeEktefelle}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.pensjonsgivendeInntektAvdodSisteAar" /></td>
            <td><FormattedMessage id="kodeverk.standardtekst.kr" />
              {pensjonsgivendeInntektAvdodSisteAar}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>

          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlattEktefelleEp.overgangsstonadEllerPensjonKode" /></td>
            <td><FormattedMessage id={`GrunnblankettEtterlattEktefelleEp.overgangsstonadPensjonKode.${overgangsstonadEllerPensjonKode}`} /></td>
          </tr>
        </InfoTable>
        <EtterlattEktefelleFortsetter {...ubehandlede} />
      </Column>
      <Column size={6}>
        <div>&nbsp;<h4>EtterlattEktefelle fortsetter:</h4></div>
        <EtterlattEktefelleFortsetter2 {...ubehandlede} />
        <div>&nbsp;<h3>Vernepliktsår:</h3></div>
        <VernepliktsAar vernepliktaar={finnVernepliktsAar(ubehandlede)} />
      </Column>
    </Row>;

GrunnblankettEtterlattEktefelleEp.propTypes = {
  bosattNorge: React.PropTypes.string.isRequired,
  tpProsent: React.PropTypes.number.isRequired,
  omsorgAvdodeBarn: React.PropTypes.string.isRequired,
  vilkaarPar10Pkt5: React.PropTypes.string.isRequired,
  forventetInntekt: React.PropTypes.number.isRequired,
  hjemmelPar10Pkt8: React.PropTypes.string.isRequired,
  framleggsdato: React.PropTypes.number.isRequired,
  framleggskode: React.PropTypes.string.isRequired,
  fodrselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  dodsdato: React.PropTypes.number.isRequired,
  vilkaarPar4Pkt4Ledd3BokstavA: React.PropTypes.string.isRequired,
  framtidigArbeidsinntekt: React.PropTypes.number.isRequired,
  bosattNorgeEktefelle: React.PropTypes.string.isRequired,
  pensjonsgivendeInntektAvdodSisteAar: React.PropTypes.number.isRequired,
  overgangsstonadEllerPensjonKode: React.PropTypes.string.isRequired,
};


export default GrunnblankettEtterlattEktefelleEp;
