import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import InfoTable from 'components/elements/InfoTable';
import { FormattedMessage } from 'react-intl';

const GrunnblankettForsorgertilleggEktefelleBarn = ({
    ektefelleTillegg,
    bosattUtland,
    trygdetidFor1967Ektefelle,
    trygdetidEtter1966EktefelleAar,
    trygdetidEtter1966EktefelleMaaneder,
    antallBarnetillegg,
    fodselsnummerEktefelle,
    navnEktefelle,
    ektefellesInntektOver4G,
         }) => <Row>
           <Column size={6}>
             <InfoTable>
               <tr>
                 <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleBarn.ektefelleTillegg" /></td>
                 <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelleTillegg}`} /></td>
               </tr>
               <tr>
                 <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleBarn.bosattUtland" /></td>
                 <td><FormattedMessage id={`kodeverk.ja.nei.${bosattUtland}`} /></td>
               </tr>
               <tr>
                 <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleBarn.trygdetidFor1967Ektefelle" /></td>
                 <td>{trygdetidFor1967Ektefelle}</td>
               </tr>
               <tr>
                 <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleBarn.trygdetidEtter1966Ektefelle" /></td>
                 <td>{trygdetidEtter1966EktefelleAar}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                   {trygdetidEtter1966EktefelleMaaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
               </tr>
               <tr>
                 <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleBarn.antallBarnetillegg" /></td>
                 <td>{antallBarnetillegg}</td>
               </tr>
               <tr>
                 <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleBarn.fodselsnummerEktefelle" /></td>
                 <td>{fodselsnummerEktefelle}</td>
               </tr>
               <tr>
                 <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleBarn.navnEktefelle" /></td>
                 <td>{navnEktefelle}</td>
               </tr>
               <tr>
                 <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleBarn.ektefellesInntektOver4G" /></td>
                 <td><FormattedMessage id={`kodeverk.ja.nei.${ektefellesInntektOver4G}`} /></td>
               </tr>
             </InfoTable>
           </Column>
         </Row>;
GrunnblankettForsorgertilleggEktefelleBarn.propTypes = {
  ektefelleTillegg: React.PropTypes.string.isRequired,
  bosattUtland: React.PropTypes.string.isRequired,
  trygdetidFor1967Ektefelle: React.PropTypes.number.isRequired,
  trygdetidEtter1966EktefelleAar: React.PropTypes.number.isRequired,
  trygdetidEtter1966EktefelleMaaneder: React.PropTypes.number.isRequired,
  antallBarnetillegg: React.PropTypes.number.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  ektefellesInntektOver4G: React.PropTypes.string.isRequired,
};

export default GrunnblankettForsorgertilleggEktefelleBarn;
