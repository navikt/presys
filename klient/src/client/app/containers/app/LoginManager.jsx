import React, { Component } from 'react';
import { connect } from 'react-redux';
import { login, logout } from 'actions/saksbehandlerActions';

class LoginManager extends Component {

  constructor(props) {
    super(props);

    this.handleSubmit = this.handleSubmit.bind(this);

    this.state = {
      username: null,
      password: null,
    };
  }

  handleSubmit(event) {
    event.preventDefault();
    this.props.login(this.state.username, this.state.password);
  }

  render() {
    if (this.props.loggedIn) {
      return <button onClick={this.props.logout}>Logg ut</button>;
    }

    return (
      <div>
        <p>
          <strong>Bruk user:password for å få tilgang.</strong>
        </p>
        <form onSubmit={this.handleSubmit}>
          <label htmlFor="username">
            Brukernavn:
            <input
              type="text" id="username" onChange={(e) => {
                this.setState({
                  username: e.target.value,
                });
              }}
            />
          </label>
          <label htmlFor="password">
            Passord:
            <input
              type="password" id="password" onChange={(e) => {
                this.setState({
                  password: e.target.value,
                });
              }}
            />
          </label>
          <button type="submit" onClick={this.handleSubmit}>Logg inn</button>
        </form>
      </div>
    );
  }
}

LoginManager.propTypes = {
  loggedIn: React.PropTypes.bool.isRequired,
  login: React.PropTypes.func.isRequired,
  logout: React.PropTypes.func.isRequired,
};


export default connect(state => ({ loggedIn: state.saksbehandlerContext.loggedIn }), { login, logout })(LoginManager);
