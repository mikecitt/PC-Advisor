import React, { FC } from 'react';
import { useDispatch } from 'react-redux';

import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import { nextSurveyStep } from 'store/survey/actions';
import './style.scss';

const StartScreen: FC = () => {
  const dispatch = useDispatch();

  const handleNext = () => {
    dispatch(nextSurveyStep());
  };

  return (
    <>
      <SectionTitle text="Survey" style={{ marginBottom: '64px' }} />
      <div className="start-screen">
        <div className="start-screen__text">
          In the next sections you will be guided throw the flow of finding a
          best PC for you
        </div>
        <SecondaryButton text="Start" buttonProps={{ onClick: handleNext }} />
      </div>
    </>
  );
};

export default StartScreen;
