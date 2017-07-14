import reducerFactory from '../common/personDependentReducer';
import actionCreator, { actionsFor } from '../common/action';

const actionTypes = actionsFor('inntekt');
export default reducerFactory(actionTypes);
export const fetch = actionCreator('inntekter', actionTypes.fetch);
