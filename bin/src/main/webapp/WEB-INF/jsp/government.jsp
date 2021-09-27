<%@ page language="java" contentType = "text/html; charset = UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">

  <head>

    <meta charset="utf-8">

    <title> Registration Form</title>

    <link href="<c:url value="/resources/css/government_entity.css" />" rel="stylesheet">
	 <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"/>"></script>
  </head>

  <body>

<form action="/signup/government">
  <div class="container">
    <h1>Government Registration</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
	<label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
   <label for="name"><b>State</b></label>
    <input type="text" placeholder="State" name="state" id="state" pattern="[a-zA-Z]+" required>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" minlength="8" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" title="Please include at least 1 uppercase character, 1 lowercase character, and 1 number." required>
    <label for="password-repeat"><b>Confirm Password</b></label>
    <input type="password" placeholder="Confirm Password" name="password-repeat" id="password-repeat" minlength="8" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" title="Please include at least 1 uppercase character, 1 lowercase character, and 1 number." required>
    
	
    <hr>
    <p><input type="checkbox" id="termsChkbx" />By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
	<div align="center">
    <button type="submit" class="button" id="register" disabled="disabled">Register</button>
    </div>
  	</div>
  	<div class="container signin">
    <p>Already have an account? <a href="signin">Sign in</a>.</p>
  	</div>>
</form>

</body>
<script>
$(function() {
    $('#termsChkbx').click(function() {
        if ($(this).is(':checked')) {
            $('#register').removeAttr('disabled');
        } else {
            $('#register').attr('disabled', 'disabled');
        }
    });
});
</script>
</html>