import React, { FC } from 'react';
import { Rate } from 'antd';

import { SurveyQuestionModel } from 'services/survey-question/survey-question.model';
import './style.scss';

const starDescription = [
  'not agree',
  'partially not agree',
  "don't know",
  'partially agree',
  'fully agree'
];

interface QuestionInterface {
  question: SurveyQuestionModel;
  onStarChange: (id: number, score: number) => void;
}

const Question: FC<QuestionInterface> = ({ question, onStarChange }) => {
  return (
    <div>
      <div className="question__text">{question.question}</div>
      <Rate
        onChange={(value) => onStarChange(question.id, value)}
        tooltips={starDescription}
        allowClear={false}
      />
    </div>
  );
};

export default Question;
