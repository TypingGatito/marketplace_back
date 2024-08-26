<!DOCTYPE html>
<html>
<head>
    <title>Marketplace</title>
</head>
<body>
<h1>Marketplace</h1><hr>
<h4>Информация о пользователе ${user.name}</h4>
<b>Номер телефона: </b> ${user.phoneNumber} <br>
<b>Email: </b> ${user.email} <br>

<#list products as product>
    <div>
        <p>${product.title} ${product.price} руб.
            <a href="/product/${product.id}">Подробнее</a>
        </p>
    </div>
<#else>
    <h3>Товаров нет</h3>
</#list>

<#if errorMessage??>
    <h1 style="color:red">${errorMessage}</h1>
</#if>
</body>
</html>