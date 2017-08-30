import React from 'react';
import Row from 'components/elements/Row';
import Column from 'components/elements/Column';
import GrunnblankettF7 from './GrunnblankettF7';
import Opphorsblankett2 from './Opphorsblankett2';
import GrunnblankettAlderspensjon from './GrunnblankettAlderspensjon';

import styles from './Transaksjonshistorikk.less';

const Grunnblankett = ({ type, ...rest }) => {
  switch (type) {
    case 'F7': return <GrunnblankettF7 {...rest} />;
    case 'O2': return <Opphorsblankett2 {...rest} />;
    case 'AP': return <GrunnblankettAlderspensjon {...rest} />;
    default: return (<Row>
      <Column size={6}>
        <table className={styles.infotable}><tbody>
          {Object.keys(rest).map(key => <tr><td>{key}</td><td>{rest[key]}</td></tr>)}
        </tbody></table>
      </Column>
    </Row>);
  }
};

Grunnblankett.propTypes = {
  type: React.PropTypes.string.isRequired,
};


export default Grunnblankett;
