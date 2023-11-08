<!DOCTYPE html>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>
    <h1>LOGIN</h1>
    <form action="/login" method="post">
        <label for="username">UserName</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>


        <input type="submit" value="Entrar">
    </form>
    <div id="error-message">
        <% String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) { %>
            <span style="color: red;"><%= errorMessage %></span>
        <% } %>
    </div>
    <p>No estoy registrado <a href ="/register">Registrarme</p>
</body>
</html>