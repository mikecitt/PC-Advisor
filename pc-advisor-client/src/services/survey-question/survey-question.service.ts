import axios, { AxiosResponse } from 'axios';
import { API_URL } from 'utils/consts/api.consts';
import { SurveyQuestionModel } from './survey-question.model';

export const getSurveyQuestions = (): Promise<
  AxiosResponse<Array<SurveyQuestionModel>>
> => axios.get(`${API_URL}/survey-question`);
