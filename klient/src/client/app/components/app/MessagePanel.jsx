import React from 'react';

import style from './messagePanel.less';

const MessagePanel = ({
  errorMessage,
}) => (
  <div className={style.container}>
    {errorMessage}
  </div>
);

MessagePanel.propTypes = {
  errorMessage: React.PropTypes.string.isRequired,
};

export default MessagePanel;
