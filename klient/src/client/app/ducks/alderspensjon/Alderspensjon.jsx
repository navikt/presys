import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedNumber } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

const Alderspensjon = ({ grunnpensjon,
            saertillegg,
            tilleggspensjon,
            sluttpoengtall,
            overkompensasjonPoengtall,
            poengaar }) => <Row>
              <Column size={6}>
                <div>&nbsp;<h4>Alderspensjon:</h4></div>
                <InfoTable>
                  <tr>
                    <td>Grunnpensjon</td>
                    <td>{grunnpensjon}</td>
                  </tr>
                  <tr>
                    <td>Særtillegg</td>
                    <td>{saertillegg}</td>
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
                    <td>Overkompensasjonspoengtall</td>
                    <td><FormattedNumber value={overkompensasjonPoengtall} /></td>
                  </tr>
                  <tr>
                    <td>Poengår</td>
                    <td>{poengaar}</td>
                  </tr>
                </InfoTable>
              </Column>
            </Row>;

Alderspensjon.propTypes = {
  grunnpensjon: React.PropTypes.number.isRequired,
  saertillegg: React.PropTypes.number.isRequired,
  tilleggspensjon: React.PropTypes.number.isRequired,
  sluttpoengtall: React.PropTypes.string.isRequired,
  overkompensasjonPoengtall: React.PropTypes.string.isRequired,
  poengaar: React.PropTypes.number.isRequired,
};

export default Alderspensjon;
