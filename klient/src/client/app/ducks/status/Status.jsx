import React from 'react';
import PrettyJson from 'components/elements/PrettyJson';
import UforeHistorikk from '../uforehistorikk/UforeHistorikk';
import YrkesskadePensjon from '../yrkesskadepensjon/YrkesskadePensjon';

const renderIfExcist = (liste, Komponent) => <div>{liste.length === 1 ? <Komponent {...liste[0]} /> : null}</div>;

const Status = ({ yrkesskadepensjoner, uforehistorikk, uforepensjoner, statusKode, ...status }) => <div>
  <h1>{statusKode}</h1>
  <PrettyJson data={status} />
  {renderIfExcist(uforepensjoner, props => <PrettyJson data={props} />)}
  {uforehistorikk.map(element => <UforeHistorikk key={element.uftMaaned} {...element} />)}
  {renderIfExcist(yrkesskadepensjoner, YrkesskadePensjon)}
</div>;

Status.propTypes = {
  yrkesskadepensjoner: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  statusKode: React.PropTypes.string.isRequired,
  uforehistorikk: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  uforepensjoner: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
};

export default Status;
