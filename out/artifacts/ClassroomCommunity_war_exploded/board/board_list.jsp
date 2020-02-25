<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>BoardList</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
    <tr>
        <td>번호</td>
        <td>이름</td>
        <td>제목</td>
        <td>만든 날짜</td>
        <td>수정 날짜</td>
        <td>조회수</td>
    </tr>
    <c:forEach items="${list}" var="dto">
        <tr>
            <td>${dto.id}</td>
            <td>${dto.user_id}</td>
            <td>
                <c:forEach begin="1" end="${dto.depth}">└</c:forEach>
                <a href="board_content.board?id=${dto.id}">${dto.title}</a>
            </td>
            <td>${dto.createdTime}</td>
            <td>${dto.updatedTime}</td>
            <td>${dto.hit}</td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="6"><a href="board_insert.jsp">글작성</a></td>
    </tr>
</table>
</body>
</html>
