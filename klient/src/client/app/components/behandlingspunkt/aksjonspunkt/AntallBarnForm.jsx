import React from 'react';

import RadioButton from 'elements/RadioButton';
import VerticalSpacer from 'elements/VerticalSpacer';
import H3 from 'elements/H3';
import TextField from 'elements/TextField';
import Label from 'elements/Label';
import DateLabel from 'elements/DateLabel';
import Row from 'elements/Row';
import Column from 'elements/Column';
import FieldError from 'elements/FieldError';
import Hr from 'elements/Hr';

import { required, maxLength } from 'helpers/validation/validators';
import { ruleRunner } from 'helpers/validation/ruleRunner';

import styles from './antallBarnForm.less';

export const getModel = behandling => ({
  foedselsdatoSoeknad: behandling.soknad.fodselsdato,
  antallBarn: behandling.soknad.antallBarn,
  antallBarnTps: behandling.tpsData ? behandling.tpsData.antallBarn : null,
  brukAntallBarnFraTps: false,
});

/* TODO (tor) Trekk ut tekstar i message-fil */
export const rules = [
  ruleRunner('antallBarn', 'Antall barn i søknaden', required, maxLength(1)),
  ruleRunner('brukAntallBarnFraTps', 'kilde', required),
];

const AntallBarnForm = ({
  code,
  model,
  errorMessages,
}, context) => (
  <form className={styles.container} >
    <H3 textCode="AntallBarnForm.NumberOfChildren" className={styles.header} />
    <VerticalSpacer space={2} />

    <Label textCode="AntallBarnForm.BornDate" className={styles.fieldLabel} />
    <VerticalSpacer space={1} />
    <span className={styles.element}>
      <DateLabel dateString={model.foedselsdatoSoeknad} />
    </span>
    <VerticalSpacer space={3} />

    <Row>
      <Column size={8}>
        <FieldError errorMessage={errorMessages && errorMessages.antallBarn} showError={context.showErrors}>
          <TextField
            id="antall-barn"
            labelClassName={styles.fieldLabel}
            labelTextCode="AntallBarnForm.NumberOfChildrenInApplication"
            textFieldClassName={styles.numberOfChildren}
            onChange={e => context.updateModel(code, parseInt(e.target.value, 10), 'antallBarn')}
            onBlur={() => context.validateModel()}
            value={model.antallBarn ? model.antallBarn.toString() : ''}
            autoFocus
          />
        </FieldError>
      </Column>
      <Column size={3}>
        <Label textCode="AntallBarnForm.NumberOfChildrenInTps" className={styles.fieldLabel} />
        <VerticalSpacer space={2} />
        <p className={styles.element}>{model.antallBarnTps}</p>
      </Column>
    </Row>

    <Hr />

    <Row>
      <FieldError classNameLabel={styles.radioButtonError} errorMessage={errorMessages && errorMessages.brukAntallBarnFraTps} showError={context.showErrors}>
        <Column>
          <RadioButton
            id="select-source-application"
            name="child-source"
            value="false"
            checked={!model.brukAntallBarnFraTps}
            textCode="AntallBarnForm.useNumberInApplication"
            onChange={() => context.updateModel(code, false, 'brukAntallBarnFraTps')}
            onBlur={() => context.validateModel()}
          />
        </Column>
        <Column className={styles.navInput}>
          <RadioButton
            id="select-source-tps"
            name="child-source"
            value="true"
            checked={model.brukAntallBarnFraTps}
            textCode="AntallBarnForm.useNumberInTps"
            onChange={() => context.updateModel(code, true, 'brukAntallBarnFraTps')}
            onBlur={() => context.validateModel()}
          />
        </Column>
      </FieldError>
    </Row>
  </form>
);

AntallBarnForm.contextTypes = {
  showErrors: React.PropTypes.bool.isRequired,
  updateModel: React.PropTypes.func.isRequired,
  validateModel: React.PropTypes.func.isRequired,
};

AntallBarnForm.propTypes = {
  code: React.PropTypes.string.isRequired,
  model: React.PropTypes.shape({
    foedselsdatoSoeknad: React.PropTypes.string,
    antallBarn: React.PropTypes.number,
    antallBarnTps: React.PropTypes.number,
    brukAntallBarnFraTps: React.PropTypes.bool,
  }).isRequired,
  errorMessages: React.PropTypes.shape({
    antallBarn: React.PropTypes.element,
    brukAntallBarnFraTps: React.PropTypes.element,
  }),
};

AntallBarnForm.defaultProps = {
  errorMessages: null,
};

export default AntallBarnForm;
