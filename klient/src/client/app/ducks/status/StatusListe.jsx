import React from 'react';
import PrettyJson from 'components/elements/PrettyJson';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { Link } from 'react-router';
import styles from './status.less';

const StatusListe = ({ status, params: { valgtstatus }, parentLocation }) => <Row>
  <Row>
    <Column>
      <Link activeClassName={styles.activemenu} to={`${parentLocation}/status/s`}>siste</Link> |
      <Link activeClassName={styles.activemenu} to={`${parentLocation}/status/n`}>nest siste</Link>
    </Column>
  </Row>
  {valgtstatus ? <Row>
    <Column> <PrettyJson data={status.find(s => s.statusKode === valgtstatus.toUpperCase())} /></Column>
  </Row> : null}
</Row>;

StatusListe.propTypes = {
  status: React.PropTypes.arrayOf(React.PropTypes.object),
  params: React.PropTypes.shape({
    valgtstatus: React.PropTypes.string,
  }),
  parentLocation: React.PropTypes.string.isRequired,
};

StatusListe.defaultProps = {
  status: [],
  params: {},
};

export default StatusListe;
