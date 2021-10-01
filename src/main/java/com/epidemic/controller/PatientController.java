package com.epidemic.controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.epidemic.model.ContactList;
import com.epidemic.model.Disease;
import com.epidemic.model.HealthWorker;
import com.epidemic.model.LatestResult;
import com.epidemic.model.Patient;
import com.epidemic.model.TestRequest;
import com.epidemic.model.TestResult;
import com.epidemic.services.ContactListService;
import com.epidemic.services.DiseaseService;
import com.epidemic.services.HealthWorkerService;
import com.epidemic.services.LatestResultService;
import com.epidemic.services.PatientService;
import com.epidemic.services.TestRequestService;
import com.epidemic.services.TestResultService;


@Controller
@RequestMapping("/patient")

public class PatientController {
	
	@Autowired
	PatientService patient_service;
	
	@Autowired
	TestRequestService test_request_service;
	
	@Autowired
	HealthWorkerService hw_service;
	
	@Autowired
	TestResultService test_result_service;
	
	@Autowired 
	ContactListService contact_service;
	
	@Autowired
	LatestResultService latest_result_service;
	
	@Autowired
	DiseaseService diseaseService;
//-----------------------------------------------------------------------------------------------------------------------------
	@RequestMapping ("/{id}/p_home")    // display patient info
	public String home(@PathVariable("id")  int id,Model model) {
		Patient p=patient_service.searchPatient(id);
		model.addAttribute("name", p.getFirstName());
		model.addAttribute("id",p.getId()+"");
		model.addAttribute("state",p.getState());
		model.addAttribute("city",p.getCity());
		model.addAttribute("pincode",p.getPincode());
		LatestResult lr=latest_result_service.getLatestResultPatient(id);
		if(lr==null) {
			return "pat/p_home";
		}
		
		Date date1=lr.getDate();
		String date = new SimpleDateFormat("dd-MM-YYYY").format(date1);
		model.addAttribute("date",date);
		int hwId=lr.getHwId();
		String hwname=hw_service.searchWorker(hwId).getName();
		if(hwname==null) {
			hwname="N/A";
		}
		String result=lr.getStatus();
		model.addAttribute("result",result);
		model.addAttribute("hwname",hwname);
	

		return "pat/p_home";
	}
//---------------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping ("/{id}/test_request")  // if not already booked -> choose hw from dd and request test
												// else show already booked
												// update in home page as well
												
	
	public String test_request(@PathVariable("id") int id, Model model ,HttpServletRequest request) {
		
		Patient p=patient_service.searchPatient(id);
		model.addAttribute("name",p.getFirstName());
		model.addAttribute("id",p.getId()+"");
		String disease=(String)request.getParameter("disease");
		String test=(String)request.getParameter("test");
		if(disease!=null && test!=null && test_request_service.findTest(id,disease,test) !=null) {
			
			model.addAttribute("msg1","Oops, Looks Like You Have Already Requested. Try Again Later");
			}
		
		else {
		String hw_id=(String)request.getParameter("hw");
		
		if(hw_id==null) {
			hw_id="sel";
			List<HealthWorker> hw_list=hw_service.findActiveHW();
			model.addAttribute("hw_list",hw_list);
		}
		if(hw_id=="sel") {
			model.addAttribute("msg1","");
		
			return "pat/test_request";
		}  
		// first time hw_id=sel so no msg will be displayed.  ->next time select will have id as 1,2,3 etc so below code will run.
		model.addAttribute("msg1","Request Sent");
		TestRequest tr=new TestRequest(id,Integer.parseInt(hw_id),disease,test);
		test_request_service.add(tr);
		
		return "pat/test_request";
		}
		
		return "pat/test_request";
	}
//---------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping ("/{id}/results") // get list of all result uploaded by hw
	public String test_result(@PathVariable("id") int id, Model model) {
		Patient p=patient_service.searchPatient(id);
		model.addAttribute("id",p.getId()+"");
		model.addAttribute("name",p.getFirstName());
		List<TestResult> result_list=test_result_service.findAllPatientResult(id);
		model.addAttribute("result_list",result_list);
		return "pat/results";
	}
//-------------------------------------------------------------------------------------------------------------------------------	
	@RequestMapping("/{id}/settings") // settings TAB
	public String settings(@PathVariable("id") int id,Model model,HttpServletRequest request) {
		Patient p=patient_service.searchPatient(id);
		model.addAttribute("name",p.getFirstName());
		model.addAttribute("firstname",p.getFirstName());
		model.addAttribute("lastname",p.getFirstName());
		model.addAttribute("id",p.getId()+"");
		model.addAttribute("mobile",p.getMobile()+"");
		model.addAttribute("email",p.getEmail());
		
		String firstname=(String)request.getParameter("firstname");
		String lastname=(String)request.getParameter("lastname");
		String mobile=(String)request.getParameter("mobile");
		String newpassword=(String)request.getParameter("newpassword");
		String oldpassword=(String)request.getParameter("oldpassword");
		
		if(firstname!=null || lastname!=null || mobile!=null && (!mobile.equals(p.getMobile()))  || newpassword!=null ) {
			
			
			if(firstname!="") {
				p.setFirstname(firstname);
			
			}
			if(lastname!="") {   
				p.setLastname(lastname);
			}
			if(mobile!="" ) {
				p.setMobile(Long.parseLong(mobile));
			}
		
			if(oldpassword!="" && oldpassword.equals(p.getPassword())) {
				if(newpassword!="") {
					p.setPassword(newpassword);
				}
			}
		
		patient_service.addByPatient(p);
		}
		return "pat/settings";
		}
//---------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping ("/{id}/update") // patient uploads contacted person details
	public String update(@PathVariable("id") int id,HttpServletRequest request,Model model) {
		Patient p=patient_service.searchPatient(id);
		model.addAttribute("name",p.getFirstName());
		String  name=(String)request.getParameter("name");       //*** add firstname and lastname
		String  city=(String)request.getParameter("city");
		String  state=(String)request.getParameter("state");
		String  mobile=(String)request.getParameter("mobile");
		String  pincode=(String)request.getParameter("pincode");
		String date=(String)request.getParameter("date");
		model.addAttribute("id",p.getId()+"");
		Date date1 = null;
		
		java.sql.Date datesq=null;
		
		if(name==null || city==null || state==null || mobile==null || pincode==null || date==null ) { // opening of page for first time
			return "pat/update";
		}
		try {
			date1=new SimpleDateFormat("dd-MM-yyyy").parse(date); 
			 datesq = java.sql.Date.valueOf( date );
	
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error is in date in format");
			e.printStackTrace();
		}  
		
		ContactList cl=new ContactList(id,name,city,state,Long.parseLong(pincode),Long.parseLong(mobile),datesq);
		contact_service.add(cl); // add to contactlist DB
		model.addAttribute("msg","Contact List has been updated");
		return "redirect:/patient/{id}/update";
		
	}
//----------------------------------------------------------------------------------------------------------------------------------	
	@RequestMapping ("/{id}/recommendations") //recommendations TAB
	public String recommendations(@PathVariable("id") int id,Model model) {
		Patient p=patient_service.searchPatient(id);
		model.addAttribute("id",p.getId()+"");
		model.addAttribute("name",p.getFirstName());
		return "pat/recommendations";
	}
//----------------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping("/{id}/logout")
	public String logout(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response)throws IOException {
		
		HttpSession session= request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		return "redirect:/signin";
	}

}
