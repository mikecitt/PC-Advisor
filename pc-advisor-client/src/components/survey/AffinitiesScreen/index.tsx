import React, { FC } from 'react';
import { useDispatch } from 'react-redux';
import { Select } from 'antd';

import PInput from 'shared/PInput';
import PSelect from 'shared/PSelect';
import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import { nextSurveyStep, previousSurveyStep } from 'store/survey/actions';
import './style.scss';

const { Option } = Select;

const AffinitiesScreen: FC = () => {
  const dispatch = useDispatch();

  const handlePrevious = () => {
    dispatch(previousSurveyStep());
  };

  const handleContinue = () => {
    dispatch(nextSurveyStep());
  };

  return (
    <>
      <SectionTitle
        text="Affinities"
        action={handlePrevious}
        style={{ marginBottom: '64px' }}
      />
      <div className="affinities-screen">
        <PSelect antSelectProps={{ placeholder: 'Brand' }}>
          <Option value="amd">AMD</Option>
          <Option value="intel">Intel</Option>
        </PSelect>
        <PInput
          antInputProps={{ placeholder: 'Minimum storage in Gigabytes' }}
        />
        <PInput antInputProps={{ placeholder: 'Minimum budget €' }} />
        <SecondaryButton
          text="Next"
          style={{ alignSelf: 'flex-end' }}
          buttonProps={{ onClick: handleContinue }}
        />
      </div>
    </>
  );
};

export default AffinitiesScreen;
