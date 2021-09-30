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
  <script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"/>"></script>
  <script src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" />" ></script>
  <link href="<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css" />" rel="stylesheet" integrity="sha384-T8Gy5hrqNKT+hzMclPo118YTQO6cYprQmhrYwIiQ/3axmI1hQomh7Ud2hPOy8SP1" crossorigin="anonymous">
</head>
<body>
<%
String name=(String)request.getAttribute("name");
				response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
				if(session.getAttribute("username")==null){
					response.sendRedirect("/signin");
				}
	%>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h4>Dashboard</h4>
      <ul class="nav nav-pills nav-stacked">
        <li>
        <a href="p_home"><i class="fa fa-home" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Home</span></a></li>
         <li class="active"><a href="test_request"><i class="fa fa-calendar" aria-hidden="true"></i><span class="hidden-xs hidden-sm">Request Test</span></a></li>
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
      </table>
     </div>
      <hr>
      
      <div> 
      <h4>
      <label for="hw">Choose a health worker:</label>
      <select name="hw" id="hw">
      <option disabled selected value> -- select an option -- </option>
       <c:forEach items="${hw_list}" var="hw" >
        <option value="${hw.id}">HW name: ${hw.name} and HW id : ${hw.id}</option>
    </c:forEach>
      </select>
      
      <!-- 
       <label for="hw">Choose a health worker:</label>
      <select name="hw" id="hw">
			<option value="sel" selected>select</option>
			  <option value="3">3</option>
			  <option value="4">4</option>
			  <option value="1">1</option>
			  <option value="6">6</option>
			</select> -->	
	
      
      </h4>
      </div>
      <br>
      <br>
      <div>
      <h4>
      <label for="disease">Disease Type:     </label>
      <select id="disease">
  	<option value="" disabled selected>Select an option</option>
  	<option value="CORONA">CORONA</option>
  	<option value="EBOLA">EBOLA</option>
  	<option value="NIPAH">NIPAH</option>
	</select>
	</h4>
	</div>
	<br>
	<br>
	<div>
	<h4>
	<label for="test">Test To Conduct:  </label>
	<select id="test">
  	<option value="" disabled selected>Please select an option</option>
	</select>
	</h4>
	</div>
	<br>
	<br>
	<div>
	<h4>
	<button id="testrequest" style="float:right; margin-right:50%" >Submit Test Request</button>
	</h4>
	</div>
    </div>
  </div>
</div>
<script>
var lookup = {
		   "CORONA": ["RTPCR", "ANTIBODY"],
		   "EBOLA": ["PCR", "CBP"],
		   "NIPAH": ["PCR","CBP","ANTIBODY"],
		};

		// When an option is changed, search the above for matching test
		$('#disease').on('change', function() {
		   // Set selected option as variable
		   var selectValue = $(this).val();

		   // Empty the target field
		   $('#test').empty();
		   
		   // For each chocie in the selected option
		   for (i = 0; i < lookup[selectValue].length; i++) {
		      // Output choice in the target field
		      $('#test').append("<option value='" + lookup[selectValue][i] + "'>" + lookup[selectValue][i] + "</option>");
		   }
		});
</script>
</body> 

</html>