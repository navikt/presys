import React from 'react';

import styles from './row.less';

const Row = ({
  className,
  children,
}) => (
  <div className={`${styles.row} ${className}`}>
    {children}
  </div>
);

Row.propTypes = {
  className: React.PropTypes.string,
  children: React.PropTypes.oneOfType([
    React.PropTypes.arrayOf(React.PropTypes.any),
    React.PropTypes.any,
  ]),
};

Row.defaultProps = {
  className: null,
  children: null,
};

export default Row;
