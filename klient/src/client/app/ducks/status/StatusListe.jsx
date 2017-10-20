import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { Link } from 'react-router';
import styles from './status.less';
import Status from './Status';

const StatusListe = ({ status, params: { valgtstatus }, parentLocation }) => <div> {status.length === 0 ? null : <Row> <Column size={12}>
  <Row>
    {status.length < 2 ? null : <Column>
      <Link activeClassName={styles.activemenu} to={`${parentLocation}/status/s`}>siste</Link> |
      <Link activeClassName={styles.activemenu} to={`${parentLocation}/status/n`}>nest siste</Link>
    </Column>}
  </Row>
  { valgtstatus ? <Row>
    <Column size={12}> <Status {...status.find(s => s.statusKode === valgtstatus.toUpperCase())} /></Column>
  </Row> : <Row>
    <Column size={12}> <Status {...status.find(s => s.statusKode === 'S')} /></Column>
  </Row>}</Column>
</Row>}</div>;

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
