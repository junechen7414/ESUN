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
            <input type="checkbox" v-model="cart[product.id].selected" @change = "updateSeletcion(product.id,$event.target.checked)"/>
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
    <button @click="checkout">結帳</button>
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
      this.products.forEach(product => {
    this.cart[product.id] = { ...this.cart[product.id], selected: checked };
  });
  },
  updateCartQuantity(productId, quantity) {
    this.cart[productId].quantity = quantity;
  },
  updateSeletcion(productId,selected){
    this.cart[productId].selected = selected;
  },
  async checkout(){
    const selectedProducts = [];
      for (const productId in this.cart) {
        if (this.cart[productId].selected) {
          const product = {
            id: productId,
            quantity: this.cart[productId].quantity,
          };
          selectedProducts.push(product);
        }
  }
  if (selectedProducts.length === 0) {
        alert('請至少選擇一項商品');
        return;
      }
      try {
        const response = await axios.post('http://localhost:8080/checkout', {
          products: selectedProducts,
        });

        if (response.status === 200) {
          alert('結帳成功！');
          // Reset cart
          this.cart = this.products.reduce((acc, product) => {
            acc[product.id] = { quantity: product.quantity, selected: false };
            return acc;
          }, {});
        } else {
          alert('結帳失敗，請稍後再試');
        }
      } catch(error)    {
        console.error('Error checking out:', error);
        alert('結帳失敗，請稍後再試');
      }
    },
}
};
</script>
<style>
.centered-table {
  margin: 0 auto;
  width: 50%;
}
</style>