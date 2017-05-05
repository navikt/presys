import React, { Component } from 'react';

import { Link } from 'react-router';
import fetchPerson from 'actions/personActions';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { connect } from 'react-redux';
import Person from 'components/person/Person';

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
    const { person, children, params: { fnr }, location: { pathname } } = this.props;

    const pageRoot = `/person/${fnr}`;

    const menuItems = [
      { link: '', tekst: 'Start' },
      { link: '/inntekter', tekst: 'Inntekter' },
      { link: '/eoafp', tekst: 'AFP etteroppgjør' },
    ].map(({ link, tekst }) => <li key={link}> {pathname === pageRoot + link ? '>' : null} <Link to={pageRoot + link}>{tekst}</Link></li>);

    if (!person.fnr) {
      return null;
    } else if (person.loading) {
      return <div>loading</div>;
    }

    return (<div><Row><Column size={4}><Person
      navn={person.navn}
      alder={person.alder}
      personnummer={person.fnr}
      erKvinne={parseInt(person.fnr.charAt(8), 10) % 2 === 0}
      hasLargeFont={false}
    />
      <ul>
        {menuItems}
      </ul>
    </Column>
      <Column size={8}>
        {children}
      </Column></Row></div>);
  }
}

PersonFraFnr.propTypes = {
  person: React.PropTypes.shape({
    // fnr: React.PropTypes.string.isRequired,
    loading: React.PropTypes.bool.isRequired,
  }).isRequired,
  fetchPerson: React.PropTypes.func.isRequired,
  params: React.PropTypes.shape({ fnr: React.PropTypes.string.isRequired }).isRequired,
  children: React.PropTypes.element,
  location: React.PropTypes.shape({ pathname: React.PropTypes.string.isRequired }).isRequired,
};


PersonFraFnr.defaultProps = {
  children: [],
};

export default connect(state => ({
  person: state.person,
}), { fetchPerson })(PersonFraFnr);
