import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import { DsfDate } from 'components/elements/ParseDate';
import { MonthInYear } from 'components/elements/FormattedDate';

import styles from './Transaksjonshistorikk.less';
import VernepliktsAar from './VernepliktsAar';
import EktefelleInfo from './EktefelleInfo';


const BostedsInfo = ({ norskINorgeMedlem,
     statsborgerskap,
     bosattLand,
     uforUnderBotid }) => <Row>
       <Column size={12}>
         <table className={styles.infotable}><tbody>
           <tr>
             <td>Norsk medlem bosatt i Norge</td>
             <td><FormattedMessage id={`kodeverk.ja.nei.${norskINorgeMedlem}`} /></td>
           </tr>
           <tr>
             <td>Statsborger i</td>
             <td><FormattedMessage id={`kodeverk.land.${statsborgerskap}`} /></td>
           </tr>
           <tr>
             <td>Bosatt i</td>
             <td><FormattedMessage id={`kodeverk.land.${bosattLand}`} /></td>
           </tr>
           <tr>
             <td>Ufør under botid</td>
             <td><FormattedMessage id={`kodeverk.ja.nei.${uforUnderBotid}`} /></td>
           </tr>
         </tbody></table>
       </Column>
     </Row>;
BostedsInfo.propTypes = {
  norskINorgeMedlem: React.PropTypes.string.isRequired,
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  uforUnderBotid: React.PropTypes.string.isRequired,
};


const Fravik = ({ fravikBosatt,
    trygd3,
    fravikTrygdet3Aar,
    fravik81,
    konvensjon,
    fravik193,
    fravikFlyktning,
    vilkaar843A,
    vilkaar81B,
    overkompUtl,
    ttfmt81,
    ikkeGrunnpensjon }) => <Row>
      <Column size={12}>
        <table className={styles.infotable}><tbody>
          <tr>
            <td>Vilkår §8-4-3A</td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaar843A}`} /></td>
          </tr>
          <tr>
            <td>Vilkaar §8-1B</td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaar81B}`} /></td>
          </tr>
          <tr>
            <td>Overkompensasjon utland</td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${overkompUtl}`} /></td>
          </tr>
          <tr>
            <td>TTFMT81</td>
            <td>{ttfmt81}</td>
          </tr>
          <tr>
            <td> Ikke grunnpensjon</td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${ikkeGrunnpensjon}`} /></td>
          </tr>
          <tr>
            <td>Fravik bosatt</td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikBosatt}`} /></td>
          </tr>
          <tr>
            <td>Trygdet 3 år</td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${trygd3}`} /></td>
          </tr>
          <tr>
            <td>Fravik fra trygdet tre år</td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikTrygdet3Aar}`} /></td>
          </tr>
          <tr>
            <td>Fravik §8-1</td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravik81}`} /></td>
          </tr>
          <tr>
            <td>Konvensjon</td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${konvensjon}`} /></td>
          </tr>
          <tr>
            <td>Fravik etter gammel lov § 19-3</td>
            <td><FormattedMessage id={`Uforepensjon.fravik193.${fravik193}`} /></td>
          </tr>
          <tr>
            <td>Godkjent som flyktning av Utlendingsdirektoratet (UDI)</td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikFlyktning}`} /></td>
          </tr>
        </tbody></table>
      </Column>
    </Row>;

Fravik.propTypes = {

  fravikBosatt: React.PropTypes.string.isRequired,
  trygd3: React.PropTypes.string.isRequired,
  fravikTrygdet3Aar: React.PropTypes.string.isRequired,
  fravik81: React.PropTypes.string.isRequired,
  konvensjon: React.PropTypes.string.isRequired,
  fravik193: React.PropTypes.string.isRequired,
  fravikFlyktning: React.PropTypes.string.isRequired,
  vilkaar843A: React.PropTypes.string.isRequired,
  vilkaar81B: React.PropTypes.string.isRequired,
  overkompUtl: React.PropTypes.string.isRequired,
  ttfmt81: React.PropTypes.number.isRequired,
  ikkeGrunnpensjon: React.PropTypes.string.isRequired,
};


const GrunnblankettUforepensjon = ({
    anntallBarn,
    uforegrad,
    uforetidspunkt,
    yrke,
    pensjonsgivendeInntekt,
    trygdetidFor1967,
    trygdetidEtter1966Aar,
    trygdetidEtter1966Maaneder,
    ttFramtUft,
    attforingUfore,
    yrkesskadetillegg,
    inntektForUforepensjon,
    ...ubehandlede }) => <Row>
      <Column size={6}>
        <div>&nbsp;<h3>Personalia:</h3></div>
        <table className={styles.infotable}><tbody>
          <tr>
            <td>Antall forsørgede barn</td>
            <td>{anntallBarn}</td>
          </tr>
          <tr>
            <td>Uføregrad</td>
            <td>{uforegrad}</td>
          </tr>
          <tr>
            <td>Uføretidspunkt</td>
            <td><DsfDate value={uforetidspunkt}><MonthInYear /></DsfDate></td>
          </tr>
          <tr>
            <td>Yrke</td>
            <td><FormattedMessage id={`kodeverk.yrke.${yrke}`} /></td>
          </tr>
          <tr>
            <td>Pensjonsgivendeinntekt</td>
            <td>{pensjonsgivendeInntekt}</td>
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
            <td>Fremtidig trygdetid</td>
            <td>{ttFramtUft}</td>
          </tr>
          <tr>
            <td>Attføring/Uføre</td>
            <td><FormattedMessage id={`Uforepensjon.attforingUfore.${attforingUfore}`} /></td>
          </tr>
          <tr>
            <td>Yrkesskadetillegg</td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${yrkesskadetillegg}`} /></td>
          </tr>
          <tr>
            <td>Inntekt før uforepensjon</td>
            <td>{inntektForUforepensjon}</td>
          </tr>
        </tbody></table>
        <table className={styles.infotable}>
          <div>&nbsp;<h3>Bosted:</h3></div>
          <BostedsInfo {...ubehandlede} />
          <tbody /></table>
      </Column>
      <Column size={6}>
        <div>&nbsp;<h3>Fravik:</h3></div>
        <Fravik {...ubehandlede} />
        <div>&nbsp;<h3>Vernepliktsår:</h3></div>
        <VernepliktsAar {...ubehandlede} />
        <div>&nbsp;<h3>Ektefelle:</h3></div>
        <EktefelleInfo {...ubehandlede} />
      </Column>
    </Row>;

GrunnblankettUforepensjon.propTypes = {
  anntallBarn: React.PropTypes.number.isRequired,
  uforegrad: React.PropTypes.number.isRequired,
  uforetidspunkt: React.PropTypes.number.isRequired,
  yrke: React.PropTypes.number.isRequired,
  pensjonsgivendeInntekt: React.PropTypes.number.isRequired,
  statsborgerskap: React.PropTypes.number.isRequired,
  trygdetidFor1967: React.PropTypes.number.isRequired,
  trygdetidEtter1966Aar: React.PropTypes.number.isRequired,
  trygdetidEtter1966Maaneder: React.PropTypes.number.isRequired,
  ttFramtUft: React.PropTypes.number.isRequired,
  attforingUfore: React.PropTypes.string.isRequired,
  yrkesskadetillegg: React.PropTypes.string.isRequired,
  inntektForUforepensjon: React.PropTypes.number.isRequired,
};

export default GrunnblankettUforepensjon;
