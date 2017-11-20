import React from 'react';
import { routerActions } from 'react-router-redux';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import FagsakSearch from 'components/fagsak/FagsakSearch';
import setSearchString from 'actions/personsokActions';

export const PersonsokIndex = props => <FagsakSearch
  searchString={props.searchString}
  setSearchStringCallback={props.setSearchString}
  searchFagsakCallback={({ searchString }) => props.push(`/person/${searchString.trim().replace(/\s/g, '')}`)}
/>;

PersonsokIndex.propTypes = {
  searchString: React.PropTypes.string,
  push: React.PropTypes.func.isRequired,
  setSearchString: React.PropTypes.func.isRequired,
};

PersonsokIndex.defaultProps = {
  searchString: '',
};

const mapStateToProps = state => ({
  searchString: state.personsok.searchString,
});

const mapDispatchToProps = dispatch => ({
  ...bindActionCreators({ ...routerActions, setSearchString }, dispatch),
});

export default connect(mapStateToProps, mapDispatchToProps)(PersonsokIndex);
