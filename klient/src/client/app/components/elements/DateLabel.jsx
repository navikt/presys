import React from 'react';
import { FormattedDate } from 'react-intl';

const DateLabel = ({
  dateString,
}) => (
  <FormattedDate day="2-digit" month="2-digit" year="numeric" value={new Date(parseInt(dateString, 10))} />
);

DateLabel.propTypes = {
  dateString: React.PropTypes.string.isRequired,
};

export default DateLabel;
