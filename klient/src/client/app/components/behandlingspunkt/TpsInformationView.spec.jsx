import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import TpsInformationView, { getModel } from './TpsInformationView';

describe('<TpsInformationView>', () => {
  const model = {
    fodselsdato: '15.10.2017',
    antallBarn: 2,
  };

  it('skal sette opp modell gitt behandling', () => {
    const behandling = {
      tpsData: {
        fodselsdato: '15.10.2017',
        antallBarn: 2,
      },
    };
    const tpsInfoModel = getModel(behandling);

    expect(tpsInfoModel).to.eql(model);
  });

  it('skal vise props i form', () => {
    const wrapper = shallow(<TpsInformationView model={model} />);

    const foedselsdatoSoeknadDateLabel = wrapper.find('DateLabel');
    expect(foedselsdatoSoeknadDateLabel).to.have.length(1);
    expect(foedselsdatoSoeknadDateLabel.prop('dateString')).to.eql('15.10.2017');

    const numberOfChildren = wrapper.find('p');
    expect(numberOfChildren).to.have.length(1);
    expect(numberOfChildren.text()).to.eql('2');
  });
});
