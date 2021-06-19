import React, { FC } from 'react';
import { Tag, TagProps } from 'antd';

import './style.scss';
import BaseProps from 'shared/props';

const { CheckableTag } = Tag;

interface TTagProps extends BaseProps {
  text?: string;
  onChange?: (checked: boolean) => void;
}

const TTag: FC<TTagProps> = ({ text, style, onChange }) => {
  const [checked, setChecked] = React.useState<boolean>(false);

  const handleOnChange = (checked: boolean) => {
    setChecked(checked);
    onChange && onChange(checked);
  };

  return (
    <CheckableTag
      onChange={handleOnChange}
      checked={checked}
      className="ttag"
      style={style}
    >
      {text}
    </CheckableTag>
  );
};

export default TTag;
