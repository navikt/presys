import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

const EktefelleInfo = ({ ektefelletillegg,
               fodselsnummerEktefelle,
               navnEktefelle,
               trygdetidFor1967Ektefelle,
               trygdetidEtter1966AarEktefelle,
               trygdetidEtter1966MaanederEktefelle,
               inntektMinst4G }) => <Row>
                 <Column size={12}>
                   <InfoTable>
                     <tr>
                       <td>Ektefelletillegg</td>
                       <td><input type="checkbox" checked={ektefelletillegg !== ' '} /></td>
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
                       <td>Trygdetid for ektefelle før 1967 år</td>
                       <td>{trygdetidFor1967Ektefelle} år</td>
                     </tr>
                     <tr>
                       <td>Trygdetid for ektefelle etter 1966</td>
                       <td>{trygdetidEtter1966AarEktefelle} år og {trygdetidEtter1966MaanederEktefelle} mnd</td>
                     </tr>

                     <tr>
                       <td>Ektefelles inntekt større enn 4 G</td>
                       <td><FormattedMessage id={`kodeverk.ja.nei.${inntektMinst4G}`} /></td>
                     </tr>

                   </InfoTable>
                 </Column>
               </Row>;

EktefelleInfo.propTypes = {
  ektefelletillegg: React.PropTypes.string.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  trygdetidFor1967Ektefelle: React.PropTypes.number.isRequired,
  trygdetidEtter1966AarEktefelle: React.PropTypes.number.isRequired,
  trygdetidEtter1966MaanederEktefelle: React.PropTypes.number.isRequired,
  inntektMinst4G: React.PropTypes.string.isRequired,
};

export default EktefelleInfo;
