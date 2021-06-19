import { AffinitiesDTOModel } from 'services/affinities/affinities-dto.model';
import { ComputerProgramModelDTO } from 'services/computer-program/computer-program-dto.model';
import { SurveyQuestionModelDTO } from 'services/survey-question/survey-question.model';

export const NEXT_SURVEY_STEP = 'survey/nextStep';
export const PREVIOUS_SURVEY_STEP = 'survey/peviousStep';
export const RESET_SURVEY = 'survey/reset';
export const SET_SURVEY_QUESTIONS = 'survey/setQuestions';
export const SET_SURVEY_COMPUTER_PROGRAMS = 'survey/setComputerPrograms';
export const SET_SURVEY_AFFINITIES = 'survey/setAffinities';

export interface SurveyState {
  step: number;
  questions: Array<SurveyQuestionModelDTO>;
  computerPrograms: Array<ComputerProgramModelDTO>;
  affinities: AffinitiesDTOModel;
}

const initialState: SurveyState = {
  step: 0,
  questions: [],
  computerPrograms: [],
  affinities: {
    brandPref: null,
    storageMin: 0,
    budget: 0
  }
};

export function surveyReducer(
  state = initialState,
  action: SurveyActionTypes
): SurveyState {
  switch (action.type) {
    case NEXT_SURVEY_STEP:
      return {
        ...state,
        step: state.step + 1
      };
    case PREVIOUS_SURVEY_STEP:
      return {
        ...state,
        step: state.step - 1
      };
    case RESET_SURVEY:
      return {
        ...state,
        step: 0
      };
    case SET_SURVEY_QUESTIONS:
      return {
        ...state,
        questions: action.payload.questions
      };
    case SET_SURVEY_COMPUTER_PROGRAMS:
      return {
        ...state,
        computerPrograms: action.payload.computerPrograms
      };
    case SET_SURVEY_AFFINITIES:
      return {
        ...state,
        affinities: action.payload.affinities
      };
    default:
      return state;
  }
}

interface NextSurveyStepAction {
  type: typeof NEXT_SURVEY_STEP;
}

interface PreviousSurveyStepAction {
  type: typeof PREVIOUS_SURVEY_STEP;
}

interface ResetSurveyStepAction {
  type: typeof RESET_SURVEY;
}

interface SetSurveyQuestionsAction {
  type: typeof SET_SURVEY_QUESTIONS;
  payload: {
    questions: Array<SurveyQuestionModelDTO>;
  };
}

interface SetSurveyComputerProgramsAction {
  type: typeof SET_SURVEY_COMPUTER_PROGRAMS;
  payload: {
    computerPrograms: Array<ComputerProgramModelDTO>;
  };
}

interface SetSurveyAffinitiesAction {
  type: typeof SET_SURVEY_AFFINITIES;
  payload: {
    affinities: AffinitiesDTOModel;
  };
}

export type SurveyActionTypes =
  | NextSurveyStepAction
  | PreviousSurveyStepAction
  | ResetSurveyStepAction
  | SetSurveyQuestionsAction
  | SetSurveyComputerProgramsAction
  | SetSurveyAffinitiesAction;
