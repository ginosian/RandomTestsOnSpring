<%--
  Created by IntelliJ IDEA.
  User: Lion
  Date: 9/7/16
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body onload="vle()">

<h1 id="h1"></h1>

<script>
    function vle() {
        document.getElementById("h1").innerHTML = '${vle}';
    }
</script>

</body>
</html>
