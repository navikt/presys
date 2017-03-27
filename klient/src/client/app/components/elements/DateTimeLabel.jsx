import React from 'react';
import { FormattedDate, FormattedTime } from 'react-intl';

const DateTimeLabel = ({
  dateTimeString,
}) => (
  <div>
    <FormattedDate day="2-digit" month="2-digit" year="numeric" value={new Date(parseInt(dateTimeString, 10))} />
    {' - '}<FormattedTime value={new Date(parseInt(dateTimeString, 10))} />
  </div>
);

DateTimeLabel.propTypes = {
  dateTimeString: React.PropTypes.string.isRequired,
};

export default DateTimeLabel;
