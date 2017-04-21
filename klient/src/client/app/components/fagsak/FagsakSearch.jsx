import React from 'react';
import Search from './Search';

import styles from './fagsakSearch.less';

const FagsakSearch = ({
  searchString,
  setSearchStringCallback,
  searchFagsakCallback,
}) => (
  <div className={styles.container}>
    <Search
      searchString={searchString}
      setSearchStringCallback={setSearchStringCallback}
      searchFagsakCallback={searchFagsakCallback}
    />
  </div>
);

FagsakSearch.propTypes = {
  searchString: React.PropTypes.string,
  setSearchStringCallback: React.PropTypes.func.isRequired,
  searchFagsakCallback: React.PropTypes.func.isRequired,
};

FagsakSearch.defaultProps = {
  searchString: '',
};

export default FagsakSearch;
