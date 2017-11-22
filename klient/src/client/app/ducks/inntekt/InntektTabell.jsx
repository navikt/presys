import Table from 'components/elements/Table';
import React from 'react';

const formatRappdate = (rappdate) => {
  if (!rappdate) {
    return '';
  }
  const asString = rappdate.toString();
  return `${asString.slice(0, 4)} ${asString.slice(4)}`;
};

export const InntektListe = ({ inntekter }) => <div>{!inntekter ? null : <Table
  headerTextCodes={['Inntekt.Aar', 'Kommune', 'Type', 'Inntekt.Pensjonsgivende', 'Inntekt.Rapporteringsdato']}
  data={inntekter.map((row, i) => ({ key: i,
    columns: [
          { key: '0', value: row.personInntektAar },
          { key: '1', value: row.kommune },
          { key: '2', value: row.personInntektType },
          { key: '3', value: row.personInntekt },
          { key: '4', value: formatRappdate(row.rapporteringsDato) },
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
