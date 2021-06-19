import React, { FC } from 'react';
import { useDispatch } from 'react-redux';
import { Select } from 'antd';

import PInput from 'shared/PInput';
import PSelect from 'shared/PSelect';
import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import {
  nextSurveyStep,
  previousSurveyStep,
  setSurveyAffinities
} from 'store/survey/actions';
import './style.scss';
import { useState } from 'react';

const { Option } = Select;

const AffinitiesScreen: FC = () => {
  const dispatch = useDispatch();

  const [brandPref, setBrandPref] = useState<'AMD' | 'INTEL' | null>('AMD');
  const [storageMin, setStorageMin] = useState<number>(0);
  const [budget, setBudget] = useState<number>(0);

  const handlePrevious = () => {
    dispatch(previousSurveyStep());
  };

  const handleCPUBrandChange = (value: string) => {
    switch (value) {
      case 'AMD':
        setBrandPref('AMD');
        break;
      case 'INTEL':
        setBrandPref('AMD');
        break;
      case 'NONE':
        setBrandPref(null);
        break;
    }
  };

  const handleContinue = () => {
    setSurveyAffinities({ brandPref, storageMin, budget });
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
        <PSelect
          antSelectProps={{ placeholder: 'Brand' }}
          onChange={(value: string) => handleCPUBrandChange(value)}
        >
          <Option value="AMD">AMD</Option>
          <Option value="INTEL">Intel</Option>
          <Option value="NONE">None</Option>
        </PSelect>
        <PInput
          antInputProps={{
            placeholder: 'Minimum storage in Gigabytes'
          }}
          onChange={(event) =>
            setStorageMin(event.target.value as unknown as number)
          }
        />
        <PInput
          antInputProps={{ placeholder: 'Minimum budget €' }}
          onChange={(event) =>
            setBudget(event.target.value as unknown as number)
          }
        />
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
