<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
</head>
<body>
<h1>Marketplace</h1>
<hr>
<h4>О товаре</h4>
<br>
<b>Наименование товара</b>
<p>${product.title}</p>

<#list images as image>
    <img src="/images/${image.id}" height="60px"/>
</#list>

<p>Описание</p>
<p>${product.description}</p>

<p>Цена</p>
<p>${product.price} руб.</p>

<p>Город</p>
<p>${product.city}</p>

<p>Автор</p>
<p>${product.author}</p>

<hr>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар">
</form>
</body>
</html>