import React from 'react';

import styles from './fieldError.less';

const FieldError = ({
  errorMessage,
  showError,
  classNameLabel,
  children,
}) => (
  <div className={showError && errorMessage ? styles.container : null}>
    {children}
    <span className={`${styles.error_message} ${classNameLabel}`}>{errorMessage}</span>
  </div>
);

FieldError.propTypes = {
  errorMessage: React.PropTypes.element,
  showError: React.PropTypes.bool.isRequired,
  classNameLabel: React.PropTypes.string,
  children: React.PropTypes.oneOfType([
    React.PropTypes.arrayOf(React.PropTypes.any),
    React.PropTypes.any,
  ]).isRequired,
};

FieldError.defaultProps = {
  errorMessage: null,
  classNameLabel: '',
};

export default FieldError;
