import React from 'react';
import { FormattedMessage } from 'react-intl';

const Kodeverk = ({ kodeverk, kode }) => <FormattedMessage id={`kodeverk.${kodeverk}.${kode}`} />;

Kodeverk.propTypes = {
  kodeverk: React.PropTypes.string.isRequired,
  kode: React.PropTypes.string.isRequired,
};

export const OpphorsKode = ({ kode }) => <Kodeverk kodeverk="opphorsdato" kode={kode} />;

OpphorsKode.propTypes = {
  kode: React.PropTypes.string.isRequired,
};

export default Kodeverk;
