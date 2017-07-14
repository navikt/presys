import React from 'react';
import { connect } from 'react-redux';

import { fetch } from './duck';
import Dataview from './InntektTabell';
import LastData from '../common/LastData';

const LastInntekter = ({ substate, fnr, fetchData, ...rest }) => (
  <LastData idToShow={fnr} idShowing={substate.fnr} loading={substate.loading} fetch={fetchData}>
    <Dataview {...rest} inntekter={substate.data} />
  </LastData>);


LastInntekter.propTypes = {
  fnr: React.PropTypes.string.isRequired,
  substate: React.PropTypes.shape({
    fnr: React.PropTypes.string,
    data: React.PropTypes.arrayOf(React.PropTypes.object),
    loading: React.PropTypes.bool,
  }).isRequired,
  fetchData: React.PropTypes.func.isRequired,
};


export default connect(state => ({ substate: state.inntekter }), { fetchData: fetch })(LastInntekter);
