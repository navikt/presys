import reducerFactory from '../common/personDependentReducer';
import actionCreator, { actionsFor } from '../common/action';

const actionTypes = actionsFor('transaksjonshistorikk');
export default reducerFactory(actionTypes);
export const fetch = actionCreator('tranHister', actionTypes.fetch);
