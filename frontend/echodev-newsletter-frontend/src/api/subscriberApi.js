import axios from 'axios';

const API_URL = "http://localhost:8080";

export const subscribe = async (email) => {
    return axios.post(`${API_URL}/subscribers`, { email });
};

export const getSubscriberByEmail = async (email) => {
    const response = await axios.get(`${API_URL}/subscribers/email/${email}`);
    return response.data;
};

export const deleteSubscriberById = async (id) => {
    return axios.delete(`${API_URL}/subscribers/${id}`);
};