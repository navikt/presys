import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import styles from './Transaksjonshistorikk.less';

const Grunnblankett = ({
    ektefelleTillegg,
    framtidigArbeidsinntekt,
    bosattNorge,
    statsborgerskap,
    bosattLand,
    erFlyktning,
    fravikPar19Pkt3,
    trygdetidVentetUtlandMaaneder,
    trygdetidFor1967,
    trygdetidEtter1966Aar,
    trygdetidEtter1966Maaneder,
    antallBarnetillegg,
    alderspensjonsdel,
    fodselsnummerEktefelle,
    navnEktefelle,
    trygdetidFor1967Ektefelle,
    trygdetidEtter1966AarEktefelle,
    trygdetidEtter1966MaanederEktefelle,
    overkompensasjonUtland,
    ikkeGrunnpensjon,
    inntektMinst4G }) => <Row>
      <Column size={6}>
        <table className={styles.infotable}><tbody>
          <tr>
            <td>EktefelleTillegg</td>
            <td>{ektefelleTillegg}</td>
          </tr>
          <tr>
            <td>Framtidig arbeidsinntekt</td>
            <td>{framtidigArbeidsinntekt}</td>
          </tr>
          <tr>
            <td>Er bosatt i Norge</td>
            <td>{bosattNorge}</td>
          </tr>
          <tr>
            <td>Statsborgerskap</td>
            <td>{statsborgerskap}</td>
          </tr>
          <tr>
            <td>Fravik etter paragraf 19_3</td>
            <td>{fravikPar19Pkt3}</td>
          </tr>
          <tr>
            <td>Bosatt i:</td>
            <td>{bosattLand}</td>
          </tr>
          <tr>
            <td>Har flyktningstatus:</td>
            <td>{erFlyktning}</td>
          </tr>
          <tr>
            <td>Trygdetid ventet i utlandet</td>
            <td>{trygdetidVentetUtlandMaaneder} mnd</td>
          </tr>
          <tr>
            <td>Trygdetid før 1967</td>
            <td>{trygdetidFor1967} år</td>
          </tr>
          <tr>
            <td>Trygdetid etter 1966</td>
            <td>{trygdetidEtter1966Aar} år og {trygdetidEtter1966Maaneder} mnd</td>
          </tr>
          <tr>
            <td>Antall barnetillegg</td>
            <td>{antallBarnetillegg}</td>
          </tr>
          <tr>
            <td>Alderspensjonsdel</td>
            <td>{alderspensjonsdel}</td>
          </tr>
          <tr>
            <td>Fødselsnummer ektefelle</td>
            <td>{fodselsnummerEktefelle}</td>
          </tr>
          <tr>
            <td>Navn ektefelle</td>
            <td>{navnEktefelle}</td>
          </tr>
          <tr>
            <td>Trygdetid før 1967 for ektefelle</td>
            <td>{trygdetidFor1967Ektefelle}</td>
          </tr>
          <tr>
            <td>Trygdetid etter 1966 år - mnd for ektefelle</td>
            <td>{trygdetidEtter1966AarEktefelle} år og {trygdetidEtter1966MaanederEktefelle} mnd</td>
          </tr>
          <tr>
            <td>Overkompensasjon utland</td>
            <td>{overkompensasjonUtland}</td>
          </tr>
          <tr>
            <td>Ikke grunnpensjon</td>
            <td>{ikkeGrunnpensjon}</td>
          </tr>
          <tr>
            <td>Inntekt minst 4G</td>
            <td>{inntektMinst4G}</td>
          </tr>
        </tbody></table>
      </Column>
    </Row>;


Grunnblankett.propTypes = {
  ektefelleTillegg: React.PropTypes.string.isRequired,
  framtidigArbeidsinntekt: React.PropTypes.number.isRequired,
  bosattNorge: React.PropTypes.string.isRequired,
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  erFlyktning: React.PropTypes.string.isRequired,
  fravikPar19Pkt3: React.PropTypes.string.isRequired,
  trygdetidVentetUtlandMaaneder: React.PropTypes.number.isRequired,
  trygdetidFor1967: React.PropTypes.number.isRequired,
  trygdetidEtter1966Aar: React.PropTypes.number.isRequired,
  trygdetidEtter1966Maaneder: React.PropTypes.number.isRequired,
  antallBarnetillegg: React.PropTypes.number.isRequired,
  alderspensjonsdel: React.PropTypes.number.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  trygdetidFor1967Ektefelle: React.PropTypes.number.isRequired,
  trygdetidEtter1966AarEktefelle: React.PropTypes.number.isRequired,
  trygdetidEtter1966MaanederEktefelle: React.PropTypes.number.isRequired,
  overkompensasjonUtland: React.PropTypes.string.isRequired,
  ikkeGrunnpensjon: React.PropTypes.string.isRequired,
  inntektMinst4G: React.PropTypes.string.isRequired,
};

export default Grunnblankett;
