import React, { Component } from 'react';
import { routerActions } from 'react-router-redux';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import behandlingPropType from 'constants/propTypes/behandlingPropType';
import BehandlingList from 'components/behandling/BehandlingList';
import { fetchBehandlinger, setSelectedBehandling, toggleShowAllBehandlinger } from 'actions/behandlingActions';

class BehandlingIndex extends Component {

  constructor() {
    super();
    this.selectBehandling = this.selectBehandling.bind(this);
  }

  componentWillMount() {
    const saksnummerUrlParam = this.props.params.saksnummer;
    this.props.fetchBehandlinger({ snr: saksnummerUrlParam });
  }

  componentDidUpdate() {
    if (this.props.behandlinger.length > 0) {
      const behandlingIdUrlParam = this.props.params.behandlingId;
      const filteredBehandlinger = this.props.behandlinger
        .filter(behandling => (behandlingIdUrlParam ? behandling.id === parseInt(behandlingIdUrlParam, 10) : true))
        .sort((behandling1, behandling2) => {
          const changeTimeBehandling1 = behandling1.endret ? behandling1.endret : behandling1.opprettet;
          const changeTimeBehandling2 = behandling2.endret ? behandling2.endret : behandling2.opprettet;
          return new Date(parseInt(changeTimeBehandling1, 10)) < new Date(parseInt(changeTimeBehandling2, 10)) ? 1 : -1;
        });

      if (!this.props.selectedBehandling || this.props.selectedBehandling !== filteredBehandlinger[0]) {
        this.props.setSelectedBehandling(filteredBehandlinger[0]);
      }
    }
  }

  selectBehandling(behandlingId) {
    const filteredBehandlinger = this.props.behandlinger
      .filter(behandling => behandling.id === behandlingId);
    this.props.setSelectedBehandling(filteredBehandlinger[0]);

    const path = this.props.location.pathname;
    const urlPath = path.substring(0, path.indexOf('behandling'));
    this.props.push(`${urlPath}behandling/${behandlingId}/punkt/`);
  }

  render() {
    return (
      <div>
        { this.props.behandlingResultReceived &&
        <BehandlingList
          behandlinger={this.props.behandlinger}
          selectedBehandling={this.props.selectedBehandling}
          showAllBehandlinger={this.props.showAll}
          selectBehandlingCallback={this.selectBehandling}
          toggleShowAllBehandlingerCallback={this.props.toggleShowAllBehandlinger}
        />
        }
      </div>
    );
  }
}

BehandlingIndex.propTypes = {
  behandlinger: React.PropTypes.arrayOf(behandlingPropType),
  selectedBehandling: behandlingPropType,
  location: React.PropTypes.shape({
    pathname: React.PropTypes.string.isRequired,
  }).isRequired,
  params: React.PropTypes.shape({
    saksnummer: React.PropTypes.string.isRequired,
    behandlingId: React.PropTypes.string,
  }).isRequired,
  fetchBehandlinger: React.PropTypes.func.isRequired,
  behandlingResultReceived: React.PropTypes.bool.isRequired,
  setSelectedBehandling: React.PropTypes.func.isRequired,
  toggleShowAllBehandlinger: React.PropTypes.func.isRequired,
  showAll: React.PropTypes.bool.isRequired,
  push: React.PropTypes.func.isRequired,
};

BehandlingIndex.defaultProps = {
  behandlinger: {},
  selectedBehandling: null,
};

const mapStateToProps = state => ({
  behandlinger: state.default.behandlingContext.behandlinger,
  selectedBehandling: state.default.behandlingContext.selectedBehandling,
  behandlingResultReceived: state.default.behandlingContext.behandlingResultReceived,
  showAll: state.default.behandlingContext.showAll,
});

const mapDispatchToProps = dispatch => ({
  ...bindActionCreators({ ...routerActions, fetchBehandlinger, setSelectedBehandling, toggleShowAllBehandlinger }, dispatch),
});

export default connect(mapStateToProps, mapDispatchToProps)(BehandlingIndex);
