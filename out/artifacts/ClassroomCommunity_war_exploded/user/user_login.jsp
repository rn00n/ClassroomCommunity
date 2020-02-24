<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <script>
        function onLoginCheck(){
            if(document.user_login.id.value.length == 0) {
                alert('아이디는 필수사항입니다.')
                user_login.id.focus()
                return
            }
            if(document.user_login.pw.value.length == 0) {
                alert('비밀번호는 필수사항입니다.')
                user_login.pw.focus()
                return
            }
            document.user_login.submit()
        }
    </script>
</head>
<body>
<form action="user_login.user" method="post" name="user_login">
    id : <input type="text" name="id"/>
    pw : <input type="password" name="pw"/>
    <input type="button" value="로그인" onclick="onLoginCheck()"/>
</form>
</body>
</html>
