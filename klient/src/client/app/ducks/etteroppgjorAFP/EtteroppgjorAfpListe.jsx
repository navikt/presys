import React from 'react';
import Table from 'components/elements/Table';

const EtteroppgjorAfpListe = ({ etteroppgjor }) => <Table
  headerTextCodes={['Inntekt.Aar',
    'PGI',
    'AFP.Inntekt_pre_Uttak',
    'AFP.IFU.fraDsfInfotrygd',
    'AFP.Inntekt_etter_opphor',
    'AFP.IEO.fraDsfInfotrygd',
    'AFP.Inntekt_i_perioden',
    'AFP.Infotrygd.Beregnet_eller_registrert',
    'Oppgitt framtidig inntekt',
    'Tidligere inntekt',
    '100% AFP i avregningsperioden',
    'Faktisk utbetalt',
    'Differanse for mye utbetalt',
    'Differanse for lite utbealt']}
  data={etteroppgjor.map(row => ({ key: row.inntektsAar,
    columns: [
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
/>;

EtteroppgjorAfpListe.propTypes = {
  etteroppgjor: React.PropTypes.arrayOf(React.PropTypes.object),
};

EtteroppgjorAfpListe.defaultProps = {
  etteroppgjor: [],
};

export default EtteroppgjorAfpListe;
