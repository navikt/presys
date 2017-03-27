import React from 'react';
import { FormattedMessage } from 'react-intl';

const DateField = ({
  id,
  labelClassName,
  labelTextCode,
  dateFieldClassName,
  value,
  onChange,
  autoFocus,
}) => {
  const stringToDateFormatter = (dateString) => {
    const d = new Date(parseInt(dateString, 10));
    let month = String(d.getMonth() + 1);
    let day = String(d.getDate());
    const year = String(d.getFullYear());

    if (month.length < 2) {
      month = `0${month}`;
    }
    if (day.length < 2) {
      day = `0${day}`;
    }
    return `${year}-${month}-${day}`;
  };

  const dateToStringFormatter = event => new Date(event.target.value).getTime().toString();

  return (
    <div>
      <label className={labelClassName} htmlFor={id}>
        <FormattedMessage id={labelTextCode} />
      </label>
      <input
        id={id}
        className={dateFieldClassName}
        type="date"
        value={stringToDateFormatter(value)}
        onChange={e => onChange(e, dateToStringFormatter(e))}
        autoFocus={autoFocus}
      />
    </div>
  );
};

DateField.propTypes = {
  id: React.PropTypes.string,
  labelClassName: React.PropTypes.string,
  labelTextCode: React.PropTypes.string.isRequired,
  dateFieldClassName: React.PropTypes.string,
  value: React.PropTypes.string,
  onChange: React.PropTypes.func,
  autoFocus: React.PropTypes.bool,
};

DateField.defaultProps = {
  id: null,
  labelClassName: null,
  dateFieldClassName: null,
  value: null,
  onChange: null,
  autoFocus: false,
};

export default DateField;
