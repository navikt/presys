import React from 'react';
import { connect } from 'react-redux';

import { fetch } from './duck';
import Dataview from './TransaksjonshistorieTabell';
import LastData from '../common/LastData';

const ConnectedLastData = connect(state => ({ idShowing: state.transaksjonshistorikk.fnr, loading: state.transaksjonshistorikk.loading }),
 { fetch })(LastData);

const Last = ({ fnr, ...rest, data }) => (
  <ConnectedLastData idToShow={fnr}>
    <Dataview {...rest} transaksjonshistorie={data} />
  </ConnectedLastData>);


Last.propTypes = {
  fnr: React.PropTypes.string.isRequired,
  data: React.PropTypes.arrayOf(React.PropTypes.object),
};

Last.defaultProps = {
  data: [],
};


export default connect(state => ({ data: state.transaksjonshistorikk.data }), {})(Last);
