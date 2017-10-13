import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import InfoTable from 'components/elements/InfoTable';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';
import { FormattedMessage } from 'react-intl';

const Opphorsblankett1 = ({ dodsDato,
                        ektefelleFodselsnummer,
                        ektefelleNavn,
                        avdodesPensjonsgivendeInntekt }) => <Row>
                          <Column size={6}>
                            <div>&nbsp;<h4>Opphørsblankett 1 dødsfall:</h4></div>
                            <InfoTable>
                              <tr>
                                <td><FormattedMessage id="Opphorsblankett1.dodsDato" /></td>
                                <td><DsfDate value={dodsDato}><ISO8601 /></DsfDate></td>
                              </tr>
                              <tr>
                                <td><FormattedMessage id="Opphorsblankett1.ektefelleFodselsnummer" /></td>
                                <td>{ektefelleFodselsnummer}</td>
                              </tr>
                              <tr>
                                <td><FormattedMessage id="Opphorsblankett1.ektefelleNavn" /></td>
                                <td>{ektefelleNavn}</td>
                              </tr>
                              <tr>
                                <td><FormattedMessage id="Opphorsblankett1.avdodesPensjonsgivendeInntekt" /></td>
                                <td>{avdodesPensjonsgivendeInntekt}</td>
                              </tr>
                            </InfoTable>
                          </Column>
                        </Row>;

Opphorsblankett1.propTypes = {
  dodsDato: React.PropTypes.number.isRequired,
  ektefelleFodselsnummer: React.PropTypes.string.isRequired,
  ektefelleNavn: React.PropTypes.string.isRequired,
  avdodesPensjonsgivendeInntekt: React.PropTypes.number.isRequired,
};

export default Opphorsblankett1;
