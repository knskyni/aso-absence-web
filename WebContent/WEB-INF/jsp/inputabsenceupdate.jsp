<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="absence.beans.AbsenceBeans" %>
<%
    AbsenceBeans absenceBeans = (AbsenceBeans)session.getAttribute("updateAbsenceBeans");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公欠更新 | 公欠管理システム</title>
</head>
<body>
    <form action="confirmabsenceupdate" method="POST">
        <input type="date" name="absence_date" value="<%= absenceBeans.getAbsenceDate() %>">
        <input type="text" name="company_name" value="<%= absenceBeans.getCompanyName() %>">
        <textarea name="reason"><%= absenceBeans.getReason() %></textarea>
        <input type="submit" value="送信">
    </form>
</body>
</html>