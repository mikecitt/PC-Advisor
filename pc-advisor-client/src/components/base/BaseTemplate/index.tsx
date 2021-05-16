import React, { FC } from 'react';
import { Layout } from 'antd';

import TopNavigation from 'components/navigation/top/TopNavigation';
import SideNavigation from 'components/navigation/side/SideNavigation';
import './style.scss';

const { Header, Content, Sider } = Layout;

const BaseTemplate: FC = ({ children }) => (
  <Layout className="home-template">
    <Sider className="home-template__sider" breakpoint="md" collapsedWidth="0">
      <SideNavigation />
    </Sider>
    <Layout className="home-template__layout">
      <Header className="home-template__layout__header">
        <TopNavigation />
      </Header>
      <Content className="home-template__layout__content">{children}</Content>
    </Layout>
  </Layout>
);

export default BaseTemplate;
