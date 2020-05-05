# 智慧物联网教室预约系统-后台系统

![license](https://img.shields.io/github/license/Antabot/White-Jotter)
![release](https://img.shields.io/github/v/release/Antabot/White-Jotter)
![Build Status](https://www.travis-ci.org/Antabot/White-Jotter.svg?branch=master)

## 项目简介

 这是一个前后端分离的教室预约和查看系统项目，主要采用Vue.js+SpringBoot 技术栈开发hibernate

## 使用说明：

项目使用了虹软公司的人脸识别SDK与百度的人体分析SDk：
* 虹软的SDK请自行前往官网获取，获取后建议将SDK导入到``src/main/resources/lib-sdk``目录下,然后在``src/main/java/utils``目录下新建``SdkParameter.java``文件，填入appId和key以及引擎和算法等文件位置。

* 百度人体分析SDk已在``maven``中引用，但是``app_id``等请前往百度云AI开发者平台自行获取，该项目中表示位置为``SdkParameter.java``文件。

## 前端项目地址

## 效果截图
