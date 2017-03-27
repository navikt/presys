export const ruleRunner = (field, name, ...validations) => (state, context) => validations
.map(v => v(state[field], state, context))
.filter(errorMessageFunc => errorMessageFunc)
.reduce((prev, errorMessageFunc) => prev || ({ [field]: errorMessageFunc(name) }), null);

export const run = (state, runners, context) => runners.reduce((prev, runner) => Object.assign(prev, runner(state, context)), {});
