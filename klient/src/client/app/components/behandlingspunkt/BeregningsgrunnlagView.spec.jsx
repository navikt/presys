import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import BeregningsgrunnlagView, { getModel } from './BeregningsgrunnlagView';

describe('<BeregningsgrunnlagView>', () => {
  const model = {
    beregnetTilkjentYtelse: 120000,
    satsVerdi: 60000,
    antallBarn: 2,
  };

  it('skal sette opp modell gitt behandling', () => {
    const behandling = {
      behandlingResultat: {
        beregnetTilkjentYtelse: 120000,
        satsVerdi: 60000,
        antallBarn: 2,
      },
    };
    const beregningModel = getModel(behandling);

    expect(beregningModel).to.eql(model);
  });

  it('skal vise props i form', () => {
    const wrapper = shallow(<BeregningsgrunnlagView model={model} />);

    const texts = wrapper.find('p');
    expect(texts).to.have.length(3);
    expect(texts.first().text()).to.eql('120000');
    expect(texts.at(1).text()).to.eql('2');
    expect(texts.last().text()).to.eql('60000');
  });
});
