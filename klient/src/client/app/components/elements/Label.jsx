import React from 'react';
import { FormattedMessage } from 'react-intl';

/* TODO (tor) bytt ut div med label */
const Label = ({
  textCode,
  className,
}) => (
  <div className={className}>
    <FormattedMessage id={textCode} />
  </div>
);

Label.propTypes = {
  textCode: React.PropTypes.string.isRequired,
  className: React.PropTypes.string,
};

Label.defaultProps = {
  className: null,
};

export default Label;
