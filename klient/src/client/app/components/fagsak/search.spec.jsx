import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import Search from './Search';

describe('<Search>', () => {
  it('skal ha et soekefelt', () => {
    const wrapper = shallow(<Search
      searchString=""
      searchFagsakCallback={sinon.spy()}
      setSearchStringCallback={sinon.spy()}
    />);

    expect(wrapper.find('TextField')).to.have.length(1);
  });

  it('skal ha en soekeknapp', () => {
    const wrapper = shallow(<Search
      searchString=""
      searchFagsakCallback={sinon.spy()}
      setSearchStringCallback={sinon.spy()}
    />);
    expect(wrapper.find('Button')).to.have.length(1);
  });

  it('skal utføre endring av søkestreng i store når bruker endrer verdi i tekstfelt', () => {
    let searchTextFieldValue = '';
    const changeStringFunction = text => searchTextFieldValue = text;
    const wrapper = shallow(<Search
      searchString=""
      setSearchStringCallback={changeStringFunction}
      searchFagsakCallback={sinon.spy()}
    />);

    expect(searchTextFieldValue).to.eql('');
    wrapper.find('TextField').simulate('change', { target: { value: 'fagsak123' } });
    expect(searchTextFieldValue).to.eql('fagsak123');
  });

  it('skal utføre søk når en står i tekstfelt og trykker enter', () => {
    const searchFagsak = sinon.spy();
    const wrapper = shallow(<Search
      searchString=""
      setSearchStringCallback={sinon.spy()}
      searchFagsakCallback={searchFagsak}
    />);

    wrapper.find('TextField').simulate('keyDown', { key: 'Enter' });
    expect(searchFagsak).to.have.property('callCount', 1);
  });

  it('skal ikke utføre søk når en står i tekstfelt og trykker space', () => {
    const searchFagsak = sinon.spy();
    const wrapper = shallow(<Search
      searchString=""
      setSearchStringCallback={sinon.spy()}
      searchFagsakCallback={searchFagsak}
    />);

    wrapper.find('TextField').simulate('keyDown', { key: ' ' });
    expect(searchFagsak).to.have.property('callCount', 0);
  });

  it('skal utføre søk når en trykker på søkeknapp', () => {
    const onButtonClick = sinon.spy();
    const wrapper = shallow(<Search
      searchString=""
      searchFagsakCallback={onButtonClick}
      setSearchStringCallback={sinon.spy()}
    />);

    wrapper.find('Button').simulate('click');

    expect(onButtonClick).to.have.property('callCount', 1);
  });
});
