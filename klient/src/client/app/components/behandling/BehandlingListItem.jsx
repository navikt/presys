import React from 'react';
import { FormattedMessage } from 'react-intl';

import Row from 'elements/Row';
import Column from 'elements/Column';
import DateLabel from 'elements/DateLabel';

import openImage from 'images/pil_opp.svg';
import closedImage from 'images/pil_ned.svg';

import styles from './behandlingListItem.less';

/* TODO (tor) Denne har ein rotete bruk av props. Rydd */
/* TODO (tor) Kanskje er det bedre å bruka tabell her? Kan da gjenbruka tabell-komponenten */
const BehandlingListItem = ({
  onlyOneBehandling,
  showAllBehandlinger,
  toggleShowAllBehandlingerCallback,
  selectBehandlingCallback,
  id,
  type,
  opprettetDato,
  avsluttetDato,
  behandlingsstatus,
}) => {
  const mouseEventFunction = () => {
    if (!onlyOneBehandling) {
      if (toggleShowAllBehandlingerCallback) {
        toggleShowAllBehandlingerCallback();
      } else {
        selectBehandlingCallback(id);
      }
    }
  };

  const keyEventFunction = (e) => {
    if (e.key === 'ArrowDown') {
      if (e.target.nextSibling) {
        e.target.nextSibling.focus();
        e.preventDefault();
      }
    } else if (e.key === 'ArrowUp') {
      if (e.target.previousSibling) {
        e.target.previousSibling.focus();
        e.preventDefault();
      }
    } else if ((e.key === 'Enter' || e.key === ' ')) {
      if (!onlyOneBehandling) {
        if (toggleShowAllBehandlingerCallback) {
          toggleShowAllBehandlingerCallback();
        } else {
          selectBehandlingCallback(id);
        }
      }
      e.preventDefault();
    }
  };

  return (
    <div
      className={onlyOneBehandling ? styles.containerWithoutPointer : styles.container}
      onMouseDown={mouseEventFunction}
      onKeyDown={keyEventFunction}
      tabIndex="0"
    >
      <div className={styles.header}>
        <h3 className={styles.type}>
          {type}
        </h3>
        {toggleShowAllBehandlingerCallback !== null &&
          <img className={styles.image} src={showAllBehandlinger ? openImage : closedImage} alt={<FormattedMessage id="BehandlingListItem.Behandlinger" />} />
        }
      </div>
      <Row value={id} className={styles.mainRow}>
        <Column size={4}>
          <Row className={styles.headerRow}>
            <FormattedMessage id="BehandlingListItem.Opprettet" />
          </Row>
          <Row className={styles.contentRow}>
            <DateLabel dateString={opprettetDato} />
          </Row>
        </Column>
        <Column size={4}>
          <Row className={styles.headerRow}>
            <FormattedMessage id="BehandlingListItem.Avsluttet" />
          </Row>
          <Row className={styles.contentRow}>
            {avsluttetDato &&
              <DateLabel dateString={avsluttetDato} />
            }
          </Row>
        </Column>
        <Column size={4}>
          <Row className={styles.headerRow}>
            <FormattedMessage id="BehandlingListItem.Behandlingsstatus" />
          </Row>
          <Row className={styles.contentRow}>
            {behandlingsstatus}
          </Row>
        </Column>
      </Row>
    </div>
  );
};

BehandlingListItem.propTypes = {
  id: React.PropTypes.number.isRequired,
  type: React.PropTypes.string.isRequired,
  opprettetDato: React.PropTypes.string.isRequired,
  avsluttetDato: React.PropTypes.string,
  behandlingsstatus: React.PropTypes.string.isRequired,
  onlyOneBehandling: React.PropTypes.bool.isRequired,
  showAllBehandlinger: React.PropTypes.bool.isRequired,
  toggleShowAllBehandlingerCallback: React.PropTypes.func,
  selectBehandlingCallback: React.PropTypes.func,
};

BehandlingListItem.defaultProps = {
  toggleShowAllBehandlingerCallback: null,
  selectBehandlingCallback: null,
  avsluttetDato: null,
};

export default BehandlingListItem;
