import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';

import InfoTable from 'components/elements/InfoTable';

const Opphorsblankett2 = ({
ektefelletilleggStoppes,
opphorskode }) => <Row>
  <Column size={6}>
    <InfoTable>
      <tr><td>Er ektefelletillegget stoppet</td><td>{ektefelletilleggStoppes}</td></tr>
      <tr>
        <td>Opphørskode</td>
        <td>{opphorskode}</td>
      </tr>
    </InfoTable>
  </Column>
</Row>;


Opphorsblankett2.propTypes = {
  ektefelletilleggStoppes: React.PropTypes.string.isRequired,
  opphorskode: React.PropTypes.string.isRequired,
};

export default Opphorsblankett2;
