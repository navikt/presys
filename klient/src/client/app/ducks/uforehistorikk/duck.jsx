import reducerFactory from '../common/personDependentReducer';
import actionCreator, { actionsFor } from '../common/action';

const actionTypes = actionsFor('uforehistorikk');
export default reducerFactory(actionTypes);
export const fetch = actionCreator('uforeHistorikk', actionTypes.fetch);
