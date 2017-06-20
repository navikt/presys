import React, { Component } from 'react';
import { fetchUforeHistorikk } from 'actions/personActions';
import { connect } from 'react-redux';

import UforeHistorikkListe from './UforeHistorikkListe';

class LastUforeHistorikk extends Component {
  componentDidMount() {
    if (this.props.person.fnr && !this.props.person.uforehistorikker) {
      this.props.fetchUforeHistorikk(this.props.person.fnr);
    }
  }

  componentWillReceiveProps(nextProps) {
    if (this.props.person.fnr && this.props.person.fnr !== nextProps.person.fnr && !nextProps.person.uforehistorikkerIsLoading) {
      this.props.fetchUforeHistorikk(nextProps.person.fnr);
    }
  }


  render() {
    const { person: { uforehistorikker, fnr, uforehistorikkerIsLoading, loading }, ...rest } = this.props;

    if (fnr !== this.props.params.fnr) {
      return null;
    }

    if (uforehistorikker === null) {
      return null;
    }

    if (uforehistorikkerIsLoading || loading) {
      return null;
    }

    return <UforeHistorikkListe {...rest} uforehistorikker={uforehistorikker} />;
  }
}


LastUforeHistorikk.propTypes = {
  person: React.PropTypes.shape({
    fnr: React.PropTypes.string.isRequired,
    uforehistorikker: React.PropTypes.arrayOf(React.PropTypes.object),
    uforehistorikkerIsLoading: React.PropTypes.bool,
  }),
  fetchUforeHistorikk: React.PropTypes.func.isRequired,
  params: React.PropTypes.shape({ fnr: React.PropTypes.string.isRequired }).isRequired,
};

LastUforeHistorikk.defaultProps = {
  person: { uforehistorikker: null, uforehistorikkerIsLoading: false, loading: React.PropTypes.bool.isRequired },
};


export default connect(null, { fetchUforeHistorikk })(LastUforeHistorikk);
