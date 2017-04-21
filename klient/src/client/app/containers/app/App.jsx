import React from 'react';
import { connect } from 'react-redux';

import Header from 'components/app/Header';
import Home from 'components/app/Home';

export const App = ({ errorMessage, children }) => <div>
  <Header errorMessage={errorMessage} />
  <Home errorMessage={errorMessage}>{children}</Home>
</div>;

App.propTypes = {
  children: React.PropTypes.element.isRequired,
  errorMessage: React.PropTypes.string,
};

App.defaultProps = {
  errorMessage: '',
};

const mapStateToProps = state => ({
  errorMessage: state.errorHandlingContext.errorMessage,
});

export default connect(mapStateToProps, {})(App);
