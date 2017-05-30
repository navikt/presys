import React from 'react';
import { Link } from 'react-router';
import { FormattedMessage } from 'react-intl';

import { connect } from 'react-redux';

import logoUrl from 'images/nav.svg';
import saksbehandlerIkonUrl from 'images/saksbehandler.svg';
import Label from 'elements/Label';

import MessagePanel from './MessagePanel';
import styles from './header.less';

const Header = props => (
  <header className={styles.container}>
    <div className={styles.topplinje}>
      <div>
        <div className={styles.logo}>
          <Link to="/">
            <img src={logoUrl} className={styles.headerIkon} alt="NAV" />
          </Link>
        </div>
        <div className={styles.headerDivider} />
      </div>
      <Label textCode="Header.Foreldrepenger" className={styles.text} />
      <div className={styles.saksbehandler}>
        <img src={saksbehandlerIkonUrl} className={styles.saksbehandlerIkon} alt={<FormattedMessage id="Header.Saksbehandler" />} />
        { props.loggedIn ? (<span>
          Du er logget inn.
          <Link to="/login">Logg ut</Link>
        </span>) : '' }
      </div>
      <div className={styles.saksbehandlerTekst} />
    </div>
    {props.errorMessage !== '' &&
    <MessagePanel errorMessage={props.errorMessage} />
    }
  </header>
);

Header.propTypes = {
  errorMessage: React.PropTypes.string,
  loggedIn: React.PropTypes.bool.isRequired,
};

Header.defaultProps = {
  errorMessage: '',
};

export default connect(state => ({ loggedIn: state.saksbehandlerContext.loggedIn }), { })(Header);

