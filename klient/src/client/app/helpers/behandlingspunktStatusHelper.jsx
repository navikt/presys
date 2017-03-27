import innvilgetHoverIkonUrl from 'images/innvilget_hover.svg';
import avslaattIkonUrl from 'images/avslaatt.svg';
import avslaattValgtIkonUrl from 'images/avslaatt_valgt.svg';
import avslattHoverIkonUrl from 'images/avslaatt_hover.svg';
import behandleIkonUrl from 'images/behandle.svg';
import behandleValgtIkonUrl from 'images/behandle_valgt.svg';
import behandleHoverIkonUrl from 'images/behandle_hover.svg';
import innvilgetIkonUrl from 'images/innvilget.svg';
import innvilgetValgtIkonUrl from 'images/innvilget_valgt.svg';

import BehandlingspunktStatus from 'constants/behandlingspunktStatus';

const imageMap = new Map();
imageMap.set(BehandlingspunktStatus.INNVILGET, innvilgetIkonUrl);
imageMap.set(BehandlingspunktStatus.AKSJONSPUNKT, behandleIkonUrl);
imageMap.set(BehandlingspunktStatus.AVSLAATT, avslaattIkonUrl);
imageMap.set(BehandlingspunktStatus.BEREGNET, innvilgetIkonUrl);
imageMap.set(BehandlingspunktStatus.IKKE_BEREGNET, behandleIkonUrl);

const selectImageMap = new Map();
selectImageMap.set(BehandlingspunktStatus.INNVILGET, innvilgetValgtIkonUrl);
selectImageMap.set(BehandlingspunktStatus.AKSJONSPUNKT, behandleValgtIkonUrl);
selectImageMap.set(BehandlingspunktStatus.AVSLAATT, avslaattValgtIkonUrl);
selectImageMap.set(BehandlingspunktStatus.BEREGNET, innvilgetValgtIkonUrl);
selectImageMap.set(BehandlingspunktStatus.IKKE_BEREGNET, behandleValgtIkonUrl);

const hooverImageMap = new Map();
hooverImageMap.set(BehandlingspunktStatus.INNVILGET, innvilgetHoverIkonUrl);
hooverImageMap.set(BehandlingspunktStatus.AKSJONSPUNKT, behandleHoverIkonUrl);
hooverImageMap.set(BehandlingspunktStatus.AVSLAATT, avslattHoverIkonUrl);
hooverImageMap.set(BehandlingspunktStatus.BEREGNET, innvilgetHoverIkonUrl);
hooverImageMap.set(BehandlingspunktStatus.IKKE_BEREGNET, behandleHoverIkonUrl);

export const findBehandlingspunktImageSrc = (isHovering, isSelected, status) => {
  const imageSrc = isSelected ? selectImageMap.get(status) : imageMap.get(status);
  return isHovering && !isSelected ? hooverImageMap.get(status) : imageSrc;
};

const statusMap = new Map();
/* Map fra vilkårstatus */
statusMap.set('OPPFYLT', BehandlingspunktStatus.INNVILGET);
statusMap.set('IKKE_OPPFYLT', BehandlingspunktStatus.AVSLAATT);
/* TODO (tor) Håndter status IKKE_RELEVANT og IKKE_VURDERT*/
statusMap.set('IKKE_RELEVANT', BehandlingspunktStatus.AVSLAATT);
statusMap.set('IKKE_VURDERT', BehandlingspunktStatus.AVSLAATT);
/* Map fra aksjonspunktstatus */
statusMap.set('OPPR', BehandlingspunktStatus.AKSJONSPUNKT);
statusMap.set('REAP', BehandlingspunktStatus.AKSJONSPUNKT);
/* Map beregningsstatuser */
statusMap.set('BEREGNET', BehandlingspunktStatus.BEREGNET);
statusMap.set('IKKE_BEREGNET', BehandlingspunktStatus.IKKE_BEREGNET);


export function getBehandlingspunktStatus(status) {
  return statusMap.get(status);
}
