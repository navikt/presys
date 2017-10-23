import React from 'react';

import styles from './footer.less';

const subject = encodeURIComponent('Feil i presys');
const body = pathname => encodeURIComponent(`Det oppstod en feil i: ${pathname} \n\nBeskriv gjerne problemet:`);
const Footer = ({ pathname }) => (
  <footer className={styles.container}>
    <div className={styles.bunnlinje} >
      <a href={`mailto:nav.it.team.pesys-presys@nav.no?Subject=${subject}&Body=${body(pathname)}`} >Meld feil</a>
    </div>
  </footer>
);

Footer.propTypes = {
  pathname: React.PropTypes.string.isRequired,
};

Footer.defaultProps = {
};

export default Footer;
