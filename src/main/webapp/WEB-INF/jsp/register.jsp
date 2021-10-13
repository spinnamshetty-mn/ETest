<%@ page language="java" contentType = "text/html; charset = UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">

  <head>

    <meta charset="utf-8">

    <title> Registration Form</title>

    <link href="<c:url value="/resources/css/first.css" />" rel="stylesheet">

  </head>

  <body>

<form class="box" action="signup" modelAttribute="hello" method="post">
<br>
  <h1>Register as</h1>
<input type="submit" name="Type" value="Patient">
<input type="submit" name="Type" value="HealthWorker">
  <input type="submit" name="Type" value="Government">
	<br>
</form>

  </body>

</html>