import axios from 'axios';
import { API_URL } from 'utils/consts/api.consts';

export const getComputerPrograms = () =>
  axios.get(`${API_URL}/computer-program`);
