<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Form</title>
    <style>
        body {
            font-family: Verdana, Geneva, Tahoma, sans-serif;
            background-color: #FF8E8F; /* Original background color */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: #FFFDCB; /* Original container background color */
            padding: 40px 50px;
            border-radius: 20px;
            box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }
        h1 {
            color: #E178C5; /* Original heading color */
            margin-bottom: 30px;
            font-size: 24px;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        input[type="text"],
        input[type="password"] {
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #d9d9d9;
            border-radius: 12px;
            font-size: 16px;
            width: 100%;
            max-width: 400px;
            box-sizing: border-box;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus,
        input[type="password"]:focus {
            border-color: #E178C5; /* Original heading color for focus state */
            outline: none;
        }
        input[type="submit"] {
            padding: 12px;
            background-color: #FFB38E; /* Original button color */
            border: none;
            border-radius: 6px;
            color: white;
            font-size: 16px;
            cursor: pointer;
            margin-top: 20px;
            transition: background-color 0.3s;
            width: 100%;
            max-width: 400px;
            box-sizing: border-box;
        }
        input[type="submit"]:hover {
            background-color: #344955; /* Original button hover color */
        }
        .error-message {
            color: red;
            margin-top: 10px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h1>Login</h1>
        <form action="login" method="post">
            <input type="text" name="email" placeholder="Email" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="Login">
        </form>
        <% if (request.getAttribute("errorMessage") != null) { %>
            <p class="error-message"><%= request.getAttribute("errorMessage") %></p>
        <% } %>
    </div>
</body>
</html>
