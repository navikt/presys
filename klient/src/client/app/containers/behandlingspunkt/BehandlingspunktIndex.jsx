import React, { Component } from 'react';
import { routerActions } from 'react-router-redux';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';

import TempPlaceholderView from 'components/behandlingspunkt/TempPlaceholderView';
import behandlingspunktPropType from 'constants/propTypes/behandlingspunktPropType';
import behandlingPropType from 'constants/propTypes/behandlingPropType';
import BehandlingspunktSelector from 'components/behandlingspunkt/BehandlingspunktSelector';
import FormIndex from 'containers/behandlingspunkt/FormIndex';

import BehandlingspunktStatus from 'constants/behandlingspunktStatus';
import { setBehandlingspunkter, setSelectedBehandlingspunkt } from 'actions/behandlingspunktActions';
import replaceNorwegianCharacters from 'helpers/languageHelper';
import getBehandlingspunkter from './behandlingspunktBuilder';

class BehandlingspunktIndex extends Component {

  constructor() {
    super();
    this.setSelectedBehandlingspunkt = this.setSelectedBehandlingspunkt.bind(this);
    this.behandlingNotStarted = false;
  }

  componentWillReceiveProps(nextProps) {
    if (!nextProps.selectedBehandling
        || nextProps.selectedBehandling === this.props.selectedBehandling) {
      return;
    }

    /* TODO (tor) START: Temp kode for å håndtere behandlinger som ikke er startet */
    if (nextProps.selectedBehandling.behandlingspunkter.length === 0) {
      this.props.setSelectedBehandlingspunkt(null);
      this.props.setBehandlingspunkter([]);
      this.behandlingNotStarted = true;
      return;
    }
    this.behandlingNotStarted = false;
    /* SLUTT: Temp kode for å håndtere behandlinger som ikke er startet */

    const behandlingspunkter = getBehandlingspunkter(nextProps.selectedBehandling);

    this.props.setBehandlingspunkter(behandlingspunkter);


    if (this.props.selectedBehandling === null) {
      const punktnavn = this.props.params.punktnavn;
      const punkt = behandlingspunkter.filter(p => replaceNorwegianCharacters(p.navn.toLowerCase()) === punktnavn);
      this.props.setSelectedBehandlingspunkt(punkt.length > 0 ? punkt[0] : behandlingspunkter[0]);
    } else {
      this.props.setSelectedBehandlingspunkt(behandlingspunkter[0]);
    }
  }

  componentWillUnmount() {
    this.props.setSelectedBehandlingspunkt(null);
    this.props.setBehandlingspunkter([]);
  }

  setSelectedBehandlingspunkt(punkt) {
    this.props.setSelectedBehandlingspunkt(punkt);

    const path = this.props.location.pathname;
    const urlPath = path.substring(0, path.indexOf('punkt'));
    this.props.push(`${urlPath}punkt/${replaceNorwegianCharacters(punkt.navn.toLowerCase())}/`);
  }

  render() {
    /* TODO (tor) START: Temp kode for å håndtere behandlinger som ikke er startet */
    if (this.behandlingNotStarted) {
      return (<TempPlaceholderView text="Behandling ikke started. Skal utvides i senere brukerhistorier" />);
    }
    /* SLUTT: Temp kode for å håndtere behandlinger som ikke er startet */

    if (this.props.behandlingspunkter.length === 0) {
      return null;
    }

    return (
      <div>
        <BehandlingspunktSelector
          behandlingspunkter={this.props.behandlingspunkter}
          selectedBehandlingspunkt={this.props.selectedBehandlingspunkt}
          selectBehandlingspunktCallback={this.setSelectedBehandlingspunkt}
        />
        {this.props.selectedBehandling &&
        <FormIndex
          behandlingId={this.props.selectedBehandling.id}
          aksjonspunkterData={this.props.selectedBehandlingspunkt.aksjonspunkterData}
          readOnly={this.props.selectedBehandlingspunkt.status === BehandlingspunktStatus.INNVILGET}
        />
        }
      </div>
    );
  }
}

BehandlingspunktIndex.propTypes = {
  selectedBehandling: behandlingPropType,
  setBehandlingspunkter: React.PropTypes.func.isRequired,
  setSelectedBehandlingspunkt: React.PropTypes.func.isRequired,
  behandlingspunkter: React.PropTypes.arrayOf(behandlingspunktPropType).isRequired,
  selectedBehandlingspunkt: behandlingspunktPropType,
  location: React.PropTypes.shape({
    pathname: React.PropTypes.string.isRequired,
  }).isRequired,
  params: React.PropTypes.shape({
    punktnavn: React.PropTypes.string,
  }).isRequired,
  push: React.PropTypes.func.isRequired,
};

BehandlingspunktIndex.defaultProps = {
  selectedBehandling: null,
  selectedBehandlingspunkt: null,
};

const mapStateToProps = state => ({
  selectedBehandling: state.default.behandlingContext.selectedBehandling,
  behandlingspunkter: state.default.behandlingspunktContext.behandlingspunkter,
  selectedBehandlingspunkt: state.default.behandlingspunktContext.selectedBehandlingspunkt,
});

const mapDispatchToProps = dispatch => ({
  ...bindActionCreators({ ...routerActions, setBehandlingspunkter, setSelectedBehandlingspunkt }, dispatch),
});

export default connect(mapStateToProps, mapDispatchToProps)(BehandlingspunktIndex);
