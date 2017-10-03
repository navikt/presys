import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import InfoTable from 'components/elements/InfoTable';
import { FormattedNumber, FormattedMessage } from 'react-intl';


const EtterlattBarn = ({ pensjonEtter,
                         gp,
                         tp,
                         st,
                         kt,
                         sptMor,
                         optMor,
                         paaMor,
                         sptFar,
                         optFar,
                         paaFar }) => <Row>
                           <Column size={6}>
                             <div>&nbsp;<h4>Etterlatt barn:</h4></div>
                             <InfoTable>
                               <tr>
                                 <td><FormattedMessage id="EtterlatteBarn.pensjonEtter" /></td>
                                 <td>{pensjonEtter !== ' ' ? <FormattedMessage id={`EtterlatteBarn.pensjonEtter.${pensjonEtter}`} /> : ''}</td>
                               </tr>
                               <tr>
                                 <td><FormattedMessage id="EtterlatteBarn.gp" /></td>
                                 <td>{gp}</td>
                               </tr>
                               <tr>
                                 <td><FormattedMessage id="EtterlatteBarn.tp" /></td>
                                 <td><FormattedNumber value={tp} /></td>
                               </tr>
                               <tr>
                                 <td><FormattedMessage id="EtterlatteBarn.st" /></td>
                                 <td><FormattedNumber value={st} /></td>
                               </tr>
                               <tr>
                                 <td><FormattedMessage id="EtterlatteBarn.kt" /></td>
                                 <td>{kt}</td>
                               </tr>
                               <tr>
                                 <td><FormattedMessage id="EtterlatteBarn.sptMor" /></td>
                                 <td><FormattedNumber value={sptMor} /></td>
                               </tr>
                               <tr>
                                 <td><FormattedMessage id="EtterlatteBarn.optMor" /></td>
                                 <td><FormattedNumber value={optMor} /></td>
                               </tr>
                               <tr>
                                 <td><FormattedMessage id="EtterlatteBarn.paaMor" /></td>
                                 <td>{paaMor}</td>
                               </tr>
                               <tr>
                                 <td><FormattedMessage id="EtterlatteBarn.sptFar" /></td>
                                 <td><FormattedNumber value={sptFar} /></td>
                               </tr>
                               <tr>
                                 <td><FormattedMessage id="EtterlatteBarn.optFar" /></td>
                                 <td><FormattedNumber value={optFar} /></td>
                               </tr>
                               <tr>
                                 <td><FormattedMessage id="EtterlatteBarn.paaFar" /></td>
                                 <td>{paaFar}</td>
                               </tr>
                             </InfoTable>
                           </Column>
                         </Row>;


EtterlattBarn.propTypes = {
  pensjonEtter: React.PropTypes.string.isRequired,
  gp: React.PropTypes.number.isRequired,
  tp: React.PropTypes.number.isRequired,
  st: React.PropTypes.number.isRequired,
  kt: React.PropTypes.number.isRequired,
  sptMor: React.PropTypes.string.isRequired,
  optMor: React.PropTypes.string.isRequired,
  paaMor: React.PropTypes.number.isRequired,
  sptFar: React.PropTypes.string.isRequired,
  optFar: React.PropTypes.string.isRequired,
  paaFar: React.PropTypes.number.isRequired,
};

export default EtterlattBarn;
