import React, { Component } from 'react';
import { routerActions } from 'react-router-redux';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import fagsakPropType from 'constants/propTypes/fagsakPropType';
import FagsakSearch from 'components/fagsak/FagsakSearch';
import { searchFagsaker, setSelectedFagsak, setSearchString } from 'actions/fagsakActions';

class FagsakSearchIndex extends Component {

  constructor() {
    super();
    this.selectFagsak = this.selectFagsak.bind(this);
  }

  componentDidUpdate() {
    if (this.props.searchResultReceived && this.props.fagsaker.length === 1) {
      this.updateStoreAndGoToRoute(this.props.fagsaker[0]);
    }
  }

  selectFagsak(e, saksnummer) {
    const filteredFagsaker = this.props.fagsaker
      .filter(fagsak => fagsak.saksnummer === saksnummer);

    this.updateStoreAndGoToRoute(filteredFagsaker[0]);
  }

  updateStoreAndGoToRoute(fagsak) {
    this.props.setSelectedFagsak(fagsak);
    this.props.push(`fagsak/${fagsak.saksnummer}`);
  }

  render() {
    return (
      <FagsakSearch
        searchString={this.props.searchString}
        setSearchStringCallback={this.props.setSearchString}
        fagsaker={this.props.fagsaker}
        // searchFagsakCallback={this.props.searchFagsaker}
        searchFagsakCallback={({ searchString }) => this.props.push(`/person/${searchString}`)}
        searchResultReceived={this.props.searchResultReceived}
        selectFagsakCallback={this.selectFagsak}
      />
    );
  }
}

FagsakSearchIndex.propTypes = {
  searchString: React.PropTypes.string,
  fagsaker: React.PropTypes.arrayOf(fagsakPropType),
  push: React.PropTypes.func.isRequired,
  setSearchString: React.PropTypes.func.isRequired,
  // searchFagsaker: React.PropTypes.func.isRequired,
  searchResultReceived: React.PropTypes.bool.isRequired,
  setSelectedFagsak: React.PropTypes.func.isRequired,
};

FagsakSearchIndex.defaultProps = {
  searchString: '',
  fagsaker: [],
};

const mapStateToProps = state => ({
  searchString: state.default.fagsakContext.searchString,
  searchResultReceived: state.default.fagsakContext.searchResultReceived,
  fagsaker: state.default.fagsakContext.fagsaker,
});

const mapDispatchToProps = dispatch => ({
  ...bindActionCreators({ ...routerActions, searchFagsaker, setSelectedFagsak, setSearchString }, dispatch),
});

export default connect(mapStateToProps, mapDispatchToProps)(FagsakSearchIndex);
