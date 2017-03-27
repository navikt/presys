import React, { Component } from 'react';
import fetchPerson from 'actions/personActions';
import { connect } from 'react-redux';

import Person from './Person';


// connector.propTypes = {
//  params: React.PropTypes.shape({ fnr: React.PropTypes.string.isRequired }).isRequired,
// };

class PersonFraFnr extends Component {

  constructor(props) {
    super(props);
    props.fetchPerson(props.params.fnr);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.params.fnr !== nextProps.person.fnr) {
      this.props.fetchPerson(nextProps.params.fnr);
    }
  }

  render() {
    const person = this.props.person;
    return (<Person
      navn={person.navn}
      alder={person.alder}
      personnummer={person.fnr}
      erKvinne={person.kjonn === 'KVINNE'}
      hasLargeFont={false}
    />);
  }
}

PersonFraFnr.propTypes = {
  person: React.PropTypes.shape({
    fnr: React.PropTypes.string.isRequired,
  }).isRequired,
  fetchPerson: React.PropTypes.func.isRequired,
  params: React.PropTypes.shape({ fnr: React.PropTypes.string.isRequired }).isRequired,

};


export default connect(state => ({
  person: state.person,
}), { fetchPerson })(PersonFraFnr);
