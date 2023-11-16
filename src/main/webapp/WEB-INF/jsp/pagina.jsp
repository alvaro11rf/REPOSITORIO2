<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="/CSS/styleCanvas.css">


</head>
<body>
    <h1>DRAWING</h1>
    <canvas id="canvas" width="800" height="600"></canvas>
    <script src="/JS/java.js"></script>
        <br>
        <br>
        <button id="clearCanvas">CLEAN</button>



    <form action="/pagina" method="post" id = "formulario">
       <label for="shape">Shape:</label>
       <select id="shapeSelect" name="shapeSelect">
           <option value="square">Square</option>
           <option value="triangle">Triangle</option>
           <option value="rectangle">Rectangle</option>
           <option value="circle">Circle</option>
       </select><br><br>
 <label for="brush">Brush:</label>
      <input type="checkbox" id="brush">

        <label for="Size">Size:</label>
        <input type="range" id="size" min="10" max="50" value="10">

       <label for="Color">Color:</label>
               <input type="color" id="color" value="#000000">

               <label for="Fill">Fill shape:</label>
                       <input type="checkbox" id="fillShape">
 <input type="hidden" id="draw" name="draw">
        <input type="submit" value="Send">
    </form>
</body>
</html>