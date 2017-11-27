import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';


import InfoTable from 'components/elements/InfoTable';

const GrunnblankettEndringsblankettEnFortsetter = ({ pensjonsinntektEktefelle,
           arbeidsinntektEktefelle,
           statsborgerskap,
           bosattLand,
           tilleggspensjonNordiskLand,
           tilleggsPensjonFraNordiskLand,
           pensjonFraEOS,
           sivilstatus,
           opphorSamboer,
           inntektForUforepensjon,
           inntektsdato,
           reaktivisering,
           unntattForVentetid,
           frysperiode5Aar,
           frysperiodeTidspunkt,
           inntektOver2GEktefelle,
           inntektsprovetIEOS,
           trygdetidEOSAar,
           trygdetidEOSMaaneder,
           epsInntektOverG,
           lonnstilskudd }) => <Row>
             <Column size={12}>
               <InfoTable>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.pensjonsinntektEktefelle" /></td>
                   <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                     {pensjonsinntektEktefelle}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.arbeidsinntektEktefelle" /></td>
                   <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                     {arbeidsinntektEktefelle}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.statsborgerskap" /></td>
                   <td><FormattedMessage id={`kodeverk.land.${statsborgerskap}`} /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.bosattLand" /></td>
                   <td><FormattedMessage id={`kodeverk.land.${bosattLand}`} /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.tilleggspensjonNordiskLand" /></td>
                   <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                     {tilleggspensjonNordiskLand}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.tilleggsPensjonFraNordiskLand" /></td>
                   <td><FormattedMessage id={`kodeverk.land.${tilleggsPensjonFraNordiskLand}`} /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.pensjonFraEOS" /></td>
                   <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                     {pensjonFraEOS}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>

                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.sivilstatus" /></td>
                   <td><FormattedMessage id={`kodeverk.sivilstand.${sivilstatus}`} /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.opphorSamboer" /></td>
                   <td>{opphorSamboer}</td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.inntektForUforepensjon" /></td>
                   <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                     {inntektForUforepensjon}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.inntektsdato" /></td>
                   <td><DsfDate value={inntektsdato}><ISO8601 /></DsfDate></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.reaktivisering" /></td>
                   <td><FormattedMessage id={`kodeverk.reaktivisering.${reaktivisering}`} /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.unntattForVentetid" /></td>
                   <td><FormattedMessage id={`GrunnblankettEndringsblankettEn.kodeverk.${unntattForVentetid}`} /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.frysperiode5Aar" /></td>
                   <td><FormattedMessage id={`GrunnblankettEndringsblankettEn.kodeverk.${frysperiode5Aar}`} /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.frysperiodeTidspunkt" /></td>
                   <td><FormattedMessage id={`GrunnblankettEndringsblankettEn.kodeverk.${frysperiodeTidspunkt}`} /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.inntektOver2GEktefelle" /></td>
                   <td><FormattedMessage id={`kodeverk.ja.nei.${inntektOver2GEktefelle}`} /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.inntektsprovetIEOS" /></td>
                   <td><FormattedMessage id={`kodeverk.ja.nei.${inntektsprovetIEOS}`} /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.trygdetidEOS" /></td>
                   <td>{trygdetidEOSAar}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                     {trygdetidEOSMaaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.epsInntektOverG" /></td>
                   <td><FormattedMessage id={`kodeverk.ja.nei.${epsInntektOverG}`} /></td>
                 </tr>
                 <tr>
                   <td><FormattedMessage id="GrunnblankettEndringsblankettEn.lonnstilskudd" /></td>
                   <td><FormattedMessage id={`GrunnblankettEndringsblankettEn.kodeverk.${lonnstilskudd}`} /></td>
                 </tr>
               </InfoTable>
             </Column>
           </Row>;

GrunnblankettEndringsblankettEnFortsetter.propTypes = {
  pensjonsinntektEktefelle: React.PropTypes.number.isRequired,
  arbeidsinntektEktefelle: React.PropTypes.number.isRequired,
  statsborgerskap: React.PropTypes.number.isRequired,
  bosattLand: React.PropTypes.number.isRequired,
  tilleggspensjonNordiskLand: React.PropTypes.number.isRequired,
  tilleggsPensjonFraNordiskLand: React.PropTypes.number.isRequired,
  pensjonFraEOS: React.PropTypes.number.isRequired,
  sivilstatus: React.PropTypes.string.isRequired,
  opphorSamboer: React.PropTypes.string.isRequired,
  inntektForUforepensjon: React.PropTypes.number.isRequired,
  inntektsdato: React.PropTypes.number.isRequired,
  reaktivisering: React.PropTypes.string.isRequired,
  unntattForVentetid: React.PropTypes.string.isRequired,
  frysperiode5Aar: React.PropTypes.string.isRequired,
  frysperiodeTidspunkt: React.PropTypes.string.isRequired,
  inntektOver2GEktefelle: React.PropTypes.string.isRequired,
  inntektsprovetIEOS: React.PropTypes.string.isRequired,
  trygdetidEOSAar: React.PropTypes.number.isRequired,
  trygdetidEOSMaaneder: React.PropTypes.number.isRequired,
  epsInntektOverG: React.PropTypes.string.isRequired,
  lonnstilskudd: React.PropTypes.string.isRequired,
};

const GrunnblankettEndringsblankettEn = ({ framtidigArbeidsinntekt,
           uforegrad,
           forventetInntekt,
           fraOvergangsstonadTilPensjon,
           fradrag2G,
           framleggsdato,
           opphortOvergangsstonadGjennlevende,
           nyttNavnStonadsmottaker,
           nyttNavnEktefelle,
           fodselsnummerEktefelle,
           navnEktefelle,
           skilsmisse,
           flyttetFraHverandre,
           flyttetSammen,
           inntektMins4G,
           inntektUnder4G,
           yrkeUforegrad,
           pensjonsinntekt,
           arbeidsinntekt,
            ...ubehandlede }) => <Row>
              <Column size={6}>
                <div>&nbsp;<h4>Endringsblankett:</h4></div>
                <div>&nbsp;<h4>OBS! Alle tall felt som ikke er utfylt er preutfylt med 9-tall</h4></div>
                <InfoTable>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.framtidigArbeidsinntekt" /></td>
                    <td>{framtidigArbeidsinntekt}</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.uforegrad" /></td>
                    <td>{uforegrad}%</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.forventetInntekt" /></td>
                    <td>{forventetInntekt}</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.fraOvergangsstonadTilPensjon" /></td>
                    <td>{fraOvergangsstonadTilPensjon}</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.fradrag2G" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${fradrag2G}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.framleggsdato" /></td>
                    <td><DsfDate value={framleggsdato}><ISO8601 /></DsfDate></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.opphortOvergangsstonadGjennlevende" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${opphortOvergangsstonadGjennlevende}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.nyttNavnStonadsmottaker" /></td>
                    <td>{nyttNavnStonadsmottaker}</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.nyttNavnEktefelle" /></td>
                    <td>{nyttNavnEktefelle}</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.fodselsnummerEktefelle" /></td>
                    <td>{fodselsnummerEktefelle}</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.navnEktefelle" /></td>
                    <td>{navnEktefelle}</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.skilsmisse" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${skilsmisse}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.flyttetFraHverandre" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${flyttetFraHverandre}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.flyttetSammen" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${flyttetSammen}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.inntektMins4G" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${inntektMins4G}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.inntektUnder4G" /></td>
                    <td><FormattedMessage id={`kodeverk.ja.nei.${inntektUnder4G}`} /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.yrkeUforegrad" /></td>
                    <td>{yrkeUforegrad}%</td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.pensjonsinntekt" /></td>
                    <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                      {pensjonsinntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                  </tr>
                  <tr>
                    <td><FormattedMessage id="GrunnblankettEndringsblankettEn.arbeidsinntekt" /></td>
                    <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                      {arbeidsinntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                  </tr>
                </InfoTable>
              </Column>
              <Column size={6}>
                <div>&nbsp;<h4>Endringsblanketten fortsetter:</h4></div>
                <GrunnblankettEndringsblankettEnFortsetter {...ubehandlede} />
              </Column>
            </Row>;

GrunnblankettEndringsblankettEn.propTypes = {
  framtidigArbeidsinntekt: React.PropTypes.number.isRequired,
  uforegrad: React.PropTypes.number.isRequired,
  forventetInntekt: React.PropTypes.number.isRequired,
  fraOvergangsstonadTilPensjon: React.PropTypes.string.isRequired,
  fradrag2G: React.PropTypes.string.isRequired,
  framleggsdato: React.PropTypes.number.isRequired,
  opphortOvergangsstonadGjennlevende: React.PropTypes.string.isRequired,
  nyttNavnStonadsmottaker: React.PropTypes.string.isRequired,
  nyttNavnEktefelle: React.PropTypes.string.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  skilsmisse: React.PropTypes.string.isRequired,
  flyttetFraHverandre: React.PropTypes.string.isRequired,
  flyttetSammen: React.PropTypes.string.isRequired,
  inntektMins4G: React.PropTypes.string.isRequired,
  inntektUnder4G: React.PropTypes.string.isRequired,
  yrkeUforegrad: React.PropTypes.number.isRequired,
  pensjonsinntekt: React.PropTypes.number.isRequired,
  arbeidsinntekt: React.PropTypes.number.isRequired,
};

export default GrunnblankettEndringsblankettEn;
