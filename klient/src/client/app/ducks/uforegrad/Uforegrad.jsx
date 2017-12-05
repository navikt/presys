import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';

import InfoTable from 'components/elements/InfoTable';

const Uforegrad = ({ uforegradDato,
             uforegradOvrige,
             yngsteBarnFoerGrad,
             virkningsdatoUforegrad }) => <Row>
             <div>&nbsp;<h4>Uføregrad:</h4></div>
               <Column size={6}>
                 <InfoTable>
                   <tr>
                     <td>Uføregradsdato</td>
                     <td><DsfDate value={uforegradDato}><ISO8601 /></DsfDate></td>
                   </tr>
                   <tr>
                     <td>Yngste barns fødselsår</td>
                     <td>{yngsteBarnFoerGrad}</td>
                   </tr>
                   <tr>
                     <td>Virkningsdato uføregrad</td>
                     <td><DsfDate value={virkningsdatoUforegrad}><ISO8601 /></DsfDate></td>
                   </tr>
                 </InfoTable>
               </Column>
             </Row>;

Uforegrad.propTypes = {
    uforegradDato: React.PropTypes.number.isRequired,
    uforegradOvrige: React.PropTypes.number.isRequired,
    yngsteBarnFoerGrad: React.PropTypes.number.isRequired,
    virkningsdatoUforegrad: React.PropTypes.number.isRequired,
};

export default Uforegrad;
