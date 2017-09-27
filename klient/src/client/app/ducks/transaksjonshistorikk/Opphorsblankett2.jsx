import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import InfoTable from 'components/elements/InfoTable';

const Opphorsblankett2 = ({
ektefelletilleggStoppes,
opphorskode }) => <Row>
  <Column size={6}>
    <div>&nbsp;<h4>Opphørsblankett 2. Ikke dødsfall:</h4></div>
    <InfoTable>
      <tr>
        <td><FormattedMessage id="Opphorsblankett2.stoppet" /></td>
        <td>{<FormattedMessage id={`kodeverk.ja.nei.${ektefelletilleggStoppes}`} />}</td>
      </tr>
      <tr>
        <td><FormattedMessage id="Opphorsblankett2.opphorskode" /></td>
        <td>{<FormattedMessage id={`kodeverk.opphorsblankett2.${opphorskode}`} /> }</td>
      </tr>
    </InfoTable>
  </Column>
</Row>;


Opphorsblankett2.propTypes = {
  ektefelletilleggStoppes: React.PropTypes.string.isRequired,
  opphorskode: React.PropTypes.string.isRequired,
};

export default Opphorsblankett2;
