import React, { FC } from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import { getComputerPrograms } from 'services/computer-program/computer-program.service';
import { ComputerProgramModel } from 'services/computer-program/cumputer-program.model';
import { submitQuestions } from 'services/survey/survey.service';
import PTag from 'shared/PTag';
import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import { RootState } from 'store';
import { nextSurveyStep, previousSurveyStep } from 'store/survey/actions';
import './style.scss';

const ComputerProgramsScreen: FC = () => {
  const dispatch = useDispatch();
  const questionsDTO = useSelector(
    (state: RootState) => state.survey.questions
  );

  const [computerPrograms, setComputerPrograms] = useState<
    Array<ComputerProgramModel>
  >([]);

  const handlePrevious = () => {
    dispatch(previousSurveyStep());
  };

  const handleContinue = () => {
    dispatch(nextSurveyStep());
  };

  useEffect(() => {
    submitQuestions(questionsDTO).then((response) => {
      console.log(response);
      setComputerPrograms(response.data.computerPrograms);
    });
  }, []);

  return (
    <>
      <SectionTitle
        text="Select computer programs"
        action={handlePrevious}
        style={{ marginBottom: '64px' }}
      />
      <div className="computer-programs-screen">
        <div className="computer-programs-screen__computer-programs">
          {computerPrograms.map((computerProgram) => (
            <PTag
              text={computerProgram.displayName}
              style={{ marginTop: '12px', marginBottom: '12px' }}
            />
          ))}
        </div>
        <SecondaryButton
          text="Next"
          style={{ marginTop: '32px', alignSelf: 'flex-end' }}
          buttonProps={{ onClick: handleContinue }}
        />
      </div>
    </>
  );
};

export default ComputerProgramsScreen;
