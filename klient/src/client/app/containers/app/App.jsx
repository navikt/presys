import React, { Component } from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { routerActions } from 'react-router-redux';

import Header from 'components/app/Header';
import Home from 'components/app/Home';

export class App extends Component {

  componentWillMount() {
    // this.props.fetchSaksbehandler();
  }

  render() {
    return (
      <div>
        <Header saksbehandlerName={this.props.saksbehandlerName} errorMessage={this.props.errorMessage} />
        <Home errorMessage={this.props.errorMessage}>{this.props.children}</Home>
      </div>
    );
  }
}

App.propTypes = {
  children: React.PropTypes.element.isRequired,
  errorMessage: React.PropTypes.string,
  // fetchSaksbehandler: React.PropTypes.func.isRequired,
  saksbehandlerName: React.PropTypes.string,
};

App.defaultProps = {
  errorMessage: '',
  saksbehandlerName: '',
};

const mapStateToProps = state => ({
  errorMessage: state.default.errorHandlingContext.errorMessage,
  saksbehandlerName: state.default.saksbehandlerContext.saksbehandlerName,
  fetchSaksbehandler: 'Lars Erik',
});

const mapDispatchToProps = dispatch => ({
  ...bindActionCreators({ ...routerActions }, dispatch),
});

export default connect(mapStateToProps, mapDispatchToProps)(App);
