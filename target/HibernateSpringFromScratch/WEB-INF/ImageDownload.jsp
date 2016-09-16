<%--
  Created by IntelliJ IDEA.
  User: Lion
  Date: 9/15/16
  Time: 6:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Download</title>
</head>
<body>

<%--<form action="download" method="post">--%>

    <h1>Write the Id of the file to download it.</h1>

    ID: <input id="imageId" type="text" name="id">

    <input type="BUTTON" onclick="downloadImg()" value="Download">


<%--</form>--%>
    <h3 id="imgTitle"></h3>
    <img id="imageHolder" src="">

</body>
</html>


<script>

    function downloadImg() {
        var holderElement = document.getElementById("imageHolder");
        var idElement = document.getElementById("imageId")
        if (!idElement.value) return;
        holderElement.src = "http://localhost:8080/download/" + idElement.value;
    }

</script>