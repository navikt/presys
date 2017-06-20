import React, { Component } from 'react';
import fetchPerson from 'actions/personActions';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { connect } from 'react-redux';
import Person from 'components/person/Person';
// import { Menu, MenuItem } from 'components/app/Menu';

class PersonFraFnr extends Component {

  componentDidMount() {
    if (this.props.params.fnr && this.props.params.fnr !== this.props.person.fnr && !this.props.person.loading) {
      this.props.fetchPerson(this.props.params.fnr);
    }
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.params.fnr && nextProps.params.fnr !== nextProps.person.fnr && !nextProps.person.loading) {
      nextProps.fetchPerson(nextProps.params.fnr);
    }
  }

  render() {
    const { person, children, params: { fnr }, route: { path } } = this.props;

    if (!person.fnr) {
      return null;
    } else if (person.loading) {
      return <div>loading</div>;
    }

    const personLocation = path.replace(':fnr', fnr);

    return (<div><Row><Column size={3}><Person
      navn={person.navn}
      alder={person.alder}
      personnummer={person.fnr}
      erKvinne={parseInt(person.fnr.charAt(8), 10) % 2 === 0}
      hasLargeFont={false}
    />
    </Column>
      <Column size={9}>
        {React.Children.map(children,
              child => React.cloneElement(child, {
                person, parentLocation: personLocation,
              }),
             )}
      </Column></Row></div>);
  }
}

PersonFraFnr.propTypes = {
  person: React.PropTypes.shape({
    loading: React.PropTypes.bool.isRequired,
    fnr: React.PropTypes.string,
  }).isRequired,
  fetchPerson: React.PropTypes.func.isRequired,
  params: React.PropTypes.shape({ fnr: React.PropTypes.string.isRequired }).isRequired,
  children: React.PropTypes.element,
  route: React.PropTypes.shape({
    path: React.PropTypes.string.isRequired,
  }).isRequired,
};


PersonFraFnr.defaultProps = {
  children: [],
};

export default connect(state => ({
  person: state.person,
}), { fetchPerson })(PersonFraFnr);
