<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
   <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        
        h2 {
            text-align: center;
            margin-top: 20px;
            color: #333;
        }
        
        form {
            width: 50%;
            margin: 0 auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }
        
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }
        
        input[type="text"],
        input[type="email"],
        input[type="password"] {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            margin-top: 5px;
        }
        
        input[type="radio"] {
            margin-top: 5px;
        }
        
        button {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-top: 20px;
        }
        
        button:hover {
            background-color: #0056b3;
        }
        
        .error {
            color: red;
            margin-top: 10px;
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
    <h2>Register</h2>
    <form:form action="/register" modelAttribute="user" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required />
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required />
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required />
        
        <label for="cpassword">Confirm Password:</label>
        <input type="password" id="cpassword" name="cpassword" required />
        
        <label>Select Role:</label>
        <input type="radio" id="userRole" name="role" value="USER" checked>
        <label for="userRole">USER</label>
        <input type="radio" id="adminRole" name="role" value="ADMIN">
        <label for="adminRole">ADMIN</label>
        
        <button type="submit">Register</button>
  
        <c:if test="${not empty errmsg}">
            <p class="error">${errmsg} Please try again.</p>
        </c:if>
        
        <div class="container">
            <p><a href="/"><button>Home</button></a></p>
        </div>
    </form:form>
    
    <footer>&copy; 2024 mcdse 105 assignment</footer>
</body>
</html>