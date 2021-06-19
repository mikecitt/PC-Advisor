import { Card, Select } from 'antd';
import React, { FC } from 'react';

import { PCBuildModel } from 'services/pc-build/pc-build.model';
import './style.scss';
import BaseProps from 'shared/props';

const { Option } = Select;

interface PCBuildProps extends BaseProps {
  pcBuild: PCBuildModel;
}

const PCBuild: FC<PCBuildProps> = ({ pcBuild, style }) => {
  return (
    <Card style={style} title="PC Build">
      CPU: {pcBuild.cpu?.displayName}
      <br />
      GPU: {pcBuild.gpu?.displayName}
      <br />
      Motherboard: {pcBuild.motherboard?.displayName}
      <br />
      Power Supply: {pcBuild.powerSupply?.displayName}
      <br />
      Storage: {pcBuild.storage?.map((storage) => storage.displayName + ' ')}
      <br />
      RAM: {pcBuild.ram?.displayName}
    </Card>
  );
};

export default PCBuild;
