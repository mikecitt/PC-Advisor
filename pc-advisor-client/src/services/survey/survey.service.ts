import axios from 'axios';
import { SurveyQuestionModelDTO } from 'services/survey-question/survey-question.model';
import { API_URL } from 'utils/consts/api.consts';

export const submitSurvey = () => axios.post(`${API_URL}/survey/submitSurvey`);

export const submitQuestions = (questions: Array<SurveyQuestionModelDTO>) =>
  axios.post(`${API_URL}/survey/submitQuestions`, { questions });
