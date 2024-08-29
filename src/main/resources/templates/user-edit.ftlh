<!DOCTYPE html>
<html>
<head>
    <title>marketplace</title>
</head>
<body>
<h1>marketplace</h1><hr>
<h3>Редактирование пользователя ${userToEdit.name}</h3>
<form action="/admin/user/edit" method="post">
    <#list roles as role>
        <div>
            <label><input type="checkbox" name="${role}" ${userToEdit.roles?seq_contains(role)?string("checked", "")}>${role}</label>
        </div>
    </#list>
    <input type="hidden" value="${userToEdit.id}" name="id">
    <input type="hidden" value="${_csrf.token}" name="_csrf">
    <button type="submit">Сохранить</button>
</form>
</body>
</html>