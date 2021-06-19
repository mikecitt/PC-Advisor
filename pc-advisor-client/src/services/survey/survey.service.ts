import axios, { AxiosResponse } from 'axios';
import { AffinitiesDTOModel } from 'services/affinities/affinities-dto.model';
import { ComputerProgramModelDTO } from 'services/computer-program/computer-program-dto.model';
import { SurveyQuestionModelDTO } from 'services/survey-question/survey-question.model';
import { API_URL } from 'utils/consts/api.consts';
import { ComputerProgramResponse } from './computer-program-response.model';

export const submitSurvey = (
  affinitiesDTO: AffinitiesDTOModel,
  computerPrograms: Array<ComputerProgramModelDTO>
) =>
  axios.post(`${API_URL}/survey/submitSurvey`, {
    affinitiesDTO,
    computerProgramsRequestDTO: {
      computerPrograms
    }
  });

export const submitQuestions = (
  questions: Array<SurveyQuestionModelDTO>
): Promise<AxiosResponse<ComputerProgramResponse>> =>
  axios.post(`${API_URL}/survey/submitQuestions`, { questions });
