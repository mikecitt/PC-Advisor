import React, { FC } from 'react';
import { Result } from 'antd';

import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import { useDispatch } from 'react-redux';
import { nextStep, previousStep } from 'store/compatibility/actions';
import './style.scss';

const ResultScreen: FC = () => {
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
      <Result
        status="success"
        title="Successfully Purchased Cloud Server ECS!"
        subTitle="Order number: 2017182818828182881 Cloud server configuration takes 1-5 minutes, please wait."
      />
      <SecondaryButton text="Next" buttonProps={{ onClick: handleNext }} />
    </>
  );
};

export default ResultScreen;
