package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
 
@RestController
public class controller {
   
	@RequestMapping("/login")
  public ModelAndView login(HttpServletRequest request,
			   HttpServletResponse response) {
		  String userName=request.getParameter("userName");  
	      String password=request.getParameter("password");
	      String message;
	      if(userName != null && 
	    		  !userName.equals("") 
	    		  && userName.equals("jai") && 
	    		  password != null && 
	    		  !password.equals("") && 
	    		  password.equals("123")){
	    	  message = "Welcome " +userName + ".";
		      return new ModelAndView("welcome", 
		    		  "message", message);  
	 
	      }else{
	    	  message = "Wrong username or password.";
	    	  return new ModelAndView("errorPage", 
	    			  "message", message);
      }
   }
	
   //@RequestMapping("/login.html")  
   //Patient- jai,jai123
   //HW- aman,aman123
   //Gov-ram,ram123
   
   public String log(HttpServletRequest request,
		   HttpServletResponse response) {
	  String userName=request.getParameter("userName");  
      String password=request.getParameter("password");
      String category=request.getParameter("category");
      String message; 
      if(userName != null && 
    		  !userName.equals("") 
    		  && userName.equals("jai") && 
    		  password != null 
    		  && (category.equals("Patient")) && 
    		  !password.equals("") && 
    		  password.equals("jai123")){
    	  message = "Welcome " +userName + ".";
	      return message;

      }
      	if(userName != null && 
        		  !userName.equals("") 
        		  && userName.equals("aman") && 
        		  password != null &&(category.equals("Health Worker"))&& 
        		  !password.equals("") && 
        		  password.equals("aman123")){
        	  message = "Welcome " +userName + ".";
    	      return message;
     
          }
          
          if(userName != null && 
        		  !userName.equals("") 
        		  && userName.equals("ram") && 
        		  password != null && (category.equals("Government")) &&
        		  !password.equals("") && 
        		  password.equals("ram123")){
        	  message = "Welcome " +userName + ".";
    	      return message;
          }     
      else {
    	  return "Wrong Credentials";
      }
      
}
   
}