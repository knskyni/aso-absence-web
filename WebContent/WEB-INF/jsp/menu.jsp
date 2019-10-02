<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="absence.beans.LoginInfoBeans" %>
<%
    LoginInfoBeans loginInfoBeans = (LoginInfoBeans)session.getAttribute("loginInfoBeans");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー | 公欠管理システム</title>
</head>
<body>
    <p>ようこそ、（学籍番号: <%= loginInfoBeans.getUserId() %>）<%= loginInfoBeans.getUserName() %>さん！</p>
    <a href="dispabsencelist">公欠一覧表示</a>
    <a href="inputabsenceresist">公欠を登録する</a>
    <a href="logout">ログアウト</a>
</body>
</html>