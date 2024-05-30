<template>
    <div>
        <h1>商品清單</h1>
        <table class="centered-table">
      <thead>
        <tr>
          <th>
            <input type="checkbox" v-model="selectAll" @change="toggleSelectAll(selectAll)" />
          </th>
          <th>Product Name</th>
          <th>Price</th>
          <th>Quantity</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="product in products" :key="product.id">
          <td>
            <input type="checkbox" v-model="cart[product.id]" />
          </td>
          <td>{{ product.name }}</td>
          <td>{{ product.price }}</td>
          <td><input type="number" v-model="cart[product.id].quantity"
            :min="0"
            :max="product.quantity"
            @change="updateCartQuantity(product.id,$event.target.value)"></td>
        </tr>
      </tbody>
    </table>
    </div>
</template>
<script>
import axios from 'axios';
// import apiClient from '../api/api.js';

export default {
  name: 'showProduct',
  data() {
    return {
      products: [],
      cart: {},
      selectAll: false,
    };
  },
  created() {
    this.fetchProducts();
  },
  methods: {
    async fetchProducts() {
      try {
        const response = await axios.get('http://localhost:8080/showProduct');
        this.products = response.data;

        // Initialize cart with quantity for each product
        this.cart = this.products.reduce((acc, product) => {
          acc[product.id] = { quantity: product.quantity };
          return acc;
        }, {});

      } catch (error) {
        console.error('Error fetching products:', error);
      }
    },
    toggleSelectAll(checked) {
      this.cart = this.products.reduce((acc, product) => {
        acc[product.id] = checked; // 將選擇狀態存儲在cart物件中
        return acc;
      },{});
  },
  updateCartQuantity(productId, quantity) {
    this.cart[productId].quantity = quantity;
  }
}
};
</script>
<style>
.centered-table {
  margin: 0 auto;
  width: 50%;
}
</style>