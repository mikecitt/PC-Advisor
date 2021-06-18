import React, { FC, useEffect, useState } from 'react';
import { LeftOutlined, MacCommandOutlined } from '@ant-design/icons';
import { List } from 'antd';

import SecondaryButton from 'shared/SecondaryButton';
import MotherboardImage from 'assets/icons/motherboard.svg';
import SearchInput from 'shared/SearchInput';
import { MotherboardModel } from 'services/motherboard/motherboard.model';
import { useDispatch, useSelector } from 'react-redux';
import { RootState } from 'store';
import { setCompatibilityMotherboard } from 'store/compatibility/actions';
import { getMotherboards } from 'services/motherboard/motherboard.service';
import './style.scss';

enum MotherboardAreaMode {
  Choose,
  Preview
}

const MotherboardArea: FC = () => {
  const dispatch = useDispatch();
  const [mode, setMode] = useState<MotherboardAreaMode>(
    MotherboardAreaMode.Choose
  );
  const selectedMotherboard = useSelector(
    (state: RootState) => state.compatibility.motherboard
  );

  const PreviewMode = () => (
    <div className="motherboard-area__preview">
      <div className="motherboard-area__preview__title">Motherboard</div>
      <div className="motherboard-area__preview__body">
        <div className="motherboard-area__preview__body__area">
          <div className="motherboard-area__preview__body__area__name">
            {selectedMotherboard
              ? selectedMotherboard.displayName
              : 'None selected'}
          </div>
          <SecondaryButton
            text="Change"
            buttonProps={{
              onClick: () => {
                setMode(MotherboardAreaMode.Choose);
              }
            }}
          />
        </div>
        <img
          src={MotherboardImage}
          alt="motherboard"
          className="motherboard-area__preview__body__image"
        />
      </div>
    </div>
  );

  const ChooseMode = () => {
    const [motherboards, setMotherboards] = useState<Array<MotherboardModel>>(
      []
    );

    useEffect(() => {
      getMotherboards().then((response) => {
        setMotherboards(response.data);
      });
    }, []);

    const handleMotherboardSelect = (motherboard: MotherboardModel) => {
      dispatch(setCompatibilityMotherboard(motherboard));

      setMode(MotherboardAreaMode.Preview);
    };

    return (
      <div className="motherboard-area__choose">
        <div className="motherboard-area__choose__header">
          <div className="motherboard-area__choose__title">
            <LeftOutlined
              onClick={() => setMode(MotherboardAreaMode.Preview)}
              className="motherboard-area__choose__title__back-icon"
            />
            <div className="motherboard-area__choose__title__text">
              Choose Motherboard
            </div>
          </div>
          <SearchInput antInputProps={{ placeholder: 'search' }} />
        </div>
        <div className="motherboard-area__choose__body">
          <List
            itemLayout="horizontal"
            className="motherboard-area__choose__body__list"
            dataSource={motherboards}
            renderItem={(item) => (
              <List.Item onClick={() => handleMotherboardSelect(item)}>
                <List.Item.Meta
                  avatar={<MacCommandOutlined />}
                  title={item.displayName}
                  description={`${item.price}€`}
                />
              </List.Item>
            )}
          />
        </div>
      </div>
    );
  };

  const renderMode = () => {
    switch (mode) {
      case MotherboardAreaMode.Preview:
        return <PreviewMode />;
      case MotherboardAreaMode.Choose:
        return <ChooseMode />;
      default:
        return <></>;
    }
  };

  return <div className="motherboard-area">{renderMode()}</div>;
};

export default MotherboardArea;
