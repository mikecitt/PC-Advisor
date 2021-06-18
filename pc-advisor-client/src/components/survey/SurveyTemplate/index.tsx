import React, { FC } from 'react';
import { useSelector } from 'react-redux';

import { RootState } from 'store';
import QuestionsScreen from '../QuestionsScreen';
import './style.scss';

const SurveyTemplate: FC = () => {
  const step = useSelector((root: RootState) => root.compatibility.step);

  const renderSection = () => {
    switch (step) {
      case 0:
        return <QuestionsScreen />;
      case 1:
        return <ChooseComponentsScreen />;
      case 2:
        return <ResultScreen />;
      default:
        return <></>;
    }
  };

  return renderSection();
};

export default SurveyTemplate;
