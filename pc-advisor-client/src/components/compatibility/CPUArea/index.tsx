import React, { FC, useState } from 'react';
import axios from 'axios';

import SecondaryButton from 'shared/SecondaryButton';
import CPUImage from 'assets/icons/cpu.svg';
import { LeftOutlined } from '@ant-design/icons';
import './style.scss';

enum CPUAreaMode {
  Choose,
  Preview
}

const CPUArea: FC = () => {
  const fetchCPU = async () => {
    const response = await axios.get('http://localhost:8080/api/cpu');
    return response.data;
  };

  const [mode, setMode] = useState<CPUAreaMode>(CPUAreaMode.Choose);
  const [allCPU, setAllCPU] = useState<Array<any>>([]);

  const PreviewMode = () => (
    <div className="cpu-area__preview">
      <div className="cpu-area__preview__title">CPU</div>
      <div className="cpu-area__preview__body">
        <div>
          <div className="cpu-area__preview__subtitle">
            AMD Ryzen 7 2800x 3.4hz
          </div>
          <div className="cpu-area__preview__subtitle">Price: $300</div>
          <SecondaryButton
            text="Change"
            buttonProps={{
              onClick: () => {
                fetchCPU();
                setMode(CPUAreaMode.Choose);
              }
            }}
          />
        </div>
        <img src={CPUImage} alt="cpu" className="cpu-area__preview__image" />
      </div>
    </div>
  );

  const ChooseMode = () => (
    <div className="cpu-area__search">
      <div className="cpu-area__search__header">
        <LeftOutlined onClick={() => setMode(CPUAreaMode.Preview)} />
        <span>Choose</span>
      </div>
      {allCPU.map((cpu) => (
        <span>{cpu.displayName}</span>
      ))}
    </div>
  );

  const renderMode = () => {
    switch (mode) {
      case CPUAreaMode.Preview:
        return <PreviewMode />;
      case CPUAreaMode.Choose:
        return <ChooseMode />;
      default:
        return <></>;
    }
  };

  return <div className="cpu-area">{renderMode()}</div>;
};

export default CPUArea;
