import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { MonthInYear, ISO8601 } from 'components/elements/FormattedDate';


import styles from './Transaksjonshistorikk.less';


const TransInfo = ({ virkningsdato, registreringsdato, sivilstand, spraak, terminalId, trygdekontornummer }) => <Row>
  <Column size={4}>
    <table className={styles.infotable}><tbody>
      <tr>
        <td>Virkningsdato:</td>
        <td><DsfDate value={virkningsdato}><MonthInYear /></DsfDate></td>
      </tr>
      <tr>
        <td>Registrert dato:</td>
        <td><DsfDate value={registreringsdato}><ISO8601 /></DsfDate></td>
      </tr>
    </tbody>
    </table>
  </Column>
  <Column size={4}>
    <table className={styles.infotable}><tbody>
      <tr>
        <td>Tknr:</td>
        <td>{trygdekontornummer}</td>
      </tr>
      <tr>
        <td>TerminalId:</td>
        <td>{terminalId}</td>
      </tr>
    </tbody>
    </table>
  </Column>
  <Column size={4}>
    <table className={styles.infotable}><tbody>
      <tr>
        <td>Sivilstand:</td>
        <td>{sivilstand}</td>
      </tr>
      <tr>
        <td>Språk:</td>
        <td>{spraak}</td>
      </tr>
    </tbody>
    </table>
  </Column>
</Row>
;

TransInfo.propTypes = {
  virkningsdato: React.PropTypes.number.isRequired,
  registreringsdato: React.PropTypes.number.isRequired,
  sivilstand: React.PropTypes.string.isRequired,
  spraak: React.PropTypes.string.isRequired,
  terminalId: React.PropTypes.string.isRequired,
  trygdekontornummer: React.PropTypes.number.isRequired,
};


export default TransInfo;

