import React from 'react';

import { FormattedMessage } from 'react-intl';

import styles from './tablecolumn.less';

const TableColumn = ({
  value,
  textCode,
  classNameTd,
}) => {
  if (textCode !== null) {
    if (classNameTd === 'hoyreJustertKolonne') {
      return (<th className={`${styles.hoyreJustertKolonne}`}><FormattedMessage id={textCode} /></th>);
    } else if (classNameTd === 'midtJustertKolonne') {
      return (<th className={`${styles.midtJustertKolonne}`}><FormattedMessage id={textCode} /></th>);
    }

    return (<th><FormattedMessage id={textCode} /></th>);
  }

  if (classNameTd === 'hoyreJustertKolonne') {
    return (<td className={`${styles.hoyreJustertKolonne}`}>{value}</td>);
  } else if (classNameTd === 'midtJustertKolonne') {
    return (<td className={`${styles.midtJustertKolonne}`}>{value}</td>);
  }
  return (<td>{value}</td>);
};

TableColumn.propTypes = {
  value: React.PropTypes.oneOfType([
    React.PropTypes.any,
  ]),

  textCode: React.PropTypes.string,
  classNameTd: React.PropTypes.string,
};

TableColumn.defaultProps = {
  value: null,
  textCode: null,
  classNameTd: null,
};

export default TableColumn;
