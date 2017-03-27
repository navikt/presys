import React from 'react';

import styles from './verticalSpacer.less';

const VerticalSpacer = ({
  space,
}) => {
  let spacer = styles.spacer5;
  if (space === 1) {
    spacer = styles.spacer1;
  } else if (space === 2) {
    spacer = styles.spacer2;
  } else if (space === 3) {
    spacer = styles.spacer3;
  } else if (space === 4) {
    spacer = styles.spacer4;
  } else if (space === 5) {
    spacer = styles.spacer5;
  } else if (space === 6) {
    spacer = styles.spacer6;
  } else if (space === 7) {
    spacer = styles.spacer7;
  } else if (space === 8) {
    spacer = styles.spacer8;
  }

  return (
    <div className={spacer} />
  );
};

VerticalSpacer.propTypes = {
  space: React.PropTypes.number,
};

VerticalSpacer.defaultProps = {
  space: 5,
};

export default VerticalSpacer;
