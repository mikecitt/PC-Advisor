import React, { FC } from 'react';
import { Radio, RadioChangeEvent, RadioProps } from 'antd';

import BaseProps from 'shared/props';
import './style.scss';

interface PRadioProps extends BaseProps {
  antRadioProps?: RadioProps;
  onChange?: (e: RadioChangeEvent) => void;
  value?: any;
}

const PRadio: FC<PRadioProps> = ({
  antRadioProps,
  style,
  children,
  onChange,
  value
}) => (
  <Radio
    {...antRadioProps}
    style={style}
    className="pradio"
    value={value}
    onChange={onChange}
  >
    {children}
  </Radio>
);

export default PRadio;
