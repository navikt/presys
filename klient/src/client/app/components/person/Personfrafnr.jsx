import React, { Component } from 'react';
import fetchPerson from 'actions/personActions';
import { connect } from 'react-redux';

import Person from './Person';

class PersonFraFnr extends Component {

  componentDidMount() {
    this.props.fetchPerson(this.props.params.fnr);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.params.fnr !== this.props.params.fnr) {
      this.props.fetchPerson(nextProps.params.fnr);
    }
  }

  render() {
    const { person } = this.props;
    if (!person.fnr) {
      return null;
    } else if (person.loading) {
      return <div>loading</div>;
    }
    return (<Person
      navn={person.navn}
      alder={person.alder}
      personnummer={person.fnr}
      erKvinne={person.kjonn === 'KVINNE'}
      erGift={person.sivilStatus === 'GIFT'}
      erSamboer={person.sivilStatus === 'SAMBOER'}
      erEnslig={person.sivilStatus === 'ENSLIG'}
      erPartner={person.sivilStatus === 'PARTNER'}
      hasLargeFont={false}
    />);
  }
}

PersonFraFnr.propTypes = {
  person: React.PropTypes.shape({
    // fnr: React.PropTypes.string.isRequired,
    loading: React.PropTypes.bool.isRequired,
  }).isRequired,
  fetchPerson: React.PropTypes.func.isRequired,
  params: React.PropTypes.shape({ fnr: React.PropTypes.string.isRequired }).isRequired,

};

export default connect(state => ({
  person: state.person,
}), { fetchPerson })(PersonFraFnr);
