<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="/CSS/style.css">


</head>
<body>
    <h1>DIBUJO</h1>
    <canvas id="canvas" width="800" height="600"></canvas>
    <script src="/JS/java.js"></script>
        <br>
        <br>
        <button id="clearCanvas">Limpiar</button>



    <form action="/pagina" method="post">
       <label for="figura">Figure:</label>
       <select id="figura" name="figura">
           <option value="square">Square</option>
           <option value="triangle">Triangle</option>
           <option value="star">Star</option>
           <option value="circle">Circle</option>
       </select><br><br>
 <label for="brush">Brush:</label>
      <input type="checkbox" id="brush">

        <label for="Size">Size:</label>
        <input type="range" id="size" min="1" max="10" value="1">

       <label for="Color">Color del pincel/figura:</label>
               <input type="color" id="color" value="#000000">

               <label for="Fill">Rellenar figura:</label>
                       <input type="checkbox" id="fill">

        <input type="submit" value="Ready">
    </form>
</body>
</html>