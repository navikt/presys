import React from 'react';

const Form = ({
  className,
  submitCallback,
  children,
}) => (
  <form className={className} onSubmit={submitCallback}>
    {children}
  </form>
);

Form.propTypes = {
  className: React.PropTypes.string,
  submitCallback: React.PropTypes.func.isRequired,
  children: React.PropTypes.oneOfType([
    React.PropTypes.arrayOf(React.PropTypes.element),
    React.PropTypes.element,
  ]).isRequired,
};

Form.defaultProps = {
  className: null,
};

export default Form;
