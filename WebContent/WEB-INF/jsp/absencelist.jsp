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
<html lang="ja" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>公欠リスト | 公欠管理システム</title>

    <!-- meta -->
    <meta name="viewport" content="width=device-width,initial-scale=1.0">

    <!-- css -->
    <link rel="stylesheet" href="./css/master.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <style>
        table {
            text-align: center;
        }
    </style>
    <div class="container">
        <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
            <a class="navbar-brand" href="#">公欠管理システム</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">トップ（公欠一覧） <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">公欠登録</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0 text-white">
                    ようこそ、◯◯◯さん
                </form>
            </div>
        </nav>
        <div class="row">
            <div class="col-md-12">
                <table class="table">
                    <thead class="thead-dark">
                        <tr>
                            <th>学籍番号</th>
                            <th>日付</th>
                            <th>会社名</th>
                            <th>理由</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for(AbsenceBeans absenceBeans : absenceList) { %>
                        <tr>
                            <td><%= absenceBeans.getUserId() %></td>
                            <td><%= sdf.format(absenceBeans.getAbsenceDate()) %></td>
                            <td><%= absenceBeans.getCompanyName() %></td>
                            <td><%= absenceBeans.getReason().replace("\n", "<br>") %></td>
                            <td><a href="inputabsenceupdate?id=<%= absenceBeans.getAbsenceId() %>">編集</a> <a href="confirmabsencedelete?id=<%= absenceBeans.getAbsenceId() %>">削除</a></td>
                        </tr>
                        <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <!-- javascript -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
