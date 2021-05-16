import React from 'react';
import { Provider } from 'react-redux';

import store from 'store';
import 'styles/global.scss';

export const wrapRootElement = ({ element }) => (
  <Provider store={store}>
    {element}
  </Provider>
);
