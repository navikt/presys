import React from 'react';
import { FormattedMessage } from 'react-intl';

import styles from './person.less';

const EtteroppgorAFP = ({
  inntektsAar,
  pensjonsgivendeInntekt,
  inntektForUttakAvAFP,
  registertViaDSFEllerInfotrygdIFU,
  inntektEtterOpphor,
  registertViaDSFEllerInfotrygdIEO,
  inntektIAFPPerioden,
  beregnetEllerRegistrertViaInfotrygd,
  oppgittFramtidigInntekt,
  tidligereInntekt,
  fullAFPiAvregningsperioden,
  faktiskUtbetalt,
  differanseForMyeUtbetalt,
  differanseForLiteUtbetalt,
  hasLargeFont,
}) => (
  <div>
    <div className={styles.infoPlaceholder}>
      <h2>
        {inntektsAar}
        {pensjonsgivendeInntekt}
        {inntektForUttakAvAFP}
        {registertViaDSFEllerInfotrygdIFU}
        {inntektEtterOpphor}
        {registertViaDSFEllerInfotrygdIEO}
        {inntektIAFPPerioden}
        {beregnetEllerRegistrertViaInfotrygd}
        {oppgittFramtidigInntekt}
        {tidligereInntekt}
        {fullAFPiAvregningsperioden}
        {faktiskUtbetalt}
        {differanseForMyeUtbetalt}
        {differanseForLiteUtbetalt}
      </h2>
  </div>
);

EtteroppgorAFP.propTypes = {
    inntektsAar: React.PropTypes.number.isRequired,
    pensjonsgivendeInntekt: React.PropTypes.number.isRequired,
    inntektForUttakAvAFP: React.PropTypes.number.isRequired,
    registertViaDSFEllerInfotrygdIFU: React.PropTypes.string.isRequired,
    inntektEtterOpphor: React.PropTypes.number.isRequired,
    registertViaDSFEllerInfotrygdIEO: React.PropTypes.string.isRequired,
    inntektIAFPPerioden: React.PropTypes.number.isRequired,
    beregnetEllerRegistrertViaInfotrygd: React.PropTypes.string.isRequired,
    oppgittFramtidigInntekt: React.PropTypes.number.isRequired,
    tidligereInntekt: React.PropTypes.number.isRequired,
    fullAFPiAvregningsperioden: React.PropTypes.number.isRequired,
    faktiskUtbetalt: React.PropTypes.number.isRequired,
    differanseForMyeUtbetalt: React.PropTypes.number.isRequired,
    differanseForLiteUtbetalt: React.PropTypes.number.isRequired,
};


export default EtteroppgorAFP;
