import React, { FC, ReactNode } from 'react';
import { Select, SelectProps } from 'antd';

import './style.scss';

interface PSelectProps<T> {
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  onChange?: any;
  antSelectProps?: SelectProps<T>;
  children: ReactNode;
}

const PSelect: FC<PSelectProps<string | number>> = ({
  onChange,
  antSelectProps,
  children
}) => (
  <Select {...antSelectProps} onChange={onChange}>
    {children}
  </Select>
);

export default PSelect;
