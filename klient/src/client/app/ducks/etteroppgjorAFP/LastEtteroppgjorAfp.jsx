import React from 'react';
import { connect } from 'react-redux';

import { fetch } from './duck';
import Dataview from './EtteroppgjorAfpListe';
import LastData from '../common/LastData';

const LastEtteroppgjorAfp = ({ substate, fnr, fetchData, ...rest }) => (
  <LastData idToShow={fnr} idShowing={substate.fnr} loading={substate.loading} fetch={fetchData}>
    <Dataview {...rest} etteroppgjor={substate.data} />
  </LastData>);


LastEtteroppgjorAfp.propTypes = {
  fnr: React.PropTypes.string.isRequired,
  substate: React.PropTypes.shape({
    fnr: React.PropTypes.string,
    data: React.PropTypes.arrayOf(React.PropTypes.object),
    loading: React.PropTypes.bool,
  }).isRequired,
  fetchData: React.PropTypes.func.isRequired,
};


export default connect(state => ({ substate: state.afpEtteroppgjor }), { fetchData: fetch })(LastEtteroppgjorAfp);
