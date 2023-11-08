<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>Registro de Usuario</h1>
    <form action="/register" method="post">
        <label for="username">UserName:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="email">E-Mail:</label>
        <input type="email" id="email" name="email" required><br><br>

            <% String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) { %>
                <span style="color: red;"><%= errorMessage %></span>
            <% } %>

        <input type="submit" value="Registrarse">

    </form>
</body>
</html>