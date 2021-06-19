import React, { FC } from 'react';
import { useState } from 'react';
import { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import { ComputerProgramModelDTO } from 'services/computer-program/computer-program-dto.model';

import { ComputerProgramModel } from 'services/computer-program/cumputer-program.model';
import { submitQuestions } from 'services/survey/survey.service';
import PTag from 'shared/PTag';
import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import { RootState } from 'store';
import {
  nextSurveyStep,
  previousSurveyStep,
  setSurveyComputerPrograms
} from 'store/survey/actions';
import './style.scss';

const ComputerProgramsScreen: FC = () => {
  const dispatch = useDispatch();
  const questionsDTO = useSelector(
    (state: RootState) => state.survey.questions
  );

  const [computerPrograms, setComputerPrograms] = useState<
    Array<ComputerProgramModel>
  >([]);
  const [computerProgramsDTO, setComputerProgramsDTO] = useState<
    Array<ComputerProgramModelDTO>
  >([]);
  const [canContinue, setCanContinue] = useState<boolean>(false);

  const handlePrevious = () => {
    dispatch(previousSurveyStep());
  };

  const handleContinue = () => {
    dispatch(setSurveyComputerPrograms(computerProgramsDTO));
    dispatch(nextSurveyStep());
  };

  useEffect(() => {
    setCanContinue(computerProgramsDTO.length > 0);
  }, [computerProgramsDTO]);

  const handleProgramSelected = (id: number, value: boolean) => {
    if (value) {
      const newProgramsDTO = [...computerProgramsDTO];
      newProgramsDTO.push({ id });
      setComputerProgramsDTO(newProgramsDTO);
    } else {
      setComputerProgramsDTO(
        computerProgramsDTO.filter((program) => program.id !== id)
      );
    }
  };

  useEffect(() => {
    submitQuestions(questionsDTO).then((response) => {
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
              key={computerProgram.id}
              text={computerProgram.displayName}
              onChange={(checked) =>
                handleProgramSelected(computerProgram.id, checked)
              }
              style={{ marginTop: '12px', marginBottom: '12px' }}
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

export default ComputerProgramsScreen;
