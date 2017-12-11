import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';

import InfoTable from 'components/elements/InfoTable';
import VernepliktsAar from './VernepliktsAar';

const finnVernepliktsAar = ({ vernepliktaar1Ektefelle, vernepliktaar2Ektefelle, vernepliktaar3Ektefelle, vernepliktaar4Ektefelle }) =>
[vernepliktaar1Ektefelle, vernepliktaar2Ektefelle, vernepliktaar3Ektefelle, vernepliktaar4Ektefelle].filter(elementIListe => elementIListe > 0);


const GrunnblankettEtterlatteEktefelleEe = ({ bosattNorge,
          forventetArbeidsInntekt,
          forventetArbeidsInntektMellom67Og70,
          overgangsstonadPensjonKode,
          yrkesskadetillegg,
          framleggsdato,
          fodselsnummerEktefelle,
          navnEktefelle,
          sivilstandEktefelle,
          dodsdatoEktefelle,
          bosattNorgeEktefelle,
          vilkaarPar3Pkt17AEktefelle,
          pensjonsgivendeInntektEktefelle,
          redusertGrunnpensjonPar3Pkt2Ledd5,
          ektefelleInntektOver2G,
          ...ubehandlede }) => <Row>
            <Column size={6}>
              <div>&nbsp;<h4>Etterlatte ektefelle:</h4></div>
              <InfoTable>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.bosattNorge" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${bosattNorge}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.forventetArbeidsInntekt" /></td>
                  <td><FormattedMessage id="kodeverk.standardtekst.kr" />{forventetArbeidsInntekt}
                    <FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.forventetArbeidsInntektMellom67Og70" /></td>
                  <td><FormattedMessage id="kodeverk.standardtekst.kr" />{forventetArbeidsInntektMellom67Og70}
                    <FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.overgangsstonadPensjonKode" /></td>
                  <td><FormattedMessage id={`GrunnblankettEtterlatteEktefelleEe.overgangsstonadPensjonKode.${overgangsstonadPensjonKode}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.yrkesskadetillegg" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${yrkesskadetillegg}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.framleggsdato" /></td>
                  <td><DsfDate value={framleggsdato}><ISO8601 /></DsfDate></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.fodselsnummerEktefelle" /></td>
                  <td>{fodselsnummerEktefelle}</td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.navnEktefelle" /></td>
                  <td>{navnEktefelle}</td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.sivilstandEktefelle" /></td>
                  <td><FormattedMessage id={`kodeverk.sivilstand.${sivilstandEktefelle}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.dodsdatoEktefelle" /></td>
                  <td><DsfDate value={dodsdatoEktefelle}><ISO8601 /></DsfDate></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.bosattNorgeEktefelle" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${bosattNorgeEktefelle}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.vilkaarPar3Pkt17AEktefelle" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar3Pkt17AEktefelle}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.pensjonsgivendeInntektEktefelle" /></td>
                  <td><FormattedMessage id="kodeverk.standardtekst.kr" />{pensjonsgivendeInntektEktefelle}
                    <FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.redusertGrunnpensjonPar3Pkt2Ledd5" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${redusertGrunnpensjonPar3Pkt2Ledd5}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelleEe.ektefelleInntektOver2G" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelleInntektOver2G}`} /></td>
                </tr>
              </InfoTable>
            </Column>
            <Column size={6}>
              <div>&nbsp;<h4>Vernepliktsår ektefelle:</h4></div>
              <VernepliktsAar vernepliktaar={finnVernepliktsAar(ubehandlede)} />
            </Column>
          </Row>;

GrunnblankettEtterlatteEktefelleEe.propTypes = {
  bosattNorge: React.PropTypes.string.isRequired,
  forventetArbeidsInntekt: React.PropTypes.number.isRequired,
  forventetArbeidsInntektMellom67Og70: React.PropTypes.number.isRequired,
  overgangsstonadPensjonKode: React.PropTypes.string.isRequired,
  yrkesskadetillegg: React.PropTypes.string.isRequired,
  framleggsdato: React.PropTypes.number.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  sivilstandEktefelle: React.PropTypes.string.isRequired,
  dodsdatoEktefelle: React.PropTypes.number.isRequired,
  bosattNorgeEktefelle: React.PropTypes.string.isRequired,
  vilkaarPar3Pkt17AEktefelle: React.PropTypes.string.isRequired,
  pensjonsgivendeInntektEktefelle: React.PropTypes.number.isRequired,
  redusertGrunnpensjonPar3Pkt2Ledd5: React.PropTypes.string.isRequired,
  ektefelleInntektOver2G: React.PropTypes.string.isRequired,
};

export default GrunnblankettEtterlatteEktefelleEe;
