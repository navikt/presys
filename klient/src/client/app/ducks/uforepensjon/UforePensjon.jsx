import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import InfoTable from 'components/elements/InfoTable';
import { FormattedNumber } from 'react-intl';

const UforePensjon = ({ uforegrad,
               vilkaarPar8Pkt4Ledd3BokstavA,
               vilkaarPar8Pkt1BokstavB,
               grunnpensjon,
               saertillegg,
               aatteFemEnTillegg,
               ektefelletillegg,
               barnetillegg,
               kompensasjonstillegg,
               tilleggspensjon,
               sluttpoengtall,
               overkompensasjonstillegg }) => <Row>
                 <Column size={6}>
                   <div>&nbsp;<h4>Uforepensjon:</h4></div>
                   <InfoTable>
                     <tr>
                       <td>Uforegrad</td>
                       <td>{uforegrad}</td>
                     </tr>
                     <tr>
                       <td>Vilkår §8_4_3A</td>
                       <td>{vilkaarPar8Pkt4Ledd3BokstavA}</td>
                     </tr>
                     <tr>
                       <td>Vilkår §8_1B</td>
                       <td>{vilkaarPar8Pkt1BokstavB}</td>
                     </tr>
                     <tr>
                       <td>Grunnpensjon</td>
                       <td>{grunnpensjon}</td>
                     </tr>
                     <tr>
                       <td>Særtillegg</td>
                       <td>{saertillegg}</td>
                     </tr>
                     <tr>
                       <td>Åtte fem en tillegg</td>
                       <td>{aatteFemEnTillegg}</td>
                     </tr>
                     <tr>
                       <td>Ektefelletillegg</td>
                       <td>{ektefelletillegg}</td>
                     </tr>
                     <tr>
                       <td>Barnetillegg</td>
                       <td>{barnetillegg}</td>
                     </tr>
                     <tr>
                       <td>Kompensasjonstillegg</td>
                       <td>{kompensasjonstillegg}</td>
                     </tr>
                     <tr>
                       <td>Tilleggspensjon</td>
                       <td>{tilleggspensjon}</td>
                     </tr>
                     <tr>
                       <td>Sluttpoengtall</td>
                       <td><FormattedNumber value={sluttpoengtall} /></td>
                     </tr>
                     <tr>
                       <td>Overkompensasjonstillegg</td>
                       <td>{overkompensasjonstillegg}</td>
                     </tr>
                   </InfoTable>
                 </Column>
               </Row>;

UforePensjon.propTypes = {
  uforegrad: React.PropTypes.number.isRequired,
  vilkaarPar8Pkt4Ledd3BokstavA: React.PropTypes.string.isRequired,
  vilkaarPar8Pkt1BokstavB: React.PropTypes.string.isRequired,
  grunnpensjon: React.PropTypes.number.isRequired,
  saertillegg: React.PropTypes.number.isRequired,
  aatteFemEnTillegg: React.PropTypes.number.isRequired,
  ektefelletillegg: React.PropTypes.number.isRequired,
  barnetillegg: React.PropTypes.number.isRequired,
  kompensasjonstillegg: React.PropTypes.number.isRequired,
  tilleggspensjon: React.PropTypes.number.isRequired,
  sluttpoengtall: React.PropTypes.number.isRequired,
  overkompensasjonstillegg: React.PropTypes.number.isRequired,
};

export default UforePensjon;
