import React, { FC } from 'react';
import { useDispatch } from 'react-redux';

import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import { nextStep } from 'store/compatibility/actions';
import './style.scss';

const StartScreen: FC = () => {
  const dispatch = useDispatch();

  const handleNext = () => {
    dispatch(nextStep());
  };

  return (
    <div>
      <SectionTitle text="Compatibility" style={{ marginBottom: '64px' }} />
      <div className="start-screen__text">
        From here you can choose CPU and motherboard and check if they are
        compatible
      </div>
      <SecondaryButton text="Start" buttonProps={{ onClick: handleNext }} />
    </div>
  );
};

export default StartScreen;
