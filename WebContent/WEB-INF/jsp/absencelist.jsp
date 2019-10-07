<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="absence.beans.LoginInfoBeans" %>
<%@ page import="java.util.List" %>
<%@ page import="absence.beans.AbsenceBeans" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%
    List<AbsenceBeans> absenceList = (List<AbsenceBeans>)request.getAttribute("absenceList");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公欠リスト | 公欠管理システム</title>
</head>
<body>
    <style>
        td {
            padding-left: 2rem;
            padding-right: 2rem;
        }
    </style>
    <table border="1">
        <tbody>
            <tr>
                <th>学籍番号</th>
                <th>日付</th>
                <th>会社名</th>
                <th>理由</th>
                <th>操作</th>
            </tr>
            <% for(AbsenceBeans absenceBeans : absenceList) { %>
            <tr>
                <td><%= absenceBeans.getUserId() %></td>
                <td><%= sdf.format(absenceBeans.getAbsenceDate()) %></td>
                <td><%= absenceBeans.getCompanyName() %></td>
                <td><%= absenceBeans.getReason() %></td>
                <td><a href="inputabsenceupdate?id=<%= absenceBeans.getAbsenceId() %>">編集</a> <a href="confirmabsencedelete?id=<%= absenceBeans.getAbsenceId() %>">削除</a></td>
            </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>