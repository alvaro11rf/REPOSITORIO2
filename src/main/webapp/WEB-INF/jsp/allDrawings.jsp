<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>ALL DRAWINGS</title>
     <link rel="stylesheet" type="text/css" href="CSS/styleDrawTable.css">
</head>
<body>
      <h2><a href="/draw">MY DRAWINGS</a></h2>
             <h2><a href="/allDrawings">ALL DRAWINGS</a></h2>
                    <h2><a href="/pagina">NEW DRAWING</a></h2>

<c:out value="${fn:length(list)}" />
        <table>
            <tr>
                <th>ID Drawing</th>
                <th>Username</th>
                <th>Creation Date</th>
                <th>Drawing Name</th>
                <th>See</th>
                <th>Delete</th>
                <th>Modify</th>

            </tr>
            <c:forEach var="draw" items="${list}">
            <tr>
                <td>${draw.id}</td>
                <td>${draw.user}</td>
               <td><fmt:formatDate value="${draw.creationDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
                <td>${draw.name}</td>
                <td>
                <form action="/viewDrawing" method="get">
                    <input type="hidden" name="drawingId" value="${draw.id}">
                    <button type="submit"  class="see-button" >See</button>
                </form>
                
                </td>
                
            </tr>
            </c:forEach>
        </table>

</body>
</html>