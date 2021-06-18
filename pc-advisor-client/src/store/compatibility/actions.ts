import { CPUModel } from 'services/cpu/cpu.model';
import { MotherboardModel } from 'services/motherboard/motherboard.model';
import {
  NEXT_STEP,
  PREVIOUS_STEP,
  RESET,
  SET_CPU,
  SET_MOTHERBOARD
} from './reducer';

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

export const setCPU = (cpu: CPUModel) => {
  return {
    type: SET_CPU,
    payload: { cpu }
  };
};

export const setMotherboard = (motherboard: MotherboardModel) => {
  return {
    type: SET_MOTHERBOARD,
    payload: { motherboard }
  };
};
