import React, { FC } from 'react';
import { useSelector } from 'react-redux';

import { RootState } from 'store';
import StartScreen from '../StartScreen';
import ResultScreen from '../ResultScreen';
import ChooseComponentsScreen from '../ChooseComponentsScreen';

const CompatibilityTemplate: FC = () => {
  const step = useSelector((root: RootState) => root.compatibility.step);

  const renderSection = () => {
    switch (step) {
      case 0:
        return <StartScreen />;
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

export default CompatibilityTemplate;
