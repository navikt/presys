import reducerFactory from '../common/personDependentReducer';
import actionCreator, { actionsFor } from '../common/action';

const actionTypes = actionsFor('status');
export default reducerFactory(actionTypes);
export const fetch = actionCreator('status', actionTypes.fetch);
