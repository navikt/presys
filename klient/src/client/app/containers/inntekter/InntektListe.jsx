import React, { Component } from 'react';
import { connect } from 'react-redux';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { Menu, TextMenuItem as MenuItem } from 'components/app/Menu';

import Inntekt, { inntektProptype } from './Inntekt';

const uniqe = arrArg => arrArg.filter((elem, pos, arr) => arr.indexOf(elem) === pos);

class InntektListe extends Component {

  componentDidMount() {
    const { inntekter, router: { push }, params: { aar }, location: { pathname } } = this.props;
    if (!aar && inntekter.length > 0) {
      push(`${pathname}/${inntekter[inntekter.length - 1].personInntektAar.toString()}`);
    }
  }

  componentWillReceiveProps(nextProps) {
    if (!nextProps.params.aar && nextProps.inntekter.length > 0) {
      nextProps.router.push(`${nextProps.location.pathname}/${nextProps.inntekter[nextProps.inntekter.length - 1].personInntektAar.toString()}`);
    }
  }

  render() {
    const { inntekter, location: { pathname }, params: { aar } } = this.props;
    const pageRoot = aar ? pathname.replace(aar.toString(), '') : `${pathname}/`;// `/${location.path.replace(':fnr', fnr)}`;

    return (<Row><Column size={1}>
      <Menu>
        {uniqe(inntekter.map(i => i.personInntektAar)).sort((a, b) => b - a).map(i => <MenuItem
          key={`${pageRoot}${i}`}
          link={`${pageRoot}${i}`}
          text={i.toString()}
        />)}

      </Menu>
    </Column>
      <Column size={9}>
        {inntekter.filter(i => i.personInntektAar === parseInt(aar, 10)).map(inntekt => <Inntekt {...inntekt} />) }
      </Column>
    </Row>);
  }
}


InntektListe.propTypes = {
  inntekter: React.PropTypes.arrayOf(React.PropTypes.shape(inntektProptype)),
  params: React.PropTypes.shape({
    aar: React.PropTypes.string,
  }).isRequired,
  location: React.PropTypes.shape({ pathname: React.PropTypes.string.isRequired }).isRequired,
  router: React.PropTypes.shape({ push: React.PropTypes.func.isRequired }).isRequired,

};

InntektListe.defaultProps = {
  params: {
    aar: null,
  },
  inntekter: [],
};

export default connect(state => ({
  inntekter: state.person.inntekter,
}), { })(InntektListe);
