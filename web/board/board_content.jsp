<%@ page import="com.team3.board.model.BoardDTO" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-02-21
  Time: 오전 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% BoardDTO dto = (BoardDTO) request.getAttribute("dto"); %>
<form action="board_update.board" method="post" name="board_content">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title" value="<%=dto.getTitle()%>"/></td>
        </tr>
        <tr>
            <th>작성 날짜</th>
            <td><input type="text" readonly="readonly" name="createdTime" value="<%= dto.getCreatedTime()%>"/></td>
        </tr>
        <tr>
            <th>수정 날짜</th>
            <td><input type="text" readonly="readonly" name="updatedTime" value="<%= dto.getUpdatedTime()%>"/></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10" maxlength="500"><%=dto.getContent()%></textarea></td>
        </tr>
        <input type="hidden" name="id" value="<%=dto.getId()%>"/>
    </table>
    <div><a href="/board/board_list.board">목록으로</a></div>
    <div><input type="submit" value="수정"/></div>
    <div><a href="/board/board_delete.board?id=<%=dto.getId()%>">삭제</a></div>

    <div><a href="/board/board_answer_content.board?id=<%=dto.getId()%>">답글작성</a></div>
</form>


</body>
</html>
