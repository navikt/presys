import Table from 'components/elements/Table';
import React from 'react';

export const InntektListe = ({ inntekter }) => <div>{!inntekter ? null : <Table
  headerTextCodes={['Inntekt.Aar', 'Kommune', 'Type', 'Inntekt.Pensjonsgivende']}
  data={inntekter.map(row => ({ key: row.personInntektAar,
    columns: [
          { key: 'a', value: row.personInntektAar },
          { key: 'b', value: row.kommune },
          { key: 'c', value: row.personInntektType },
          { key: 'd', value: row.personInntekt },
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
