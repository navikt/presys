import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import TableRow from './TableRow';

describe('<TableRow>', () => {
  it('skal lage en rad og rendre children inne denne', () => {
    const mouseEventFunction = sinon.spy();
    const keyEventFunction = sinon.spy();
    const wrapper = shallow(<TableRow
      id={1}
      onMouseDown={mouseEventFunction}
      onKeyDown={keyEventFunction}
      tabIndex="0"
    >{[<td key="1" />]}</TableRow>);

    const row = wrapper.find('tr');
    expect(row).to.have.length(1);
    expect(wrapper.find('td')).to.have.length(1);

    expect(row.prop('tabIndex')).to.eql('0');
  });

  it('skal trigge events ved museklikk og tasteklikk', () => {
    const mouseEventFunction = sinon.spy();
    const keyEventFunction = sinon.spy();
    const wrapper = shallow(<TableRow
      id={1}
      onMouseDown={mouseEventFunction}
      onKeyDown={keyEventFunction}
      tabIndex="0"
    >{[<td key="1" />]}</TableRow>);

    const row = wrapper.find('tr');
    row.simulate('mouseDown');
    expect(mouseEventFunction).to.have.property('callCount', 1);
    expect(keyEventFunction).to.have.property('callCount', 0);

    row.simulate('keyDown', { key: 'Enter', preventDefault: sinon.spy() });
    expect(keyEventFunction).to.have.property('callCount', 1);
    expect(mouseEventFunction).to.have.property('callCount', 1);
  });
});
