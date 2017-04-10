import React, { Component } from 'react';
import { connect } from 'react-redux';
import { login, logout, refresh } from 'actions/saksbehandlerActions';

class LoginManager extends Component {

  componentWillMount() {
    this.props.refresh();
  }

  render() {
    if (this.props.loggedIn) {
      return <button onClick={this.props.logout}>Logg ut</button>;
    }
    return (<div>
      <button onClick={() => this.props.login('lars', 'Sortbil')}>Logg inn</button>
    </div>);
  }
}

LoginManager.propTypes = {
  loggedIn: React.PropTypes.bool.isRequired,
  login: React.PropTypes.func.isRequired,
  logout: React.PropTypes.func.isRequired,
  refresh: React.PropTypes.func.isRequired,
};


export default connect(state => ({ loggedIn: state.saksbehandlerContext.loggedIn }), { login, logout, refresh })(LoginManager);
