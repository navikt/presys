import React from 'react';
import { FormattedMessage } from 'react-intl';

export const isRequiredMessage = () => <FormattedMessage id="ValidationMessage.NotEmpty" />;
export const minLengthMessage = length => () => <FormattedMessage id="ValidationMessage.MinLength" values={{ length }} />;
export const maxLengthMessage = length => () => <FormattedMessage id="ValidationMessage.MaxLength" values={{ length }} />;
