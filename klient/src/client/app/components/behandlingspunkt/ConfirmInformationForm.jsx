import React from 'react';

import VerticalSpacer from 'elements/VerticalSpacer';
import H3 from 'elements/H3';
import TextArea from 'elements/TextArea';
import FieldError from 'elements/FieldError';
import SubmitOrCancelButtons from 'elements/SubmitOrCancelButtons';
import Form from 'elements/Form';

import { requiredWhen, minLength } from 'helpers/validation/validators';
import { ruleRunner } from 'helpers/validation/ruleRunner';

import styles from './confirmInformationForm.less';

export const getModel = () => ({
  begrunnelse: '',
});

export const rules = [
  ruleRunner('begrunnelse', 'Begrunnelse', requiredWhen(data => data.isDirty), minLength(3)),
];

const ConfirmInformationForm = ({
  code,
  model,
  errorMessages,
  readOnly,
  url,
}, context) => (
  <Form className={styles.container} submitCallback={e => (!context.isDirty && (readOnly || context.isSubmitting) ? null : context.submitCallback(e, url))}>
    <H3 textCode="ConfirmInformation.ConfirmInformationHeader" className={styles.header} />
    <VerticalSpacer space={2} />
    <FieldError errorMessage={errorMessages && errorMessages.begrunnelse} showError={context.showErrors}>
      <TextArea
        id="begrunnelse"
        labelTextCode="ConfirmInformation.ChangeOfInformationRequiresExplanation"
        labelClassName={styles.fieldLabel}
        textAreaClassName={styles.explanationTextarea}
        rows={3}
        value={model.begrunnelse}
        onChange={e => context.updateModel(code, e.target.value, 'begrunnelse')}
        onBlur={() => context.validateModel()}
      />
    </FieldError>
    <VerticalSpacer space={3} />
    <SubmitOrCancelButtons readOnly={readOnly || context.isSubmitting} cancelCallback={context.cancelCallback} isDirty={context.isDirty} />
  </Form>
);

ConfirmInformationForm.contextTypes = {
  updateModel: React.PropTypes.func.isRequired,
  validateModel: React.PropTypes.func.isRequired,
  submitCallback: React.PropTypes.func.isRequired,
  isSubmitting: React.PropTypes.bool.isRequired,
  cancelCallback: React.PropTypes.func.isRequired,
  isDirty: React.PropTypes.bool.isRequired,
  showErrors: React.PropTypes.bool.isRequired,
};

ConfirmInformationForm.propTypes = {
  code: React.PropTypes.string.isRequired,
  model: React.PropTypes.shape({
    begrunnelse: React.PropTypes.string,
  }).isRequired,
  errorMessages: React.PropTypes.shape({
    begrunnelse: React.PropTypes.element,
  }),
  readOnly: React.PropTypes.bool.isRequired,
  url: React.PropTypes.string.isRequired,
};

ConfirmInformationForm.defaultProps = {
  errorMessages: null,
};

export default ConfirmInformationForm;
