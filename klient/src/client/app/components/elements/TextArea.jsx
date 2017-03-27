import React from 'react';
import { FormattedMessage } from 'react-intl';

const TextArea = ({
  id,
  labelClassName,
  labelTextCode,
  textAreaClassName,
  rows,
  value,
  onChange,
  onBlur,
}) => (
  <div className="nav-input">
    <label className={labelClassName} htmlFor={id}>
      <FormattedMessage id={labelTextCode} />
    </label>
    <textarea id={id} className={textAreaClassName} rows={rows} value={value} onChange={onChange} onBlur={onBlur} />
  </div>
);

TextArea.propTypes = {
  id: React.PropTypes.string,
  labelClassName: React.PropTypes.string,
  labelTextCode: React.PropTypes.string.isRequired,
  textAreaClassName: React.PropTypes.string,
  rows: React.PropTypes.number.isRequired,
  value: React.PropTypes.string.isRequired,
  onChange: React.PropTypes.func.isRequired,
  onBlur: React.PropTypes.func.isRequired,
};

TextArea.defaultProps = {
  id: null,
  labelClassName: null,
  textAreaClassName: null,
};

export default TextArea;
