import React from 'react';

import fagsakPropType from 'constants/propTypes/fagsakPropType';

import Person from 'components/person/Person';
import Label from 'elements/Label';
import Search from './Search';
import FagsakList from './FagsakList';

import styles from './fagsakSearch.less';

const FagsakSearch = ({
  searchString,
  setSearchStringCallback,
  fagsaker,
  searchFagsakCallback,
  searchResultReceived,
  selectFagsakCallback,
}) => (
  <div className={styles.container}>
    <Search
      searchString={searchString}
      setSearchStringCallback={setSearchStringCallback}
      searchFagsakCallback={searchFagsakCallback}
    />

    {searchResultReceived && fagsaker.length === 0 &&
    <Label textCode="FagsakSearch.ZeroSearchResults" className={styles.label} />
    }

    {fagsaker.length > 1 &&
    <Person
      navn={fagsaker[0].person.navn}
      alder={fagsaker[0].person.alder}
      personnummer={fagsaker[0].person.personnummer}
      erKvinne={fagsaker[0].person.erKvinne}
      hasLargeFont={false}
    />
    }

    {fagsaker.length > 1 &&
    <FagsakList fagsaker={fagsaker} selectFagsakCallback={selectFagsakCallback} />
    }
  </div>
);

FagsakSearch.propTypes = {
  searchString: React.PropTypes.string,
  fagsaker: React.PropTypes.arrayOf(fagsakPropType),
  setSearchStringCallback: React.PropTypes.func.isRequired,
  searchResultReceived: React.PropTypes.bool.isRequired,
  searchFagsakCallback: React.PropTypes.func.isRequired,
  selectFagsakCallback: React.PropTypes.func.isRequired,
};

FagsakSearch.defaultProps = {
  searchString: '',
  fagsaker: [],
};

export default FagsakSearch;
