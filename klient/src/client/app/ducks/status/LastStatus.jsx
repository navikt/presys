import React from 'react';
import { connect } from 'react-redux';

import { fetch } from './duck';
import Dataview from './StatusListe';
import LastData from '../common/LastData';

const ConnectedLastData = connect(state => ({ idShowing: state.status.fnr, loading: state.status.loading }),
 { fetch })(LastData);

const Last = ({ fnr, data, ...rest }) => (
  <ConnectedLastData idToShow={fnr}>
    <Dataview {...rest} status={data} />
  </ConnectedLastData>);


Last.propTypes = {
  fnr: React.PropTypes.string.isRequired,
  data: React.PropTypes.arrayOf(React.PropTypes.object),
};

Last.defaultProps = {
  data: [],
};


export default connect(state => ({ data: state.status.data }), {})(Last);
