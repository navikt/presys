import React from 'react';
import { FormattedDate } from 'react-intl';

const YyyyMmDd = ({ value }) => <FormattedDate
  value={new Date(value / 10000, ((value % 10000) / 100) - 1)}
  month="long"
  year="numeric"
/>;

YyyyMmDd.propTypes = { value: React.PropTypes.number.isRequired };

export default YyyyMmDd;
