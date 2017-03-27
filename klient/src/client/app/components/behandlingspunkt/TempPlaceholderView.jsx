import React from 'react';

import styles from './tempPlaceholderView.less';

/* TODO (tor) Denne blir brukt for status godkjent og avslått. Skal fjernast seinare... */
const TempPlaceholderView = ({
  text,
}) => (
  <div className={styles.container}>
    <p className={styles.element}>{text}</p>
  </div>
);

TempPlaceholderView.propTypes = {
  text: React.PropTypes.string.isRequired,
};

export default TempPlaceholderView;
