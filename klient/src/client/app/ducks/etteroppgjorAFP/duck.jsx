import reducerFactory from '../common/personDependentReducer';
import actionCreator, { actionsFor } from '../common/action';

const actionTypes = actionsFor('afpetteroppgjor');
export default reducerFactory(actionTypes);
export const fetch = actionCreator('etteroppgjor', actionTypes.fetch);
