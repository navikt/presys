import React from 'react';

import H2 from 'elements/H2';
import TextField from 'elements/TextField';
import Button from 'elements/Button';

import styles from './search.less';

const Search = ({
  searchString,
  setSearchStringCallback,
  searchFagsakCallback,
}) => (
  <div className={styles.container}>
    <H2 textCode="Search.SearchFagsakOrPerson" className={styles.header} />
    <div>
      <TextField
        id="fagsak-search-button"
        labelClassName={styles.helptext}
        labelTextCode="Search.SaksnummerOrPersonId"
        textFieldClassName={styles.inputLarge}
        value={searchString}
        onChange={e => setSearchStringCallback(e.target.value)}
        onKeyDown={(e) => {
          if (e.key === 'Enter') {
            searchFagsakCallback({ searchString });
          }
        }}
        autoFocus
      />
      <Button textCode="Search.Search" onClick={() => searchFagsakCallback({ searchString })} tabIndex="0" />
    </div>
  </div>
);

Search.propTypes = {
  searchString: React.PropTypes.string,
  setSearchStringCallback: React.PropTypes.func.isRequired,
  searchFagsakCallback: React.PropTypes.func.isRequired,
};

Search.defaultProps = {
  searchString: '',
};

export default Search;
