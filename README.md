# esun

## Project setup
```
npm install
```

### Compiles and hot-reloads for development
```
npm run serve
```

### Compiles and minifies for production
```
npm run build
```

### Lints and fixes files
```
npm run lint
```

### Customize configuration
See [Configuration Reference](https://cli.vuejs.org/config/).    
簡介: 如字面上的實作功能，新增商品、展示商品、新增訂單，來不及顧到會員功能，於是訂單中也是用隨機生成會員編號  
完成的部分: 可以透過新增商品功能新增商品，商品欄位至少需包含 [商品編號] [商品名稱] [售價] [庫存] 、新增訂單功能 顯示庫存量大於零的商品清單。 顧客可以勾選多個商品，並設定購買的數量，購買數量不能大於該商品庫存量 顯示顧客訂單內容，包含各商品金額小計以及訂單總金額。  
使用 Vue.js 做為前端技術。  使用 Spring Boot 搭建相關應用程式。  使用 RESTful API 風格建立後端服務。  使用 Maven 或 Gradle 做為專案建立的工具。  初次使用Vue.js和Spring boot，git也可以說是第一次實際使用，結論是時間內無法完成，main branch 中放的是 Vue， Springboot branch中放的是Springboot，雖然git的使用可能有誤，不過做一半才發現於是將計就計，執行步驟如下:  
1. 首先打開mysql workbench 
輸入 Create database testdb;
 use testdb;  
名字要對上Springboot中的設定  
2. 之後執行Spring Boot的 '檔名'Application.java檔，建立資料庫，然後使用default的web server tomcat server  
3. 運行前端的Vue.js ， 有個簡陋的操作介面，把新增商品功能和新增訂單功能和成一塊，點擊後操作各自的功能    
