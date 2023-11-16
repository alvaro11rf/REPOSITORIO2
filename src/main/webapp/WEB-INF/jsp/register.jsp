<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
      <link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>
<body>
<div class="login-container">
        <div class="login-header">
    <h1>USER REGISTER</h1>
    <form action="/register" method="post">
    </div>
            <div class="login-form">
                <div class="form-group">
        <label for="username">UserName:</label>
        <input type="text" id="username" name="username" required><br><br>
 </div>
            <div class="form-group">
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
 </div>
            <div class="form-group">
        <label for="email">E-Mail:</label>
        <input type="email" id="email" name="email" required><br><br>
        </div>
                    <div class="form-group">
 <button type="submit"> Register </button>
  </div>
         </div>
     </div>
            <% String errorMessage = (String) request.getAttribute("errorMessage");
            if (errorMessage != null) { %>
                <span style="color: red;"><%= errorMessage %></span>
            <% } %>



    </form>
</body>
</html>