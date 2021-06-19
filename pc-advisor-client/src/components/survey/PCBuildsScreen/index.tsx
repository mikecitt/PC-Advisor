import React, { FC, useEffect, useState } from 'react';
import { useDispatch, useSelector } from 'react-redux';

import SectionTitle from 'shared/SectionTitle';
import { previousSurveyStep } from 'store/survey/actions';
import { submitSurvey } from 'services/survey/survey.service';
import { PCBuildModel } from 'services/pc-build/pc-build.model';
import PCBuild from './PCBuild';
import { RootState } from 'store';
import './style.scss';

const AffinitiesScreen: FC = () => {
  const dispatch = useDispatch();
  const computerPrograms = useSelector(
    (state: RootState) => state.survey.computerPrograms
  );
  const affinities = useSelector((state: RootState) => state.survey.affinities);

  const handlePrevious = () => {
    dispatch(previousSurveyStep());
  };

  const [pcBuilds, setPCBuilds] = useState<Array<PCBuildModel>>([]);

  useEffect(() => {
    submitSurvey(affinities, computerPrograms).then((response) => {
      console.log(response);
      setPCBuilds(response.data);
    });
  }, []);

  return (
    <>
      <SectionTitle
        text="Best recommends"
        action={handlePrevious}
        style={{ marginBottom: '64px' }}
      />
      <div className="pc-builds-screen">
        {pcBuilds.map((pcBuild) => (
          <PCBuild
            key={pcBuild.cpu.id}
            pcBuild={pcBuild}
            style={{ margin: '16px' }}
          />
        ))}
      </div>
    </>
  );
};

export default AffinitiesScreen;
