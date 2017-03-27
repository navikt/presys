import React from 'react';

const behandlingspunktPropType = React.PropTypes.shape({
  navn: React.PropTypes.string.isRequired,
  merknad: React.PropTypes.string.isRequired,
  status: React.PropTypes.string.isRequired,
  aksjonspunkterData: React.PropTypes.oneOfType([
    React.PropTypes.arrayOf(React.PropTypes.shape({
      id: React.PropTypes.number,
      readOnly: React.PropTypes.bool.isRequired,
      code: React.PropTypes.string.isRequired,
      form: React.PropTypes.func.isRequired,
      model: React.PropTypes.shape(),
      rules: React.PropTypes.arrayOf(React.PropTypes.func),
    })),
    React.PropTypes.shape({
      id: React.PropTypes.number,
      readOnly: React.PropTypes.bool.isRequired,
      code: React.PropTypes.string.isRequired,
      form: React.PropTypes.func.isRequired,
      model: React.PropTypes.shape(),
      rules: React.PropTypes.arrayOf(React.PropTypes.func),
    }),
  ]).isRequired,
});

export default behandlingspunktPropType;
