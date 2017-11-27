import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';
import { DsfDate } from 'components/elements/ParseDate';
import { ISO8601 } from 'components/elements/FormattedDate';


import InfoTable from 'components/elements/InfoTable';

const GrunnblankettEndringsblankett = ({ framtidigArbeidsinntekt,
        hoyestePensjonsgrad,
        alderspensjonsdelIProsent,
        uforegrad,
        forventetInntekt,
        overgangsstonadTilPensjon,
        tilleggspensjonForGjenlevendePensjonIProsent,
        framleggsdato,
        opphortOvergangsstonadGjennlevende,
        nyttNavnPensjonist,
        nyttNavnEps,
        fodselsnummerEktefelle,
        navnEktefelle,
        skilsmisse,
        flyttetFraHverandre,
        flyttetSammen,
        inntektMinst4G,
        inntektUnder4G,
        yrkeUforegrad }) => <Row>
          <Column size={6}>
            <div>&nbsp;<h4>Endringsblankett:</h4></div>
            <div>&nbsp;<h4>OBS! Alle tall felt som ikke er utfylt er preutfylt med 9-tall</h4></div>
            <InfoTable>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.framtidigArbeidsinntekt" /></td>
                <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                  {framtidigArbeidsinntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.hoyestePensjonsgrad" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${hoyestePensjonsgrad}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.alderspensjonsdelIProsent" /></td>
                <td>{alderspensjonsdelIProsent}%</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.uforegrad" /></td>
                <td>{uforegrad}%</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.forventetInntekt" /></td>
                <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                  {forventetInntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.overgangsstonadTilPensjon" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${overgangsstonadTilPensjon}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.tilleggspensjonForGjenlevendePensjonIProsent" /></td>
                <td>{tilleggspensjonForGjenlevendePensjonIProsent}%</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.framleggsdato" /></td>
                <td><DsfDate value={framleggsdato}><ISO8601 /></DsfDate></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.opphortOvergangsstonadGjennlevende" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${opphortOvergangsstonadGjennlevende}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.nyttNavnPensjonist" /></td>
                <td>{nyttNavnPensjonist}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.nyttNavnEps" /></td>
                <td>{nyttNavnEps}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.fodselsnummerEktefelle" /></td>
                <td>{fodselsnummerEktefelle}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.navnEktefelle" /></td>
                <td>{navnEktefelle}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.skilsmisse" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${skilsmisse}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.flyttetFraHverandre" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${flyttetFraHverandre}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.flyttetSammen" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${flyttetSammen}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.inntektMinst4G" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${inntektMinst4G}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.inntektUnder4G" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${inntektUnder4G}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettEndringsblankett.yrkeUforegrad" /></td>
                <td>{yrkeUforegrad}%</td>
              </tr>
            </InfoTable>
          </Column>
        </Row>;

GrunnblankettEndringsblankett.propTypes = {
  framtidigArbeidsinntekt: React.PropTypes.number.isRequired,
  hoyestePensjonsgrad: React.PropTypes.string.isRequired,
  alderspensjonsdelIProsent: React.PropTypes.number.isRequired,
  uforegrad: React.PropTypes.number.isRequired,
  forventetInntekt: React.PropTypes.number.isRequired,
  overgangsstonadTilPensjon: React.PropTypes.string.isRequired,
  tilleggspensjonForGjenlevendePensjonIProsent: React.PropTypes.number.isRequired,
  framleggsdato: React.PropTypes.number.isRequired,
  opphortOvergangsstonadGjennlevende: React.PropTypes.string.isRequired,
  nyttNavnPensjonist: React.PropTypes.string.isRequired,
  nyttNavnEps: React.PropTypes.string.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  skilsmisse: React.PropTypes.string.isRequired,
  flyttetFraHverandre: React.PropTypes.string.isRequired,
  flyttetSammen: React.PropTypes.string.isRequired,
  inntektMinst4G: React.PropTypes.string.isRequired,
  inntektUnder4G: React.PropTypes.string.isRequired,
  yrkeUforegrad: React.PropTypes.number.isRequired,
};

export default GrunnblankettEndringsblankett;
