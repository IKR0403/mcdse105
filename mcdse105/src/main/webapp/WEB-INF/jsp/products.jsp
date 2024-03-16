<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Car Detailing Products | Admin</title>
     <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            flex-direction: column; /* Added */
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
            color: #333;
        }

        tr:hover {
            background-color: #f9f9f9;
        }

        p {
            color: red;
            font-style: italic;
        }

        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            text-decoration: none;
        }

        button:hover {
            background-color: #0056b3;
        }

        a {
            color: inherit;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }

        .right {
            text-align: right;
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
    <h1>Welcome, <c:if test="${not empty username }">${username}</c:if>!</h1>
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <button type="submit">Logout</button>
    </form:form>
</div>

<div class="container">
    <h1>Car Detailing Products</h1>
    <!-- Search Form -->
    <form action="${pageContext.request.contextPath}/products/search" method="GET">
        <input type="text" name="name" placeholder="Search by product name">
        <button type="submit">Search</button>
    </form>
    <c:if test="${empty products}">
        <p>No product(s) found.</p>
    </c:if>

    <c:if test="${not empty products}">
        <table>
            <!-- Table Header -->
            <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Category</th>
                    <th>Price Per Unit (MYR)</th>
                    <th>Quantity</th>
                    <th>Action</th>
                </tr>
            </thead>
            <!-- Table Body -->
            <tbody>
                <c:forEach var="product" items="${products}" varStatus="row">
                    <tr>
                        <td>${row.index + 1}</td>
                        <td><a href="/products/${product.id}">${product.name}</a></td>
                        <td>${product.description}</td>
                        <td>${product.category}</td>
                        <td>${product.price}</td>
                        <td>${product.quantity}</td>
                        <td><a href="/products/${product.id}/delete">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </c:if>
</div>

<div class="container">
    <div class="right">
        <p><a href="${pageContext.request.contextPath}/products"><button>Show All Products</button></a></p>
        <p><a href="/products/NewProduct"><button>Create New Product</button></a></p>
    </div>
</div>

<footer>&copy; 2024 mcdse 105 assignment</footer>
</body>
</html>