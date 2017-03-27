import React from 'react';
import { FormattedMessage } from 'react-intl';

import styles from './button.less';

const Button = ({
  type,
  textCode,
  className,
  onClick,
  tabIndex,
  autoFocus,
}) => (
  <button className={className || styles.button} type={type} onClick={onClick} tabIndex={tabIndex} autoFocus={autoFocus}>
    <FormattedMessage id={textCode} />
  </button>
);

Button.propTypes = {
  type: React.PropTypes.string,
  textCode: React.PropTypes.string.isRequired,
  className: React.PropTypes.string,
  onClick: React.PropTypes.func,
  tabIndex: React.PropTypes.string,
  autoFocus: React.PropTypes.bool,
};

Button.defaultProps = {
  type: 'button',
  className: null,
  onClick: null,
  tabIndex: '0',
  autoFocus: false,
};

export default Button;
