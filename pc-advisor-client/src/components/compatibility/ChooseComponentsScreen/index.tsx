import React, { FC } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import { RootState } from 'store';
import {
  nextCompatibilityStep,
  previousCompatibilityStep
} from 'store/compatibility/actions';
import CPUArea from '../CPUArea';
import MotherboardArea from '../MotherboardArea';
import './style.scss';

const ChooseComponentsScreen: FC = () => {
  const areComponentsSelected: boolean = useSelector(
    (state: RootState) =>
      state.compatibility.cpu !== null &&
      state.compatibility.motherboard !== null
  );

  const dispatch = useDispatch();

  const handlePrevious = () => {
    dispatch(previousCompatibilityStep());
  };

  const handleNext = () => {
    dispatch(nextCompatibilityStep());
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
          buttonProps={{
            onClick: handleNext,
            disabled: !areComponentsSelected
          }}
          style={{ marginTop: '32px' }}
        />
      </div>
    </>
  );
};

export default ChooseComponentsScreen;
