import React, { FC } from 'react';
import { useDispatch } from 'react-redux';

import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import { nextStep, previousStep } from 'store/compatibility/actions';
import CPUArea from '../CPUArea';
import MotherboardArea from '../MotherboardArea';
import './style.scss';

const ChooseComponentsScreen: FC = () => {
  const dispatch = useDispatch();

  const handlePrevious = () => {
    dispatch(previousStep());
  };

  const handleNext = () => {
    dispatch(nextStep());
  };

  return (
    <>
      <SectionTitle
        text="Components"
        action={handlePrevious}
        style={{ marginBottom: '64px' }}
      />
      <div className="choose-components__wrapper">
        <div className="choose-components">
          <CPUArea />
          <MotherboardArea />
        </div>
        <SecondaryButton
          text="Next"
          buttonProps={{ onClick: handleNext }}
          style={{ marginTop: '32px' }}
        />
      </div>
    </>
  );
};

export default ChooseComponentsScreen;
