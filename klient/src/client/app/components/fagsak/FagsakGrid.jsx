import React from 'react';
import fagsakPropType from 'constants/propTypes/fagsakPropType';

import Person from 'components/person/Person';
import Fagsak from './Fagsak';

import styles from './fagsakGrid.less';

const FagsakGrid = ({
  selectedFagsak,
  behandlingListePanel,
  infoPanel,
  behandlingspunktPanel,
}) => (
  <div className={styles.container}>
    <div>
      <div className={styles['col-md-8']}>
        <div className={styles.row}>
          <div className={styles['col-xs-12']}>
            <div className={styles['person--column']}>
              {selectedFagsak !== null &&
              <Person
                navn={selectedFagsak.person.navn}
                alder={selectedFagsak.person.alder}
                personnummer={selectedFagsak.person.personnummer}
                erKvinne={selectedFagsak.person.erKvinne}
                hasLargeFont
              />
          }
            </div>
          </div>
        </div>
        <div className={styles.row}>
          <div className={styles['col-xs-12']}>
            <div className={styles['behandlingspunkt--column']}>
              {behandlingspunktPanel}
            </div>
          </div>
        </div>
      </div>

      <div className={styles['col-md-4']}>
        <div className={styles.row}>
          <div className={styles['col-xs-12']}>
            <div className={styles['behandlinger--column']}>
              {selectedFagsak !== null &&
              <Fagsak
                saksnummer={selectedFagsak.saksnummer}
                sakstype={selectedFagsak.sakstype.navn}
                status={selectedFagsak.status.navn}
              />
              }
              {behandlingListePanel}
            </div>
          </div>
        </div>
        <div className={styles.row}>
          <div className={styles['col-xs-12']}>
            <div className={styles['historikk--column']}>
              {infoPanel}
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
);

FagsakGrid.propTypes = {
  selectedFagsak: fagsakPropType,
  behandlingListePanel: React.PropTypes.element.isRequired,
  infoPanel: React.PropTypes.element.isRequired,
  behandlingspunktPanel: React.PropTypes.element.isRequired,
};

FagsakGrid.defaultProps = {
  selectedFagsak: null,
};


export default FagsakGrid;
