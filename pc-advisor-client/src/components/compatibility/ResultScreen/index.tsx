import React, { FC, useState } from 'react';
import { Result } from 'antd';

import SecondaryButton from 'shared/SecondaryButton';
import SectionTitle from 'shared/SectionTitle';
import { useDispatch, useSelector } from 'react-redux';
import { resetCompatibility } from 'store/compatibility/actions';
import { getCompatibility } from 'services/compatibility/compatibility.service';
import { RootState } from 'store';
import './style.scss';

const ResultScreen: FC = () => {
  const dispatch = useDispatch();

  const cpuId = useSelector(
    (state: RootState) => state.compatibility.cpu?.id as number
  );
  const motherboardId = useSelector(
    (state: RootState) => state.compatibility.motherboard?.id as number
  );

  const handleReset = () => {
    dispatch(resetCompatibility());
  };

  const [success, setSuccess] = useState<boolean | undefined>(undefined);

  React.useEffect(() => {
    getCompatibility(cpuId, motherboardId).then((response) => {
      setSuccess(response.data.success);
    });
  }, []);

  return (
    <>
      <SectionTitle text="Results" />
      <div className="result-screen">
        {success ? (
          <Result
            status="success"
            title="Selected CPU and Motherboard are Match!"
          />
        ) : (
          <Result
            status="error"
            title="Selected CPU and Motherboard do not Match!"
          />
        )}
        <SecondaryButton
          text="Play again"
          buttonProps={{ onClick: handleReset }}
        />
      </div>
    </>
  );
};

export default ResultScreen;
