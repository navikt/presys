import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

const Tilknytning = ({ fnr,
           tilknytningskode,
           forsorgerTilleggFor1991 }) => <Row>
             <Column size={6}>
               <InfoTable>
                 <div>&nbsp;<h4>Tilknytning:</h4></div>
                 <tr>
                   <td>Fødselsnummer</td>
                   <td>{fnr}</td>
                 </tr>
                 <tr>
                   <td>Tilknytningskode</td>
                   <td>{tilknytningskode !== null ?
                     <FormattedMessage id={`Tilknytning.tilknytningskode.${tilknytningskode}`} /> :
                   'Forsørgingstillegg regnes etter reglene før 1.5.1991'}</td>
                 </tr>
                 <tr>
                   <td>Forsørgertillegg før 1991</td>
                   <td>{forsorgerTilleggFor1991 !== null ?
                     <FormattedMessage id={`Tilknytning.forsorgertilleggFor1999.${forsorgerTilleggFor1991}`} /> :
                   'Forsørgingstillegg regnes etter reglene før 1.5.1991'}</td>
                 </tr>
               </InfoTable>
             </Column>
           </Row>;

Tilknytning.propTypes = {
  fnr: React.PropTypes.string.isRequired,
  tilknytningskode: React.PropTypes.string.isRequired,
  forsorgerTilleggFor1991: React.PropTypes.string.isRequired,
};

export default Tilknytning;
