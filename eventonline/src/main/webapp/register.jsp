<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
    <style>
        body {
            font-family: Verdana, Geneva, Tahoma, sans-serif;
            background-color: #FF8E8F;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .register-container {
            background-color: #FFFDCB;
            padding: 40px 50px;
            border-radius: 20px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
            text-align: center;
        }
        h1 {
            color: #E178C5;
            margin-bottom: 20px;
            font-size: 24px;
        }
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="tel"] {
            padding: 12px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 12px;
            font-size: 16px;
            width: 100%;
            max-width: 400px;
            box-sizing: border-box;
            transition: border-color 0.3s;
        }
        input[type="text"]:focus,
        input[type="password"]:focus,
        input[type="email"]:focus,
        input[type="tel"]:focus {
            border-color: #E178C5;
            outline: none;
        }
        input[type="submit"],
        input[type="button"] {
            padding: 12px;
            background-color: #FFB38E;
            border: none;
            border-radius: 6px;
            color: white;
            font-size: 16px;
            cursor: pointer;
            margin-top: 20px;
            width: 100%;
            max-width: 400px;
            box-sizing: border-box;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover,
        input[type="button"]:hover {
            background-color: #344955;
        }
        .back-button {
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="register-container">
        <h1>Register</h1>
        <form action="registration" method="post">
            <input type="text" name="name" placeholder="Name" required>
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="email" name="email" placeholder="Email" required>
            <input type="text" name="phone_number" placeholder="Phone Number" required>
            <input type="text" name="city" placeholder="Address" required>
            <input type="text" name="role" placeholder="Role" required>
            <input type="submit" value="Register">
            <a href="welcome.jsp"><input type="button" value="Back" class="back-button"></a>
        </form>
    </div>
</body>
</html>
