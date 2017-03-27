import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';
import sinon from 'sinon';

import DateTimeLabel from 'elements/DateTimeLabel';
import DocumentList from './DocumentList';

describe('<DocumentList>', () => {
  it('skal vise to dokumenter i liste', () => {
    const document = {
      journalpostId: '1',
      dokumentId: '1',
      dokumentType: 'Terminbekreftelse',
      tidspunkt: '0405198632231',
    };

    const anotherDocument = {
      journalpostId: '2',
      dokumentId: '2',
      dokumentType: 'Førstegangssøknad',
      tidspunkt: '0405198632231',
    };

    const wrapper = shallow(<DocumentList
      documents={[document, anotherDocument]}
      selectDocumentCallback={sinon.spy()}
    />);

    const label = wrapper.find('Label');
    expect(label).to.have.length(0);

    const table = wrapper.find('Table');
    expect(table).to.have.length(1);
    expect(table.prop('data')).to.eql([{
      key: 1,
      model: document,
      columns: [{
        key: '1-1',
        value: '',
      }, {
        key: '1-2',
        value: 'Terminbekreftelse',
      }, {
        key: '1-3',
        value: <DateTimeLabel dateTimeString="0405198632231" />,
      },
      ],
    }, {
      key: 2,
      model: anotherDocument,
      columns: [{
        key: '2-1',
        value: '',
      }, {
        key: '2-2',
        value: 'Førstegangssøknad',
      }, {
        key: '2-3',
        value: <DateTimeLabel dateTimeString="0405198632231" />,
      },
      ],
    }]);
  });

  it('skal ikke vise tabell når det ikke finnes dokumenter', () => {
    const wrapper = shallow(<DocumentList
      documents={[]}
      selectDocumentCallback={sinon.spy()}
    />);

    const label = wrapper.find('Label');
    expect(label).to.have.length(1);
    const table = wrapper.find('Table');
    expect(table).to.have.length(0);
  });
});
