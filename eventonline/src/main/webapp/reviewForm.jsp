<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Review Form</title>
    <link rel="stylesheet" href="styles.css">
</head>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #f2f2f2;
    padding: 20px;
}

h1 {
    text-align: center;
    color: #333;
}

form {
    max-width: 600px;
    margin: 0 auto;
    background-color: #fff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

form div {
    margin-bottom: 15px;
}

form label {
    display: block;
    font-weight: bold;
    margin-bottom: 5px;
}

form input[type="text"], form input[type="email"], form textarea {
    width: 100%;
    padding: 8px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 16px;
}

form textarea {
    height: 120px;
}

form button[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 16px;
}

form button[type="submit"]:hover {
    background-color: #45a049;
}

.error-message {
    color: red;
    margin-top: 10px;
    font-size: 14px;
}
</style>
<body>
    <h1>Give Review</h1>
    <form action="ReviewServlet" method="post">
        <input type="hidden" name="eventid" value="${param.eventid}">
        <input type="hidden" name="userid" value="${param.userid}">
        <div>
            <label for="u_name">Name:</label>
            <input type="text" id="u_name" name="u_name" value="<%= session.getAttribute("username") %>" disabled>
        </div>
        <div>
            <label for="u_email">Email:</label>
            <input type="email" id="u_email" name="u_email" value="<%= session.getAttribute("useremail") %>" disabled>
        </div>

        <div>
            <label for="rating">Rating:</label>
            <input type="text" id="rating" name="rating" required>
        </div>
        <div>
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required>
        </div>
        <div>
            <label for="description">Description:</label>
            <textarea id="description" name="description" required></textarea>
        </div>
        <button type="submit">Submit Review</button>
    </form>
</body>
</html>
