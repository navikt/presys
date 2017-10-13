import React from 'react';

import styles from './maincontent.less';

const MainContent = ({ children }) => <div className={styles.container}> {children}</div>;

MainContent.propTypes = {
  children: React.PropTypes.arrayOf(React.PropTypes.element).isRequired,
};

export default MainContent;
