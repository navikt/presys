import React from 'react';
import { FormattedMessage } from 'react-intl';

import styles from './radioButton.less';

const RadioButton = ({
  id,
  name,
  value,
  checked,
  textCode,
  onChange,
  onBlur,
  inputClassName,
  labelClassName,
}) => (
  <div className={styles.navInput}>
    <input
      id={id}
      className={`${styles.navRadioknapp} ${inputClassName}`}
      type="radio"
      name={name}
      value={value}
      checked={checked}
      onChange={onChange}
      onBlur={onBlur}
    />
    <label htmlFor={id} className={labelClassName}>
      <FormattedMessage id={textCode} />
    </label>
  </div>
);

RadioButton.propTypes = {
  id: React.PropTypes.string.isRequired,
  name: React.PropTypes.string.isRequired,
  value: React.PropTypes.string.isRequired,
  checked: React.PropTypes.bool,
  textCode: React.PropTypes.string.isRequired,
  onChange: React.PropTypes.func.isRequired,
  onBlur: React.PropTypes.func.isRequired,
  inputClassName: React.PropTypes.string,
  labelClassName: React.PropTypes.string,
};

RadioButton.defaultProps = {
  inputClassName: '',
  labelClassName: '',
  checked: false,
};

export default RadioButton;
