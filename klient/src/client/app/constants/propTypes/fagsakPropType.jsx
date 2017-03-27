import React from 'react';

const fagsakPropType = React.PropTypes.shape({
  saksnummer: React.PropTypes.number.isRequired,
  sakstype: React.PropTypes.shape({
    kode: React.PropTypes.string.isRequired,
    navn: React.PropTypes.string.isRequired,
  }).isRequired,
  status: React.PropTypes.shape({
    kode: React.PropTypes.string.isRequired,
    navn: React.PropTypes.string.isRequired,
  }).isRequired,
  barnFoedt: React.PropTypes.string,
  person: React.PropTypes.shape({
    navn: React.PropTypes.string.isRequired,
    alder: React.PropTypes.number.isRequired,
    personnummer: React.PropTypes.string.isRequired,
    erKvinne: React.PropTypes.bool.isRequired,
  }),
});

export default fagsakPropType;
