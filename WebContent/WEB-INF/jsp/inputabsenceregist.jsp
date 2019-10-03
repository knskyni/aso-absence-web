<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>公欠登録 | 公欠管理システム</title>
</head>
<body>
    <form action="confirmabsenceregist" method="POST">
        <input type="date" name="absence_date">
        <input type="text" name="company_name">
        <textarea name="reason"></textarea>
        <input type="submit" value="送信">
    </form>
</body>
</html>