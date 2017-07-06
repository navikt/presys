import React from 'react';
import { connect } from 'react-redux';
import LoginManager from 'containers/app/LoginManager';

import Header from 'components/app/Header';
import Home from 'components/app/Home';

const App = ({ errorMessage, loggedIn, children }) => <div>
  <Header errorMessage={errorMessage} />
  <Home errorMessage={errorMessage}>
    {!loggedIn ? <LoginManager /> : children}
  </Home>
</div>;

App.propTypes = {
  children: React.PropTypes.element.isRequired,
  errorMessage: React.PropTypes.string,
  loggedIn: React.PropTypes.bool.isRequired,
};

App.defaultProps = {
  errorMessage: '',
};

const mapStateToProps = state => ({
  errorMessage: state.errorHandlingContext.errorMessage,
  loggedIn: state.saksbehandlerContext.loggedIn,
});

export default connect(mapStateToProps, {})(App);
