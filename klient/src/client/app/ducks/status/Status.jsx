import React from 'react';
import PrettyJson from 'components/elements/PrettyJson';
import UforeHistorikk from '../uforehistorikk/UforeHistorikk';
import YrkesskadePensjon from '../yrkesskadepensjon/YrkesskadePensjon';
import UforePensjon from '../uforepensjon/UforePensjon';

const renderIfExcist = (liste, Komponent) => <div>{liste.length === 1 ? <Komponent {...liste[0]} /> : null}</div>;

const Status = ({ yrkesskadepensjoner,
                  uforehistorikk,
                  uforepensjoner,
                  statusKode,
                  tilknytninger,
                  alderspensjoner,
                  yrkesskadeHistorikker,
                  afpHistorikker,
                  etterlattEktefeller,
                  etterlattBarn,
                  eosInfoer,
                  spesielleOpplysningerer, ...status }) => <div>
                    <h1>{statusKode}</h1>
                    <PrettyJson data={status} />

                    {uforepensjoner.length > 0 ? <div>&nbsp;<h4>Uforepensjon</h4></div> : null}
                    {renderIfExcist(uforepensjoner, UforePensjon)}

                    {afpHistorikker.length > 0 ? <div>&nbsp;<h4>AFP-historikk</h4></div> : null}
                    {renderIfExcist(afpHistorikker, props => <PrettyJson data={props} />)}

                    {tilknytninger.length > 0 ? <div>&nbsp;<h4>Tilknytninger</h4></div> : null}
                    {renderIfExcist(tilknytninger, props => <PrettyJson data={props} />)}

                    {alderspensjoner.length > 0 ? <div>&nbsp;<h4>Alderspensjon</h4></div> : null}
                    {renderIfExcist(alderspensjoner, props => <PrettyJson data={props} />)}

                    {yrkesskadeHistorikker.length > 0 ? <div>&nbsp;<h4>Yrkesskadehistorikk</h4></div> : null}
                    {renderIfExcist(yrkesskadeHistorikker, props => <PrettyJson data={props} />)}

                    {etterlattEktefeller.length > 0 ? <div>&nbsp;<h4>Etterlatt ektefeller</h4></div> : null}
                    {renderIfExcist(etterlattEktefeller, props => <PrettyJson data={props} />)}

                    {etterlattBarn.length > 0 ? <div>&nbsp;<h4>Etterlatt barn</h4></div> : null}
                    {renderIfExcist(etterlattBarn, props => <PrettyJson data={props} />)}

                    {eosInfoer.length > 0 ? <div>&nbsp;<h4>EØS-info</h4></div> : null}
                    {renderIfExcist(eosInfoer, props => <PrettyJson data={props} />)}

                    {spesielleOpplysningerer.length > 0 ? <div>&nbsp;<h4>Spesielle opplysninger</h4></div> : null}
                    {renderIfExcist(spesielleOpplysningerer, props => <PrettyJson data={props} />)}

                    {uforehistorikk.map(element => <UforeHistorikk key={element.uftMaaned} {...element} />)}

                    {yrkesskadepensjoner.length > 0 ? <div>&nbsp;<h4>Yrkesskadepensjon</h4></div> : null}
                    {renderIfExcist(yrkesskadepensjoner, YrkesskadePensjon)}
                  </div>;

Status.propTypes = {
  yrkesskadepensjoner: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  statusKode: React.PropTypes.string.isRequired,
  uforehistorikk: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  uforepensjoner: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  eosInfo: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  tilknytninger: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  alderspensjoner: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  yrkesskadeHistorikker: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  afpHistorikker: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  etterlattEktefeller: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  etterlattBarn: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  eosInfoer: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  spesielleOpplysningerer: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
};

export default Status;
