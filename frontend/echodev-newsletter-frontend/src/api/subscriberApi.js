import axios from 'axios';

const API_URL = "http://localhost:8080";

export const subscribe = async (email) => {
    return axios.post(`${API_URL}/subscribers`, { email });
};

export const unsubscribe = async (email) => {
    return axios.delete(`${API_URL}/subscribers/${email}`);
};
