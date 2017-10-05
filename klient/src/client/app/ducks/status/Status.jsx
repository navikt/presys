import React from 'react';
import StatusSegment from './StatusSegment';
import YrkesskadePensjon from '../yrkesskadepensjon/YrkesskadePensjon';
import YrkesskadeHistorikk from '../yrkesskadehistorikk/YrkesskadeHistorikk';
import AfpHistorikk from '../afphistorikk/AfpHistorikk';
import Alderspensjon from '../alderspensjon/Alderspensjon';
import EtterlattBarn from '../etterlattbarn/EtterlattBarn';
import EtterlattEktefelle from '../etterlattektefelle/EtterlattEktefelle';
import SpesielleOpplysninger from '../spesielleOpplysninger/SpesielleOpplysninger';
import EosInfo from '../eosinfo/EosInfo';


import Tilknytning from '../tilknytning/Tilknytning';


import UforePensjon from '../uforepensjon/UforePensjon';

const renderIfExcist = (liste, Komponent) => <div>{liste.length === 1 ? <Komponent {...liste[0]} /> : null}</div>;

const Status = ({ yrkesskadepensjoner,
                  uforepensjoner,
                  statusKode,
                  tilknytninger,
                  alderspensjoner,
                  yrkesskadeHistorikker,
                  afpHistorikker,
                  etterlattEktefeller,
                  etterlattBarn,
                  eosInfoer,
                  spesielleOpplysningerer, ...status }) => (<div>
                    <StatusSegment {...status} statusKode={statusKode} />
                    {renderIfExcist(uforepensjoner, UforePensjon)}
                    {renderIfExcist(afpHistorikker, AfpHistorikk)}
                    {renderIfExcist(tilknytninger, Tilknytning)}
                    {renderIfExcist(alderspensjoner, Alderspensjon)}
                    {renderIfExcist(yrkesskadeHistorikker, YrkesskadeHistorikk)}
                    {renderIfExcist(etterlattEktefeller, EtterlattEktefelle)}
                    {renderIfExcist(etterlattBarn, EtterlattBarn)}
                    {renderIfExcist(eosInfoer, EosInfo)}
                    {renderIfExcist(yrkesskadepensjoner, YrkesskadePensjon)}
                    {renderIfExcist(spesielleOpplysningerer, SpesielleOpplysninger)}
                  </div>);

Status.propTypes = {
  yrkesskadepensjoner: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  statusKode: React.PropTypes.string.isRequired,
  uforehistorikk: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  uforepensjoner: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
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
