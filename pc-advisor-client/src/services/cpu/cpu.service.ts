import axios from 'axios';
import { API_URL } from 'utils/consts/api.consts';

export const getCpus = () => axios.get(`${API_URL}/cpu`);
