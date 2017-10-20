import React, { Component } from 'react';
import fetchPerson from 'actions/fetchPerson';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { connect } from 'react-redux';
import Person from 'components/person/Person';
import { Menu, MenuItem } from 'components/app/Menu';
import MainContent from 'components/app/MainContent';

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
    const { person, children, params: { fnr }, route: { path }, router: { replace } } = this.props;

    if (!person.fnr || !fnr) {
      return null;
    } else if (person.loading) {
      return <div>loading</div>;
    }

    const pageRoot = `/${this.props.route.path.replace(':fnr', fnr)}`;

    if (!children) {
      replace(`${pageRoot}/uforehistorikk`);
    }
    const menuItems = this.props.route.childRoutes
    .map(({ path: childPath }) => <MenuItem
      key={`${pageRoot}/${childPath}`}
      link={`${pageRoot}/${childPath}`}
      textcode={`link.to.${childPath}`}
    />);

    const personLocation = path.replace(':fnr', fnr);

    return (
      <div>
        <MainContent>

          <Row>
            <Column size={3}>
              <Person
                navn={person.navn}
                alder={person.alder}
                personnummer={person.fnr}
                erKvinne={parseInt(person.fnr.charAt(8), 10) % 2 === 0}
                hasLargeFont={false}
              />
            </Column>
          </Row>
          <Row>
            <Column size={12}>
              <Menu>{menuItems}</Menu>
            </Column>
          </Row>
        </MainContent>
        <Row>
          <Column size={12}>
            {React.Children.map(children,
              child => React.cloneElement(child, {
                fnr, parentLocation: personLocation,
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
    childRoutes: React.PropTypes.arrayOf(React.PropTypes.shape({
      path: React.PropTypes.string.isRequired,
    })).isRequired,
  }).isRequired,
  router: React.PropTypes.shape({ replace: React.PropTypes.func.isRequired }).isRequired,

};


PersonFraFnr.defaultProps = {
  children: [],
};

export default connect(state => ({
  person: state.person,
}), { fetchPerson })(PersonFraFnr);
