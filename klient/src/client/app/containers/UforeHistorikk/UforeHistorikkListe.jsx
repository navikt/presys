import React, { Component } from 'react';
import { connect } from 'react-redux';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import UforeHistorikk from './UforeHistorikk';

const uniqe = arrArg => arrArg.filter((elem, pos, arr) => arr.indexOf(elem) === pos);

class UforeHistorikkListe extends Component {

  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this);
  }


  componentDidMount() {
    const { uforehistorikker, router: { replace }, params: { maaned }, location: { pathname } } = this.props;
    if (!maaned && uforehistorikker.length > 0) {
      replace(`${pathname}/${uforehistorikker[uforehistorikker.length - 1].uftMaaned.toString()}`);
    }
  }

  componentWillReceiveProps(nextProps) {
    if (!nextProps.params.maaned && nextProps.uforehistorikker.length > 0) {
      nextProps.router.replace(`${nextProps.location.pathname}/${nextProps.uforehistorikker[nextProps.uforehistorikker.length - 1].uftMaaned.toString()}`);
    }
  }

  handleChange(event) {
    this.props.router.push(this.props.location.pathname.replace(`uforehistorikk/${this.props.params.maaned}`, `uforehistorikk/${event.target.value}`));
  }

  render() {
    const { uforehistorikker, params: { maaned } } = this.props;
    const selectedMonth = maaned || uforehistorikker[uforehistorikker.length - 1].uftMaaned.toString();
    return (<Row>
      <Column size={2}>
        <select value={selectedMonth} onChange={this.handleChange}>
          {uniqe(uforehistorikker.map(i => i.uftMaaned)).sort((a, b) => b - a).map(i => <option
            key={i}
            value={i.toString()}
          >
            {i.toString()}
          </option>)}
        </select>
      </Column>
      <Column size={8}>
        {uforehistorikker.filter(i => i.uftMaaned === parseInt(maaned, 10)).map(uforehistorikk =>
          <UforeHistorikk {...uforehistorikk} key={uforehistorikk.uftMaaned} />) }
      </Column>
    </Row>);
  }
}


UforeHistorikkListe.propTypes = {
  uforehistorikker: React.PropTypes.arrayOf(React.PropTypes.shape({ uftMaaned: React.PropTypes.number.isRequired })),
  params: React.PropTypes.shape({
    maaned: React.PropTypes.string,
  }).isRequired,
  location: React.PropTypes.shape({ pathname: React.PropTypes.string.isRequired }).isRequired,
  router: React.PropTypes.shape({ push: React.PropTypes.func.isRequired, replace: React.PropTypes.func.isRequired }).isRequired,

};

UforeHistorikkListe.defaultProps = {
  params: {
    maaned: null,
  },
  uforehistorikker: [],
};

export default connect(state => ({
  uforehistorikker: state.person.status[0].uforehistorikk,
}), { })(UforeHistorikkListe);
