import React from 'react';

import styles from './column.less';

/* size: 12 tar hele bredden i raden. 6 tar halve, osv. */
const Column = ({
  size,
  className,
  children,
}) => {
  const style = styles[`column${size}`];
  return (
    <div className={`${style} ${className}`}>
      {children}
    </div>
  );
};

Column.propTypes = {
  size: React.PropTypes.number,
  className: React.PropTypes.string,
  children: React.PropTypes.oneOfType([
    React.PropTypes.arrayOf(React.PropTypes.any),
    React.PropTypes.any,
  ]),
};

Column.defaultProps = {
  size: 6,
  className: '',
  children: null,
};

export default Column;
