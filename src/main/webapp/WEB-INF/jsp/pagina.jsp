<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>DIBUJO</h1>
    <canvas id="canvas" width="800" height="600"></canvas>
        <br>
        <br>
        <button id="clearCanvas">Limpiar</button>
        <script src="java.js"></script>

    <form action="/pagina" method="post">
        <label for="figura">Figure:</label>
        <select id="figura" name="figura"
                    <option value="square">Square</option>
                    <option value="triangle">Triangle</option>
                    <option value="star">Star</option>
                    <option value="circle">Circle</option>

                </select><br><br>

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