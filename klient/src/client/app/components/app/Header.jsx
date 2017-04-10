import React from 'react';
import { Link } from 'react-router';
import { FormattedMessage } from 'react-intl';

import logoUrl from 'images/nav.svg';
import saksbehandlerIkonUrl from 'images/saksbehandler.svg';
import Label from 'elements/Label';
import LoginManager from 'containers/app/LoginManager';


import MessagePanel from './MessagePanel';


import styles from './header.less';

const Header = ({
  saksbehandlerName,
  errorMessage,
}) => (
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
        <div className={styles.saksbehandlerTekst}>{saksbehandlerName}</div>
      </div>
      <div className={styles.saksbehandlerTekst} >
        <LoginManager />
      </div>
    </div>
    {errorMessage !== '' &&
    <MessagePanel errorMessage={errorMessage} />
    }
  </header>
);

Header.propTypes = {
  saksbehandlerName: React.PropTypes.string.isRequired,
  errorMessage: React.PropTypes.string,
};

Header.defaultProps = {
  errorMessage: '',
};

export default Header;
