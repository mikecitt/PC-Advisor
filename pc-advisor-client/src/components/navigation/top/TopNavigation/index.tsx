import React, { FC } from 'react';
import { Menu } from 'antd';
import {
  BuildOutlined,
  PieChartOutlined,
  FileSearchOutlined
} from '@ant-design/icons';
import { useLocation } from '@reach/router';

import './style.scss';
import { Link } from 'gatsby';

const TopNavigation: FC = () => {
  const { pathname } = useLocation();

  return (
    <div className="top-navigation">
      <div>
        <Menu mode="horizontal" className="top-navigation__menu">
          <Menu.Item
            key="survey"
            icon={<FileSearchOutlined />}
            className={pathname === '/survey' ? 'ant-menu-item-selected' : ''}
          >
            <Link to="/survey">Survey</Link>
          </Menu.Item>
          <Menu.Item
            key="build"
            icon={<BuildOutlined />}
            className={pathname === '/build' ? 'ant-menu-item-selected' : ''}
          >
            <Link to="/build">Build own</Link>
          </Menu.Item>
          <Menu.Item
            key="compatibility"
            icon={<PieChartOutlined />}
            className={
              pathname === '/compatibility' ? 'ant-menu-item-selected' : ''
            }
          >
            <Link to="/compatibility">Compatibility</Link>
          </Menu.Item>
        </Menu>
      </div>
    </div>
  );
};

export default TopNavigation;
