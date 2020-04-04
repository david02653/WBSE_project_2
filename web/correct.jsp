<%--
  Created by IntelliJ IDEA.
  User: otonashi
  Date: 2020/4/4
  Time: 下午 09:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>correct</title>
</head>
<body>
  <h2 style="color: firebrick;">恭喜，您答對了!</h2>
  <form action="next" method="post">
      <%
        request.getSession().setAttribute("status", true);
      %>
      <input type="submit" value="Go to next">
  </form>
</body>
</html>
