import { SurveyQuestionModelDTO } from 'services/survey-question/survey-question.model';
import {
  NEXT_SURVEY_STEP,
  PREVIOUS_SURVEY_STEP,
  RESET_SURVEY,
  SET_SURVEY_QUESTIONS,
  SurveyActionTypes
} from './reducer';

export const nextSurveyStep = (): SurveyActionTypes => {
  return {
    type: NEXT_SURVEY_STEP
  };
};

export const previousSurveyStep = (): SurveyActionTypes => {
  return {
    type: PREVIOUS_SURVEY_STEP
  };
};

export const resetSurvey = (): SurveyActionTypes => {
  return {
    type: RESET_SURVEY
  };
};

export const setQuestions = (
  questions: Array<SurveyQuestionModelDTO>
): SurveyActionTypes => {
  return {
    type: SET_SURVEY_QUESTIONS,
    payload: {
      questions: questions
    }
  };
};
