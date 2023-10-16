<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/signup.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="../js/signupjq.js"></script>
</head>

<body>
    <form class="login" id="signupForm">
        <label for="id">아이디 :</label>
        <input class="idd" id="id" name="id" type="text" autocomplete="off"
                value="id2">
        <button class="iddupchk" type="button" value="아이디 중복 확인">아이디 중복 확인</button>



        <label for="pwd">비밀번호 :</label>
        <input id="pwd" name="pwd" type="password" 
            value="a**12345678"
            pattern="(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}">

        <label for="pwd1">비밀번호 확인 :</label>
        <input id="pwd1" type="password" 
                value="a**12345678">

        <label for="name">이름:</label>
        <input id="name" name="name" type="text">

        <button class="signup" type="submit">가입</button>

    </form>
    <!--
        내부에 만들면 전송 (type='submit') 버튼이 된다
        form외부에 button을 만들면 일반(type='button') 버튼이된다

    -->


</body>

</html>