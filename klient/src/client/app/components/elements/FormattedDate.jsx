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

const dateOnlyProp = { date: React.PropTypes.instanceOf(Date).isRequired };

export const MonthInYear = ({ date }) => <FormattedDate date={date} format="yyyy/mm" />;
MonthInYear.propTypes = dateOnlyProp;

export const ISO8601 = ({ date }) => <FormattedDate date={date} format="yyyy-mm-dd" />;
ISO8601.propTypes = dateOnlyProp;
