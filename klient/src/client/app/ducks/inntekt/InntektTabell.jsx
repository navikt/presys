import Table from 'components/elements/Table';
import React from 'react';

const formatRappdate = (rappdate) => {
  if (!rappdate) {
    return '';
  }
  const asString = rappdate.toString();
  return `${asString.slice(0, 4)} ${asString.slice(4)}`;
};

const formatPersoninntekt = (personinntekt) => {
  if (!personinntekt) {
    return '';
  }
  const piString = personinntekt.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ' ');
  return piString;
};

export const InntektListe = ({ inntekter }) => <div>{!inntekter ? null : <Table
  headerTextCodes={[
    {
      textCode: 'Inntekt.Aar',
    },
    {
      textCode: 'Kommune',
    },
    {
      textCode: 'Type',
    },
    {
      textCode: 'Inntekt.Pensjonsgivende',
      classNameTd: 'hoyreJustertKolonne',
    },
    {
      textCode: 'Inntekt.Rapporteringsdato',
      classNameTd: 'midtJustertKolonne',
    }]}
  data={inntekter.sort((a, b) => b.personInntektAar - a.personInntektAar).map((row, i) => ({ key: i,
    columns: [
          { key: '0', value: row.personInntektAar },
          { key: '1', value: row.kommune },
          { key: '2', value: row.personInntektType },
          { key: '3', value: formatPersoninntekt(row.personInntekt), classNameTd: 'hoyreJustertKolonne' },
          { key: '4', value: formatRappdate(row.rapporteringsDato), classNameTd: 'midtJustertKolonne' },
    ] }))}
/>
        }</div>;

InntektListe.propTypes = {
  inntekter: React.PropTypes.arrayOf(React.PropTypes.object),
};

InntektListe.defaultProps = {
  inntekter: [],
};

export default InntektListe;
