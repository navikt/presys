import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import GrunnblankettF7 from './GrunnblankettF7';
import Opphorsblankett2 from './Opphorsblankett2';
import GrunnblankettAlderspensjon from './GrunnblankettAlderspensjon';
import GrunnblankettUforepensjon from './GrunnblankettUforepensjon';
import Barn from './Barn';

import styles from './Transaksjonshistorikk.less';

const Grunnblankett = ({ type, barn, ...rest }) => {
  let grunnblankett = null;
  switch (type) {
    case 'F7':
      grunnblankett = <GrunnblankettF7 {...rest} />;
      break;
    case 'O2':
      grunnblankett = <Opphorsblankett2 {...rest} />;
      break;
    case 'AP':
      grunnblankett = <GrunnblankettAlderspensjon {...rest} />;
      break;
    case 'UP':
      grunnblankett = <GrunnblankettUforepensjon {...rest} />;
      break;
    default: grunnblankett = (<Row>
      <Column size={6}>
        <table className={styles.infotable}><tbody>
          {Object.keys(rest).map(key => <tr><td>{key}</td><td>{JSON.stringify(rest[key])}</td></tr>)}
        </tbody></table>
      </Column>
    </Row>);
  }

  return (<div><div>{grunnblankett}</div>
    {barn.length > 0 ? <div>&nbsp;<h3>Barn:</h3></div> : null}
    {barn.map(b => <Barn key={b.fnr} {...b} />)
}</div>);
};

Grunnblankett.propTypes = {
  type: React.PropTypes.string.isRequired,
  barn: React.PropTypes.arrayOf(React.PropTypes.object).isRequired,
};


export default Grunnblankett;
