<!DOCTYPE html>
<html en="ru">
<head>
    <title>Products</title>
</head>

<body>
<h1>Marketplace</h1>
<hr>
<h2>Панель администратора</h2>
<table border="1">
    <tr>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Роли</th>
        <th>Бан</th>
        <th>Редактировать</th>
        <th>Подробнее</th>
    </tr>
    <#list users as user>
        <tr>
            <th>${user.email}</th>
            <th>${user.phoneNumber}</th>
            <th><#if user.active>true <#else> false</#if></th>
            <th><#list user.roles as role>${role}<#sep>, </#list></th>
            <th>
                <form action="admin/user/ban/${user.id?c}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form>
            </th>
            <th><a href="/admin/user/edit/${user.id?c}">Редактировать</a></th>
            <th><a href="users/${user.id?c}">Подробнее</a></th>
        </tr>
    <#else>
        <h3>Пользователей нет</h3>
    </#list>
</table>
<hr>

</body>
</html>