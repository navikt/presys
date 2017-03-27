import React from 'react';

import VerticalSpacer from 'elements/VerticalSpacer';
import H3 from 'elements/H3';
import Label from 'elements/Label';
import DateLabel from 'elements/DateLabel';

import styles from './tpsInformationView.less';

export const getModel = behandling => ({
  fodselsdato: behandling.tpsData.fodselsdato,
  antallBarn: behandling.tpsData.antallBarn,
});

const TpsInformationView = ({
  model,
}) => (
  <div className={styles.container}>
    <div>
      <H3 textCode="TpsOpplysninger.TpsInformation" className={styles.header} />
      <VerticalSpacer space={2} />
      <Label textCode="TpsOpplysninger.BornDate" className={styles.fieldLabel} />
      <VerticalSpacer space={1} />
      <span className={styles.element}>
        <DateLabel dateString={model.fodselsdato} />
      </span>
      <VerticalSpacer space={3} />
      <Label textCode="TpsOpplysninger.NumberOfChildren" className={styles.fieldLabel} />
      <p className={styles.element}>{model.antallBarn}</p>
    </div>
  </div>
);

TpsInformationView.propTypes = {
  model: React.PropTypes.shape({
    fodselsdato: React.PropTypes.string.isRequired,
    antallBarn: React.PropTypes.number.isRequired,
  }).isRequired,
};

export default TpsInformationView;
