import React from 'react';

import H2 from 'elements/H2';
import Person from './Person';

const state = [{ navn: 'Lars Erik', alder: 31, personnummer: '123', erKvinne: false },
{ navn: 'Bernt Halseide', alder: 73, personnummer: '321', erKvinne: true }];

const connector = (props) => {
  const person = state.find(item => item.personnummer === props.params.fnr);
  return person ? (
    <Person navn={person.navn} alder={person.alder} personnummer={person.personnummer} erKvinne={person.erKvinne} hasLargeFont={false} />
    ) : <H2 textCode="FagsakSearch.ZeroSearchResults" />;
};

connector.propTypes = {
  params: React.PropTypes.shape({ fnr: React.PropTypes.string.isRequired }).isRequired,
};


export default connector;
