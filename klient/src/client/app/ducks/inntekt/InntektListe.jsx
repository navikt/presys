import React, { Component } from 'react';
import { connect } from 'react-redux';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import Inntekt, { inntektProptype } from './Inntekt';

const uniqe = arrArg => arrArg.filter((elem, pos, arr) => arr.indexOf(elem) === pos);

class InntektListe extends Component {

  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this);
  }


  componentDidMount() {
    const { inntekter, router: { replace }, params: { aar }, location: { pathname } } = this.props;
    if (!aar && inntekter.length > 0) {
      replace(`${pathname}/${inntekter[inntekter.length - 1].personInntektAar.toString()}`);
    }
  }

  componentWillReceiveProps(nextProps) {
    if (!nextProps.params.aar && nextProps.inntekter.length > 0) {
      nextProps.router.replace(`${nextProps.location.pathname}/${nextProps.inntekter[nextProps.inntekter.length - 1].personInntektAar.toString()}`);
    }
  }

  handleChange(event) {
    this.props.router.push(this.props.location.pathname.replace(`inntekter/${this.props.params.aar}`, `inntekter/${event.target.value}`));
  }

  render() {
    const { inntekter, params: { aar } } = this.props;
    const selectedYear = aar || inntekter[inntekter.length - 1].personInntektAar.toString();
    return (<Row>
      <Column size={2}>
        <select value={selectedYear} onChange={this.handleChange}>
          {uniqe(inntekter.map(i => i.personInntektAar)).sort((a, b) => b - a).map(i => <option
            key={i}
            value={i.toString()}
          >
            {i.toString()}
          </option>)}
        </select>
      </Column>
      <Column size={8}>
        {inntekter.filter(i => i.personInntektAar === parseInt(aar, 10)).map(inntekt => <Inntekt key={inntekt.personInntektType} {...inntekt} />) }
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
  router: React.PropTypes.shape({ push: React.PropTypes.func.isRequired, replace: React.PropTypes.func.isRequired }).isRequired,

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
