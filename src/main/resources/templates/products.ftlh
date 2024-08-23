<!DOCTYPE html>
<html>
<head>
    <title>Products</title>
</head>

<body>
<h1>Marketplace</h1>
<hr>
<h4>Товары</h4>

<form action="/product" method="get">
    <label for="title">Название</label>
    <input type="text" id="title" name="title">
    <input type="submit" value="Поиск">
</form>

<#list products as product>
    <div>
        <p>${product.title} ${product.price} руб.
            <a href="/product/${product.id}">Подробнее</a>
        </p>
    </div>
    <#else>
    <h3>Товаров нет</h3>
</#list>
<hr>
<h3>Создать товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    <label for="title">Название:</label>
    <input type="text" id="title" name="title" required>
    <br>

    <label for="description">Описание:</label>
    <textarea id="description" name="description" required></textarea>
    <br>

    <label for="price">Цена:</label>
    <input type="number" id="price" name="price" required>
    <br>

    <label for="city">Город:</label>
    <input type="text" id="city" name="city" required>
    <br>

    <label for="author">Автор:</label>
    <input type="text" id="author" name="author" required>
    <br>

    <label for="file1">Фотография 1</label>
    <input type="file" id="file1" name="file1">
    <br>

    <label for="file2">Фотография 2</label>
    <input type="file" id="file2" name="file2">
    <br>

    <label for="file3">Фотография 3</label>
    <input type="file" id="file3" name="file3">
    <br>
    <button type="submit">Create Product</button>
</form>
</body>
</html>