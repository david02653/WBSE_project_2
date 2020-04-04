<%--
  Created by IntelliJ IDEA.
  User: otonashi
  Date: 2020/4/5
  Time: 上午 02:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Score</title>
</head>
<body>
  <h1 style="color: firebrick">Your score is <%= request.getSession().getAttribute("score")%>/<%= request.getServletContext().getAttribute("total")%> !</h1>
</body>
</html>
