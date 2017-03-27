import React from 'react';
import { FormattedMessage } from 'react-intl';

const H3 = ({
  textCode,
  className,
}) => (
  <h2 className={className}>
    <FormattedMessage id={textCode} />
  </h2>
);

H3.propTypes = {
  textCode: React.PropTypes.string.isRequired,
  className: React.PropTypes.string,
};

H3.defaultProps = {
  className: null,
};

export default H3;
