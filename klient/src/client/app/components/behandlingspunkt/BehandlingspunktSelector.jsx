import React from 'react';

import { FormattedMessage } from 'react-intl';
import Image from 'elements/Image';
import BehandlingspunktStatus from 'constants/behandlingspunktStatus';
import { findBehandlingspunktImageSrc } from 'helpers/behandlingspunktStatusHelper';
import behandlingspunktPropType from 'constants/propTypes/behandlingspunktPropType';
import vedtakIkonDisableUrl from 'images/vedtak_ikon_disable.svg';

import styles from './behandlingspunktSelector.less';

const BehandlingspunktSelector = ({
  behandlingspunkter,
  selectedBehandlingspunkt,
  selectBehandlingspunktCallback,
}) => {
  const selectedPos = behandlingspunkter.findIndex(punkt => punkt === selectedBehandlingspunkt) + 1;
  const arrowPositionStyle = styles[`arrowLine_${selectedPos}`];

  return (
    <div className={styles.container}>
      {
        behandlingspunkter.map(punkt =>
          <Image
            key={punkt.navn}
            className={punkt !== selectedBehandlingspunkt ? styles.behandlingspunkt : styles.behandlingspunkt_selected}
            alt={punkt.navn}
            tabIndex="0"
            imageSrcFunction={isHovering => findBehandlingspunktImageSrc(isHovering, punkt === selectedBehandlingspunkt, punkt.status)}
            onKeyDown={punkt !== selectedBehandlingspunkt ? () => selectBehandlingspunktCallback(punkt) : null}
            onMouseDown={punkt !== selectedBehandlingspunkt ? () => selectBehandlingspunktCallback(punkt) : null}
            tooltip={punkt !== selectedBehandlingspunkt ? { header: punkt.navn, body: punkt.merknad } : null}
          />,
        )
      }
      <Image
        className={styles.behandlingspunkt_selected}
        alt="vedtak"
        imageSrcFunction={() => vedtakIkonDisableUrl}
      />
      <div className={arrowPositionStyle}>
        <h3 className={styles.header}>
          {selectedBehandlingspunkt.status === BehandlingspunktStatus.AKSJONSPUNKT &&
            <FormattedMessage id="Behandlingspunkt.AvklareFakta" />
          }
          {selectedBehandlingspunkt.navn}
        </h3>
        <p className={styles.info}>
          {selectedBehandlingspunkt.merknad}
        </p>
      </div>
    </div>
  );
};

BehandlingspunktSelector.propTypes = {
  behandlingspunkter: React.PropTypes.arrayOf(behandlingspunktPropType).isRequired,
  selectedBehandlingspunkt: behandlingspunktPropType.isRequired,
  selectBehandlingspunktCallback: React.PropTypes.func.isRequired,
};

export default BehandlingspunktSelector;
