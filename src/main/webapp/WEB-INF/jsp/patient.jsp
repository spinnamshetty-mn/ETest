<%@ page language="java" contentType = "text/html; charset = UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en" dir="ltr">

  <head>

    <meta charset="utf-8">

    <title> Registration Form</title>

    <link href="<c:url value="/resources/css/patient.css" />" rel="stylesheet">
    <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"/>"></script>

  </head>

  <body>

<form action="/signup/patient" method=post>
  <div class="container">
    <h1>Patient Registration</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>
	<label for="firstname"><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="firstname" id="firstname" pattern="([A-Za-z])+( [A-Za-z]*)" oninput="let p=this.selectionStart;this.value=this.value.toUpperCase();this.setSelectionRange(p, p);" required>
    <label for="lastname"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Last Name" name="lastname" id="lastname" pattern="([A-Za-z])+( [A-Za-z]*)" oninput="let p=this.selectionStart;this.value=this.value.toUpperCase();this.setSelectionRange(p, p);" required>
    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" id="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"  required>
    <label for="password"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" minlength="8" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" title="Please include at least 1 uppercase character, 1 lowercase character, and 1 number." required>
    <label for="password-repeat"><b>Confirm Password</b></label>
    <input type="password" placeholder="Confirm Password" name="password-repeat" id="password-repeat" minlength="8" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" title="Please include at least 1 uppercase character, 1 lowercase character, and 1 number." required>
    <label for="city"><b>City</b></label>
    <input type="text" placeholder="Enter City" name="city" id="city" oninput="let p=this.selectionStart;this.value=this.value.toUpperCase();this.setSelectionRange(p, p);" required>
    <label for="state"><b> State &emsp;</b></label>
    <select name="state" id="state">

  	<option value="ANDHRA PRADESH">Andhra Pradesh</option>
  	<option value="ARUNACHAL PRADESH">Arunachal Pradesh</option>
  	<option value="ASSAM">Assam</option>
  	<option value="BIHAR">Bihar</option>
  	<option value="CHHATTISGARH">Chhattisgarh</option>
  	<option value="GOA">Goa</option>
  	<option value="GUJARAT">Gujarat</option>
  	<option value="HARYANA">Haryana</option>
  	<option value="HIMACHAL PRADESH">Himachal Pradesh</option>
  	<option value="JAMMU AND KASHMIR">Jammu and Kashmir</option>
  	<option value="JHARKHAND">Jharkhand</option>
  	<option value="KARNATAKA">Karnataka</option>
  	<option value="KERALA">Kerala</option>
  	<option value="MADHYA PRADESH">Madhya Pradesh</option>
  	<option value="MAHARASHTRA">Maharashtra</option>
  	<option value="MANIPUR">Manipur</option>
  	<option value="MEGHALAYA">Meghalaya</option>
  	<option value="MIZORAM">Mizoram</option>
  	<option value="NAGALAND">Nagaland</option>
  	<option value="ODISHA">Odisha (Orissa)</option>
  	<option value="PUNJAB">Punjab</option>
  	<option value="RAJASTHAN">Rajasthan</option>
  	<option value="SIKKIM">Sikkim</option>
  	<option value="TAMIL NADU">Tamil Nadu</option>
  	<option value="TELANGANA">Telangana</option>
  	<option value="TRIPURA">Tripura</option>
  	<option value="UTTAR PRADESH">Uttar Pradesh</option>
  	<option value="UTTARAKHAND">Uttarakhand</option>
  	<option value="WEST BENGAL">West Bengal</option>
  	<option value="ANDAMAN AND NICOBAR ISLANDS">Andaman and Nicobar Islands</option>
  	<option value="CHANDIGARH">Chandigarh</option>
  	<option value="DADRA AND NAGAR HAVELI">Dadra and Nagar Haveli</option>
  	<option value="DAMAN AND DIU">Daman and Diu</option>
  	<option value="lAKSHADWEEP">Lakshadweep</option>
  	<option value="DELHI">Delhi</option>
  	<option value="PUDUCHERRY">Puducherry</option>

	</select>
	<br>
	<br>
	<br>
    <label for="pincode"><b>Pincode</b></label>
    <input type="text" placeholder="Enter Pincode" name="pincode" id="pincode" oninput="let p=this.selectionStart;this.value=this.value.toUpperCase();this.setSelectionRange(p, p);" required>
	<label for="mobile"><b>Mobile Number</b></label>
    <input type="text" placeholder="Enter Mobile Number" name="mobile" id="mobile" pattern="[6-9][0-9]{9}" oninput="let p=this.selectionStart;this.value=this.value.toUpperCase();this.setSelectionRange(p, p);" required>
    <hr>
    
	<p><input type="checkbox" id="termsChkbx" />By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>
	<div align="center">
    <button type="submit" class="button" name="register" id="register" disabled="disabled">Register</button>
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