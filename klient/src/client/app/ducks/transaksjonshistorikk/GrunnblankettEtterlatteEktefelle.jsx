import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';

import InfoTable from 'components/elements/InfoTable';
import VernepliktsAar from './VernepliktsAar';

const finnVernepliktsAar = ({ vernepliktaar1, vernepliktaar2, vernepliktaar3, vernepliktaar4 }) =>
[vernepliktaar1, vernepliktaar2, vernepliktaar3, vernepliktaar4].filter(elementIListe => elementIListe > 0);

const GrunnblankettEtterlatteEktefelleFortsetter = ({ fravikPgaKonvensjonAnnetLand,
        flyktning,
        overkompensasjonUtland,
        skalIkkeBeregnesGrunnpenson,
        pensjonBeregnesEtterKonvensjonsregler,
        trygdetidKonvensjonsaar,
        framtidigTrygdetidFraDod,
        faktiskTrygdetidAar,
        faktiskTrygdetidMaaneder,
        trygdetidIAnnetNordiskLand,
        vilkaarPar10Pkt5nr2,
        medlemFolketrygdenFra,
        statsborgerskapEktefelle,
        bosattEktefelle,
        erEktefelleFlyktning,
        trygdetidFra1937EktefelleAar,
        trygdetidFra1937EktefelleMaaneder,
        overkompensasjonUtlandEktefelle }) => <Row>
          <Column size={12}>
            <InfoTable>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.fravikPgaKonvensjonAnnetLand" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${fravikPgaKonvensjonAnnetLand}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.flyktning" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${flyktning}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.overkompensasjonUtland" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonUtland}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.skalIkkeBeregnesGrunnpenson" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${skalIkkeBeregnesGrunnpenson}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.pensjonBeregnesEtterKonvensjonsregler" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${pensjonBeregnesEtterKonvensjonsregler}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.trygdetidKonvensjonsaar" /></td>
                <td>{trygdetidKonvensjonsaar}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.framtidigTrygdetidFraDod" /></td>
                <td>{framtidigTrygdetidFraDod}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.faktiskTrygdetid" /></td>
                <td>{faktiskTrygdetidAar}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                  {faktiskTrygdetidMaaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.trygdetidIAnnetNordiskLand" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${trygdetidIAnnetNordiskLand}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.vilkaarPar10Pkt5nr2" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar10Pkt5nr2}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.medlemFolketrygdenFra" /></td>
                <td><DsfDate value={medlemFolketrygdenFra}><ISO8601 /></DsfDate></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.statsborgerskapEktefelle" /></td>
                <td>{statsborgerskapEktefelle}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.bosattEktefelle" /></td>
                <td>{bosattEktefelle}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.erEktefelleFlyktning" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${erEktefelleFlyktning}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.trygdetidFra1937Ektefelle" /></td>
                <td>{trygdetidFra1937EktefelleAar}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                  {trygdetidFra1937EktefelleMaaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.overkompensasjonUtlandEktefelle" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonUtlandEktefelle}`} /></td>
              </tr>
            </InfoTable>
          </Column>
        </Row>;

GrunnblankettEtterlatteEktefelleFortsetter.propTypes = {
  fravikPgaKonvensjonAnnetLand: React.PropTypes.string.isRequired,
  flyktning: React.PropTypes.string.isRequired,
  overkompensasjonUtland: React.PropTypes.string.isRequired,
  skalIkkeBeregnesGrunnpenson: React.PropTypes.string.isRequired,
  pensjonBeregnesEtterKonvensjonsregler: React.PropTypes.string.isRequired,
  trygdetidKonvensjonsaar: React.PropTypes.number.isRequired,
  framtidigTrygdetidFraDod: React.PropTypes.number.isRequired,
  faktiskTrygdetidAar: React.PropTypes.number.isRequired,
  faktiskTrygdetidMaaneder: React.PropTypes.number.isRequired,
  trygdetidIAnnetNordiskLand: React.PropTypes.string.isRequired,
  vilkaarPar10Pkt5nr2: React.PropTypes.string.isRequired,
  medlemFolketrygdenFra: React.PropTypes.number.isRequired,
  statsborgerskapEktefelle: React.PropTypes.number.isRequired,
  bosattEktefelle: React.PropTypes.number.isRequired,
  erEktefelleFlyktning: React.PropTypes.string.isRequired,
  trygdetidFra1937EktefelleAar: React.PropTypes.number.isRequired,
  trygdetidFra1937EktefelleMaaneder: React.PropTypes.number.isRequired,
  overkompensasjonUtlandEktefelle: React.PropTypes.string.isRequired,
};

const GrunnblankettEtterlatteEktefelle = ({ bosattNorge,
        omsorgAvdodesBarn,
        vilkaarPar10Pkt5,
        forventetInntekt,
        framtidigArbeidsinntekt,
        ytelse,
        yrkesskadeTillegg,
        framleggsdato,
        framleggskode,
        fodselsnummerEktefelle,
        navnEktefelle,
        dodsdato,
        bosattNorgeEktefelle,
        vilkaarPar8Pkt3Ledd3bokstavA,
        pensjonsgivendeInntektSisteLeveaar,
        statsborgerskap,
        bosattLand,
        pensjonstrygdet,
        minst20AarBotid,
          ...ubehandlede }) => <Row>
            <Column size={6}>
              <div>&nbsp;<h4>Etterlatte ektefelle:</h4></div>
              <InfoTable>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.bosattNorge" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${bosattNorge}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.vilkaarPar10Pkt5" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar10Pkt5}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.forventetInntekt" /></td>
                  <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                    {forventetInntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.framtidigArbeidsinntekt" /></td>
                  <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                    {framtidigArbeidsinntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.ytelse" /></td>
                  <td><FormattedMessage id={`GrunnblankettEtterlatteEktefelle.overgangsstonadPensjonKode.${ytelse}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.yrkesskadeTillegg" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${yrkesskadeTillegg}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.framleggsdato" /></td>
                  <td><DsfDate value={framleggsdato}><ISO8601 /></DsfDate></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.framleggskode" /></td>
                  <td><FormattedMessage id={`GrunnblankettEtterlatteEktefelle.framleggsKode.${framleggskode}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.fodselsnummerEktefelle" /></td>
                  <td>{fodselsnummerEktefelle}</td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.navnEktefelle" /></td>
                  <td>{navnEktefelle}</td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.dodsdato" /></td>
                  <td><DsfDate value={dodsdato}><ISO8601 /></DsfDate></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.bosattNorgeEktefelle" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${bosattNorgeEktefelle}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.vilkaarPar8Pkt3Ledd3bokstavA" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${vilkaarPar8Pkt3Ledd3bokstavA}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.pensjonsgivendeInntektSisteLeveaar" /></td>
                  <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                    {pensjonsgivendeInntektSisteLeveaar}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.statsborgerskap" /></td>
                  <td>{statsborgerskap}</td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.bosattLand" /></td>
                  <td>{bosattLand}</td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.pensjonstrygdet" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${pensjonstrygdet}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettEtterlatteEktefelle.minst20AarBotid" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${minst20AarBotid}`} /></td>
                </tr>
              </InfoTable>
            </Column>
            <Column size={6}>
              <div>&nbsp;<h4>Etterlatte ektefelle fortsetter:</h4></div>
              <GrunnblankettEtterlatteEktefelleFortsetter {...ubehandlede} />
            </Column>
            <Column size={6}>
              <div>&nbsp;<h4>Vernepliktsår:</h4></div>
              <VernepliktsAar vernepliktaar={finnVernepliktsAar(ubehandlede)} />
            </Column>
          </Row>;

GrunnblankettEtterlatteEktefelle.propTypes = {
  bosattNorge: React.PropTypes.string.isRequired,
  omsorgAvdodesBarn: React.PropTypes.string.isRequired,
  vilkaarPar10Pkt5: React.PropTypes.string.isRequired,
  forventetInntekt: React.PropTypes.number.isRequired,
  framtidigArbeidsinntekt: React.PropTypes.number.isRequired,
  ytelse: React.PropTypes.string.isRequired,
  yrkesskadeTillegg: React.PropTypes.string.isRequired,
  framleggsdato: React.PropTypes.number.isRequired,
  framleggskode: React.PropTypes.string.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  dodsdato: React.PropTypes.number.isRequired,
  bosattNorgeEktefelle: React.PropTypes.string.isRequired,
  vilkaarPar8Pkt3Ledd3bokstavA: React.PropTypes.string.isRequired,
  pensjonsgivendeInntektSisteLeveaar: React.PropTypes.number.isRequired,
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  pensjonstrygdet: React.PropTypes.string.isRequired,
  minst20AarBotid: React.PropTypes.string.isRequired,
};

export default GrunnblankettEtterlatteEktefelle;
