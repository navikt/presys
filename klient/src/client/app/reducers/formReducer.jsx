import * as types from 'constants/actionTypes';
import { isEqual } from 'helpers/objectUtils';

const updateModel = (currentData, newData) => {
  const data = JSON.parse(JSON.stringify(currentData));

  let model = data[newData.code];
  if (!model) {
    model = {};
  }

  Object.keys(newData.model).forEach((key) => {
    model[key] = newData.model[key];
  });

  data[newData.code] = model;

  return data;
};

const hasNewModel = (newModels, previousModels) => {
  let isNew = false;
  Object.keys(newModels).forEach((key) => {
    if (!previousModels[key]) {
      isNew = true;
    }
  });
  return isNew;
};

export default function formReducer(state = {
  models: {},
  previousModels: {},
  showErrors: false,
  isDirty: false,
  validationErrors: {},
  isSubmitting: false,
  submitSuccess: false,
},
  action = null) {
  switch (action.type) {
    case types.RESET_MODEL:
      return Object.assign({ }, state, {
        models: {},
        previousModels: {},
        showErrors: false,
        validationErrors: {},
        isSubmitting: false,
        submitSuccess: false,
        isDirty: false,
      });
    case types.SET_MODEL: {
      const newModels = updateModel(state.models, action.data);
      const newModelAdded = hasNewModel(newModels, state.previousModels);
      return Object.assign({ }, state, {
        models: newModels,
        previousModels: newModelAdded ? newModels : state.previousModels,
        showErrors: state.showErrors,
        validationErrors: state.validationErrors,
        isSubmitting: state.isSubmitting,
        submitSuccess: state.submitSuccess,
        isDirty: newModelAdded ? false : !isEqual(state.previousModels, newModels),
      });
    }
    case types.SET_PREVIOUS_MODEL:
      return Object.assign({ }, state, {
        models: state.previousModels,
        previousModels: state.previousModels,
        showErrors: false,
        validationErrors: state.validationErrors,
        isSubmitting: state.isSubmitting,
        submitSuccess: state.submitSuccess,
        isDirty: false,
      });
    case types.SHOW_FORM_ERRORS:
      return Object.assign({ }, state, {
        models: state.models,
        previousModels: state.previousModels,
        showErrors: true,
        validationErrors: state.validationErrors,
        isSubmitting: false,
        submitSuccess: false,
        isDirty: state.isDirty,
      });
    case types.SET_FORM_ERRORS:
      return Object.assign({ }, state, {
        models: state.models,
        previousModels: state.previousModels,
        showErrors: state.showErrors,
        validationErrors: action.data,
        isSubmitting: false,
        submitSuccess: false,
        isDirty: state.isDirty,
      });
    case types.FORM_SAVE_STARTED:
      return Object.assign({ }, state, {
        models: state.models,
        previousModels: state.previousModels,
        showErrors: false,
        validationErrors: {},
        isSubmitting: true,
        submitSuccess: false,
        isDirty: state.isDirty,
      });
    case types.FORM_POST_SUCCESS:
      return Object.assign({ }, state, {
        models: state.models,
        previousModels: state.models,
        showErrors: false,
        validationErrors: {},
        isSubmitting: false,
        submitSuccess: true,
        isDirty: false,
      });
    default:
      return state;
  }
}
