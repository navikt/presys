import React from 'react';
import { Link } from 'react-router';
import { FormattedMessage } from 'react-intl';

import { missingPageContainer } from './missingPage.less';

const MissingPage = () => (
  <div className={missingPageContainer}>
    <FormattedMessage id="MissingPage.PageIsMissing" />
    <br />
    <Link to="/"><FormattedMessage id="MissingPage.Home" /></Link>
  </div>
);

export default MissingPage;
