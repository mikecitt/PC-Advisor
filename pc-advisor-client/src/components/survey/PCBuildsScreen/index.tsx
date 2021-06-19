import React, { FC } from 'react';
import { useDispatch } from 'react-redux';

import SectionTitle from 'shared/SectionTitle';
import { previousSurveyStep } from 'store/survey/actions';
import './style.scss';
import { useEffect } from 'react';
import { submitSurvey } from 'services/survey/survey.service';
import { useState } from 'react';
import { PCBuildModel } from 'services/pc-build/pc-build.model';
import PCBuild from './PCBuild';

const AffinitiesScreen: FC = () => {
  const dispatch = useDispatch();

  const handlePrevious = () => {
    dispatch(previousSurveyStep());
  };

  const [pcBuilds, setPCBuilds] = useState<Array<PCBuildModel>>([]);

  useEffect(() => {
    submitSurvey().then((response) => {
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
          <PCBuild pcBuild={pcBuild} style={{ margin: '16px' }} />
        ))}
      </div>
    </>
  );
};

export default AffinitiesScreen;
function restartSurvey(): any {
  throw new Error('Function not implemented.');
}
