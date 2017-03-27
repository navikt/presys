import React, { Component } from 'react';

import { routerActions } from 'react-router-redux';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import { saveModel, setModel, showFormErrors, setFormErrors, setPreviousModel } from 'actions/formActions';
import { run } from 'helpers/validation/ruleRunner';
import { isEmpty } from 'helpers/objectUtils';

class FormProvider extends Component {

  constructor() {
    super();
    this.cancelEdit = this.cancelEdit.bind(this);
    this.updateModel = this.updateModel.bind(this);
    this.validateModel = this.validateModel.bind(this);
    this.submit = this.submit.bind(this);
    this.createRuleContext = this.createRuleContext.bind(this);
  }

  getChildContext() {
    return {
      models: this.props.models,
      updateModel: this.updateModel,
      validateModel: this.validateModel,
      submitCallback: this.submit,
      cancelCallback: this.cancelEdit,
      isSubmitting: this.props.isSubmitting,
      setFormErrors: this.props.setFormErrors,
      showFormErrors: this.props.showFormErrors,
      showErrors: this.props.showErrors,
      validationErrors: this.props.validationErrors,
      isDirty: this.props.isDirty,
    };
  }

  submit(e, url) {
    const validationResult = this.validateModel();
    if (isEmpty(validationResult)) {
      const begrunnelse = this.props.models.submit.begrunnelse;
      const behandlingId = this.props.behandlingId;

      const models = Object.keys(this.props.models)
        .filter(code => code !== 'submit')
        .map(code => ({
          '@type': code,
          behandlingId,
          aksjonspunktId: this.props.aksjonspunktIds[code],
          begrunnelse,
          ...this.props.models[code],
        }));

      this.props.saveModel(url, models);
    } else {
      this.props.showFormErrors();
    }

    e.preventDefault();
  }

  cancelEdit() {
    this.props.setFormErrors({});
    this.props.setPreviousModel();
  }

  updateModel(code, value, name) {
    const model = JSON.parse(JSON.stringify(this.props.models[code]));
    model[name] = value;
    this.props.setModel(code, model);
  }

  createRuleContext() {
    return {
      isDirty: this.props.isDirty,
    };
  }

  validateModel() {
    const validationResult = {};
    Object.keys(this.props.models).forEach((key) => {
      const result = run(this.props.models[key], this.props.rules[key], this.createRuleContext());
      if (!isEmpty(result)) {
        validationResult[key] = result;
      }
    });

    this.props.setFormErrors(validationResult);
    return validationResult;
  }

  render() {
    return (
      <div>{ this.props.children }</div>
    );
  }
}

FormProvider.childContextTypes = {
  models: React.PropTypes.shape().isRequired,
  updateModel: React.PropTypes.func.isRequired,
  validateModel: React.PropTypes.func.isRequired,
  submitCallback: React.PropTypes.func.isRequired,
  cancelCallback: React.PropTypes.func.isRequired,
  showFormErrors: React.PropTypes.func.isRequired,
  setFormErrors: React.PropTypes.func.isRequired,
  isSubmitting: React.PropTypes.bool.isRequired,
  showErrors: React.PropTypes.bool.isRequired,
  validationErrors: React.PropTypes.shape().isRequired,
  isDirty: React.PropTypes.bool.isRequired,
};

FormProvider.propTypes = {
  behandlingId: React.PropTypes.number.isRequired,
  models: React.PropTypes.shape().isRequired,
  rules: React.PropTypes.shape().isRequired,
  aksjonspunktIds: React.PropTypes.shape().isRequired,
  setModel: React.PropTypes.func.isRequired,
  saveModel: React.PropTypes.func.isRequired,
  setPreviousModel: React.PropTypes.func.isRequired,
  showFormErrors: React.PropTypes.func.isRequired,
  setFormErrors: React.PropTypes.func.isRequired,
  isSubmitting: React.PropTypes.bool.isRequired,
  showErrors: React.PropTypes.bool.isRequired,
  validationErrors: React.PropTypes.shape().isRequired,
  isDirty: React.PropTypes.bool.isRequired,
  children: React.PropTypes.oneOfType([
    React.PropTypes.arrayOf(
      React.PropTypes.element,
    ),
    React.PropTypes.element,
  ]).isRequired,
};

FormProvider.defaultProps = {
  rules: [],
};

const mapStateToProps = state => ({
  models: state.default.formContext.models,
  isSubmitting: state.default.formContext.isSubmitting,
  showErrors: state.default.formContext.showErrors,
  validationErrors: state.default.formContext.validationErrors,
  isDirty: state.default.formContext.isDirty,
});

const mapDispatchToProps = dispatch => ({
  ...bindActionCreators({ ...routerActions, setModel, saveModel, showFormErrors, setFormErrors, setPreviousModel }, dispatch),
});

export default connect(mapStateToProps, mapDispatchToProps)(FormProvider);
