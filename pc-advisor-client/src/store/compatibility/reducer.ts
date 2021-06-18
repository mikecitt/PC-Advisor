import { CPUModel } from 'services/cpu/cpu.model';
import { MotherboardModel } from 'services/motherboard/motherboard.model';

export const NEXT_STEP = 'compatibility/nextStep';
export const PREVIOUS_STEP = 'compatibility/peviousStep';
export const RESET = 'compatibility/reset';
export const SET_CPU = 'compatibility/setCPU';
export const SET_MOTHERBOARD = 'compatibility/setMotherboard';

export interface CompatibilityState {
  step: number;
  cpu: CPUModel | null;
  motherboard: any;
}

const initialState: CompatibilityState = {
  step: 0,
  cpu: null,
  motherboard: undefined
};

export function compatibilityReducer(
  state = initialState,
  action: CompatibilityActionTypes
): CompatibilityState {
  switch (action.type) {
    case NEXT_STEP:
      return {
        ...state,
        step: state.step + 1
      };
    case PREVIOUS_STEP:
      return {
        ...state,
        step: state.step - 1
      };
    case RESET:
      return {
        cpu: null,
        motherboard: undefined,
        step: 0
      };
    case SET_CPU:
      return {
        ...state,
        cpu: action.payload.cpu
      };
    case SET_MOTHERBOARD:
      return {
        ...state,
        motherboard: action.payload.motherboard
      };
    default:
      return state;
  }
}

interface NextStepAction {
  type: typeof NEXT_STEP;
}

interface PreviousStepAction {
  type: typeof PREVIOUS_STEP;
}

interface ResetStepAction {
  type: typeof RESET;
}

interface SetCPUAction {
  type: typeof SET_CPU;
  payload: {
    cpu: CPUModel;
  };
}

interface SetGPUMotherboardAction {
  type: typeof SET_MOTHERBOARD;
  payload: { motherboard: MotherboardModel };
}

export type CompatibilityActionTypes =
  | NextStepAction
  | PreviousStepAction
  | ResetStepAction
  | SetCPUAction
  | SetGPUMotherboardAction;
