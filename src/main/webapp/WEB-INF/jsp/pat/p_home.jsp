<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
			String id=(String)request.getAttribute("id");
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		if(session.getAttribute("username")==null){
			response.sendRedirect("/signin"); 
			}
		else if(!session.getAttribute("username").equals(id)){
					response.sendRedirect("/signin");
				}
	%>


	 <%
 	 String name=(String)request.getAttribute("name");
	 String state=(String)request.getAttribute("state");
	 String city=(String)request.getAttribute("city");
	 int pincode=(Integer)request.getAttribute("pincode");
	  id=(String)request.getAttribute("id");
	 String result=(String)request.getAttribute("result");
	
	 if(result==null){
		 result="N/A";
	 }
	// String hwname=(String)request.getAttribute("hwname");
	// if(hwname==null){
	//	 hwname="N/A";
	// }
	 String date=(String)request.getAttribute("date");
	 if(date==null){
		 date="N/A";
	 }
	 String hwname=(String)request.getAttribute("hwname");
	 if(hwname==null){
		 hwname="N/A";
	 }
 			%>
<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Dashboard</h4>
      <ul class="nav nav-pills nav-stacked">
        <li class="active">
        <a href="p_home"><i class="fa fa-home" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Home</span></a></li>
         <li><a href="test_request"><i class="fa fa-calendar" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Request Test</span></a></li>
         <li><a href="results"><i class="fa fa-bar-chart" aria-hidden="true"></i><span class="hidden-xs hidden-sm">View Results</span></a></li>
         <li><a href="update"><i class="fa fa-user" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Update Contact List</span></a></li>
         <li><a href="recommendations"><i class="fa fa-tasks" aria-hidden="true"></i><span class="hidden-xs hidden-sm">View Recommendations</span></a></li>
         <li><a href="settings"><i class="fa fa-cog" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Settings</span></a></li>
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
      <div class="table">
      	<table id="body">
    <tr>
        <td><b>Patient Id:</b> ${id} </td>
        <td><b>Location:</b> ${state} , ${city} , ${pincode} </td>
    </tr>
</table>
      </div>
      
    </div>
     <div class="ex1">
    
     <table id="find_and_update_request">
    
    	<tr>
    	<th>Disease</th>
    	<th>Test Type</th>
    	<th>Status</th>
    	<th> Health Worker </th>
    	<th>Tested on</th>
    	
    	</tr>
    	
    	<c:forEach items="${lr}" var="lr" >
    	
    	<tr>    	
    	<td>${lr.diseaseType} </td>
    	<td>${lr.testType }</td>
    	<td>${lr.status}</td>
    	<td>${lr.hwId}</td>
    	<td>${lr.date}</td>
    	
    	</tr>
    	</c:forEach>
    
   
    </table>
         <%
     		
			String size=(String)request.getAttribute("size");
			if(size==null){
				%> <h2> No Records to Display. </h2> <%	
			}
		
		%>
    </div>
  </div>
</div>

</body>
</html>    