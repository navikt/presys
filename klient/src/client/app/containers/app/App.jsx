import React, { Component } from 'react';
import { connect } from 'react-redux';

import { routerActions } from 'react-router-redux';
import { bindActionCreators } from 'redux';

import Header from 'components/app/Header';
import Home from 'components/app/Home';

class App extends Component {

  componentDidMount() {
    if (!this.props.loggedIn && this.props.location.pathname !== '/login') {
      this.props.push('/login');
    }
  }

  componentWillReceiveProps(nextProps) {
    if (!this.props.loggedIn && nextProps.location.pathname !== '/login') {
      this.props.push('/login');
    }
  }

  render() {
    return (<div>
      <Header errorMessage={this.props.errorMessage} />
      <Home errorMessage={this.props.errorMessage}>{this.props.children}</Home>
    </div>);
  }
}

App.propTypes = {
  children: React.PropTypes.element.isRequired,
  errorMessage: React.PropTypes.string,
  loggedIn: React.PropTypes.bool.isRequired,
  push: React.PropTypes.func.isRequired,
  location: React.PropTypes.shape({ pathname: React.PropTypes.string.isRequired }).isRequired,
};

App.defaultProps = {
  errorMessage: '',
};

const mapStateToProps = state => ({
  errorMessage: state.errorHandlingContext.errorMessage,
  loggedIn: state.saksbehandlerContext.loggedIn,
});

const mapDispatchToProps = dispatch => ({
  ...bindActionCreators({ ...routerActions }, dispatch),
});

export default connect(mapStateToProps, mapDispatchToProps)(App);
