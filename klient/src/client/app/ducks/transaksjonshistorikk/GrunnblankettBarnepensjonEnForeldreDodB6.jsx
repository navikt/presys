import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';

import InfoTable from 'components/elements/InfoTable';
import VernepliktsAar from './VernepliktsAar';

const finnVernepliktsAar = ({ vernepliktaarAvdod1, vernepliktaarAvdod2, vernepliktaarAvdod3 }) =>
[vernepliktaarAvdod1, vernepliktaarAvdod2, vernepliktaarAvdod3].filter(elementIListe => elementIListe > 0);


const GrunnblankettBarnepensjonEnForeldreDodB6 = ({ beregnesEtterRedusertTrygdetid,
          redusertTrygdetid,
          konvensjon,
          pensjonstrygdet,
          minst20Aar,
          fodselsnummerAvdod,
          navnAvdod,
          dodsdato,
          vilkaarPar8Pkt4Ledd3BokstavA,
          pensjonsgivendeInntektAvdod,
          ...ubehandlede }) => <Row>
            <Column size={6}>
              <div>&nbsp;<h4>Barnepensjon en foreldre død:</h4></div>
              <InfoTable>

                <tr>
                  <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDodB6.beregnesEtterRedusertTrygdetid" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${beregnesEtterRedusertTrygdetid}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDodB6.redusertTrygdetid" /></td>
                  <td>{redusertTrygdetid}</td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDodB6.konvensjon" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${konvensjon}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDodB6.pensjonstrygdet" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${pensjonstrygdet}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDodB6.minst20Aar" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${minst20Aar}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDodB6.fodselsnummerAvdod" /></td>
                  <td>{fodselsnummerAvdod}</td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDodB6.navnAvdod" /></td>
                  <td>{navnAvdod}</td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDodB6.dodsdato" /></td>
                  <td><DsfDate value={dodsdato}><ISO8601 /></DsfDate></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDodB6.vilkaarPar8Pkt4Ledd3BokstavA" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar8Pkt4Ledd3BokstavA}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettBarnepensjonEnForeldreDodB6.pensjonsgivendeInntektAvdod" /></td>
                  <td><FormattedMessage id="kodeverk.standardtekst.kr" />{pensjonsgivendeInntektAvdod}
                    <FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                </tr>
              </InfoTable>
            </Column>
            <Column size={6}>
              <div>&nbsp;<h4>Vernepliktsår:</h4></div>
              <VernepliktsAar vernepliktaar={finnVernepliktsAar(ubehandlede)} />
            </Column>
          </Row>;

GrunnblankettBarnepensjonEnForeldreDodB6.propTypes = {
  beregnesEtterRedusertTrygdetid: React.PropTypes.string.isRequired,
  redusertTrygdetid: React.PropTypes.number.isRequired,
  konvensjon: React.PropTypes.string.isRequired,
  pensjonstrygdet: React.PropTypes.string.isRequired,
  minst20Aar: React.PropTypes.string.isRequired,
  fodselsnummerAvdod: React.PropTypes.string.isRequired,
  navnAvdod: React.PropTypes.string.isRequired,
  dodsdato: React.PropTypes.number.isRequired,
  vilkaarPar8Pkt4Ledd3BokstavA: React.PropTypes.string.isRequired,
  pensjonsgivendeInntektAvdod: React.PropTypes.number.isRequired,
};

export default GrunnblankettBarnepensjonEnForeldreDodB6;
