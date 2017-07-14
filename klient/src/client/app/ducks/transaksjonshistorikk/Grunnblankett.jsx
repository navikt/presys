import React from 'react';
import GrunnblankettF7 from './GrunnblankettF7';

const Grunnblankett = ({ type, ...rest }) => {
  if (type === 'F7') {
    return <GrunnblankettF7 {...rest} />;
  }
  return null;
};

Grunnblankett.propTypes = {
  type: React.PropTypes.string.isRequired,
};


export default Grunnblankett;
