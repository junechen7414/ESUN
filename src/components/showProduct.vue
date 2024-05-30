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
    <button @click="checkout">下單</button>
    </div>
</template>
<script>
import axios from 'axios';
import apiClient from '../api/api.js';


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
          acc[product.id] = { quantity: 0, selected: false, price: product.price };
          return acc;
        }, {});

      } catch (error) {
        console.error('Error fetching products:', error);
      }
    },
    toggleSelectAll(checked) {
      this.products.forEach(product => {
    this.cart[product.id].selected = checked ;
  });
  },
  updateCartQuantity(productId, quantity) {
    this.cart[productId].quantity = quantity;
  },
  updateSeletcion(productId,selected){
    this.cart[productId].selected = selected;
  },
  async checkout(){
    const selectedProducts =  this.products.filter(product => this.cart[product.id].selected);    
    // Valid selection
    if (selectedProducts.length === 0) {
        alert('請至少選擇一項商品');
        return;
      }
      // Random order ID
      let randomid = Math.random().toString(36).substring(2, 15);

      const orderItems = selectedProducts.map(product => ({
        orderid: randomid, 
        productid: product.id,
        quantity: this.cart[product.id].quantity,
        standprice: this.cart[product.id].price,
        totalprice: this.cart[product.id].price * this.cart[product.id].quantity, // Calculate item price
      }));

      try {
        const response = await apiClient.addOrderDetail(orderItems);

        if (response.status === 200) {
          alert('訂單生成成功！');
          this.showOrder = true;
          // Reset cart (optional, based on your requirements)
          // this.cart = {}; // Clear all items
        } else {
          alert('訂單生成失敗，請稍後再試');
        }
      } catch (error) {
        console.error('Error checking out:', error);
        alert('訂單生成失敗，請稍後再試');
      }
    },

  //     for (const productId in this.cart) {
  //       if (this.cart[productId].selected) {
  //         const product = {
  //           ProductID: productId,
  //       Quantity: this.cart[productId].quantity,
  //       StandPrice: this.cart[productId].price,
  //       // ItemPrice: this.cart[productId].price * this.cart[productId].quantity
  //     };
  //         selectedProducts.push(product);
  //         totalPrice+=product.price*product.quantity;
  //       }
  // }
  
  // 隨機生成orderid和memberid
  // const orderid = Math.random().toString(36).substring(2, 15);

  // const orderItems = selectedProducts.map((product) => ({        
  //       OrderID: orderid,
  //       ProductID: product.ProductID,
  //       Quantity: product.Quantity,
  //       StandPrice: product.StandPrice,
  //       ItemPrice: totalPrice
  //     }));
  // try {
  //       const response = await apiClient.addOrderDetail(orderItems);

  //       if (response.status === 200) {
  //         alert('訂單生成成功！');
  //         // Reset cart
  //         // this.cart = this.products.reduce((acc, product) => {
  //         //   acc[product.id] = { quantity: product.quantity, selected: false };
  //         //   return acc;
  //         // }, {});
  //       } else {
  //         alert('訂單生成失敗，請稍後再試');
  //       }
  //     } catch(error)    {
  //       console.error('Error checking out:', error);
  //       alert('訂單生成失敗，請稍後再試');
  //     }
  //   },
}
};
</script>
<style>
.centered-table {
  margin: 0 auto;
  width: 50%;
}
</style>