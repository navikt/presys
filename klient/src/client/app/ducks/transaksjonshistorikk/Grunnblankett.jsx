import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import InfoTable from 'components/elements/InfoTable';
import GrunnblankettF7 from './GrunnblankettF7';
import Opphorsblankett2 from './Opphorsblankett2';
import Opphorsblankett1 from './Opphorsblankett1';
import GrunnblankettAlderspensjon from './GrunnblankettAlderspensjon';
import GrunnblankettUforepensjon from './GrunnblankettUforepensjon';
import GrunnblankettUforepensjonU2 from './GrunnblankettUforepensjonU2';
import GrunnblankettUforepensjonU3 from './GrunnblankettUforepensjonU3';
import GrunnblankettEtterlatteEktefelleEeS from './GrunnblankettEtterlatteEktefelleEeS';
import GrunnblankettYrkesskadePensjon from './GrunnblankettYrkesskadePensjon';

import Barn from './Barn';

const blankettyper = {
  F7: GrunnblankettF7,
  O2: Opphorsblankett2,
  AP: GrunnblankettAlderspensjon,
  UP: GrunnblankettUforepensjon,
  O1: Opphorsblankett1,
  U2: GrunnblankettUforepensjonU2,
  U3: GrunnblankettUforepensjonU3,
};


const Grunnblankett = ({ type, barn, grunnees, grunnbyp, ...rest }) => {
  const GrunnblankettType = blankettyper[type];

  return (<div><div>{GrunnblankettType ? <GrunnblankettType {...rest} /> : (<Row>
    <Column size={6}>
      <InfoTable>
        {Object.keys(rest).map(key => <tr><td>{key}</td><td>{JSON.stringify(rest[key])}</td></tr>)}
      </InfoTable>
    </Column>
  </Row>)}</div>
    {barn.length > 0 ? <div>&nbsp;<h3>Barn:</h3></div> : null}
    {barn.map(b => <Barn key={b.fnr} {...b} />)}
    {grunnees.length > 0 ? <div>&nbsp;<h3>Etterlatte:</h3></div> : null}
    {grunnees.map(b => <GrunnblankettEtterlatteEktefelleEeS {...b} />)}
    {grunnbyp.length > 0 ? <div>&nbsp;<h3>Yrkesskadeopplysninger:</h3></div> : null}
    {grunnbyp.map(b => <GrunnblankettYrkesskadePensjon {...b} />)}
  </div>);
};

Grunnblankett.propTypes = {
  type: React.PropTypes.string.isRequired,
  barn: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  grunnees: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
  grunnbyp: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,

};


export default Grunnblankett;
