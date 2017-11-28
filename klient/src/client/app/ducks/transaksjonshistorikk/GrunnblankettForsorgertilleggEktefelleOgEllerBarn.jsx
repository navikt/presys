import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';


import InfoTable from 'components/elements/InfoTable';

const GrunnblankettForsorgertilleggEktefelleOgEllerBarn = ({ ektefelleTillegg,
        arbeidsInntekt,
        pensjonsInntekt,
        arbeidsInntektEktefelle,
        pensjonsInntektEktefelle,
        anntallBarnForForsorgertillegg,
        minst4G,
        fodselsnummerEktefelle,
        navnEktefelle,
        inntektsprovetEosPensjon,
        trygdetidEosAAr,
        trygdetidEosMaaneder }) => <Row>
          <Column size={6}>
            <div>&nbsp;<h4>Forsørgertillegg for ektefelle og/eller barn:</h4></div>
            <InfoTable>
              <tr>
                <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleOgEllerBarn.ektefelleTillegg" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelleTillegg}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleOgEllerBarn.arbeidsInntekt" /></td>
                <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                  {arbeidsInntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleOgEllerBarn.pensjonsInntekt" /></td>
                <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                  {pensjonsInntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleOgEllerBarn.arbeidsInntektEktefelle" /></td>
                <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                  {arbeidsInntektEktefelle}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleOgEllerBarn.pensjonsInntektEktefelle" /></td>
                <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                  {pensjonsInntektEktefelle}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleOgEllerBarn.anntallBarnForForsorgertillegg" /></td>
                <td>{anntallBarnForForsorgertillegg}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleOgEllerBarn.minst4G" /></td>
                <td><FormattedMessage id={`kodeverk.ja.nei.${minst4G}`} /></td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleOgEllerBarn.fodselsnummerEktefelle" /></td>
                <td>{fodselsnummerEktefelle}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleOgEllerBarn.navnEktefelle" /></td>
                <td>{navnEktefelle}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleOgEllerBarn.inntektsprovetEosPensjon" /></td>
                <td>{inntektsprovetEosPensjon}</td>
              </tr>
              <tr>
                <td><FormattedMessage id="GrunnblankettForsorgertilleggEktefelleOgEllerBarn.trygdetidEos" /></td>
                <td>{trygdetidEosAAr}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                  {trygdetidEosMaaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
              </tr>
            </InfoTable>
          </Column>
        </Row>;

GrunnblankettForsorgertilleggEktefelleOgEllerBarn.propTypes = {
  ektefelleTillegg: React.PropTypes.string.isRequired,
  arbeidsInntekt: React.PropTypes.number.isRequired,
  pensjonsInntekt: React.PropTypes.number.isRequired,
  arbeidsInntektEktefelle: React.PropTypes.number.isRequired,
  pensjonsInntektEktefelle: React.PropTypes.number.isRequired,
  anntallBarnForForsorgertillegg: React.PropTypes.number.isRequired,
  minst4G: React.PropTypes.string.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  inntektsprovetEosPensjon: React.PropTypes.string.isRequired,
  trygdetidEosAAr: React.PropTypes.number.isRequired,
  trygdetidEosMaaneder: React.PropTypes.number.isRequired,
};

export default GrunnblankettForsorgertilleggEktefelleOgEllerBarn;
