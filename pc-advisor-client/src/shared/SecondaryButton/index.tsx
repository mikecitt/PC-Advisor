import React, { FC } from 'react';

import BaseProps from 'shared/props';
import './style.scss';

interface SecondaryButtonProps extends BaseProps {
  text: string;
  buttonProps?: React.DetailedHTMLProps<
    React.ButtonHTMLAttributes<HTMLButtonElement>,
    HTMLButtonElement
  >;
}

const SecondaryButton: FC<SecondaryButtonProps> = ({
  text,
  style,
  buttonProps
}) => (
  // eslint-disable-next-line react/button-has-type
  <button className="secondary-button" style={style} {...buttonProps}>
    {text}
  </button>
);

export default SecondaryButton;
