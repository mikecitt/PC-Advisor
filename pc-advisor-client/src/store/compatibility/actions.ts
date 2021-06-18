import { CPUModel } from 'services/cpu/cpu.model';
import { MotherboardModel } from 'services/motherboard/motherboard.model';
import {
  NEXT_STEP,
  PREVIOUS_STEP,
  RESET,
  SET_CPU,
  SET_MOTHERBOARD
} from './reducer';

export const nextCompatibilityStep = () => {
  return {
    type: NEXT_STEP
  };
};

export const previousCompatibilityStep = () => {
  return {
    type: PREVIOUS_STEP
  };
};

export const resetCompatibility = () => {
  return {
    type: RESET
  };
};

export const setCompatibilityCPU = (cpu: CPUModel) => {
  return {
    type: SET_CPU,
    payload: { cpu }
  };
};

export const setCompatibilityMotherboard = (motherboard: MotherboardModel) => {
  return {
    type: SET_MOTHERBOARD,
    payload: { motherboard }
  };
};
