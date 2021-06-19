import React, { FC } from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import { useDispatch } from 'react-redux';

import {
  SurveyQuestionModel,
  SurveyQuestionModelDTO
} from 'services/survey-question/survey-question.model';
import { getSurveyQuestions } from 'services/survey-question/survey-question.service';
import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import {
  nextSurveyStep,
  previousSurveyStep,
  setSurveyQuestions
} from 'store/survey/actions';
import Question from './Question';
import './style.scss';

const QuestionsScreen: FC = () => {
  const dispatch = useDispatch();

  const [questions, setQuestions] = useState<Array<SurveyQuestionModel>>([]);
  const [questionsDTO, setQuestionsDTO] = useState<
    Array<SurveyQuestionModelDTO>
  >([]);
  const [canContinue, setCanContinue] = useState<boolean>(false);

  const handlePrevious = () => {
    dispatch(previousSurveyStep());
  };

  const handleContinue = () => {
    setSurveyQuestions(questionsDTO);
    dispatch(nextSurveyStep());
  };

  useEffect(() => {
    getSurveyQuestions().then((response) => {
      setQuestions(response.data);

      setQuestionsDTO(
        response.data.map((question) => {
          return {
            id: question.id,
            score: null
          };
        })
      );
    });
  }, []);

  useEffect(() => {
    setCanContinue(questionsDTO.every((question) => question.score !== null));
  }, [questionsDTO]);

  const handleStarChange = (id: number, score: number) => {
    const quest = questionsDTO.find((question) => question.id === id);
    if (quest) {
      quest.score = score;
    }
    setQuestionsDTO([...questionsDTO]);
  };

  return (
    <>
      <SectionTitle
        text="Answer Questions"
        action={handlePrevious}
        style={{ marginBottom: '64px' }}
      />
      <div className="questions-screen">
        <div className="questions-screen__questions">
          {questions.map((question) => (
            <Question
              key={question.id}
              question={question}
              onStarChange={handleStarChange}
            />
          ))}
        </div>
        <SecondaryButton
          text="Next"
          style={{ marginTop: '32px', alignSelf: 'flex-end' }}
          buttonProps={{ onClick: handleContinue, disabled: !canContinue }}
        />
      </div>
    </>
  );
};

export default QuestionsScreen;
