<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-02-21
  Time: 오전 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function infoConfirm() {
            if(document.user_join.id.value.length == 0) {
                alert('아이디는 필수사항입니다.')
                user_join.id.focus()
                return
            }
            if(document.user_join.id.value.length < 4) {
                alert('아이디는 4글자 이상이어야합니다.')
                user_join.id.focus()
                return
            }
            if(document.user_join.pw.value.length == 0) {
                alert('비밀번호는 필수사항입니다.')
                user_join.pw.focus()
                return
            }
            if(document.user_join.pw.value != document.user_join.pw_check.value) {
                alert('비밀번호 확인란을 다시 확인해주세요.')
                user_join.pw.focus()
                return
            }
            document.user_join.submit()
        }
    </script>
</head>
<body>
<form action="user_join.user" method="post" name="user_join">
    <h3>회원가입 페이지</h3>
    <hr>
    <table border="1">
        <tr>
            <td>아이디</td>
            <td>
                <input type="text" name="id">
            </td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td>
                <input type="password" name="pw">
            </td>
        </tr>

        <tr>
            <td>비밀번호 확인</td>
            <td>
                <input type="password" name="pw_check">
            </td>
        </tr>

        <tr>
            <td>이름</td>
            <td>
                <input type="text" name="name">
            </td>
        </tr>
        <tr>
            <td>전화번호</td>
            <td>
                <input type="text" name="phone">
            </td>
        </tr>
    </table>
    <br>
    <input type="button" value="회원가입" onclick="infoConfirm()">
    &nbsp;&nbsp;
    <input type="reset" value="취소">
</form>
</body>
</html>
