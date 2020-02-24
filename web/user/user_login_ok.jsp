<%@ page import="com.team3.user.model.UserDTO" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-02-21
  Time: 오전 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    로그인 성공
    <% UserDTO dto = (UserDTO)request.getAttribute("user_login"); %>

    id : <%= request.getParameter("id")%> </br>
    pw : <%= request.getParameter("pw")%> </br>
    이름 : <%= dto.getName()%> </br>
    전화번호 : <%= dto.getPhone()%> </br>
    꺄륵
    <a href="index.jsp">홈 화면</a>

</body>
</html>
