import React from 'react';
import { FormattedMessage } from 'react-intl';


const Inntekt = ({ personInntektAar, kommune, personInntektType, personInntekt }) => <ul>
  <li><FormattedMessage id="Inntekt.Aar" />:{personInntektAar}</li>
  <li><FormattedMessage id="Kommune" />:{kommune}</li>
  <li><FormattedMessage id="Type" />:{personInntektType}</li>
  <li><FormattedMessage id="Inntekt.Pensjonsgivende" />:{personInntekt}</li>
</ul>;

export const inntektProptype = {
  personInntektAar: React.PropTypes.number.isRequired,
  kommune: React.PropTypes.string.isRequired,
  personInntektType: React.PropTypes.string.isRequired,
  personInntekt: React.PropTypes.number.isRequired,
    rapporteringsDato:React.PropTypes.number.isRequired,
};

Inntekt.propTypes = inntektProptype;

export default Inntekt;
