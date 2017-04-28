import React, { Component } from 'react';
import fetchPerson from 'actions/personActions';
import Table from 'components/elements/Table';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { connect } from 'react-redux';


import Person from 'components/person/Person';

class PersonFraFnr extends Component {

  componentDidMount() {
    this.props.fetchPerson(this.props.params.fnr);
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.params.fnr !== this.props.params.fnr) {
      this.props.fetchPerson(nextProps.params.fnr);
    }
  }

  render() {
    const { person } = this.props;
    if (!person.fnr) {
      return null;
    } else if (person.loading) {
      return <div>loading</div>;
    }
    return (<div><Row><Column size={4}><Person
      navn={person.navn}
      alder={person.alder}
      personnummer={person.fnr}
      erKvinne={person.kjonn === 'KVINNE'}
      erGift={person.sivilStatus === 'GIFT'}
      erSamboer={person.sivilStatus === 'SAMBOER'}
      erEnslig={person.sivilStatus === 'ENSLIG'}
      erPartner={person.sivilStatus === 'PARTNER'}
      hasLargeFont={false}
    />
    </Column>
      <Column size={14}>
        {!person.etteroppgjor ? null : <Table
          headerTextCodes={['Inntektsår',
            'Pensjonsgivende inntekt',
            'Inntekt før uttak av AFP',
            'Registert via DSF/Info',
            'Inntekt etter opphør',
            'Registert via DSF/Info',
            'Inntekt i AFP Perioden',
            'Beregnet eller reg via Infotrygd',
            'Oppgitt framtidig inntekt',
            'Tidligere inntekt',
            '100% AFP i avregningsperioden',
            'Faktisk utbetalt',
            'Differanse for mye utbetalt',
            'Differanse for lite utbealt',
            'Inntektsår',
            'Pensjonsgivende inntekt']}
          data={person.etteroppgjor.map(row => ({ columns: [
          { key: 'a', value: row.inntektsAar },
          { key: 'b', value: row.pensjonsgivendeInntekt },
          { key: 'c', value: row.inntektForUttakAvAFP },
          { key: 'd', value: row.registertViaDSFEllerInfotrygdIFU },
          { key: 'e', value: row.inntektEtterOpphor },
          { key: 'f', value: row.registertViaDSFEllerInfotrygdIEO },
          { key: 'g', value: row.inntektIAFPPerioden },
          { key: 'h', value: row.beregnetEllerRegistrertViaInfotrygd },
          { key: 'i', value: row.oppgittFramtidigInntekt },
          { key: 'j', value: row.tidligereInntekt },
          { key: 'k', value: row.fullAFPiAvregningsperioden },
          { key: 'l', value: row.faktiskUtbetalt },
          { key: 'm', value: row.differanseForMyeUtbetalt },
          { key: 'n', value: row.differanseForLiteUtbetalt },
          ] }))}
        />
        }
      </Column></Row></div>);
  }
}

PersonFraFnr.propTypes = {
  person: React.PropTypes.shape({
    // fnr: React.PropTypes.string.isRequired,
    loading: React.PropTypes.bool.isRequired,
  }).isRequired,
  fetchPerson: React.PropTypes.func.isRequired,
  params: React.PropTypes.shape({ fnr: React.PropTypes.string.isRequired }).isRequired,

};

export default connect(state => ({
  person: state.person,
}), { fetchPerson })(PersonFraFnr);
