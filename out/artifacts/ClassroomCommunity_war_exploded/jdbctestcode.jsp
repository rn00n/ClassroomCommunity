<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="java.sql.*" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>index.jsp</title>
</head>
<body>
<%
    response.setContentType("text/html");
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/orcl");
        System.out.println("[DataSource] : " + ds.toString());
        conn = ds.getConnection();
        stmt = conn.createStatement();
        String sql = "SELECT * FROM users";
        rs = stmt.executeQuery(sql);
%>
<table border="1">
    <tr>
        <td>id</td>
        <td>password</td>
    </tr>
    <% int i = 1;
        while(rs.next()){
            i++;
    %>
    <tr>
        <td><%=rs.getString(1)%></td>
        <td><%=rs.getString(2)%></td>
        <td><%=rs.getString(3)%></td>
        <td><%=rs.getString(4)%></td>
    </tr>
    <%
        }
    %>
</table>
<%
    } catch(SQLException e) {
        out.println("err: " + e.toString());
    } finally {
        rs.close();
        stmt.close();
    }
%>
</body>
</html>
