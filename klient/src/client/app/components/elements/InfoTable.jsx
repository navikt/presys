import React from 'react';
import styles from './infoTable.less';


const InfoTable = ({ children }) => (
  <table className={styles.infotable}><tbody>
    {children}
  </tbody></table>);

InfoTable.propTypes = {
  children: React.PropTypes.oneOfType([React.PropTypes.arrayOf(React.PropTypes.element), React.PropTypes.shape({})]).isRequired,
};

export default InfoTable;

