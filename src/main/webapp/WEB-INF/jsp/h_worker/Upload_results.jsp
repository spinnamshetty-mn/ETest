<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
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
String name=(String)request.getAttribute("name");
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
if(session.getAttribute("username")==null){
	response.sendRedirect("/signin"); 
	}
else if(!session.getAttribute("username").equals(id1)){
			response.sendRedirect("/signin");
		}
	%>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Dashboard</h4>
      <ul class="nav nav-pills nav-stacked">
        <li><a href="hdash"><i class="fa fa-home" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Home</span></a></li>
         <li ><a href="find_request"><i class="fa fa-calendar" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Find Request</span></a></li>
         <li class="active"><a href="#"><i class="fa fa-upload" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Upload Results</span></a></li>
         <li><a href="status&recommend"><i class="fa fa-tasks" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Status and Recommendations</span></a></li>
         <li><a href="hsettings"><i class="fa fa-cog" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Settings</span></a></li>
      </ul><br>
    </div>

    <div class="col-sm-9">
      <div class="top">
      <table id="head">
      <tr>
      <td><h1><small>HELLO <%= name %></small></h1></td>
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
    <div class="ex1">
    
 	 <table id="find_and_update_request">
    
    	<tr>
    	<th>Patient Id</th>
    	<th>Report Id</th>
    	<th>Patient First Name</th>
    	<th>Patient Last Name</th>
    	<th>Disease </th> 
    	<th> Test Type </th>
    	<th>Result Status</th>
    	<th>Date</th>
    	</tr>
		
		<c:forEach var="ur" items="${ur}" >
		
    <tr>
        <td>${ur.patientId}</td>
        <td>${ur.reportId}</td>
        <td>${ur.firstName}</td>
        <td>${ur.lastName}</td>
         <td>${ur.diseaseType}</td>
         <td>${ur.testType}</td>
         <td>${ur.result}</td>
          <td>${ur.contactDate}</td> 
        
    </tr>
		
    	</c:forEach>
   
    </table>
    
     <%
			int size=(Integer)request.getAttribute("size");
			if(size==0){
				%> <h2> No Records to Display. </h2> <%	
			}
		
		%>
    </div>

   
    
  </div>
</div>
</body>
</html>