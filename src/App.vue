<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <button @click="currentView = 'addProduct'">Add Product</button>
    <button @click="currentView = 'showProduct'">Show Products</button>
    <component :is="currentView"></component> 
</template>

<script>
import addProduct from './components/addProduct.vue';
import showProduct from './components/showProduct.vue';

export default {
  name: 'App',
  components: {
    addProduct,
    showProduct
  }
  ,
  data() {
    return {
      currentView: 'HelloWorld' // 初始顯示商品清單
    };
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
