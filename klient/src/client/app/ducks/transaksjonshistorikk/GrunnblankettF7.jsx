import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';

import InfoTable from 'components/elements/InfoTable';
import { FormattedMessage } from 'react-intl';

const GrunnblankettF7 = ({
arbeidsinntekt,
antallBarnetillegg,
arbeidsinntektEktefelle,
ektefelle,
ektefelletillegg,
pensjonsinntekt,
pensjonsinntektEktefelle }) => <Row>
  <Column size={6}>
    <div>&nbsp;<h4>Forørgingstillegg ektefelle/barn:</h4></div>
    <InfoTable>
      <tr>
        <td>Antall forsørgede barn</td>
        <td>{antallBarnetillegg}</td></tr>
      <tr>
        <td>Ektefelletillegg</td>
        <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelletillegg}`} /></td>
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
    <div>&nbsp;<h4>Ektefelle:</h4></div>
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
