<%--
  Created by IntelliJ IDEA.
  User: Lion
  Date: 9/15/16
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>

<form action="upload" method="post" enctype="multipart/form-data">
    <input type="file" name="image" value="Choose">

    Name: <input type="text" name="name">

    <input type="submit" value="Upload">
</form>

</body>
</html>
