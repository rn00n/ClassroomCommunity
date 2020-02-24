<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-02-21
  Time: 오후 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Connection conn = null;

    try {
        String DB_HOST = "jdbc:oracle:thin:@127.0.0.1:1521:rn00n"; // 아이피, 포트, 서비스(SID) 정보를 수정
        String DB_USER = "RN00N"; // 아이디(유저) - 11g 이상시 대소문자 구분 확인
        String DB_PASS = "1234"; // 패스워 - 11g 이상시 대소문자 구분 확인

        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection(DB_HOST, DB_USER, DB_PASS);

        out.println("연결성공!");
    } catch (ClassNotFoundException e) {
        out.println("연결 드라이버 없음");
    } catch (SQLException e) {
        out.print("연결실패 : ");
        if(e.getMessage().indexOf("ORA-28009") > -1)
            out.println("허용되지 않는 접속 권한 없음");
        else if(e.getMessage().indexOf("ORA-01017") > -1)
            out.println("유저/패스워드 확인");
        else if(e.getMessage().indexOf("IO") > -1)
            out.println("IO - 연결확인!");
        else
            out.println("기본 연결확인!");

    } finally {
        if(conn != null)
            conn.close();
    }
%></body>
</html>
