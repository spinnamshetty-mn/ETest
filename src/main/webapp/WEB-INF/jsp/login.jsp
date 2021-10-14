<%@ page language="java" contentType = "text/html; charset = UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
   <meta-charset="ISO-8859-1">
   <link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
    <script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/animejs/2.2.0/anime.min.js" />" ></script>
    
      <title>Login Page</title>
   </head>
   
   <body>
   
   	<form action="login" method="post"> 
   	 
   		<div class="page">
  <div class="container">
    <div class="left">
    
      <div class ="select">
      <% 
      	String msg = (String)request.getAttribute("msg");
      	if (msg != null) {
      		
      	    %><p style="color:red"><%= msg %></p><%
      	    		msg=null;
      	}
      	%>
		 <label id="log" for="category">Login As :</label>
    <select name="category" id="category">
    <option value="Patient">Patient</option>
    <option value="Health Worker">Health Worker</option>
    <option value="Government">Government</option>
    
   
  </select><br/><br/>
		 
      </div>
      
     
    </div>
    <div class="right">
      <svg viewBox="0 0 320 300">
        <defs>
          <linearGradient
                          inkscape:collect="always"
                          id="linearGradient"
                          x1="13"
                          y1="193.49992"
                          x2="307"
                          y2="193.49992"
                          gradientUnits="userSpaceOnUse">
            <stop
                  style="stop-color:#ff00ff;"
                  offset="0"
                  id="stop876" />
            <stop
                  style="stop-color:#ff0000;"
                  offset="1"
                  id="stop878" />
          </linearGradient>
        </defs>
        <path d="m 40,120.00016 239.99984,-3.2e-4 c 0,0 24.99263,0.79932 25.00016,35.00016 0.008,34.20084 -25.00016,35 -25.00016,35 h -239.99984 c 0,-0.0205 -25,4.01348 -25,38.5 0,34.48652 25,38.5 25,38.5 h 215 c 0,0 20,-0.99604 20,-25 0,-24.00396 -20,-25 -20,-25 h -190 c 0,0 -20,1.71033 -20,25 0,24.00396 20,25 20,25 h 168.57143" />
      </svg>
      
      <div class="form">
     
        <label for="email">Email</label>
        <input name="email" type="email" id="email" required>
        <label for="password">Password</label>
        <input name="password" type="password" id="password" required>
        
        <input type="submit" id="submit" value="Submit">
        <br>
        <br>
        <a class="signup" style="color:lightyellow;text-align:center;margin:40%" href="register">Signup</a></form>
        
        
      </div>
    </div>
  </div>
</div>



 
   </body>
   <script>
   var current = null;
   document.querySelector('#email').addEventListener('focus', function(e) {
     if (current) current.pause();
     current = anime({
       targets: 'path',
       strokeDashoffset: {
         value: 0,
         duration: 700,
         easing: 'easeOutQuart'
       },
       strokeDasharray: {
         value: '240 1386',
         duration: 700,
         easing: 'easeOutQuart'
       }
     });
   });
   document.querySelector('#password').addEventListener('focus', function(e) {
     if (current) current.pause();
     current = anime({
       targets: 'path',
       strokeDashoffset: {
         value: -336,
         duration: 700,
         easing: 'easeOutQuart'
       },
       strokeDasharray: {
         value: '240 1386',
         duration: 700,
         easing: 'easeOutQuart'
       }
     });
   });
   document.querySelector('#submit').addEventListener('focus', function(e) {
     if (current) current.pause();
     current = anime({
       targets: 'path',
       strokeDashoffset: {
         value: -730,
         duration: 700,
         easing: 'easeOutQuart'
       },
       strokeDasharray: {
         value: '530 1386',
         duration: 700,
         easing: 'easeOutQuart'
       }
     });
   });
   </script>
</html>