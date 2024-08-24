<!DOCTYPE html>
<html>
<head>
    <title>Marketplace</title>
</head>
<body>
<h1>Marketplace</h1><hr>
<h4>Регистрация</h4>
<form action="/users/registration" method="post">
    Имя пользователя: <input type="text" name="name"><br><br>
    Эл. почта: <input type="email" name="email"><br><br>
    Номер телефона: <input type="text" name="numberPhone"><br><br>
    Пароль: <input type="password" name="password"><br><br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <input type="submit" value="Регистрация"/>
</form>
<#if errorMessage??>
    <h1 style="color:red">${errorMessage}</h1>
</#if>
</body>
</html>