import axios from 'axios';

const apiClient = axios.create({
  baseURL: import.meta.env.VITE_API_BASE_URL || 'http://localhost:8081',
  headers: {
    'Content-Type': 'application/json',
  },
});

export const getRecommendations = async (preferences) => {
  const response = await apiClient.post('/api/recommend', preferences);
  return response.data;
};

export const getShortlist = async () => {
  const response = await apiClient.get('/api/shortlist');
  return response.data;
};

export const addToShortlist = async (carIds) => {
  const response = await apiClient.post('/api/shortlist', { carIds });
  return response.data;
};

export default apiClient;
