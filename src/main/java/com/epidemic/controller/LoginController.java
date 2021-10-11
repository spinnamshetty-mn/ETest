package com.epidemic.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.view.RedirectView;

import com.epidemic.*;
import com.epidemic.model.Government;
import com.epidemic.model.HealthWorker;
import com.epidemic.model.Patient;
import com.epidemic.services.GovernmentService;
import com.epidemic.services.HealthWorkerService;
import com.epidemic.services.PatientService;


@Controller
public class LoginController {
	
	@Autowired
	PatientService patient_service;
	
	@Autowired
	GovernmentService gov_service;
	
	@Autowired
	HealthWorkerService hw_service;

//------------------***************************  SIGN-UP Methods Implementaion ******************************----------------------------------
		@RequestMapping("/register")// register as ---
		public String type() {
			return "register";
		}
//----------------------------------------------------------------------------------------------------------------------------		
	@RequestMapping("/signup") //catch the type
	public String signup(@RequestParam("Type") String type) {
		if(type.equals("Patient")) {
			
			return "patient";   
		}
		if(type.equals("HealthWorker")) {
			return "healthworker";
		}
		if(type.equals("GovernmentEntity")) {
			return "government"; 
		}
		
		return "";
	}
//-----------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/signup/patient")  // Patient Sign Up Page 
	public String signupPatient(@ModelAttribute Patient patient,Model model,HttpServletRequest request) {

		boolean st=false;
		EncryptPassword p=new EncryptPassword();
		patient.setPassword(p.encryptPassword(patient.getPassword()));
		 st=patient_service.addPatient(patient); 
		 // validate and add in DB
		 	
		 model.addAttribute("patient",patient);

		if(st==true) {
			model.addAttribute("msg","Account created. Login Now");
			return "redirect:/signin";// redirect to signin page
		}
		
		return "already_exists";  // error Page**************Incomplete
	}
//------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/signup/healthworker") // HW Sign Up Page 
	public String signupPatient(@ModelAttribute HealthWorker hw,Model model) {
		boolean st=false;
		EncryptPassword p=new EncryptPassword();
		hw.setPassword(p.encryptPassword(hw.getPassword())); 
		
		st=hw_service.addWorker(hw);         // validate and add in DB with PENDING status (to be approved by GOV)
		 model.addAttribute("healthworker",hw);
		if(st==true) {
			return "redirect:/signin"; // redirect to signin/login 
		}
		return "already_exists"; // error Page**************Incomplete
	}
//-------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/signup/government")
	public String signupGovernment(@ModelAttribute Government gov,Model model) {
		boolean st=false;
		EncryptPassword p=new EncryptPassword();
		gov.setPassword(p.encryptPassword(gov.getPassword())); 
		st=gov_service.addGov(gov); // validate and add in DB with PENDING status (to be approved by ROOT USER)
		if(st==true) {
			return "login";
		}
		return "error"; // error Page**************Incomplete
		
	}
	
//-------********************************** Sign In Methods Implementation **********************************----------------------
	
	@RequestMapping("/signin") // sign in-----for redirecting to login 
	public String type_login(Model model,HttpServletRequest request) {
		
		String msg=(String)request.getSession().getAttribute("msg");
		if(msg!=null) {
			model.addAttribute("msg",msg);
			request.getSession().removeAttribute("msg");
			request.getSession().invalidate();
		}
		
		return "login";
	}
//-----------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/login") //catch the type
	public String login(@RequestParam("category") String type, @RequestParam("email") String email, @RequestParam("password") String password,Model model,HttpServletResponse response,HttpServletRequest request) throws IOException {
		String error="";
		EncryptPassword encrypt=new EncryptPassword();
	
	
		
		
		if(type.equals("Patient") &&  patient_service.validate(email,encrypt.encryptPassword(password))) {
			int id = patient_service.searchPatient(email).getId();
			HttpSession session=request.getSession();
			model.addAttribute("id",id+"");
			session.setAttribute("username",id+"");
			
			
			response.sendRedirect("/patient/" + id +"/p_home?r="+new Random().nextInt());
			return "pat/p_home";
		}	
		else	if(type.equals("Health Worker") && hw_service.validate(email,encrypt.encryptPassword(password))) {
			
			
			HealthWorker hw_db=hw_service.searchWorker(email);
				if(hw_db.getApproved_status().equals("pending")) {
					return "pending_hw"; //  Sorry your request is still pending...
				}
				HttpSession session=request.getSession();
				model.addAttribute("id",hw_db.getId()+"");
				session.setAttribute("username",hw_db.getId()+"");
				response.sendRedirect("/hw/" + hw_db.getId()+"/hdash?r="+new Random().nextInt());
				return "h_worker/hdash"; // //redirect to new jsp pages hw/hdash
			}
			
		else	if(type.equals("GovernmentEntity") && email.equals("rootuser@gmail.com" )&& gov_service.validate("rootuser@gmail.com",encrypt.encryptPassword(password))) {
					Government gov_db=gov_service.searchGov(email);
					int id=gov_db.getGovId();
					HttpSession session=request.getSession();
					model.addAttribute("id",id+"");
					session.setAttribute("username",id+"");
					response.sendRedirect("/rootgov/" + id+"/gdash?r="+new Random().nextInt());
					return "root_gov_entity/gdash"; 
			
				}
			
			if(type.equals("GovernmentEntity") && gov_service.validate(email,encrypt.encryptPassword(password))) {
				Government gov_db=gov_service.searchGov(email);
				if(gov_db.getStatus().equals("pending")) {
					return "pending_gov"; //  Sorry your request is still pending...
				}
				int id=gov_db.getGovId();
				HttpSession session=request.getSession();
				model.addAttribute("id",id+"");
				session.setAttribute("username",id+"");
				response.sendRedirect("/gov/" + id+"/gdash?r="+new Random().nextInt());
				return "g_entity/gdash"; 
			}
		else {
				try {
					String msg="Wrong Credentials";
					 request.getSession().setAttribute("msg", msg);
					response.sendRedirect("/signin?r="+new Random().nextInt());
					
					return "login";
				} catch (IOException e) {
					// TODO Auto-generated catch block
				
				}//error Page**************Incomplete
		}
		return "login";
	}
//----------------------------------------------------------------------------------------------------------------------------------

}
