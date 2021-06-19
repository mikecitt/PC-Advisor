import { AffinitiesDTOModel } from 'services/affinities/affinities-dto.model';
import { ComputerProgramModelDTO } from 'services/computer-program/computer-program-dto.model';
import { SurveyQuestionModelDTO } from 'services/survey-question/survey-question.model';
import {
  NEXT_SURVEY_STEP,
  PREVIOUS_SURVEY_STEP,
  RESET_SURVEY,
  SET_SURVEY_AFFINITIES,
  SET_SURVEY_COMPUTER_PROGRAMS,
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

export const setSurveyQuestions = (
  questions: Array<SurveyQuestionModelDTO>
): SurveyActionTypes => {
  return {
    type: SET_SURVEY_QUESTIONS,
    payload: {
      questions
    }
  };
};

export const setSurveyComputerPrograms = (
  computerPrograms: Array<ComputerProgramModelDTO>
): SurveyActionTypes => {
  return {
    type: SET_SURVEY_COMPUTER_PROGRAMS,
    payload: {
      computerPrograms
    }
  };
};

export const setSurveyAffinities = (
  affinities: AffinitiesDTOModel
): SurveyActionTypes => {
  return {
    type: SET_SURVEY_AFFINITIES,
    payload: {
      affinities
    }
  };
};
