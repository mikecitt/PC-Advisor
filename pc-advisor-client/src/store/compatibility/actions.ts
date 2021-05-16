import { NEXT_STEP, PREVIOUS_STEP, RESET, SET_CPU } from './reducer';

export const nextStep = () => {
  return {
    type: NEXT_STEP
  };
};

export const previousStep = () => {
  return {
    type: PREVIOUS_STEP
  };
};

export const reset = () => {
  return {
    type: RESET
  };
};

export const setCPU = (cpu: any) => {
  return {
    type: SET_CPU,
    payload: cpu
  };
};

export const setMotherboard = (motherboard: any) => {
  return {
    type: RESET,
    payload: motherboard
  };
};
