import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import InfoTable from 'components/elements/InfoTable';

const StatusSegment = ({ virkDato,
              statusKode,
              statusKodeHistorie,
              pensjonsType1,
              pensjonsType2,
              pensjonsType3,
              sivilstand,
              trygdetidFoer1967,
              trygdetidEtter1966,
              trygdetidFramTil,
              trygdetid1967Til1970,
              trygdetidAnvendt,
              foersteGangReg,
              sumYtelse,
              antallBarn,
              dodsddato,
              dodAvYrkesskade,
              vilkar843A,
              trygdetidGaranti,
              grunnbelopsDato,
              poengtilleggsDato,
              poengtilleggsKode,
              pensjonsrettFoer91,
              trygdetid1666,
              garantertTilleggsPensjonKode,
              gammelSammenstotsRegel,
              ektefelleInntektOver2g,
              pensjonFor9802,
              redGrunnPensjon321,
              grunnPensjonReduksjonsKode,
              friinntektDato }) => <Row>
                 <Column size={6}>
                   <InfoTable>
                     <tr>
                       <td>virkDato</td>
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
                       <td>{sluttpoengtall}</td>
                     </tr>
                     <tr>
                       <td>Overkompensasjonstillegg</td>
                       <td>{overkompensasjonstillegg}</td>
                     </tr>
                   </InfoTable>
                 </Column>
               </Row>;

StatusSegment.propTypes = {
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

export default StatusSegment;
