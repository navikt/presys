import React from 'react';
import { FormattedMessage } from 'react-intl';

const TextField = ({
  id,
  labelClassName,
  labelTextCode,
  textFieldClassName,
  value,
  onChange,
  onKeyDown,
  autoFocus,
  onBlur,
}) => (
  <span>
    {id &&
      <label className={labelClassName} htmlFor={id}>
        <FormattedMessage id={labelTextCode} />
      </label>
    }
    <input
      id={id}
      className={textFieldClassName}
      type="text"
      value={value}
      onChange={onChange}
      onKeyDown={onKeyDown}
      autoFocus={autoFocus}
      onBlur={onBlur}
    />
  </span>
);

TextField.propTypes = {
  id: React.PropTypes.string,
  labelClassName: React.PropTypes.string,
  labelTextCode: React.PropTypes.string.isRequired,
  textFieldClassName: React.PropTypes.string,
  value: React.PropTypes.string.isRequired,
  onChange: React.PropTypes.func.isRequired,
  onKeyDown: React.PropTypes.func,
  autoFocus: React.PropTypes.bool,
  onBlur: React.PropTypes.func,
};

TextField.defaultProps = {
  id: null,
  labelClassName: null,
  textFieldClassName: null,
  onKeyDown: null,
  autoFocus: false,
  onBlur: null,
};

export default TextField;
