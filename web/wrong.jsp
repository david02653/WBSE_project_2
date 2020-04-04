<%@ page import="model.Quiz" %><%--
  Created by IntelliJ IDEA.
  User: otonashi
  Date: 2020/4/4
  Time: 下午 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>wrong</title>
</head>
<body>
<% Quiz current = (Quiz) request.getServletContext().getAttribute("current"); %>
  <h2 style="color: firebrick;">抱歉，您答錯了!</h2><br>
  <h2 style="color: firebrick;">正確解答是 <%= current.getAnswer() %>。</h2>

  <form action="next" method="post">
      <%
          request.getSession().setAttribute("status", true);
      %>
      <input type="submit" value="Go to next">
  </form>
</body>
</html>
