import React from 'react';
import Table from 'components/elements/Table';

const StatusListe = ({ status }) => <Table
  headerTextCodes={['Status.virkDato',
    'Status.statusKode',
    'Status.statusKodeHistorie',
    'Status.pensjonsType1',
    'Status.pensjonsType2',
    'Status.pensjonsType3',
    'Status.sivilstand',
    'Status.trygdetidFoer1967',
    'Status.trygdetidEtter1966',
    'Status.trygdetidFramTil',
    'Status.trygdetid1967Til1970',
    'Status.trygdetidAnvendt',
    'Status.foersteGangReg',
    'Status.sumYtelse',
    'Status.antallBarn',
    'Status.dodsddato',
    'Status.dodAvYrkesskade',
    'Status.vilkar843A',
    'Status.trygdetidGaranti',
    'Status.grunnbelopsDato',
    'Status.poengtilleggsDato',
    'Status.poengtilleggsKode',
    'Status.pensjonsrettFoer91',
    'Status.trygdetid1666',
    'Status.garantertTilleggsPensjonKode',
    'Status.gammelSammenstotsRegel',
    'Status.ektefelleInntektOver2g',
    'Status.pensjonFor9802',
    'Status.redGrunnPensjon321',
    'Status.grunnPensjonReduksjonsKode',
    'Status.friinntektDato']}
  data={status.map(row => ({ key: row.virkDato,
    columns: [
          { key: 'a', value: row.virkDato },
          { key: 'b', value: row.statusKode },
          { key: 'c', value: row.statusKodeHistorie },
          { key: 'd', value: row.pensjonsType1 },
          { key: 'e', value: row.pensjonsType2 },
          { key: 'f', value: row.pensjonsType3 },
          { key: 'g', value: row.sivilstand },
          { key: 'h', value: row.trygdetidFoer1967 },
          { key: 'i', value: row.trygdetidEtter1966 },
          { key: 'j', value: row.trygdetidFramTil },
          { key: 'k', value: row.trygdetid1967Til1970 },
          { key: 'l', value: row.trygdetidAnvendt },
          { key: 'm', value: row.foersteGangReg },
          { key: 'n', value: row.sumYtelse },
          { key: 'o', value: row.antallBarn },
          { key: 'p', value: row.dodsddato },
          { key: 'q', value: row.dodAvYrkesskade },
          { key: 'r', value: row.vilkar843A },
          { key: 's', value: row.trygdetidGaranti },
          { key: 't', value: row.grunnbelopsDato },
          { key: 'u', value: row.poengtilleggsDato },
          { key: 'w', value: row.poengtilleggsKode },
          { key: 'x', value: row.pensjonsrettFoer91 },
          { key: 'y', value: row.trygdetid1666 },
          { key: 'z', value: row.garantertTilleggsPensjonKode },
          { key: 'aa', value: row.gammelSammenstotsRegel },
          { key: 'ab', value: row.ektefelleInntektOver2g },
          { key: 'ac', value: row.pensjonFor9802 },
          { key: 'ad', value: row.redGrunnPensjon321 },
          { key: 'ae', value: row.grunnPensjonReduksjonsKode },
          { key: 'af', value: row.friinntektDato },
    ] }))}
/>;

StatusListe.propTypes = {
  status: React.PropTypes.arrayOf(React.PropTypes.object),
};

StatusListe.defaultProps = {
  status: [],
};

export default StatusListe;
