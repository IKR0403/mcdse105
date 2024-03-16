<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inventory System</title>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
}

.container {
    width: 50%;
    margin: 0 auto;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    padding: 20px;
}

h1 {
    color: #333;
    text-align: center;
    margin-bottom: 20px;
}

.form-group {
    margin-bottom: 20px;
}

label {
    display: block;
    font-weight: bold;
}

input[type="text"],
input[type="number"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    box-sizing: border-box;
}

button {
    background-color: #007bff;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}

button:hover {
    background-color: #0056b3;
}

button.cancel {
    background-color: #ccc;
    margin-right: 10px;
}

     footer {
           color: black;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
</style>
</head>
<body>
<div class="container">
    <h1>Add New Product</h1>
    <form method="post" action="/products/NewProduct" modelattribute="product">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required/>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <input type="text" id="description" name="description" required/>
        </div>
        <div class="form-group">
            <label for="category">Category</label>
            <input type="text" id="category" name="category" required/>
        </div>
        <div class="form-group">
            <label for="price">Price</label>
            <input type="number" id="price" name="price" required/>
        </div>
        <div class="form-group">
            <label for="quantity">Quantity</label>
            <input type="number" id="quantity" name="quantity" required/>
        </div>
        <div class="form-group">
            <button class="cancel"><a href="/products">Cancel</a></button>
            <button type="submit">Create</button>
        </div>
    </form>
</div>
<footer>&copy; 2024 mcdse 105 assignment</footer>
</body>
</html>
