import React from 'react';

import 'styles/modigDesign.less';

import styles from './home.less';

const Home = ({
  errorMessage,
  children,
}) => (
  <div className={errorMessage ? styles.contentWithMessagePanel : styles.content}>
    {children}
  </div>
);

Home.propTypes = {
  errorMessage: React.PropTypes.string,
  children: React.PropTypes.element,
};

Home.defaultProps = {
  errorMessage: null,
  children: [],
};

export default Home;
