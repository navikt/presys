import { expect } from 'chai';

import { required, requiredWhen, minLength, maxLength } from './validators';
import { isRequiredMessage } from './messages';


describe('Validatorer', () => {
  it('skal ikke gi feilmelding når verdi ikke er tom', () => {
    expect(required('verdi')).is.null;
  });

  it('skal gi feilmelding når verdi er tom', () => {
    expect(required(' ')).to.eql(isRequiredMessage);
  });

  it('skal ikke gi feilmelding når verdi er tom og tilstand ikke er oppfylt', () => {
    const reqFunc = requiredWhen(context => context.isDirty);
    expect(reqFunc('', null, { isDirty: false })).is.null;
  });

  it('skal gi feilmelding når verdi er tom og tilstand er oppfylt', () => {
    const reqFunc = requiredWhen(context => context.isDirty);
    expect(reqFunc('', null, { isDirty: true })).to.eql(isRequiredMessage);
  });

  it('skal ikke gi feilmelding når verdi ikke er tom og tilstand er oppfylt', () => {
    const reqFunc = requiredWhen(context => context.isDirty);
    expect(reqFunc('verdi', null, { isDirty: true })).is.null;
  });

  it('skal gi feilmelding når verdi er mindre enn gitt grenseverdi', () => {
    const minFunc = minLength(3);
    expect(minFunc('12')).is.not.null;
  });

  it('skal ikke gi feilmelding når verdi har lengde lik gitt grenseverdi', () => {
    const minFunc = minLength(3);
    expect(minFunc('123')).is.null;
  });

  it('skal gi feilmelding når verdi er større enn gitt grenseverdi', () => {
    const maxFunc = maxLength(3);
    expect(maxFunc('1234')).is.not.null;
  });

  it('skal ikke gi feilmelding når verdi har lengde lik gitt grenseverdi', () => {
    const maxFunc = maxLength(3);
    expect(maxFunc('123')).is.null;
  });
});
