import React from 'react';
import { Link } from 'react-router';
import { FormattedMessage } from 'react-intl';

import logoUrl from 'images/nav.svg';
import saksbehandlerIkonUrl from 'images/saksbehandler.svg';
import Label from 'elements/Label';

import MessagePanel from './MessagePanel';
import styles from './header.less';

const Header = ({
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
        <Link to="/login" >
          <img src={saksbehandlerIkonUrl} className={styles.saksbehandlerIkon} alt={<FormattedMessage id="Header.Saksbehandler" />} />
        </Link>
      </div>
      <div className={styles.saksbehandlerTekst} />
    </div>
    {errorMessage !== '' &&
    <MessagePanel errorMessage={errorMessage} />
    }
  </header>
);

Header.propTypes = {
  errorMessage: React.PropTypes.string,
};

Header.defaultProps = {
  errorMessage: '',
};

export default Header;
