<!DOCTYPE html>
<html>
<head>
    <title>LOGIN</title>
     <link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>
<body>

    <form action="/login" method="post">
        <div class="login-container">
               <div class="login-header">
                   <h2>LOGIN</h2>
               </div>
               <div class="login-form">
                   <div class="form-group">
                       <label for="username">Username:</label>
                       <input type="text" id="username" name="username" required>
                   </div>
                   <div class="form-group">
                       <label for="password">Password:</label>
                       <input type="password" id="password" name="password" required>
                   </div>
                   <div class="form-group">
                       <button type="submit">Iniciar sesion</button>
                       <p>No estoy registrado <a href ="/register">Registrarme</p>
                   </div>
               </div>
           </div>
    </form>
    <div id="error-message">
        <% String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) { %>
            <span style="color: red;"><%= errorMessage %></span>
        <% } %>
    </div>

</body>
</html>