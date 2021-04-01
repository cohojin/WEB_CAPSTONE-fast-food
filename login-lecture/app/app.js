"use strict";


// 모듈
const express = require("express");
const app = express();
//const bodyPaser = require("body-parser");

// 라우팅
const home = require("./src/routes/home");
const PORT = 3000;

// 앱세팅
app.set("views","./src/views");
app.set("view engine","ejs");
app.use(express.static(`${__dirname}/src/public`));
//bodyPaser 대신 expresss 를 사용, 바디파서는 이제 없어질 메소드
app.use(express.json());
// UPL을 통해서 전달되는 데이터에 한글, 공백 등과 같은 문자를 포함될
//경우 제대로 인식되지 않는 문제를 해결
app.use(express.urlencoded({ extended : true}));


app.use("/",home); // use -> 미들웨어를 등록하는 메소드

module.exports = app;

