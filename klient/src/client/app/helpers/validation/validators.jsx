import { isRequiredMessage, minLengthMessage, maxLengthMessage } from './messages';

const isEmpty = text => !text || text.toString().trim().length === 0;

export const required = text => (isEmpty(text) ? isRequiredMessage : null);

export const requiredWhen = callback => (text, state, context) => (isEmpty(text) && callback(context) ? isRequiredMessage : null);

export const minLength = length => text => (isEmpty(text) || text.toString().trim().length >= length ? null : minLengthMessage(length));

export const maxLength = length => text => (isEmpty(text) || text.toString().trim().length <= length ? null : maxLengthMessage(length));
