import React, { Component } from 'react';
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
    this.syncUrlWithState = this.syncUrlWithState.bind(this);
  }

  componentDidMount() {
    this.syncUrlWithState(this.props);
  }

  componentWillReceiveProps(nextProps) {
    this.syncUrlWithState(nextProps);
  }

  syncUrlWithState(props) {
    const { uforehistorikker, router: { replace }, params: { maaned } } = props;
    if (uforehistorikker.length > 0) {
      if (!maaned || !uforehistorikker.find(i => i.uftMaaned.toString() === maaned)) {
        replace(this.urlForHistorikk(uforehistorikker[uforehistorikker.length - 1].uftMaaned.toString()));
      }
    } else if (maaned) {
      replace(this.urlForHistorikk(null));
    }
  }

  handleChange(event) {
    this.props.router.push(this.urlForHistorikk(event.target.value));
  }

  urlForHistorikk(uforeHistDato) {
    return uforeHistDato ? `${this.props.parentLocation}/${uforeHistDato}` : this.props.parentLocation;
  }


  render() {
    const { uforehistorikker, params: { maaned }, intl } = this.props;
    if (!uforehistorikker || uforehistorikker.length === 0) {
      return <p>Finner ingen uførehistorikker</p>;
    }
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
  router: React.PropTypes.shape({ push: React.PropTypes.func.isRequired, replace: React.PropTypes.func.isRequired }).isRequired,
  intl: intlShape.isRequired,
  parentLocation: React.PropTypes.string.isRequired,
};

UforeHistorikkListe.defaultProps = {
  params: {
    maaned: null,
  },
  uforehistorikker: [],
};

export default injectIntl(UforeHistorikkListe);
