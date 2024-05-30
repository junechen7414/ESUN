<template>
    <div>
      <table class="centered-table">
        <thead>
          <tr> 
            <th></th>          
            <th>訂單編號</th>
            <th>商品編號</th>
            <th>數量</th>
            <th>單價</th>
            <th>商品金額小計</th>
            <th>訂單總金額</th>
          </tr>
        </thead>
        <tbody>
            <tr v-for="orderDetail in orderDetailList" :key="orderDetail.orderid">
            <td>
                <input type="radio" :value="orderDetail.orderid" v-model="selectedOrderId" />
            </td>            
            <td>{{ orderDetail.orderid }}</td>
            <td>{{ orderDetail.productid }}</td>
            <td>{{ orderDetail.quantity }}</td>
            <td>{{ orderDetail.standprice }}</td>
            <td>{{ orderDetail.quantity * orderDetail.standprice }}</td>
            <td>{{ getOrderTotalAmount(orderDetail.orderid) }}</td> </tr>
        </tbody>
      </table>      
      <button @click="pay">下單</button>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import apiClient from '../api/api.js';

  export default {
    name: 'showOrder',
    data() {
        return {
            orderDetailList: [],
            totalAmount: 0,            
            selectedOrderId: null, // Store the ID of the selected order
        };
    },
    created() {
      this.getOrderDetailList();
    },
    methods: {
        async getOrderDetailList() {
      try {
        const response = await axios.get('http://localhost:8080/showOrderDetail');
        this.orderDetailList = response.data;
        this.calculateTotalAmount();

        // Optionally fetch product details concurrently or after order details
        // await this.fetchProductDetails(); // Replace with your actual API call
      } catch (error) {
        console.error('Error showing orderdetail:', error);
      }
    },
    calculateTotalAmount() {
      this.totalAmount = this.orderDetailList.reduce(
        (acc, orderDetail) => acc + (orderDetail.quantity * orderDetail.standprice),
        0
      );
    },
    getOrderTotalAmount(orderId) {
      return this.orderDetailList
        .filter(orderDetail => orderDetail.orderid === orderId)
        .reduce((acc, orderDetail) => acc + (orderDetail.quantity * orderDetail.standprice), 0);
    },

    async pay() {
        if (!this.selectedOrderId) {
    alert('請先選擇要付款的訂單');
    return;
  }

  const selectedOrderDetail = this.orderDetailList.find(
    orderDetail => orderDetail.orderid === this.selectedOrderId
  );

  if (!selectedOrderDetail) {
    console.error('Selected order detail not found:', this.selectedOrderId);
    alert('付款失敗，請稍後再試');
    return;
  }

  const paymentInfo = {
    orderid: this.selectedOrderId,
    memberid: Math.floor(Math.random() * 10000) + 1, // Generate random member ID
    price: selectedOrderDetail.quantity * selectedOrderDetail.standprice,
    isPaid: 0,
  };

        try {
        const response = await apiClient.addOrder(paymentInfo);

        if (response.status === 200) {
          alert('付款成功！');          
        } else {
          alert('付款失敗，請稍後再試');
        }
      } catch (error) {
        console.error('Error paying:', error);
        alert('付款失敗，請稍後再試');
      }
    },
    },
  };
  </script>
  <style>
  .centered-table {
    margin: 0 auto;
    width: 50%;
  }
  .centered-table input[type="radio"] {
  margin-right: 10px; /* Add some spacing between radio buttons */
}
  </style>