import React, { Component } from 'react';
import { routerActions } from 'react-router-redux';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import behandlingPropType from 'constants/propTypes/behandlingPropType';
import { setModel, clearFormData } from 'actions/formActions';
import FormProvider from './FormProvider';

class FormIndex extends Component {

  constructor() {
    super();
    this.setModelData = this.setModelData.bind(this);
  }

  componentWillMount() {
    this.props.clearFormData();
    this.setModelData(this.props.aksjonspunkterData);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.selectedBehandling !== this.props.selectedBehandling) {
      this.props.clearFormData();
      this.setModelData(nextProps.aksjonspunkterData);
    } else if (nextProps.aksjonspunkterData !== this.props.aksjonspunkterData) {
      this.setModelData(nextProps.aksjonspunkterData);
    }
  }

  setModelData(aksjonspunkterData) {
    this.modelRules = {};
    this.modelIds = {};
    aksjonspunkterData.forEach((apd) => {
      if (apd.model) {
        this.props.setModel(apd.code, apd.model);
      }
      this.modelRules[apd.code] = apd.rules;
      this.modelIds[apd.code] = apd.id;
    });
  }

  render() {
    return (
      <FormProvider behandlingId={this.props.behandlingId} aksjonspunktIds={this.modelIds} rules={this.modelRules}>
        {this.props.aksjonspunkterData.map((apd) => {
          if (apd.model) {
            if (!this.props.models[apd.code]) {
              return <div key={apd.code} />;
            }

            if (apd.rules) {
              return apd.form(this.props.models[apd.code], this.props.validationErrors[apd.code], this.props.readOnly);
            }
            return apd.form(this.props.models[apd.code]);
          }
          return apd.form(this.props.readOnly);
        })}
      </FormProvider>
    );
  }
}

FormIndex.propTypes = {
  models: React.PropTypes.shape().isRequired,
  validationErrors: React.PropTypes.shape().isRequired,
  behandlingId: React.PropTypes.number.isRequired,
  readOnly: React.PropTypes.bool.isRequired,
  aksjonspunkterData: React.PropTypes.oneOfType([
    React.PropTypes.arrayOf(React.PropTypes.shape({
      id: React.PropTypes.number,
      readOnly: React.PropTypes.bool.isRequired,
      code: React.PropTypes.string.isRequired,
      form: React.PropTypes.func.isRequired,
      model: React.PropTypes.shape(),
      rules: React.PropTypes.arrayOf(React.PropTypes.func),
    })),
    React.PropTypes.shape({
      id: React.PropTypes.number,
      readOnly: React.PropTypes.bool.isRequired,
      code: React.PropTypes.string.isRequired,
      form: React.PropTypes.func.isRequired,
      model: React.PropTypes.shape(),
      rules: React.PropTypes.arrayOf(React.PropTypes.func),
    }),
  ]).isRequired,
  setModel: React.PropTypes.func.isRequired,
  clearFormData: React.PropTypes.func.isRequired,
  selectedBehandling: behandlingPropType.isRequired,
};

const mapStateToProps = state => ({
  models: state.default.formContext.models,
  validationErrors: state.default.formContext.validationErrors,
  selectedBehandling: state.default.behandlingContext.selectedBehandling,
});

const mapDispatchToProps = dispatch => ({
  ...bindActionCreators({ ...routerActions, setModel, clearFormData }, dispatch),
});

export default connect(mapStateToProps, mapDispatchToProps)(FormIndex);
