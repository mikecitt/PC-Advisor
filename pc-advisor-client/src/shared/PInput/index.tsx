import React, { FC } from 'react';
import { Input, InputProps } from 'antd';

import './style.scss';

interface PInputProps {
  onChange?: (event: React.ChangeEvent<HTMLInputElement>) => void;
  antInputProps?: InputProps;
}

const TInput: FC<PInputProps> = ({ onChange, antInputProps }) => (
  <Input className="p-input" {...antInputProps} onChange={onChange} />
);

export default TInput;
