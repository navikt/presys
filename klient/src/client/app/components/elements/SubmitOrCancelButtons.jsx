import React from 'react';

import Button from 'elements/Button';

import styles from './submitOrCancelButtons.less';

const SubmitOrCancelButtons = ({
  readOnly,
  cancelCallback,
  isDirty,
}) => {
  if (isDirty) {
    return (
      <div>
        <Button className={styles.confirmButton} type="submit" textCode="SubmitButton.SaveAndConfirm" />
        <Button className={styles.cancelButton} textCode="SubmitButton.Cancel" onClick={cancelCallback} />
      </div>
    );
  }

  return (
    <Button className={readOnly ? styles.confirmButtonReadOnly : styles.confirmButton} type="submit" textCode="SubmitButton.ConfirmInformation" />
  );
};

SubmitOrCancelButtons.propTypes = {
  readOnly: React.PropTypes.bool.isRequired,
  cancelCallback: React.PropTypes.func.isRequired,
  isDirty: React.PropTypes.bool.isRequired,
};

export default SubmitOrCancelButtons;
