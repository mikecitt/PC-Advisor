import React, { FC } from 'react';
import { Input, InputProps } from 'antd';
import { SearchOutlined } from '@ant-design/icons';

import './style.scss';
import BaseProps from 'shared/props';

interface SearchInputProps extends BaseProps {
  antInputProps: InputProps;
}

const SearchInput: FC<SearchInputProps> = ({ antInputProps, style }) => {
  return (
    <Input
      {...antInputProps}
      prefix={<SearchOutlined />}
      className="search-input"
      style={style}
    />
  );
};

export default SearchInput;
