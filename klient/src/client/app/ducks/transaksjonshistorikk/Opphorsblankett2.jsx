import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';

import styles from './Transaksjonshistorikk.less';

const Opphorsblankett2 = ({
ektefelletilleggStoppes,
opphorskode }) => <Row>
  <Column size={6}>
    <table className={styles.infotable}><tbody>
      <tr><td>Er ektefelletillegget stoppet</td><td>{ektefelletilleggStoppes}</td></tr>
      <tr>
        <td>Opphørskode</td>
        <td>{opphorskode}</td>
      </tr>
    </tbody></table>
  </Column>
</Row>;


Opphorsblankett2.propTypes = {
  ektefelletilleggStoppes: React.PropTypes.string.isRequired,
  opphorskode: React.PropTypes.string.isRequired,
};

export default Opphorsblankett2;
