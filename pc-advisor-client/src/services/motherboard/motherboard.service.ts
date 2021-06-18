import axios from 'axios';
import { API_URL } from 'utils/consts/api.consts';

export const getMotherboards = () => axios.get(`${API_URL}/motherboard`);
