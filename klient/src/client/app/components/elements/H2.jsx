import React from 'react';
import { FormattedMessage } from 'react-intl';

const H2 = ({
  textCode,
  className,
}) => (
  <h2 className={className}>
    <FormattedMessage id={textCode} />
  </h2>
);

H2.propTypes = {
  textCode: React.PropTypes.string.isRequired,
  className: React.PropTypes.string,
};

H2.defaultProps = {
  className: null,
};

export default H2;
