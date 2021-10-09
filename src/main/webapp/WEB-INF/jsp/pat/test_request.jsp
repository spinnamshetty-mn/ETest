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
  <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"/>"></script>
  <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" />" ></script>
  <link href="<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
</head>
<body>
<%			
String name=(String)request.getAttribute("name");
			String id=(String)request.getAttribute("id");
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		if(session.getAttribute("username")==null){
			response.sendRedirect("/signin"); 
			}
		else if(!session.getAttribute("username").equals(id)){
					response.sendRedirect("/signin");
				}
	%>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Dashboard</h4>
      <ul class="nav nav-pills nav-stacked">
        <li>
        <a href="p_home"><i class="fa fa-home" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Home</span></a></li>
         <li class="active"><a href="test_request"><i class="fa fa-calendar" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Request Test</span></a></li>
         <li><a href="results"><i class="fa fa-bar-chart" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> View Results</span></a></li>
         <li><a href="update"><i class="fa fa-user" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Update Contact List</span></a></li>
         <li><a href="recommendations"><i class="fa fa-tasks" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> View Recommendations</span></a></li>
         <li><a href="settings"><i class="fa fa-cog" aria-hidden="true"></i><span class="hidden-xs hidden-sm"> Settings</span></a></li>
      </ul><br>
    </div>
	
    <div class="col-sm-9">
      <div class="top">
      <table id="head">
      <tr>
      <td><h1><small>  HELLO <%= name %>  </small>   </h1></td>
      <td>
      <form action="logout" method="post">
      <button value="logout" id="logout" style="float:right;" >Logout</button>
      </form>
      <form action="test_request" method="post">
		<%
		String msg=(String)request.getAttribute("msg1");
		if(msg==null){
			msg="";
		
		}
		%>
      </td>
      </tr>
      <tr><td><h1><%= msg %></h1></td></tr>
      <% 
      if(msg.length()!=0){
      response.setHeader("Refresh", "2;url=test_request");} %>
      </table>
     </div>
      <hr>
      
      <div> 
      <h4>
        <form action="/patient/${id}/${disease}/test_select" method="post">
      <label for="hw">Choose a health worker:</label>
      <select name="hw" id="hw">
      <option disabled selected value> -- select an option -- </option>
       <c:forEach items="${hw_list}" var="hw" >
        <option value="${hw.id}">HW name: ${hw.name} and HW id : ${hw.id}</option>
    </c:forEach>
      </select>	
	
      
      </h4>
      </div>
      <br>
      <br>
      <div>
      <h4>
      <label for="disease">Choose Disease:</label>
      <select name="disease" id="disease">
      <option disabled selected value> -- select an option -- </option>
       <c:forEach items="${disease_list}" var="disease_list" >
        <option value="${disease_list}">${disease_list}</option>
    </c:forEach>
      </select>
	</h4>
	</div>
	<br>
	<br>
	
	<div>
	<h4>
	<button id="testrequest" style="float:right; margin-right:50%" >Select Test</button>
	</h4>
	</div></form>
    </div>
  </div>
</div>
</body> 

</html>