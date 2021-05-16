import React, { FC } from 'react';

import BackButton from 'shared/BackButton';
import BaseProps from 'shared/props';
import './style.scss';

interface SectionTitleProps extends BaseProps {
  action?: (event: React.MouseEvent<HTMLElement, MouseEvent>) => void;
  text: string;
}

const SectionTitle: FC<SectionTitleProps> = ({ text, action, style }) => (
  <div className="section-title" style={style}>
    {action && (
      <BackButton
        antButtonProps={{ onClick: action }}
        style={{ marginRight: '32px' }}
      />
    )}
    <span className="section-title__text">{text}</span>
  </div>
);

export default SectionTitle;
