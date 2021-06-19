import { SurveyQuestionModelDTO } from 'services/survey-question/survey-question.model';

export const NEXT_SURVEY_STEP = 'survey/nextStep';
export const PREVIOUS_SURVEY_STEP = 'survey/peviousStep';
export const RESET_SURVEY = 'survey/reset';
export const SET_SURVEY_QUESTIONS = 'survey/setQuestions';

export interface SurveyState {
  step: number;
  questions: Array<SurveyQuestionModelDTO>;
}

const initialState: SurveyState = {
  step: 0,
  questions: []
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

export type SurveyActionTypes =
  | NextSurveyStepAction
  | PreviousSurveyStepAction
  | ResetSurveyStepAction
  | SetSurveyQuestionsAction;
