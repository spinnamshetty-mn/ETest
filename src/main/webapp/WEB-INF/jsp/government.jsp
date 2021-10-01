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
     <label for="state"><b> State &emsp;</b></label>
    <select name="state" id="state">
  	<option value="Andhra Pradesh">Andhra Pradesh</option>
  	<option value="Arunachal Pradesh">Arunachal Pradesh</option>
  	<option value="Assam">Assam</option>
  	<option value="Bihar">Bihar</option>
  	<option value="Chhattisgarh">Chhattisgarh</option>
  	<option value="Goa">Goa</option>
  	<option value="Gujarat">Gujarat</option>
  	<option value="Haryana">Haryana</option>
  	<option value="Himachal Pradesh">Himachal Pradesh</option>
  	<option value="Jammu and Kashmir">Jammu and Kashmir</option>
  	<option value="Jharkhand">Jharkhand</option>
  	<option value="Karnataka">Karnataka</option>
  	<option value="Kerala">Kerala</option>
  	<option value="Madhya Pradesh">Madhya Pradesh</option>
  	<option value="Maharashtra">Maharashtra</option>
  	<option value="Manipur">Manipur</option>
  	<option value="Meghalaya">Meghalaya</option>
  	<option value="Mizoram">Mizoram</option>
  	<option value="Nagaland">Nagaland</option>
  	<option value="Odisha">Odisha (Orissa)</option>
  	<option value="Punjab">Punjab</option>
  	<option value="Rajasthan">Rajasthan</option>
  	<option value="Sikkim">Sikkim</option>
  	<option value="Tamil Nadu">Tamil Nadu</option>
  	<option value="Telangana">Telangana</option>
  	<option value="Tripura">Tripura</option>
  	<option value="Uttar Pradesh">Uttar Pradesh</option>
  	<option value="Uttarakhand">Uttarakhand</option>
  	<option value="West Bengal">West Bengal</option>
  	<option value="Andaman and Nicobar Islands">Andaman and Nicobar Islands</option>
  	<option value="Chandigarh">Chandigarh</option>
  	<option value="Dadra and Nagar Haveli">Dadra and Nagar Haveli</option>
  	<option value="Daman and Diu">Daman and Diu</option>
  	<option value="Lakshadweep">Lakshadweep</option>
  	<option value="Delhi">Delhi</option>
  	<option value="Puducherry">Puducherry</option>
	</select>
	<br>
	<br>
	<br>
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
  	</div>
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