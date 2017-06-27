import React from 'react';
// import { FormattedDate } from 'react-intl';
export const dateYyMm = date => `${date.toString().substring(0, 4)}/${date.toString().substring(4, 6)}`;

const YyyyMmDd = ({ value }) => <span>{dateYyMm(value)}</span>;

/* <FormattedDate
  value={new Date((value / 10000), ((value % 10000) / 100) - 2)}
  month="long"
  year="numeric"
/>*/

YyyyMmDd.propTypes = { value: React.PropTypes.number.isRequired };

export default YyyyMmDd;
