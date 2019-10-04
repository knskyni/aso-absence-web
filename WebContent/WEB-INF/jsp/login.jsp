<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン | 公欠管理システム</title>
</head>
<body>
	<%
	    String errorMsg = (String)request.getAttribute("errorMsg");
	%>
	<form action="auth" method="POST">
		<table>
			<tbody>
				<tr>
					<th>学籍番号</th>
					<td><input type="text" name="userId" required></td>
				</tr>
				<tr>
					<th>パスワード</th>
					<td><input type="password" name="password" required></td>
				</tr>
			</tbody>
		</table>
		<% if(errorMsg != null) { %>
		<p style="color: red;"><%= errorMsg %></p>
		<% } %>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>