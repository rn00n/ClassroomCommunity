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
    <script>
        function click() {
                if(document.board_insert.createdTime.value == "") {

                    document.board_insert.submit()
                    return
                }
                // if(document.board_insert.createdTime == null) {
                //     document.board_insert.action = "board_update.board"
                //     document.board_insert.submit()
                //     return
                // }
        }
    </script>
</head>
<body>

    <form action="board_insert.board" method="post" name="board_insert">
<%--        제목 : <input type="text" name="title"/>--%>
<%--        내용 : <input type="text" name="content"/>--%>
<%--        <input type="hidden" name="user_id" value="1"/>--%>
<%--        <input type="submit" value="저장"/>--%>
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
        </table>
    <div><a href="/board/board_list.board" >목록으로</a></div>
    <div><input type="submit" value="저장" /></div>
<%--    <div><a href="/board/board_delete.board?id=<%=dto.getId()%>">삭제</a></div>--%>
    </form>


</body>
</html>
