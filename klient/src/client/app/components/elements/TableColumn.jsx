import React from 'react';

import { FormattedMessage } from 'react-intl';

const TableColumn = ({
  value,
  textCode,
}) => {
  if (textCode !== null) {
    return (<th><FormattedMessage id={textCode} /></th>);
  }

  return (<td>{value}</td>);
};

TableColumn.propTypes = {
  value: React.PropTypes.oneOfType([
    React.PropTypes.any,
  ]),

  textCode: React.PropTypes.string,
};

TableColumn.defaultProps = {
  value: null,
  textCode: null,
};

export default TableColumn;
