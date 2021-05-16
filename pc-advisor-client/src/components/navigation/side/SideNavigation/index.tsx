import React, { FC } from 'react';
import { Link } from 'gatsby';

import './style.scss';

const SideNavigation: FC = () => (
  <div className="side-navigation">
    <div className="side-navigation__title">
      <Link to="/" className="side-navigation__logo">
        PC Advisor
      </Link>
    </div>
  </div>
);

export default SideNavigation;
