import React, { FC } from 'react';
import { Button, ButtonProps } from 'antd';

import BackIcon from 'assets/icons/back-icon.svg';
import BaseProps from 'shared/props';
import './style.scss';

interface BackButtonProps extends BaseProps {
  antButtonProps?: ButtonProps;
}

const BackButton: FC<BackButtonProps> = ({ antButtonProps, style }) => (
  <Button
    shape="circle"
    className="back-button"
    icon={
      <svg
        width="11"
        height="18"
        viewBox="0 0 11 18"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path d="M10 1L2 9L10 17" stroke="#183a86" strokeWidth="1.5" />
      </svg>
    }
    {...antButtonProps}
    style={style}
  />
);

export default BackButton;
