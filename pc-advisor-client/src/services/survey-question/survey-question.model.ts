export interface SurveyQuestionModel {
  id: number;
  question: string;
  usageArea: string;
}

export interface SurveyQuestionModelDTO {
  id: number;
  score: number | null;
}
