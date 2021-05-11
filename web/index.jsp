<%--
  Created by IntelliJ IDEA.
  User: hanjie
  Date: 2021/5/7
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Home</title>

    <style>
      a{
        text-decoration: none;
        color: blueviolet;
        font-size: 18px;
      }
      h3{
        width: 180px;
        height: 38px;
        margin: 100px auto;
        text-align: center;
        line-height: 38px;
        background: pink;
        border-radius: 7px;

      }
    </style>

  </head>
  <body>
  <h3>
    <a href="${pageContext.request.contextPath}/book/allBook">图书馆</a>
  </h3>
  </body>
</html>
