import React from 'react';

import VerticalSpacer from 'elements/VerticalSpacer';
import H3 from 'elements/H3';
import DateField from 'elements/DateField';
import TextField from 'elements/TextField';
import FieldError from 'elements/FieldError';

import { required, maxLength } from 'helpers/validation/validators';
import { ruleRunner } from 'helpers/validation/ruleRunner';

import styles from './termindatoForm.less';

export const getModel = behandling => ({
  utstedtdato: behandling.soknad.utstedtDato,
  termindato: behandling.soknad.termindato,
  antallBarn: behandling.soknad.antallBarn,
});

/* TODO (tor) Trekk ut tekstar i message-fil */
export const rules = [
  ruleRunner('utstedtdato', 'Utstedt dato', required),
  ruleRunner('termindato', 'Termindato', required),
  ruleRunner('antallBarn', 'Antall barn', required, maxLength(1)),
];

const TermindatoForm = ({
  code,
  model,
  errorMessages,
}, context) => (
  <form className={styles.container}>
    <H3 textCode="TermindatoForm.ApplicationInformation" className={styles.header} />
    <VerticalSpacer space={2} />
    <FieldError errorMessage={errorMessages && errorMessages.utstedtdato} showError={context.showErrors}>
      <DateField
        id="utstedt-dato"
        labelTextCode="TermindatoForm.IssuedDate"
        labelClassName={styles.fieldLabel}
        dateFieldClassName={styles.dateField}
        value={model.utstedtdato}
        onChange={(e, value) => context.updateModel(code, value, 'utstedtdato')}
        onBlur={() => context.validateModel()}
        autoFocus
      />
    </FieldError>
    <VerticalSpacer space={1} />
    <FieldError errorMessage={errorMessages && errorMessages.termindato} showError={context.showErrors}>
      <DateField
        id="termindato"
        labelTextCode="TermindatoForm.TermDate"
        labelClassName={styles.fieldLabel}
        dateFieldClassName={styles.dateField}
        value={model.termindato}
        onChange={(e, value) => context.updateModel(code, value, 'termindato')}
        onBlur={() => context.validateModel()}
      />
    </FieldError>
    <VerticalSpacer space={1} />
    <FieldError errorMessage={errorMessages && errorMessages.antallBarn} showError={context.showErrors}>
      <TextField
        id="antall-barn"
        labelClassName={styles.fieldLabel}
        labelTextCode="TermindatoForm.NumberOfChildren"
        textFieldClassName={styles.numberOfChildren}
        value={model.antallBarn ? model.antallBarn.toString() : ''}
        onChange={e => context.updateModel(code, parseInt(e.target.value, 10), 'antallBarn')}
        onBlur={() => context.validateModel()}
      />
    </FieldError>
    <VerticalSpacer space={3} />
  </form>
  );

TermindatoForm.contextTypes = {
  showErrors: React.PropTypes.bool.isRequired,
  updateModel: React.PropTypes.func.isRequired,
  validateModel: React.PropTypes.func.isRequired,
};

TermindatoForm.propTypes = {
  code: React.PropTypes.string.isRequired,
  model: React.PropTypes.shape({
    utstedtdato: React.PropTypes.string,
    termindato: React.PropTypes.string,
    antallBarn: React.PropTypes.number,
  }).isRequired,
  errorMessages: React.PropTypes.shape({
    utstedtdato: React.PropTypes.element,
    termindato: React.PropTypes.element,
    antallBarn: React.PropTypes.element,
  }),
};

TermindatoForm.defaultProps = {
  errorMessages: null,
};

export default TermindatoForm;
