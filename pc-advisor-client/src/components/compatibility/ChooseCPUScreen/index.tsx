import React, { FC } from 'react';

import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import { useDispatch } from 'react-redux';
import { nextStep, previousStep } from 'store/compatibility/actions';
import CPUArea from '../CPUArea';
import './style.scss';

const ChooseCpuScreen: FC = () => {
  const dispatch = useDispatch();

  const handlePrevious = () => {
    dispatch(previousStep());
  };

  const handleNext = () => {
    dispatch(nextStep());
  };

  return (
    <>
      <SectionTitle text="Choose CPU" action={handlePrevious} />
      <CPUArea />
      <SecondaryButton text="Next" buttonProps={{ onClick: handleNext }} />
    </>
  );
};

export default ChooseCpuScreen;
