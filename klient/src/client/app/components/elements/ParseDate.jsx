import React from 'react';

export const toDate = (value, format) => {
  const date = new Date();
  const stringValue = value.toString();
  if (format === 'yyyymmdd') {
    const day = parseInt(stringValue.substring(6, 8), 10);
    date.setFullYear(stringValue.substring(0, 4), stringValue.substring(4, 6) - 1, day + (day === 0 ? 1 : 0));
    return date;
  }
  return new Date(value);
};

const ParseDate = ({ value, format, children }) => <span> {React.Children.map(children,
                                                         child => React.cloneElement(child, {
                                                           date: toDate(value, format),
                                                         }),
                                                        )}</span>;

ParseDate.propTypes = {
  value: React.PropTypes.number.isRequired,
  format: React.PropTypes.string.isRequired,
  children: React.PropTypes.element.isRequired,
};

export default ParseDate;


export const DsfDate = props => <ParseDate {...props} format="yyyymmdd" />;

