import React, { Component } from 'react';
import fetchPerson from 'actions/personActions';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { connect } from 'react-redux';
import Person from 'components/person/Person';
// import { Menu, MenuItem } from 'components/app/Menu';

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
    const { person, children /* , params: { fnr }*/ } = this.props;
    if (!person.fnr) {
      return null;
    } else if (person.loading) {
      return <div>loading</div>;
    }
    /* const pageRoot = `/${this.props.route.path.replace(':fnr', fnr)}`;
     const menuItems = this.props.route.childRoutes
    .map(({ path }) => <MenuItem
      key={`${pageRoot}/${path}`}
      link={`${pageRoot}/${path}`}
      textcode={`link.to.${path}`}
    />);*/

    return (<div><Row><Column size={3}><Person
      navn={person.navn}
      alder={person.alder}
      personnummer={person.fnr}
      erKvinne={parseInt(person.fnr.charAt(8), 10) % 2 === 0}
      hasLargeFont={false}
    />

      {/* <Menu>
        {menuItems}
      </Menu>*/}
    </Column>
      <Column size={9}>
        {children}
      </Column></Row></div>);
  }
}

PersonFraFnr.propTypes = {
  person: React.PropTypes.shape({
    loading: React.PropTypes.bool.isRequired,
  }).isRequired,
  fetchPerson: React.PropTypes.func.isRequired,
  params: React.PropTypes.shape({ fnr: React.PropTypes.string.isRequired }).isRequired,
  children: React.PropTypes.element,
 /* route: React.PropTypes.shape({
    path: React.PropTypes.string.isRequired,
    childRoutes: React.PropTypes.arrayOf(React.PropTypes.shape({
      path: React.PropTypes.string.isRequired,
    })).isRequired,
  }).isRequired,*/
};


PersonFraFnr.defaultProps = {
  children: [],
};

export default connect(state => ({
  person: state.person,
}), { fetchPerson })(PersonFraFnr);
