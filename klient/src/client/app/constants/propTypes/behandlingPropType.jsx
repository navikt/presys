import React from 'react';

const behandlingPropType = React.PropTypes.shape({
  id: React.PropTypes.number.isRequired,
  type: React.PropTypes.shape({
    kode: React.PropTypes.string.isRequired,
    navn: React.PropTypes.string.isRequired,
  }).isRequired,
  status: React.PropTypes.shape({
    kode: React.PropTypes.string.isRequired,
    navn: React.PropTypes.string.isRequired,
  }).isRequired,
  opprettet: React.PropTypes.string.isRequired,
  endret: React.PropTypes.string,
  avsluttet: React.PropTypes.string,
  soknad: React.PropTypes.shape({
    utstedtDato: React.PropTypes.string,
    termindato: React.PropTypes.string,
    antallBarn: React.PropTypes.number,
    fodselsdato: React.PropTypes.string,
  }),
  tpsData: React.PropTypes.shape({
    fodselsdato: React.PropTypes.string,
    antallBarn: React.PropTypes.number,
  }),
  behandlingResultat: React.PropTypes.shape({
    beregnetTilkjentYtelse: React.PropTypes.number,
    satsVerdi: React.PropTypes.number,
    antallBarn: React.PropTypes.number,
  }),
  behandlingspunkter: React.PropTypes.arrayOf(React.PropTypes.shape({
    navn: React.PropTypes.string.isRequired,
    merknad: React.PropTypes.string.isRequired,
    typeKode: React.PropTypes.string.isRequired,
    statusKode: React.PropTypes.string,
    aksjonspunkter: React.PropTypes.arrayOf(React.PropTypes.shape({
      id: React.PropTypes.number.isRequired,
      kode: React.PropTypes.string.isRequired,
      navn: React.PropTypes.string.isRequired,
      status: React.PropTypes.shape({
        kode: React.PropTypes.string.isRequired,
        navn: React.PropTypes.string.isRequired,
      }).isRequired,
    })),
  })),
});

export default behandlingPropType;
