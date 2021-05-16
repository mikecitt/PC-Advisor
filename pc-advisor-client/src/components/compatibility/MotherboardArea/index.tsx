import React, { FC } from 'react';

import SecondaryButton from 'shared/SecondaryButton';
import MotherboardImage from 'assets/icons/motherboard.svg';
import './style.scss';

const MotherboardArea: FC = () => {
  return (
    <div className="cpu-area">
      <div className="cpu-area__title">CPU</div>
      <div className="cpu-area__body">
        <div>
          <div className="cpu-area__subtitle">AMD Ryzen 7 2800x 3.4hz</div>
          <div className="cpu-area__subtitle">Price: $300</div>
          <SecondaryButton text="Change" />
        </div>
        <img src={MotherboardImage} alt="cpu" className="cpu-area__image" />
      </div>
    </div>
  );
};

export default MotherboardArea;
