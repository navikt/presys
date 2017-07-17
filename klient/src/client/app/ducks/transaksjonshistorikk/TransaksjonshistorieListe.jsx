import React, { Component } from 'react';
import { Link } from 'react-router';
import { FormattedMessage } from 'react-intl';

import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { DsfDate } from 'components/elements/ParseDate';
import { MonthInYear } from 'components/elements/FormattedDate';
import Grunnblankett from './Grunnblankett';
import TransInfo from './Transaksjonshistorikk';


class TransaksjonshistorieListe extends Component {

  constructor(props) {
    super(props);
    this.urlForTranshist = this.urlForTranshist.bind(this);
    this.syncUrlWithState = this.syncUrlWithState.bind(this);
  }

  componentDidMount() {
    this.syncUrlWithState(this.props);
  }

  componentWillReceiveProps(nextProps) {
    this.syncUrlWithState(nextProps);
  }

  syncUrlWithState(props) {
    const { transaksjonshistorie, params: { vtpkey } } = props;
    const { router: { replace } } = this.props;
    if (transaksjonshistorie.length > 0) {
      if (parseInt(vtpkey, 10) >= transaksjonshistorie.length) {
        replace(this.urlForTranshist(null));
      }
    } else if (vtpkey) {
      replace(this.urlForTranshist(null));
    }
  }

  urlForTranshist(transhist) {
    return transhist ? `/${this.props.parentLocation}/transaksjonshistorikk/${transhist}` : this.props.parentLocation;
  }


  render() {
    const { transaksjonshistorie, params: { vtpkey } } = this.props;

    if (!transaksjonshistorie || transaksjonshistorie.length === 0) {
      return <p>Finner ingen</p>;
    }

    if (!vtpkey) {
      return (<Row>
        <Column size={12}>
          <ul>
            {transaksjonshistorie.map((g, i) => <li><Link href={`#${this.urlForTranshist(i.toString())}`}>
              {g.grunnblankettkode} med virkningsdato <DsfDate value={g.virkningsdato}><MonthInYear /></DsfDate></Link></li>)}
          </ul>
        </Column>
      </Row>);
    }

    const selectedIndex = parseInt(vtpkey, 10);

    return (<div><Row>
      <Column size={12}>
        <b>Grunnblankett {selectedIndex + 1}: {transaksjonshistorie.length} </b>
      </Column>
    </Row>
      <Row>
        <Column size={12}>
          {transaksjonshistorie[selectedIndex].grunnblankettkode}:
              <FormattedMessage
                id={`kodeverk.grunnblankettType.${transaksjonshistorie[selectedIndex].grunnblankettkode}`}
              />
        </Column>
      </Row>
      <Row>
        <Column size={1}>
          {selectedIndex > 0 ? <Link
            href={`#${this.urlForTranshist((selectedIndex - 1).toString())}`}
          > &#8678;nyere</Link> : <span>&#8678;nyere</span>}
        </Column>
        <Column size={1}>
          {selectedIndex < transaksjonshistorie.length - 1 ? <Link
            href={`#${
                   this.urlForTranshist((selectedIndex + 1).toString())}`}
          > eldre&#8680;</Link> : <span>eldre&#8680;</span>}
        </Column>
      </Row>

      <Row>
        <Column size={12}>
          <TransInfo {...transaksjonshistorie[selectedIndex]} />
        </Column>

      </Row>

      <Row>
        <Column size={12}>
          <Grunnblankett
            type={transaksjonshistorie[selectedIndex].grunnblankettkode}
            {...transaksjonshistorie[selectedIndex].grunnblankett}
          />
        </Column>
      </Row>

    </div>);
  }
}


TransaksjonshistorieListe.propTypes = {
  transaksjonshistorie: React.PropTypes.arrayOf(React.PropTypes.object),
  params: React.PropTypes.shape({
    maaned: React.PropTypes.string,
  }).isRequired,
  router: React.PropTypes.shape({ push: React.PropTypes.func.isRequired, replace: React.PropTypes.func.isRequired }).isRequired,
  parentLocation: React.PropTypes.string.isRequired,
};

TransaksjonshistorieListe.defaultProps = {
  transaksjonshistorie: [],
  params: {
    vptkey: null,
  },
};

export default TransaksjonshistorieListe;
