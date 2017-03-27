import React from 'react';
import { FormattedMessage } from 'react-intl';

import urlMann from 'images/mann.svg';
import urlKvinne from 'images/kvinne.svg';

import styles from './person.less';

const Person = ({
  navn,
  alder,
  personnummer,
  erKvinne,
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
  </div>
);

Person.propTypes = {
  navn: React.PropTypes.string.isRequired,
  alder: React.PropTypes.number.isRequired,
  personnummer: React.PropTypes.string.isRequired,
  erKvinne: React.PropTypes.bool.isRequired,
  hasLargeFont: React.PropTypes.bool.isRequired,
};


export default Person;
