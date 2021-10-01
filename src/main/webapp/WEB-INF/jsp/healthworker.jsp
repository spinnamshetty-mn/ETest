<%@ page language="java" contentType = "text/html; charset = UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">

  <head>

    <meta charset="utf-8">

    <title> Registration Form</title>

    <link href="<c:url value="/resources/css/healthworker.css" />" rel="stylesheet">
	 <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"/>"></script>
  </head>

  <body>

<form action="/signup/healthworker">
  <div class="container">
    <h1>Health Worker Registration</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
	<label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" minlength="8" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" title="Please include at least 1 uppercase character, 1 lowercase character, and 1 number." required>
    <label for="password-repeat"><b>Confirm Password</b></label>
    <input type="password" placeholder="Confirm Password" name="password-repeat" id="password-repeat" minlength="8" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" title="Please include at least 1 uppercase character, 1 lowercase character, and 1 number." required>
    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" id="name" pattern="[a-zA-Z]+" required>
    <label for="city"><b>City</b></label>
    <input type="text" placeholder="Enter City" name="city" id="city" required>
    
    <label for="state"><b> State &emsp;</b></label>
    <select name="state" id="state">
  	<option value="andhra_pradesh">Andhra Pradesh</option>
  	<option value="arunachal_pradesh">Arunachal Pradesh</option>
  	<option value="assam">Assam</option>
  	<option value="bihar">Bihar</option>
  	<option value="chhattisgarh">Chhattisgarh</option>
  	<option value="goa">Goa</option>
  	<option value="gujarat">Gujarat</option>
  	<option value="haryana">Haryana</option>
  	<option value="himachal_Pradesh">Himachal Pradesh</option>
  	<option value="jammu_and_kashmir">Jammu and Kashmir</option>
  	<option value="jharkhand">Jharkhand</option>
  	<option value="karnataka">Karnataka</option>
  	<option value="kerala">Kerala</option>
  	<option value="madhya_pradesh">Madhya Pradesh</option>
  	<option value="maharashtra">Maharashtra</option>
  	<option value="manipur">Manipur</option>
  	<option value="meghalaya">Meghalaya</option>
  	<option value="mizoram">Mizoram</option>
  	<option value="nagaland">Nagaland</option>
  	<option value="odisha">Odisha (Orissa)</option>
  	<option value="punjab">Punjab</option>
  	<option value="rajasthan">Rajasthan</option>
  	<option value="sikkim">Sikkim</option>
  	<option value="tamil_nadu">Tamil Nadu</option>
  	<option value="telangana">Telangana</option>
  	<option value="tripura">Tripura</option>
  	<option value="uttar_pradesh">Uttar Pradesh</option>
  	<option value="uttarakhand">Uttarakhand</option>
  	<option value="west_bengal">West Bengal</option>
  	<option value="andaman_and_nicobar">Andaman and Nicobar Islands</option>
  	<option value="chandigarh">Chandigarh</option>
  	<option value="dadra_and_nagar">Dadra and Nagar Haveli</option>
  	<option value="daman_and_diu">Daman and Diu</option>
  	<option value="lakshadweep">Lakshadweep</option>
  	<option value="delhi">Delhi</option>
  	<option value="puducherry">Puducherry</option>
	</select>
	<br>
	<br>
	<br>
    <label for="pincode"><b>Pincode</b></label>
    <input type="text" placeholder="Enter Pincode" name="pincode" id="pincode" required>
	<label for="type"><b> Type &emsp; </b></label>
    <select name="type" id="type">
  	<option value="Doctor">Doctor</option>
  	<option value="Hospital">Hospital</option>
  	<option value="Lab Technician">Lab Technician</option>
  	<option value="Front Line Worker">Front Line Worker</option>
	</select>
	<br>
	<br>
	<br>
	<label for="address"><b>Address</b></label>
    <input type="text" placeholder="Enter Address" name="address" id="address" required>
	<label for="mobile"><b>Mobile Number</b></label>
    <input type="text" placeholder="Enter Mobile Number" name="mobile" id="mobile" pattern="[6-9][0-9]{9}" required>
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