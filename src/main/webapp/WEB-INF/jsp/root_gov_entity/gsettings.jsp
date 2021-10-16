<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<%			

String id1=(String)request.getAttribute("id");

response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("username")==null){
response.sendRedirect("/signin"); 
}
else if(!session.getAttribute("username").equals(id1)){
		response.sendRedirect("/signin");
	}
	%>

<% String State=(String)request.getAttribute("State"); %>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Dashboard</h4>
      <ul class="nav nav-pills nav-stacked">
        <li >
        <a href="gdash"><i class="fa fa-home" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Home</span></a></li>
         <li><a href="test_requests"><i class="fa fa-calendar" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Test Requests</span></a></li>
         <li><a href="active_cases"><i class="fa fa-bar-chart" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Active Cases</span></a></li> 
        <li><a href="pending_approvals"><i class="fa fa-user" aria-hidden="true"></i><span class="hidden-xs hidden-sm">  Pending Approvals</span></a></li>
         <li><a href="test_results"><i class="fa fa-tasks" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Test Results</span></a></li>
         <li><a href="zonal_info"><i class="fa fa-circle-thin" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Zones</span></a></li>
         <li><a href="view_contacts_list"><i class="fa fa-eye" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> View Contacts List</span></a></li>
         <li><a href="manage_disease"><i class="fa fa-plus" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Manage Disease</span></a></li>
         <li class="active"><a href="gsettings"><i class="fa fa-cog" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Settings</span></a></li>
       </ul><br>
    </div>

    <div class="col-sm-9">
      <div class="top">
      <table id="head">
      <tr>
       <%
              	String email=(String)request.getAttribute("email");
              	String state=(String)request.getAttribute("state");
              	
              	
              %>
      <td><h1><small> <%= State %> </small></h1></td>
      <td>
       <form action="logout" method="post">
      <button value="logout" id="logout" style="float:right;" >Logout</button>
      </form>
      </td>
      </tr>
      </table>
     </div>
      <hr>
    </div>
       <div class="container mt-5">
    <div class="row">
       
        <!-- Profile Settings-->
        <div class="col-lg-8 pb-5">
            <form class="row">
               
             
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="account-email">E-mail Address</label>
                        <input class="form-control" type="email" id="account-email" name="email" value=<%= email %> disabled="">
                    </div>
                </div>
              	
               
                 <div class="col-md-6">
                    <div class="form-group">
                        <label for="account-confirm-pass">Old Password</label>
                        <input class="form-control" type="password" name="oldpassword" id="account-confirm-pass">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="account-confirm-pass">New Password</label>
                        <input class="form-control" type="password" name="newpassword" id="account-confirm-pass" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" title="Please include at least 1 uppercase character, 1 lowercase character, and 1 number and one special character">
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="form-group">
                        <label for="account-pass">Confirm Password</label>
                        <input class="form-control" type="password" name=confirmpassword" id="account-pass" pattern="^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).*$" title="Please include at least 1 uppercase character, 1 lowercase character, and 1 number and one special character">
                    </div>
                </div>
               
                <div class="col-12">
                    <hr class="mt-2 mb-3">
                    <div class="d-flex flex-wrap justify-content-between align-items-center">
                        
                        <button style="margin-top:12%; margin-left:45%; " class="btn btn-style-1 btn-primary" type="submit" data-toast="" data-toast-position="topRight" data-toast-type="success" data-toast-icon="fe-icon-check-circle" data-toast-title="Success!" data-toast-message="Your profile updated successfuly.">Update Profile</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
  </div>
</div>
</body>
</html>