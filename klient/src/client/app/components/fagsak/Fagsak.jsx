import React from 'react';

import Button from 'elements/Button';

import styles from './fagsak.less';

const Fagsak = ({
  saksnummer,
  sakstype,
  status,
}) => (
  <div className={styles.container}>
    <div className={styles.saksinfoContainer}>
      <h2 className={styles.sakstype}>
        {sakstype}
      </h2>
      <p className={styles.saksnummer}>
        {saksnummer}        - {status}
      </p>
    </div>
    <div className={styles.buttonContainer}>
      <Button className={styles.button} textCode="Fagsak.FagsakOnHold" onClick={() => 'todo'} tabIndex="0" autoFocus />
      <Button className={styles.button} textCode="Fagsak.CloseFagsak" onClick={() => 'todo'} tabIndex="0" />
    </div>
  </div>
);

Fagsak.propTypes = {
  saksnummer: React.PropTypes.number.isRequired,
  sakstype: React.PropTypes.string.isRequired,
  status: React.PropTypes.string.isRequired,
};

export default Fagsak;
