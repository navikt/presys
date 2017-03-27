import React from 'react';

import behandlingPropType from 'constants/propTypes/behandlingPropType';

import Label from 'elements/Label';
import BehandlingListItem from './BehandlingListItem';

import styles from './behandlingList.less';

/* TODO (tor) Denne har ein rotete bruk av props. Rydd */
const BehandlingList = ({
  behandlinger,
  selectedBehandling,
  showAllBehandlinger,
  selectBehandlingCallback,
  toggleShowAllBehandlingerCallback,
}) => {
  let result = <Label textCode="BehandlingList.ZeroBhandlinger" className={styles.zeroBehandlinger} />;

  if (selectedBehandling !== null) {
    let displayedBehandlinger = [selectedBehandling];
    const selectedBehandlingId = selectedBehandling.id;

    if (showAllBehandlinger) {
      const filteredBehandlinger = behandlinger
        .filter(behandling => behandling.id !== selectedBehandlingId)
        .sort((behandling1, behandling2) => {
          const changeTimeBehandling1 = behandling1.endret ? behandling1.endret : behandling1.opprettet;
          const changeTimeBehandling2 = behandling2.endret ? behandling2.endret : behandling2.opprettet;
          return new Date(parseInt(changeTimeBehandling1, 10)) < new Date(parseInt(changeTimeBehandling2, 10)) ? 1 : -1;
        });
      displayedBehandlinger = [...displayedBehandlinger, ...filteredBehandlinger];
    }

    result = displayedBehandlinger.map(behandling =>
      <BehandlingListItem
        key={behandling.id}
        onlyOneBehandling={behandlinger.length === 1}
        showAllBehandlinger={showAllBehandlinger}
        toggleShowAllBehandlingerCallback={selectedBehandlingId === behandling.id && behandlinger.length > 1 ? toggleShowAllBehandlingerCallback : null}
        selectBehandlingCallback={selectBehandlingCallback}
        id={behandling.id}
        type={behandling.type.navn}
        opprettetDato={behandling.opprettet}
        avsluttetDato={behandling.avsluttet}
        behandlingsstatus={behandling.status.navn}
      />,
    );
  }

  return (
    <div className={styles.container}>
      { result }
    </div>
  );
};

BehandlingList.propTypes = {
  behandlinger: React.PropTypes.arrayOf(behandlingPropType),
  selectedBehandling: behandlingPropType,
  showAllBehandlinger: React.PropTypes.bool.isRequired,
  selectBehandlingCallback: React.PropTypes.func.isRequired,
  toggleShowAllBehandlingerCallback: React.PropTypes.func.isRequired,
};

BehandlingList.defaultProps = {
  behandlinger: {},
  selectedBehandling: null,
};

export default BehandlingList;
