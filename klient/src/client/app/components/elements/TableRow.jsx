import React from 'react';

import styles from './tableRow.less';

const TableRow = ({
  id,
  model,
  isHeader,
  onMouseDown,
  onKeyDown,
  tabIndex,
  children,
}) => {
  const keyDownHandler = (e) => {
    if (e.key === 'ArrowDown') {
      if (e.target.nextSibling) {
        e.target.nextSibling.focus();
        e.preventDefault();
      }
    } else if (e.key === 'ArrowUp') {
      if (e.target.previousSibling) {
        e.target.previousSibling.focus();
        e.preventDefault();
      }
    } else if (onKeyDown && (e.key === 'Enter' || e.key === ' ')) {
      onKeyDown(e, id, model);
      e.preventDefault();
    }
  };

  return (
    <tr
      className={isHeader ? styles.rowHeader : styles.rowContent}
      onMouseDown={e => onMouseDown && onMouseDown(e, id, model)}
      onKeyDown={e => keyDownHandler(e)}
      tabIndex={tabIndex}
    >
      {children}
    </tr>
  );
};

TableRow.propTypes = {
  id: React.PropTypes.number,
  model: React.PropTypes.shape(),
  isHeader: React.PropTypes.bool,
  onMouseDown: React.PropTypes.func,
  onKeyDown: React.PropTypes.func,
  tabIndex: React.PropTypes.string,
  children: React.PropTypes.arrayOf(React.PropTypes.element.isRequired).isRequired,
};

TableRow.defaultProps = {
  id: 0,
  model: null,
  isHeader: false,
  onMouseDown: null,
  onKeyDown: null,
  tabIndex: null,
};

export default TableRow;
