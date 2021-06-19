import React, { FC } from 'react';
import { Tag, TagProps } from 'antd';

import './style.scss';
import BaseProps from 'shared/props';

const { CheckableTag } = Tag;

interface TTagProps extends BaseProps {
  text?: string;
  antTagProps?: TagProps;
}

const TTag: FC<TTagProps> = ({ text, antTagProps, style }) => {
  const [checked, setChecked] = React.useState<boolean>(false);

  return (
    <CheckableTag
      checked={checked}
      onChange={(value: boolean) => setChecked(value)}
      className="ttag"
      style={style}
    >
      {text}
    </CheckableTag>
  );
};

export default TTag;
