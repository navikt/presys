import React from 'react';

import styles from './maincontent.less';

const MainContent = ({ children, medpadding }) => <div className={medpadding ? styles.container : null}> {children}</div>;

MainContent.propTypes = {
  children: React.PropTypes.arrayOf(React.PropTypes.element).isRequired,
  medpadding: React.PropTypes.bool,
};

MainContent.defaultProps = {
  medpadding: false,
};

export default MainContent;
