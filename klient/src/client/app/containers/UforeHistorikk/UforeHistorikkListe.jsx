import React, { Component } from 'react';
import { connect } from 'react-redux';
import { Link } from 'react-router';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { injectIntl, intlShape } from 'react-intl';

import UforeHistorikk from './UforeHistorikk';

const uniqe = arrArg => arrArg.filter((elem, pos, arr) => arr.indexOf(elem) === pos);

class UforeHistorikkListe extends Component {

  constructor(props) {
    super(props);
    this.handleChange = this.handleChange.bind(this);
    this.urlForHistorikk = this.urlForHistorikk.bind(this);
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
    this.props.router.push(this.urlForHistorikk(event.target.value));
  }

  urlForHistorikk(uforeHistDato) {
    return this.props.location.pathname.replace(`${this.props.params.maaned}`, `${uforeHistDato}`);
  }


  render() {
    const { uforehistorikker, params: { maaned }, intl } = this.props;
    const selectedMonth = maaned || uforehistorikker[uforehistorikker.length - 1].uftMaaned.toString();
    const maanedliste = uniqe(uforehistorikker.map(i => i.uftMaaned)).sort((a, b) => b - a);
    const selectedIndex = maanedliste.findIndex(i => i.toString() === selectedMonth);

    return (<div><Row>
      <Column size={2}>
        <select value={selectedMonth} onChange={this.handleChange}>
          {maanedliste.map(i => <option
            key={i}
            value={i.toString()}
          >
            {intl.formatDate(new Date(i / 10000, ((i % 10000) / 100) - 1), { year: 'numeric', month: 'long' })}
          </option>)
          }
        </select>
      </Column>
    </Row>
      <Row>
        <Column size={1}>
          {selectedIndex > 0 ? <Link
            href={`#${this.urlForHistorikk(maanedliste[selectedIndex - 1].toString())}`}
          > &lt;nyere</Link> : null}
        </Column>
        <Column size={1}>
          {selectedIndex < maanedliste.length - 1 ? <Link
            href={`#${
                   this.urlForHistorikk(maanedliste[selectedIndex + 1].toString())}`}
          > eldre&gt;</Link> : null}
        </Column>
        <Column size={10}>
          {uforehistorikker.filter(i => i.uftMaaned === parseInt(maaned, 10)).map(uforehistorikk =>
            <UforeHistorikk {...uforehistorikk} key={uforehistorikk.uftMaaned} />) }
        </Column>


      </Row></div>);
  }
}


UforeHistorikkListe.propTypes = {
  uforehistorikker: React.PropTypes.arrayOf(React.PropTypes.shape({ uftMaaned: React.PropTypes.number.isRequired })),
  params: React.PropTypes.shape({
    maaned: React.PropTypes.string,
  }).isRequired,
  location: React.PropTypes.shape({ pathname: React.PropTypes.string.isRequired }).isRequired,
  router: React.PropTypes.shape({ push: React.PropTypes.func.isRequired, replace: React.PropTypes.func.isRequired }).isRequired,
  intl: intlShape.isRequired,
};

UforeHistorikkListe.defaultProps = {
  params: {
    maaned: null,
  },
  uforehistorikker: [],
};

export default connect(state => ({
  uforehistorikker: state.person.status[0].uforehistorikk,
}), { })(injectIntl(UforeHistorikkListe));
