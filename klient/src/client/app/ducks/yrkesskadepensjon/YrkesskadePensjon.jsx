import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';

import InfoTable from 'components/elements/InfoTable';

const YrkesskadePensjon = ({ gjeldendeYrkesgrad,
              grunnpensjon,
              saertillegg,
              ektefelletillegg,
              barnetillegg,
              garantiYrkegrad,
              tilleggspensjon,
              yrkeskadepoengtall,
              sluttpoengtall,
              antallPoengaar,
              poengberegningsalternativ,
              yrkessykdom }) => <Row>
                <Column size={6}>
                  <div>&nbsp;<h4>Yrkesskadepensjon:</h4></div>
                  <InfoTable>
                    <tr>
                      <td>Gjeldende yrkesgrad</td>
                      <td>{gjeldendeYrkesgrad}</td>
                    </tr>
                    <tr>
                      <td>Grunnpensjon</td>
                      <td>{grunnpensjon}</td>
                    </tr>
                    <tr>
                      <td>Ektefelletillegg</td>
                      <td>{ektefelletillegg}</td>
                    </tr>
                    <tr>
                      <td>Særtillegg</td>
                      <td>{saertillegg}</td>
                    </tr>
                    <tr>
                      <td>Barnetillegg</td>
                      <td>{barnetillegg}</td>
                    </tr>
                    <tr>
                      <td>Garantert yrkesgrad</td>
                      <td>{garantiYrkegrad}</td>
                    </tr>
                    <tr>
                      <td>Tilleggspensjon</td>
                      <td>{tilleggspensjon}</td>
                    </tr>
                    <tr>
                      <td>Yrkesskadepoengtall</td>
                      <td>{yrkeskadepoengtall}</td>
                    </tr>
                    <tr>
                      <td>Sluttpoengtall</td>
                      <td>{sluttpoengtall}</td>
                    </tr>
                    <tr>
                      <td>Antall poengår</td>
                      <td>{antallPoengaar}</td>
                    </tr>
                    <tr>
                      <td>Poengberegningsalternativ</td>
                      <td>{poengberegningsalternativ}</td>
                    </tr>
                    <tr>
                      <td>Yrkessykdom</td>
                      <td>{yrkessykdom}</td>
                    </tr>
                  </InfoTable>
                </Column>
              </Row>;

YrkesskadePensjon.propTypes = {
  gjeldendeYrkesgrad: React.PropTypes.number.isRequired,
  grunnpensjon: React.PropTypes.number.isRequired,
  saertillegg: React.PropTypes.number.isRequired,
  ektefelletillegg: React.PropTypes.number.isRequired,
  barnetillegg: React.PropTypes.number.isRequired,
  garantiYrkegrad: React.PropTypes.number.isRequired,
  tilleggspensjon: React.PropTypes.number.isRequired,
  yrkeskadepoengtall: React.PropTypes.string.isRequired,
  sluttpoengtall: React.PropTypes.string.isRequired,
  antallPoengaar: React.PropTypes.number.isRequired,
  poengberegningsalternativ: React.PropTypes.string.isRequired,
  yrkessykdom: React.PropTypes.string.isRequired,
};

export default YrkesskadePensjon;
