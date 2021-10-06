<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Epidemic TTT</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />" >
  <link href="<c:url value="/resources/css/pdash_new.css" />" rel="stylesheet"> 
  <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js" />" ></script>
  <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" />" ></script>
  <link href="<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Dashboard</h4>
      <ul class="nav nav-pills nav-stacked">
        <li ><a href="gdash"><i class="fa fa-home" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Home</span></a></li>
         <li><a href="test_requests"><i class="fa fa-calendar" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Test Requests</span></a></li>
         <li ><a href="active_cases"><i class="fa fa-bar-chart" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Active Cases</span></a></li> 
        <li ><a href="pending_approvals"><i class="fa fa-user" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Pending Approvals</span></a></li>
         <li><a href="test_results"><i class="fa fa-tasks" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Test Results</span></a></li>
         <li><a href="zonal_info"><i class="fa fa-circle-thin" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Zones</span></a></li>
        <li><a href="view_contacts_list"><i class="fa fa-eye" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> View Contacts List</span></a></li>
        <li class="active"><a href="#"><i class="fa fa-plus" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Manage Disease</span></a></li>
         <li><a href="gsettings"><i class="fa fa-cog" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Settings</span></a></li>
       </ul><br>
    </div>
    
    <div class="col-sm-9">
      <div class="top">
      <table id="head">
      <tr>
      <td><h1><small>  HELLO   </small>   </h1></td>
      <td>
      <form action="logout" method="post">
      <button value="logout" id="logout" style="float:right;" >Logout</button>
      
      </td>
      </tr>
      </table>
     </div>
      <hr>
      
      <div> 
      <h4>
      
      
      <form action="">
  	<label for="disease">Enter Disease:</label>
  	<input type="text" id="disease" name="disease"><br><br>
  	<label for="test">Enter Test:</label>
  	<input type="text" id="test" name="test"><br><br>
  	<input type="submit" value="Submit">
	</form>
      
      </h4>
      </div>
	
    </div>
    </div>
    </div>
</body>
</html>