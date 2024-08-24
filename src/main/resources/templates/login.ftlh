<!DOCTYPE html>
<html>
<head>
    <title>Marketplace</title>
</head>
<body>
<h1>Marketplace</h1><hr>
<h4>Авторизация</h4>
<form action="/users/login" method="post">
    Эл. почта: <input type="email" id="username" name="username"><br><br>
    Пароль: <input type="password" id="password" name="password"><br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Вход"/>
</form>
<a href="/users/registration">Зарегистрироваться</a>
</body>
</html>