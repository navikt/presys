import React from 'react';

const pad = (num, size) => {
  let s = `${num}`;
  while (s.length < size) s = `0${s}`;
  return s;
};

export const formatDate = (date, format) => format
    .replace('yyyy', date.getFullYear())
    .replace('mm', pad(date.getMonth() + 1, 2))
    .replace('dd', pad(date.getDate(), 2))
    ;

const FormattedDate = ({ date, format }) => <span> {formatDate(date, format)}</span>;

FormattedDate.propTypes = {
  date: React.PropTypes.instanceOf(Date),
  format: React.PropTypes.string.isRequired,
};

FormattedDate.defaultProps = {
  date: new Date(),
};

export default FormattedDate;

export const MonthInYear = props => <FormattedDate {...props} format="yyyy/mm" />;
export const ISO8601 = props => <FormattedDate {...props} format="yyyy-mm-dd" />;
