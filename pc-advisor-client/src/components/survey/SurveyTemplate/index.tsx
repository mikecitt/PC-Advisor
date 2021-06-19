import React, { FC } from 'react';
import { useSelector } from 'react-redux';

import { RootState } from 'store';
import AffinitiesScreen from '../AffinitiesScreen';
import ComputerProgramsScreen from '../ComputerProgramsScreen';
import PCBuildsScreen from '../PCBuildsScreen';
import QuestionsScreen from '../QuestionsScreen';
import StartScreen from '../StartScreen';

const SurveyTemplate: FC = () => {
  const step = useSelector((root: RootState) => root.survey.step);

  const renderSection = () => {
    switch (step) {
      case 0:
        return <StartScreen />;
      case 1:
        return <QuestionsScreen />;
      case 2:
        return <ComputerProgramsScreen />;
      case 3:
        return <AffinitiesScreen />;
      case 4:
        return <PCBuildsScreen />;
      default:
        return <></>;
    }
  };

  return renderSection();
};

export default SurveyTemplate;
