import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import { FormattedMessage } from 'react-intl';

import InfoTable from 'components/elements/InfoTable';

const GrunnblankettNyAFP = ({ norskBosatt,
          trygdetidAar,
          trygdetidMaaneder,
          statsborger,
          bosattLandkode,
          fravikFlyktning,
          overkompensasjonForUtlending,
          pensjonsinntektSisteAar,
          framtidigArbeidsinntekt,
          tilleggForEktefelle,
          pensjonsinntektUtenomFolketrygd,
          afpTilleggskode,
          afpOrdningskode,
          fodselsnummerEktefelle,
          navnEktefelle,
          ektefelleInntektOver2G,
          redusertGrunnpensjonEtterParagraf325 }) => <Row>
            <Column size={6}>
              <InfoTable>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.norskBosatt" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${norskBosatt}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.trygdetid" /></td>
                  <td>{trygdetidAar}<FormattedMessage id="kodeverk.standardtekst.aarOg" />
                    {trygdetidMaaneder}<FormattedMessage id="kodeverk.standardtekst.maaneder" /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.statsborger" /></td>
                  <td><FormattedMessage id={`kodeverk.land.${statsborger}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.bosattLandkode" /></td>
                  <td><FormattedMessage id={`kodeverk.land.${bosattLandkode}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.fravikFlyktning" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${fravikFlyktning}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.overkompensasjonForUtlending" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${overkompensasjonForUtlending}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.pensjonsinntektSisteAar" /></td>
                  <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                    {pensjonsinntektSisteAar}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.framtidigArbeidsinntekt" /></td>
                  <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                    {framtidigArbeidsinntekt}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.tilleggForEktefelle" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${tilleggForEktefelle}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.pensjonsinntektUtenomFolketrygd" /></td>
                  <td><FormattedMessage id="kodeverk.standardtekst.kr" />
                    {pensjonsinntektUtenomFolketrygd}<FormattedMessage id="kodeverk.standardtekst.punktumStrek" /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.afpTilleggskode" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${afpTilleggskode}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.afpOrdningskode" /></td>
                  <td><FormattedMessage id={`kodeverk.AFP.${afpOrdningskode}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.fodselsnummerEktefelle" /></td>
                  <td>{fodselsnummerEktefelle}</td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.navnEktefelle" /></td>
                  <td>{navnEktefelle}</td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.ektefelleInntektOver2G" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${ektefelleInntektOver2G}`} /></td>
                </tr>
                <tr>
                  <td><FormattedMessage id="GrunnblankettNyAFP.redusertGrunnpensjonEtterParagraf325" /></td>
                  <td><FormattedMessage id={`kodeverk.ja.nei.${redusertGrunnpensjonEtterParagraf325}`} /></td>
                </tr>
              </InfoTable>
            </Column>
          </Row>;

GrunnblankettNyAFP.propTypes = {
  norskBosatt: React.PropTypes.string.isRequired,
  trygdetidAar: React.PropTypes.number.isRequired,
  trygdetidMaaneder: React.PropTypes.number.isRequired,
  statsborger: React.PropTypes.number.isRequired,
  bosattLandkode: React.PropTypes.number.isRequired,
  fravikFlyktning: React.PropTypes.string.isRequired,
  overkompensasjonForUtlending: React.PropTypes.number.isRequired,
  pensjonsinntektSisteAar: React.PropTypes.number.isRequired,
  framtidigArbeidsinntekt: React.PropTypes.number.isRequired,
  tilleggForEktefelle: React.PropTypes.string.isRequired,
  pensjonsinntektUtenomFolketrygd: React.PropTypes.number.isRequired,
  afpTilleggskode: React.PropTypes.string.isRequired,
  afpOrdningskode: React.PropTypes.string.isRequired,
  fodselsnummerEktefelle: React.PropTypes.string.isRequired,
  navnEktefelle: React.PropTypes.string.isRequired,
  ektefelleInntektOver2G: React.PropTypes.string.isRequired,
  redusertGrunnpensjonEtterParagraf325: React.PropTypes.string.isRequired,
};

export default GrunnblankettNyAFP;
