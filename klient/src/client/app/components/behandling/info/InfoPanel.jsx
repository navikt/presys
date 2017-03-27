import React from 'react';
import { Link } from 'react-router';
import { FormattedMessage } from 'react-intl';

import styles from './infoPanel.less';

const InfoPanel = ({
  location,
  children,
}) => {
  const path = location.pathname;
  const index = path.lastIndexOf('/');
  const urlPath = path.substring(0, index);

  return (
    <div className={styles.container}>
      <div className={styles.header}>
        <Link className={styles.link} to={`${urlPath}/historikk`}><FormattedMessage id="InfoHeader.History" /></Link>
        <Link className={styles.link} to={`${urlPath}/meldinger`}><FormattedMessage id="InfoHeader.Messages" /></Link>
        <Link className={styles.link} to={`${urlPath}/dokumenter`}><FormattedMessage id="InfoHeader.Documents" /></Link>
      </div>
      {children}
    </div>
  );
};

InfoPanel.propTypes = {
  location: React.PropTypes.shape({
    pathname: React.PropTypes.string.isRequired,
  }).isRequired,
  children: React.PropTypes.element.isRequired,
};

export default InfoPanel;
