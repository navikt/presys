import React, { Component } from 'react';
import { routerActions } from 'react-router-redux';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import fagsakPropType from 'constants/propTypes/fagsakPropType';
import FagsakGrid from 'components/fagsak/FagsakGrid';
import { searchFagsaker, setSelectedFagsak } from 'actions/fagsakActions';

class FagsakIndex extends Component {

  componentWillMount() {
    if (this.props.selectedFagsak === null) {
      const saksnummerUrlParam = this.props.params.saksnummer;
      this.props.searchFagsaker({ searchString: saksnummerUrlParam });
    }
  }

  componentDidUpdate() {
    if (this.props.selectedFagsak === null && this.props.searchResultReceived) {
      const saksnummerUrlParam = this.props.params.saksnummer;
      const fagsak = this.props.fagsaker
        .filter(f => f.saksnummer === parseInt(saksnummerUrlParam, 10));

      this.props.setSelectedFagsak(fagsak[0]);
    }
  }

  render() {
    return (
      <FagsakGrid
        selectedFagsak={this.props.selectedFagsak}
        behandlingListePanel={this.props.behandlingListePanel}
        infoPanel={this.props.infoPanel}
        behandlingspunktPanel={this.props.behandlingspunktPanel}
      />
    );
  }
}

FagsakIndex.propTypes = {
  fagsaker: React.PropTypes.arrayOf(fagsakPropType),
  selectedFagsak: fagsakPropType,
  searchFagsaker: React.PropTypes.func.isRequired,
  setSelectedFagsak: React.PropTypes.func.isRequired,
  searchResultReceived: React.PropTypes.bool.isRequired,
  behandlingListePanel: React.PropTypes.element.isRequired,
  infoPanel: React.PropTypes.element.isRequired,
  behandlingspunktPanel: React.PropTypes.element.isRequired,
  params: React.PropTypes.shape({
    saksnummer: React.PropTypes.string.isRequired,
  }).isRequired,
};

FagsakIndex.defaultProps = {
  fagsaker: [],
  selectedFagsak: null,
};

const mapStateToProps = state => ({
  searchResultReceived: state.default.fagsakContext.searchResultReceived,
  fagsaker: state.default.fagsakContext.fagsaker,
  selectedFagsak: state.default.fagsakContext.selectedFagsak,
});

const mapDispatchToProps = dispatch => ({
  ...bindActionCreators({ ...routerActions, searchFagsaker, setSelectedFagsak }, dispatch),
});

export default connect(mapStateToProps, mapDispatchToProps)(FagsakIndex);
