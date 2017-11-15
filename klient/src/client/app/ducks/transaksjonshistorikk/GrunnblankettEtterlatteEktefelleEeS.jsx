import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import InfoTable from 'components/elements/InfoTable';


const AvdodFortsetter = ({ trygdetidTeoretiskAar,
             trygdetidTeoretiskMaaneder,
             trygdetidProrataAar,
             trygdetidProrataMaaneder,
             pensjonEos,
             eosAarProrata2,
             trygdetidProrata2Aar,
             trygdetidProrata2Maaneder,
             trygdetidFaktiskNordiskAar,
             trygdetidFaktiskNordiskMaaneder,
             pensjonsaarFaktiskNordisk,
             inntektsprovetEosPensjon,
             eosOpplysning }) => <Row>
               <Column size={12}>
                 <InfoTable>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.trygdetidTeoretisk" /></td>
                     <td>{trygdetidTeoretiskAar} år og {trygdetidTeoretiskMaaneder} måneder</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.trygdetidProrata" /></td>
                     <td>{trygdetidProrataAar} år og {trygdetidProrataMaaneder} måneder</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.pensjonEos" /></td>
                     <td>{pensjonEos}</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.eosAarProrata2" /></td>
                     <td><ul>{eosAarProrata2.map(e => <li key={e}>{e}</li>)}</ul></td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.trygdetidProrata2" /></td>
                     <td>{trygdetidProrata2Aar} år og {trygdetidProrata2Maaneder} måneder</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.trygdetidFaktiskNordisk" /></td>
                     <td>{trygdetidFaktiskNordiskAar} år og {trygdetidFaktiskNordiskMaaneder} måneder</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.pensjonsaarFaktiskNordisk" /></td>
                     <td>{pensjonsaarFaktiskNordisk}</td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.inntektsprovetEosPensjon" /></td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${inntektsprovetEosPensjon}`} /></td>
                   </tr>
                   <tr>
                     <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.eosOpplysning" /></td>
                     <td><FormattedMessage id={`kodeverk.ja.nei.${eosOpplysning}`} /></td>
                   </tr>
                 </InfoTable>
               </Column>
             </Row>;

AvdodFortsetter.propTypes = {
  trygdetidTeoretiskAar: React.PropTypes.number.isRequired,
  trygdetidTeoretiskMaaneder: React.PropTypes.number.isRequired,
  trygdetidProrataAar: React.PropTypes.number.isRequired,
  trygdetidProrataMaaneder: React.PropTypes.number.isRequired,
  pensjonEos: React.PropTypes.number.isRequired,
  eosAarProrata2: React.PropTypes.arrayOf(React.PropTypes.number).isRequired,
  trygdetidProrata2Aar: React.PropTypes.number.isRequired,
  trygdetidProrata2Maaneder: React.PropTypes.number.isRequired,
  trygdetidFaktiskNordiskAar: React.PropTypes.number.isRequired,
  trygdetidFaktiskNordiskMaaneder: React.PropTypes.number.isRequired,
  pensjonsaarFaktiskNordisk: React.PropTypes.number.isRequired,
  inntektsprovetEosPensjon: React.PropTypes.string.isRequired,
  eosOpplysning: React.PropTypes.string.isRequired,
};

const Avdod = ({ statsborgerskapEktefelle,
     bosattLandEktefelle,
     fravikFlyktningEktefelle,
     fravikPar17Pkt3Ledd4BokstavA,
     fravikPar17Pkt3Ledd4BokstavB,
     overkompensasjonUtlandEktefelle,
     trygdetidFra1937AArEktefelle,
     trygdetidFra1937MaanederEktefelle,
     trygdetidKonvensjonAarEktefelle,
     beregnFolketrygd,
     eosPar3Pkt17BokstavA,
     eosAar,
     eosAarIkkeProrata }) => <Row>
       <Column size={12}>
         <InfoTable>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.statsborgerskapEktefelle" /></td>
             <td><FormattedMessage id={`kodeverk.land.${statsborgerskapEktefelle}`} /></td>
           </tr>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.bosattLandEktefelle" /></td>
             <td><FormattedMessage id={`kodeverk.land.${bosattLandEktefelle}`} /></td>
           </tr>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.fravikFlyktningEktefelle" /></td>
             <td><FormattedMessage id={`kodeverk.ja.nei.${fravikFlyktningEktefelle}`} /></td>
           </tr>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.fravikPar17Pkt3Ledd4BokstavA" /></td>
             <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar17Pkt3Ledd4BokstavA}`} /></td>
           </tr>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.fravikPar17Pkt3Ledd4BokstavB" /></td>
             <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPar17Pkt3Ledd4BokstavB}`} /></td>
           </tr>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.overkompensasjonUtlandEktefelle" /></td>
             <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonUtlandEktefelle}`} /></td>
           </tr>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.trygdetidFra1937Ektefelle" /></td>
             <td>{trygdetidFra1937AArEktefelle} år og {trygdetidFra1937MaanederEktefelle} måneder</td>
           </tr>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.trygdetidKonvensjonAarEktefelle" /></td>
             <td>{trygdetidKonvensjonAarEktefelle} år</td>
           </tr>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.beregnFolketrygd" /></td>
             <td><FormattedMessage id={`kodeverk.ja.nei.${beregnFolketrygd}`} /></td>
           </tr>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.eosPar3Pkt17BokstavA" /></td>
             <td><FormattedMessage id={`kodeverk.ja.nei.${eosPar3Pkt17BokstavA}`} /></td>
           </tr>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.eosAar" /></td>
             <td><ul>{eosAar.map(e => <li key={e}>{e}</li>)}</ul></td>
           </tr>
           <tr>
             <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.eosAarIkkeProrata" /></td>
             <td><ul>{eosAarIkkeProrata.map(e => <li key={e}>{e}</li>)}</ul></td>
           </tr>
         </InfoTable>
       </Column>
     </Row>;

Avdod.propTypes = {
  statsborgerskapEktefelle: React.PropTypes.number.isRequired,
  bosattLandEktefelle: React.PropTypes.number.isRequired,
  fravikFlyktningEktefelle: React.PropTypes.string.isRequired,
  fravikPar17Pkt3Ledd4BokstavA: React.PropTypes.string.isRequired,
  fravikPar17Pkt3Ledd4BokstavB: React.PropTypes.string.isRequired,
  overkompensasjonUtlandEktefelle: React.PropTypes.string.isRequired,
  trygdetidFra1937AArEktefelle: React.PropTypes.number.isRequired,
  trygdetidFra1937MaanederEktefelle: React.PropTypes.number.isRequired,
  trygdetidKonvensjonAarEktefelle: React.PropTypes.number.isRequired,
  beregnFolketrygd: React.PropTypes.string.isRequired,
  eosPar3Pkt17BokstavA: React.PropTypes.string.isRequired,
  eosAar: React.PropTypes.arrayOf(React.PropTypes.number).isRequired,
  eosAarIkkeProrata: React.PropTypes.arrayOf(React.PropTypes.number).isRequired,
};


const GrunnblankettEtterlatteEktefelleEeS = ({
    statsborgerskap,
    bosattLand,
    medlem,
    trygdatidLikPensjonsAar,
    minst20AarBotid,
    konvensjonsLand,
    fravikBosattEos,
    ungUfor,
    erFlyktning,
    trygdetidEndres,
    ...ubehandlede }) => <Row>
      <Column size={12}>
        <div>&nbsp;<h4>Etterlatt ektefelle:</h4></div>
        <InfoTable>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.statsborgerskap" /></td>
            <td><FormattedMessage id={`kodeverk.land.${statsborgerskap}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.bosattLand" /></td>
            <td><FormattedMessage id={`kodeverk.land.${bosattLand}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.medlem" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${medlem}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.trygdatidLikPensjonsAar" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${trygdatidLikPensjonsAar}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.minst20AarBotid" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${minst20AarBotid}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.konvensjonsLand" /></td>
            <td><FormattedMessage id={`kodeverk.land.${konvensjonsLand}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.fravikBosattEos" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${fravikBosattEos}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.ungUfor" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${ungUfor}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.erFlyktning" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${erFlyktning}`} /></td>
          </tr>
          <tr>
            <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEeS.trygdetidEndres" /></td>
            <td><FormattedMessage id={`kodeverk.ja.nei.${trygdetidEndres}`} /></td>
          </tr>

        </InfoTable>
      </Column>
      <Column size={6}>
        <div>&nbsp;<h4>Avdød:</h4></div>
        <Avdod {...ubehandlede} />
      </Column>
      <Column size={6}>
        <div>&nbsp;<h4>Avdød fortsetter:</h4></div>
        <AvdodFortsetter {...ubehandlede} />
      </Column>
    </Row>;


GrunnblankettEtterlatteEktefelleEeS.propTypes = {
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  medlem: React.PropTypes.string.isRequired,
  trygdatidLikPensjonsAar: React.PropTypes.string.isRequired,
  minst20AarBotid: React.PropTypes.string.isRequired,
  konvensjonsLand: React.PropTypes.number.isRequired,
  fravikBosattEos: React.PropTypes.string.isRequired,
  ungUfor: React.PropTypes.string.isRequired,
  erFlyktning: React.PropTypes.string.isRequired,
  trygdetidEndres: React.PropTypes.string.isRequired,
};


export default GrunnblankettEtterlatteEktefelleEeS;
