import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import FagsakSearch from './FagsakSearch';

describe('<FagsakSearch>', () => {
  it('skal kun vise søkefelt før søk er startet', () => {
    const setSearchStringFunction = sinon.spy();
    const searchFagsakFunction = sinon.spy();
    const wrapper = shallow(<FagsakSearch
      searchString="12345"
      fagsaker={[]}
      setSearchStringCallback={setSearchStringFunction}
      searchFagsakCallback={searchFagsakFunction}
      searchResultReceived={false}
      selectFagsakCallback={sinon.spy()}
    />);

    const searchComp = wrapper.find('Search');
    expect(searchComp).to.have.length(1);
    expect(wrapper.find('Label')).to.have.length(0);
    expect(wrapper.find('Person')).to.have.length(0);
    expect(wrapper.find('FagsakList')).to.have.length(0);

    expect(searchComp.prop('searchString')).is.eql('12345');
    expect(searchComp.prop('setSearchStringCallback')).is.eql(setSearchStringFunction);
    expect(searchComp.prop('searchFagsakCallback')).is.eql(searchFagsakFunction);
  });
});
