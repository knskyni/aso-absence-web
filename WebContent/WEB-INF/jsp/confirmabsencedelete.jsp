<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="absence.beans.AbsenceBeans" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    AbsenceBeans registAbsenceBeans = (AbsenceBeans)session.getAttribute("deleteAbsenceBeans");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公欠削除確認画面 | 公欠管理システム</title>
</head>
<body>
    <table border="1">
        <tbody>
            <tr>
                <th>公欠日</th>
                <td><%= sdf.format(registAbsenceBeans.getAbsenceDate()) %></td>
            </tr>
            <tr>
                <th>企業名</th>
                <td><%= registAbsenceBeans.getCompanyName() %></td>
            </tr>
            <tr>
                <th>理由</th>
                <td><%= registAbsenceBeans.getReason() %></td>
            </tr>
        </tbody>
    </table>
    <p>
        <a href="dispabsencelist">戻る</a> | <a href="executeabsencedelete">削除する</a>
    </p>
</body>
</html>