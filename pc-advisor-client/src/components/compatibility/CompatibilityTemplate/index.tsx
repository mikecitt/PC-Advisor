import React, { FC } from 'react';
import { useSelector } from 'react-redux';

import { RootState } from 'store';
import StartScreen from '../StartScreen';
import ChooseCPUScreen from '../ChooseCPUScreen';
import ChooseMotherboardScreen from '../ChooseMotherboardScreen';
import ResultScreen from '../ResultScreen';
import './style.scss';

const CompatibilityTemplate: FC = () => {
  const step = useSelector((root: RootState) => root.compatibility.step);

  const renderSection = () => {
    switch (step) {
      case 0:
        return <StartScreen />;
      case 1:
        return <ChooseCPUScreen />;
      case 2:
        return <ChooseMotherboardScreen />;
      case 3:
        return <ResultScreen />;
      default:
        return <></>;
    }
  };

  return renderSection();
};

export default CompatibilityTemplate;
