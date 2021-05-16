import { applyMiddleware, combineReducers, createStore } from 'redux';
import thunkMiddleware from 'redux-thunk';
import { composeWithDevTools } from 'redux-devtools-extension';

import { compatibilityReducer } from './compatibility/reducer';

const rootReducer = combineReducers({
  compatibility: compatibilityReducer
});

export type RootState = ReturnType<typeof rootReducer>;

const composedEnhancer = composeWithDevTools(applyMiddleware(thunkMiddleware));

const store = createStore(rootReducer, composedEnhancer);
export default store;
