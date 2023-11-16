
<!DOCTYPE html>
<html>
<head>
    <title>DRAWINGS</title>
      <link rel="stylesheet" type="text/css" href="CSS/styleDrawTable.css">
</head>
<body>
    <h2><a href="/draw">MY DRAWINGS</a></h2>
       <h2><a href="/allDrawings">ALL DRAWINGS</a></h2>
              <h2><a href="/pagina">NEW DRAWING</a></h2>


     <table>
         <tr>
             <th>ID Drawing</th>
             <th>Date of Creation</th>
             <th>Drawing Name</th>
             <th>Delete</th>
         </tr>
         <tr>
             <td>1</td>
             <td>2023-01-01</td>
             <td>Dibujo 1</td>
             <td><button class="delete-button" onclick="deleteDrawing(1)">Delete</button></td>
         </tr>
     </table>
</body>
</html>