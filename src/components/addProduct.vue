<template>
  <div>
    <h1>Add Product</h1>
    <form @submit.prevent="submitProduct">
      <div>
        <label for="id">ID:</label>
        <input type="text" v-model="product.id" required />
      </div>
      <div>
        <label for="name">Name:</label>
        <input type="text" v-model="product.name" required />
      </div>
      <div>
        <label for="price">Price:</label>
        <input type="number" v-model="product.price" required />
      </div>
      <div>
        <label for="quantity">Quantity:</label>
        <input type="number" v-model="product.quantity" required />
      </div>
      <button type="submit">Add Product</button>
    </form>
  </div>
</template>

<script>
import apiClient from '../api/api.js';

export default {
  name: 'HelloWorld',
  data() {
    return {
      product: {
        id: '',
        name: '',
        price: 0,
        quantity: 0
      }
    };
  },
  methods: {
    async submitProduct() {
      try {
        const response = await apiClient.addProduct(this.product);
        console.log('Product added:', response.data);
      } catch (error) {
        console.error('Error adding product:', error);
      }
    }
  }
};
</script>
