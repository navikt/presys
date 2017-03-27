import React from 'react';

import H3 from 'elements/H3';
import Row from 'elements/Row';
import Column from 'elements/Column';
import Label from 'elements/Label';
import VerticalSpacer from 'elements/VerticalSpacer';

import styles from './beregningsgrunnlagView.less';

export const getModel = behandling => ({
  beregnetTilkjentYtelse: behandling.behandlingResultat.beregnetTilkjentYtelse,
  satsVerdi: behandling.behandlingResultat.satsVerdi,
  antallBarn: behandling.behandlingResultat.antallBarn,
});

const BeregningsgrunnlagView = ({
  model,
}) => (
  <div className={styles.container}>
    <H3 textCode="Beregningsgrunnlag.Beregningsgrunnlag" className={styles.header} />
    <VerticalSpacer space={3} />
    <Label textCode="Beregningsgrunnlag.BeregnetEngangsstonad" className={styles.fieldLabel} />
    <p className={styles.element}>{model.beregnetTilkjentYtelse}</p>
    <Row>
      <Column>
        <Label textCode="Beregningsgrunnlag.AntallBarn" className={styles.fieldLabel} />
        <p className={styles.element}>{model.antallBarn}</p>
      </Column>
      <Column>
        <Label textCode="Beregningsgrunnlag.Sats" className={styles.fieldLabel} />
        <p className={styles.element}>{model.satsVerdi}</p>
      </Column>
    </Row>
  </div>
);

BeregningsgrunnlagView.propTypes = {
  model: React.PropTypes.shape({
    beregnetTilkjentYtelse: React.PropTypes.number,
    satsVerdi: React.PropTypes.number,
    antallBarn: React.PropTypes.number,
  }).isRequired,
};

export default BeregningsgrunnlagView;
