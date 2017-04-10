import React from 'react';
import { FormattedMessage } from 'react-intl';

import urlMann from 'images/mann.svg';
import urlKvinne from 'images/kvinne.svg';
import urlGift from 'images/pil_opp.svg';
import urlEnslig from 'images/pil_ned.svg';
import urlPartner from 'images/saksbehandler.svg';
import urlSamboer from 'images/innvilget.svg';

import styles from './person.less';

const Person = ({
  navn,
  alder,
  personnummer,
  erKvinne,
  erGift,
  erEnslig,
  erPartner,
  erSamboer,
  hasLargeFont,
}) => (
  <div>
    <img className={styles.icon} src={erKvinne ? urlKvinne : urlMann} alt={<FormattedMessage id="Person.ImageText" />} />
    <div className={styles.infoPlaceholder}>
      <h2 className={hasLargeFont ? styles.navnLarge : styles.navn}>
        {navn} {'('}{alder} <FormattedMessage id="Person.Age" />{')'}
      </h2>
      <p className={hasLargeFont ? styles.personnummerLarge : styles.personnummer}>
        {personnummer}
      </p>
    </div>
    {erGift ? <img className={styles.icon} src={urlGift} alt={<FormattedMessage id="Person.ImageText" Gift />} /> : null}

    {erPartner ? <img className={styles.icon} src={urlPartner} alt={<FormattedMessage id="Person.ImageText" Homo />} /> : null}

    {erSamboer ? <img className={styles.icon} src={urlSamboer} alt={<FormattedMessage id="Person.ImageText" Samboer />} /> : null}

    {erEnslig ? <img className={styles.icon} src={urlEnslig} alt={<FormattedMessage id="Person.ImageText" Enslig />} /> : null}
  </div>
);

Person.propTypes = {
  navn: React.PropTypes.string.isRequired,
  alder: React.PropTypes.number.isRequired,
  personnummer: React.PropTypes.string.isRequired,
  erKvinne: React.PropTypes.bool.isRequired,
  erGift: React.PropTypes.bool,
  erEnslig: React.PropTypes.bool,
  erPartner: React.PropTypes.bool,
  erSamboer: React.PropTypes.bool,
  hasLargeFont: React.PropTypes.bool.isRequired,
};

Person.defaultProps = {
  erEnslig: false,
  erGift: false,
  erSamboer: false,
  erPartner: false,
};


export default Person;
