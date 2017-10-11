import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import { DsfDate } from 'components/elements/ParseDate';
import { MonthInYear } from 'components/elements/FormattedDate';

import InfoTable from 'components/elements/InfoTable';
import VernepliktsAar from './VernepliktsAar';


const Fortsettelse = ({ fodselsnummerEktefelle,
        navnEktefelle,
        ektefellesInntektMinst4G,
        statsborgerskap,
        bosattLand,
        pensjonstrygdet,
        minst20AArBotid,
        konvensjon,
        erFlyktning,
        overkompensasjonUtland,
        ikkeGrunnpensjon,
        beregnesEtterKonvensjonbestemmelser,
        trygdetidAntallKonvensjonsaar,
        trygdetidFra1937Aar,
        trygdetidFra1937Maaneder,
        nordiskTrygdetid,
        fravikPar8Pkt1LeddNr3,
        stonadstilfelletsInntreden,
        inntektForUforhet }) => <Row>
          <Column size={12}>
            <InfoTable>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.fodselsnummerEktefelle" /></td>
                <td>{fodselsnummerEktefelle}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.navnEktefelle" /></td>
                <td>{navnEktefelle}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.ektefellesInntektMinst4G" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${ektefellesInntektMinst4G}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.statsborgerskap" /></td>
                <td><FormattedMessage id={`kodeverk.land.${statsborgerskap}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.bosattLand" /></td>
                <td><FormattedMessage id={`kodeverk.land.${bosattLand}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.pensjonstrygdet" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${pensjonstrygdet}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.minst20AArBotid" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${minst20AArBotid}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.konvensjon" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${konvensjon}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.erFlyktning" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${erFlyktning}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.overkompensasjonUtland" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonUtland}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.ikkeGrunnpensjon" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${ikkeGrunnpensjon}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.beregnesEtterKonvensjonbestemmelser" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${beregnesEtterKonvensjonbestemmelser}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.trygdetidAntallKonvensjonsaar" /></td>
                <td>{trygdetidAntallKonvensjonsaar}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.trygdetidFra1937" /></td>
                <td>{trygdetidFra1937Aar} år og {trygdetidFra1937Maaneder} måneder</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.nordiskTrygdetid" /></td>
                <td>{nordiskTrygdetid !== ' ' ? { nordiskTrygdetid } : ''}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.fravikPar8Pkt1LeddNr3" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar8Pkt1LeddNr3}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.stonadstilfelletsInntreden" /></td>
                <td>{stonadstilfelletsInntreden}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettUforepensjonU2.inntektForUforhet" /></td>
                <td>{inntektForUforhet}</td>
              </tr>
            </InfoTable>
          </Column>
        </Row>;

Fortsettelse.propTypes = {
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  ektefellesInntektMinst4G: React.PropTypes.string.isRequired,
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  pensjonstrygdet: React.PropTypes.string.isRequired,
  minst20AArBotid: React.PropTypes.string.isRequired,
  konvensjon: React.PropTypes.string.isRequired,
  erFlyktning: React.PropTypes.string.isRequired,
  overkompensasjonUtland: React.PropTypes.string.isRequired,
  ikkeGrunnpensjon: React.PropTypes.string.isRequired,
  beregnesEtterKonvensjonbestemmelser: React.PropTypes.string.isRequired,
  trygdetidAntallKonvensjonsaar: React.PropTypes.number.isRequired,
  trygdetidFra1937Aar: React.PropTypes.number.isRequired,
  trygdetidFra1937Maaneder: React.PropTypes.number.isRequired,
  nordiskTrygdetid: React.PropTypes.string.isRequired,
  fravikPar8Pkt1LeddNr3: React.PropTypes.string.isRequired,
  stonadstilfelletsInntreden: React.PropTypes.number.isRequired,
  inntektForUforhet: React.PropTypes.number.isRequired,
};


const GrunnblankettUforepensjonU2 = ({
    attforingUfor,
    ektefelleTillegg,
    bosattNorge,
    antaBarnMedBarnetillegg,
    yrkesskadetillegg,
    utdanning,
    vilkaarPar8Pkt4Ledd3Bokatava,
    pensjonsgivendeInntekt,
    uforegrad,
    uforetidspunkt,
    yrkesmessigAttforing,
    yrke,
    ...ubehandlede }) => <Row>
      <Column size={4}>
        <div>&nbsp;<h3>Uforepensjon:</h3></div>
        <InfoTable>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.attforingUfor" /></td>
            <td><FormattedMessage id={`Uforepensjon.attforingUfore.${attforingUfor}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.ektefelleTillegg" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelleTillegg}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.bosattNorge" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${bosattNorge}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.antaBarnMedBarnetillegg" /></td>
            <td>{antaBarnMedBarnetillegg}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.yrkesskadetillegg" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${yrkesskadetillegg}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.utdanning" /></td>
            <td><FormattedMessage id={`Uforepensjon.utdanning.${utdanning}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.vilkaarPar8Pkt4Ledd3Bokatava" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar8Pkt4Ledd3Bokatava}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.pensjonsgivendeInntekt" /></td>
            <td>{pensjonsgivendeInntekt}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.uforegrad" /></td>
            <td>{uforegrad}</td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.uforetidspunkt" /></td>
            <td><DsfDate value={uforetidspunkt}><MonthInYear /></DsfDate></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.yrkesmessigAttforing" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${yrkesmessigAttforing}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettUforepensjonU2.yrke" /></td>
            <td><FormattedMessage id={`kodeverk.yrke.${yrke}`} /></td>
          </tr>
        </InfoTable>
      </Column>
      <Column size={4}>
        <div>&nbsp;<h3>Uforepensjon fortsettelse:</h3></div>
        <Fortsettelse {...ubehandlede} />
      </Column>
      <Column size={4}>
        <div>&nbsp;<h3>Vernepliktsår:</h3></div>
        <VernepliktsAar {...ubehandlede} />
      </Column>

    </Row>;

GrunnblankettUforepensjonU2.propTypes = {
  attforingUfor: React.PropTypes.string.isRequired,
  ektefelleTillegg: React.PropTypes.string.isRequired,
  bosattNorge: React.PropTypes.string.isRequired,
  antaBarnMedBarnetillegg: React.PropTypes.number.isRequired,
  yrkesskadetillegg: React.PropTypes.string.isRequired,
  utdanning: React.PropTypes.string.isRequired,
  vilkaarPar8Pkt4Ledd3Bokatava: React.PropTypes.string.isRequired,
  pensjonsgivendeInntekt: React.PropTypes.number.isRequired,
  uforegrad: React.PropTypes.number.isRequired,
  uforetidspunkt: React.PropTypes.number.isRequired,
  yrkesmessigAttforing: React.PropTypes.string.isRequired,
  yrke: React.PropTypes.number.isRequired,
};

export default GrunnblankettUforepensjonU2;
