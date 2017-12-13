import React from 'react';
import { FormattedMessage } from 'react-intl';

import style from './messagePanel.less';

const MessagePanel = ({
  errorMessage,
}) => (
  <div className={style.container}>
    <FormattedMessage id={errorMessage} />
  </div>
);

MessagePanel.propTypes = {
  errorMessage: React.PropTypes.string.isRequired,
};

export default MessagePanel;
