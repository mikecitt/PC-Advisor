import React, { FC } from 'react';
import { useDispatch } from 'react-redux';

import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import { nextStep, previousStep } from 'store/compatibility/actions';
import MotherboardArea from '../MotherboardArea';
import './style.scss';

const ChooseMotherboardScreen: FC = () => {
  const dispatch = useDispatch();

  const handlePrevious = () => {
    dispatch(previousStep());
  };

  const handleNext = () => {
    dispatch(nextStep());
  };

  return (
    <>
      <SectionTitle text="Choose motherboard" action={handlePrevious} />
      <MotherboardArea />
      <SecondaryButton text="Next" buttonProps={{ onClick: handleNext }} />
    </>
  );
};

export default ChooseMotherboardScreen;
