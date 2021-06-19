import axios, { AxiosResponse } from 'axios';
import { SurveyQuestionModelDTO } from 'services/survey-question/survey-question.model';
import { API_URL } from 'utils/consts/api.consts';
import { ComputerProgramResponse } from './computer-program-response.model';

export const submitSurvey = () => axios.post(`${API_URL}/survey/submitSurvey`);

export const submitQuestions = (
  questions: Array<SurveyQuestionModelDTO>
): Promise<AxiosResponse<ComputerProgramResponse>> =>
  axios.post(`${API_URL}/survey/submitQuestions`, { questions });
