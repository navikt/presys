import React from 'react';
import { shallow } from 'enzyme';
import { expect } from 'chai';

import EtteroppgjorAFP from './EtteroppgjorAFP';

describe('<EtteroppgjorAFP>', () => {
  it('skal inneholde etteroppgjorAFPinfo', () => {
    const wrapper = shallow(<EtteroppgjorAFP
      inntektsAar={1964}
      pensjonsgivendeInntekt={999999999}
      inntektForUttakAvAFP={999999999}
      registertViaDSFEllerInfotrygdIFU="A"
      inntektEtterOpphor={999999999}
      registertViaDSFEllerInfotrygdIEO="B"
      inntektIAFPPerioden={999999999}
      beregnetEllerRegistrertViaInfotrygd="C"
      oppgittFramtidigInntekt={7777777}
      tidligereInntekt={7777777}
      fullAFPiAvregningsperioden={7777777}
      faktiskUtbetalt={7777777}
      differanseForMyeUtbetalt={7777777}
      differanseForLiteUtbetalt={7777777}

    />);

    expect(wrapper.find('div')).to.have.length(2);
    expect(wrapper.find('img')).to.have.length(1);
    expect(wrapper.find('FormattedMessage')).to.have.length(1);
  });

  it('skal sjekke at props blir brukt korrekt', () => {
    const wrapper = shallow(<EtteroppgjorAFP
      inntektsAar={1964}
      pensjonsgivendeInntekt={123456789}
      inntektForUttakAvAFP={987654321}
      registertViaDSFEllerInfotrygdIFU="A"
      inntektEtterOpphor={900000000}
      registertViaDSFEllerInfotrygdIEO="B"
      inntektIAFPPerioden={1000000009}
      beregnetEllerRegistrertViaInfotrygd="C"
      oppgittFramtidigInntekt={1234567}
      tidligereInntekt={7654321}
      fullAFPiAvregningsperioden={1234568}
      faktiskUtbetalt={8654321}
      differanseForMyeUtbetalt={1234569}
      differanseForLiteUtbetalt={9654321}
    />);

    const h2 = wrapper.find('h2');
    expect(h2.text()).to.eql('1964 (123456789 <FormattedMessage />)'); //  se hva vi får
  });
});
