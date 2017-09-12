import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';

import InfoTable from 'components/elements/InfoTable';

const GrunnblankettF7 = ({
arbeidsinntekt,
antallBarnetillegg,
arbeidsinntektEktefelle,
ektefelle,
ektefelletillegg,
pensjonsinntekt,
pensjonsinntektEktefelle }) => <Row>
  <Column size={6}>
    <InfoTable>
      <tr><td>antall forsørgede barn</td><td>{antallBarnetillegg}</td></tr>
      <tr>
        <td>Ektefelletillegg</td>
        <td><input type="checkbox" checked={ektefelletillegg !== ' '} /></td>
      </tr>
      <tr>
        <td>Arbeidsinntekt søker</td>
        <td>{arbeidsinntekt}</td>
      </tr>
      <tr>
        <td>Arbeidsinntekt ektefelle</td>
        <td>{arbeidsinntektEktefelle}</td>
      </tr>
      <tr>
        <td>Pensjonsinntekt søker</td>
        <td>{pensjonsinntekt}</td>
      </tr>
      <tr>
        <td>Pensjonsinntekt ektefelle</td>
        <td>{pensjonsinntektEktefelle}</td>
      </tr>

    </InfoTable>
  </Column>
  <Column size={6}>
    <InfoTable>
      <tr>
        <td>Ektefelle:</td>
        <td>{ektefelle.fnr}</td>
      </tr>
      <tr>
        <td> Navn</td>
        <td>{ektefelle.navn}</td>
      </tr>
    </InfoTable>
  </Column>
</Row>;

GrunnblankettF7.propTypes = {
  arbeidsinntekt: React.PropTypes.number.isRequired,
  antallBarnetillegg: React.PropTypes.number.isRequired,
  arbeidsinntektEktefelle: React.PropTypes.number.isRequired,
  ektefelle: React.PropTypes.shape({
    fnr: React.PropTypes.string.isRequired,
    navn: React.PropTypes.string.isRequired,
  }).isRequired,
  ektefelletillegg: React.PropTypes.string.isRequired,
  pensjonsinntekt: React.PropTypes.number.isRequired,
  pensjonsinntektEktefelle: React.PropTypes.number.isRequired,
};

export default GrunnblankettF7;
