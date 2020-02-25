<%@ page import="com.team3.board.model.BoardDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>답글 작성</title>
</head>
<body>

<%--게시글의 데이터를 검색한 객체--%>
<% BoardDTO dto = (BoardDTO) request.getAttribute("dto"); %>
<form action="board_answer_insert.board" method="post" name="board_answer_insert">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"/></td>
        </tr>
        <tr>
            <th>작성 날짜</th>
            <td><input type="text" readonly name="createdTime" value=""/></td>
        </tr>
        <tr>
            <th>수정 날짜</th>
            <td><input type="text" readonly name="updatedTime" value=""/></td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10" maxlength="500"></textarea></td>
        </tr>
        <input type="hidden" name="user_id" value="1"/>
        <input type="hidden" name="groups" value="<%=dto.getGroups()%>"/>
        <input type="hidden" name="depth" value="<%=dto.getDepth()%>"/>
        <input type="hidden" name="sort" value="<%=dto.getSort()%>"/>
    </table>
    <div><a href="/board/board_list.board">목록으로</a></div>
    <div><input type="submit" value="저장"/></div>
</form>
</body>
</html>
