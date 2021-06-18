import axios from 'axios';
import { API_URL } from 'utils/consts/api.consts';

export const getCompatibility = (cpuId: number, motherboardId: number) =>
  axios.post(`${API_URL}/compatibility/check`, { cpuId, motherboardId });
