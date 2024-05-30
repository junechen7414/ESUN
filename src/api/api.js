// src/api.js
import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'http://localhost:8080', // Spring Boot的基礎URL
  headers: {
    'Content-Type': 'application/json'
  }
});

export default {
  addProduct(product) {
    return apiClient.post('/addProduct', product);
  },
  addOrderDetail(orderDetail) {
    return apiClient.post('/addOrderDetail', orderDetail);
  },
  addOrder(order) {
    return apiClient.post('/addOrder', order);
  },
};
