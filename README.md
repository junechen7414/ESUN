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
初次使用Vue.js和Spring boot，git也可以說是第一次實際使用，結論是時間內無法完成，main branch 中放的是 Vue， Springboot branch中放的是Springboot，雖然git的使用可能有誤，不過做一半才發現於是將計就計，執行步驟如下:  
1. 首先打開mysql workbench 
輸入 Create database testdb;
 use testdb;  
名字要對上Springboot中的設定  
2. 之後執行Spring Boot的 '檔名'Application.java檔，建立資料庫，然後使用default的web server tomcat server  
3. 運行前端的Vue.js ， 有個簡陋的操作介面，把新增商品功能和新增訂單功能和成一塊，點擊後操作各自的功能    
