<%@ page import="model.Quiz" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %><%--
  Created by IntelliJ IDEA.
  User: otonashi
  Date: 2020/4/2
  Time: 下午 02:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quiz</title>
</head>
<body>
  <% Quiz quiz = (Quiz) request.getServletContext().getAttribute("current"); %>
  <h2 style="color: blue;"><%= quiz.getQuestion() %></h2>

  <form action="sol" method="post">
  <% ArrayList<String> list = quiz.getOption(); %>
  <% Collections.shuffle(list); %>
  <% int count = 0; %>
  <% for(String s: list){ %>
      <input type="radio" id=<%=s%> name="ans" value=<%=s%>>
      <label for=<%=s%>> [<%=++count%>] <%=s%></label>
      <br>

  <% }%>
      <br>
      <input type="submit" value="Submit">
  </form>
</body>
</html>
