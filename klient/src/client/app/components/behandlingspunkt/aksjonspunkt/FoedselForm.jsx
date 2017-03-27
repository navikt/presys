import React from 'react';

import VerticalSpacer from 'elements/VerticalSpacer';
import H3 from 'elements/H3';
import DateField from 'elements/DateField';
import TextField from 'elements/TextField';
import FieldError from 'elements/FieldError';
import Row from 'elements/Row';
import Column from 'elements/Column';
import Label from 'elements/Label';

import { required, maxLength } from 'helpers/validation/validators';
import { ruleRunner } from 'helpers/validation/ruleRunner';

import styles from './foedselForm.less';

export const getModel = behandling => ({
  fodselsdato: behandling.soknad.fodselsdato,
  antallBarn: behandling.soknad.antallBarn,
});

/* TODO (tor) Trekk ut tekstar i message-fil */
export const rules = [
  ruleRunner('fodselsdato', 'Fødselsdato', required),
  ruleRunner('antallBarn', 'Antall barn', required, maxLength(1)),
];

const FoedselForm = ({
  code,
  model,
  errorMessages,
}, context) => (
  <form className={styles.container}>
    <H3 textCode="FoedselForm.ApplicationInformation" className={styles.header} />
    <VerticalSpacer space={2} />
    <FieldError errorMessage={errorMessages && errorMessages.fodselsdato} showError={context.showErrors}>
      <DateField
        id="foedselsdato"
        labelTextCode="FoedselForm.BornDate"
        labelClassName={styles.fieldLabel}
        dateFieldClassName={styles.dateField}
        value={model.fodselsdato}
        onChange={(e, value) => context.updateModel(code, value, 'fodselsdato')}
        onBlur={() => context.validateModel()}
        autoFocus
      />
    </FieldError>
    <VerticalSpacer space={1} />
    <Row>
      <Column>
        <FieldError errorMessage={errorMessages && errorMessages.antallBarn} showError={context.showErrors}>
          <TextField
            id="antall-barn"
            labelClassName={styles.fieldLabel}
            labelTextCode="FoedselForm.NumberOfChildren"
            textFieldClassName={styles.numberOfChildren}
            value={model.antallBarn ? model.antallBarn.toString() : ''}
            onChange={e => context.updateModel(code, parseInt(e.target.value, 10), 'antallBarn')}
            onBlur={() => context.validateModel()}
          />
        </FieldError>
      </Column>
      <Column>
        <Label className={styles.fieldLabel} textCode="FoedselForm.NumberOfChildrenTps" />
        <Label className={styles.noTpsInfo} textCode="FoedselForm.NoTpsInfo" />
      </Column>
    </Row>
  </form>
  );

FoedselForm.contextTypes = {
  showErrors: React.PropTypes.bool.isRequired,
  updateModel: React.PropTypes.func.isRequired,
  validateModel: React.PropTypes.func.isRequired,
};

FoedselForm.propTypes = {
  code: React.PropTypes.string.isRequired,
  model: React.PropTypes.shape({
    fodselsdato: React.PropTypes.string,
    antallBarn: React.PropTypes.number,
  }).isRequired,
  errorMessages: React.PropTypes.shape({
    fodselsdato: React.PropTypes.element,
    antallBarn: React.PropTypes.element,
  }),
};

FoedselForm.defaultProps = {
  errorMessages: null,
};

export default FoedselForm;
