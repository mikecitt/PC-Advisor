import React, { FC, useEffect, useState } from 'react';
import { LeftOutlined, MacCommandOutlined } from '@ant-design/icons';
import { List } from 'antd';

import SecondaryButton from 'shared/SecondaryButton';
import CPUImage from 'assets/icons/cpu.svg';
import SearchInput from 'shared/SearchInput';
import { getCpus } from 'services/cpu/cpu.service';
import { CPUModel } from 'services/cpu/cpu.model';
import './style.scss';

enum CPUAreaMode {
  Choose,
  Preview
}

const CPUArea: FC = () => {
  const [cpus, setCpus] = useState<Array<CPUModel>>([]);

  useEffect(() => {
    getCpus().then((response) => {
      setCpus(response.data);
    });
  }, []);

  const [mode, setMode] = useState<CPUAreaMode>(CPUAreaMode.Choose);
  const [allCPU, setAllCPU] = useState<Array<any>>([]);

  const PreviewMode = () => (
    <div className="cpu-area__preview">
      <div className="cpu-area__preview__title">CPU</div>
      <div className="cpu-area__preview__body">
        <div className="cpu-area__preview__body__area">
          <div className="cpu-area__preview__body__area__name">
            AMD Ryzen 7 2800x 3.4hz asddas dasd
          </div>
          <SecondaryButton
            text="Change"
            buttonProps={{
              onClick: () => {
                setMode(CPUAreaMode.Choose);
              }
            }}
          />
        </div>
        <img
          src={CPUImage}
          alt="cpu"
          className="cpu-area__preview__body__image"
        />
      </div>
    </div>
  );

  const ChooseMode = () => (
    <div className="cpu-area__choose">
      <div className="cpu-area__choose__header">
        <div className="cpu-area__choose__title">
          <LeftOutlined
            onClick={() => setMode(CPUAreaMode.Preview)}
            className="cpu-area__choose__title__back-icon"
          />
          <div className="cpu-area__choose__title__text">Choose CPU</div>
        </div>
        <SearchInput antInputProps={{ placeholder: 'search' }} />
      </div>
      <div className="cpu-area__choose__body">
        <List
          itemLayout="horizontal"
          className="cpu-area__choose__body__list"
          dataSource={cpus}
          renderItem={(item) => (
            <List.Item>
              <List.Item.Meta
                avatar={<MacCommandOutlined />}
                title={item.displayName}
                description={`${item.cores}-core ${item.frequency}Hz`}
              />
            </List.Item>
          )}
        />
      </div>
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
