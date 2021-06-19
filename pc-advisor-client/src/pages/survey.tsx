import React, { FC } from 'react';

import BaseTemplate from 'components/base/BaseTemplate';
import SurveyTemplate from 'components/survey/SurveyTemplate';

const SurveyPage: FC = () => (
  <BaseTemplate>
    <SurveyTemplate />
  </BaseTemplate>
);

export default SurveyPage;
