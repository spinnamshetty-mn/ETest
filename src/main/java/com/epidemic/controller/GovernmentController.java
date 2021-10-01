package com.epidemic.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.epidemic.UpdatedResult;
import com.epidemic.UserPDFExporter;
import com.epidemic.joinclass;
import com.epidemic.model.ContactList;
import com.epidemic.model.Government;
import com.epidemic.model.HealthWorker;
import com.epidemic.model.LatestResult;
import com.epidemic.model.Patient;
import com.epidemic.model.Stats;
import com.epidemic.model.TestRequest;
import com.epidemic.model.TestResult;
import com.epidemic.repositories.PatientRepo;
import com.epidemic.services.ContactListService;
import com.epidemic.services.GovernmentService;
import com.epidemic.services.HealthWorkerService;
import com.epidemic.services.LatestResultService;
import com.epidemic.services.TestRequestService;
import com.epidemic.services.TestResultService;
import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
 
import com.lowagie.text.DocumentException;
//government controller
@Controller
@RequestMapping("/gov")
public class GovernmentController {
	
	@Autowired
	TestRequestService test_request_service;
	
	@Autowired
	HealthWorkerService hw_service;
	
	@Autowired
	PatientRepo patient_repo;
	
	@Autowired
	GovernmentService gov_service;
	
	@Autowired
	LatestResultService latest_result_service;
	
	@Autowired
	TestResultService test_result_service;
	
	@Autowired
	ContactListService contact_service;
	
 	// To Display State Name on top of every Page
	
//-------------------------------------------------------------------------------------------------------------------------------	
	@RequestMapping ("/{id}/gdash")    // Home Page---->  display gov info
	public String home(@PathVariable("id")  int id,Model model) {
		
		Government gov=gov_service.searchGov(id);
		
		String state=gov.getState();	// initialize state name to be displayed on top of every page
		model.addAttribute("State",gov.getState());
		
		int activeCases=latest_result_service.getCountAllActiveCases();  // count all active cases from latest result table
		int totalHW=hw_service.findActiveHW().size();	// count all "approved" HW from HW table
		int totalTest=test_result_service.totalAllTests(); //count total test in Result Table
		int positivityRate=0;   
		if(totalTest!=0) {   // to avoid arithmetic Exception ( / 0 )
		positivityRate=test_result_service.countAllPositive()*100/totalTest;
		}
		
		model.addAttribute("state",state);     //added variables to model and sent to JSP for display purposes 
		model.addAttribute("State",state);
		model.addAttribute("id",gov.getGovId()+"");
		model.addAttribute("active",activeCases+"");
		model.addAttribute("totalHW",totalHW+"");
		model.addAttribute("totalTest",totalTest+"");
		model.addAttribute("rate",positivityRate+"");
		
		return "g_entity/gdash";
	}
//---------------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping("/{id}/hw_info")     // HW Request TAB ----->  page to handle accept / reject HW account creation by GOV.
	public String approveHw(@PathVariable("id") int id,Model model,HttpServletRequest request) {
		model.addAttribute("id",id+"");
		Government gov=gov_service.searchGov(id);
		model.addAttribute("State",gov.getState());  // display state name at top of page
		
		List<HealthWorker> request_list=hw_service.displayPendingHW();  // get list of pending HW request from HW table
		model.addAttribute("request_list",request_list);
		model.addAttribute("govId", id);
		
		String hw_id=(String)request.getParameter("getbutton");        // mapped each row of the JSP hwID to button i.e buttonId=hwID so that controller knows which HW to update
		String update=(String)request.getParameter("hw_request_update");  // get dropdown(accept/reject) reponse
		
		if(hw_id==null || update==null) {    // for handling when page opened for first time.
			return "g_entity/hw_info";
		}
		
		if(update.equals("reject")) {						// update response in HW DB 
		hw_service.deleteRequest(Integer.parseInt(hw_id));
		}
		else {
			hw_service.updateRequest(Integer.parseInt(hw_id));
		}
		return "redirect:/gov/{id}/hw_info";
	}
//-----------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping("/{id}/gsettings")  // for GOVT Settings TAB
	public String settings(@PathVariable("id") int id,Model model,HttpServletRequest request ) {
		model.addAttribute("id",id+"");
		Government gov=gov_service.searchGov(id);
		model.addAttribute("State",gov.getState());        // to display these info in JSP
		model.addAttribute("email",gov.getEmail());
		model.addAttribute("state",gov.getState());
		
		String newpassword=(String)request.getParameter("newpassword");		// for getting these fields from JSP
		String oldpassword=(String)request.getParameter("oldpassword");
		
		
		if( newpassword!=null ) {		// validate and set new password
			if(oldpassword!="" && oldpassword.equals(gov.getPassword())) {
				if(newpassword!="") {
					gov.setPassword(newpassword);
				}
			}
		
		gov_service.Update(gov);  //update new pasword in GOV DB
		}
		
		return "g_entity/gsettings";
	}
//-----------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping("/{id}/zonal_info") // Zones Tab----------> to Catch Type (choose state,city,pincode) in Zones Tab 
	public String zonal_info(@PathVariable("id") int id,HttpServletRequest request,Model model){
		model.addAttribute("id",id+"");
		Government gov=gov_service.searchGov(id);
		model.addAttribute("State",gov.getState());   // display state name at top of page
		
		String type=(String)request.getParameter("zones");    // catch the zone type and redirect correspondingly
			if(type==null) {  // for handling opening of tab for first time
			return "g_entity/zonal_info";
		}
			
		return "redirect:/gov/"+id+"/"+type+"/zonal_info_category";  // redirect to next url with type information
	}

//---------------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping("/{id}/{type}/zonal_info_category") // after zone tab --- 2nd page ---- display dynamic dropdown according to type 
	public String zonal_info_category(@PathVariable("id") int id,@PathVariable("type") String type, HttpServletRequest request,Model model) {
		
		List<String> list=new ArrayList<>();  // for dynamic drop down ---get list from Result Table and send to JSP
		model.addAttribute("type",type);
		model.addAttribute("id",id+"");
		Government gov=gov_service.searchGov(id);
		model.addAttribute("State",gov.getState()); 
		
		if(type.equals("state")) {						// get list for dynamic drop down according to type
			 list=test_result_service.getAllState();
		}
		if(type.equals("city")) {
			list=test_result_service.getAllCity();
		}
		if(type.equals("pincode")) {
			list=test_result_service.getAllPincode();
		}
		
		model.addAttribute("list",list);
		
		return "g_entity/zonal_info_category";
	}
	
//----------------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping("/{id}/{type}/{name}/zonal_info_result") //Zone Tab 3rd Page (Last)--> get details to be displayed on the result page--> here name=specific state,city,pincode
	public String result(@PathVariable("id") int id,@PathVariable("type") String type,@PathVariable("name") String name,Model model) {
		model.addAttribute("id",id+"");
		Government gov=gov_service.searchGov(id);
		model.addAttribute("State",gov.getState()); // for displaying state name at top
		
		int totalActiveCases=0;
		int totalTests=0;
		int totalCases=0;
		float positivityRate=0;
			
			if(type.equals("state")) {        // name =specific state/city/pincode chosen from dropdown
				
					totalActiveCases=latest_result_service.countActiveByState(name);  // from latest result table
					totalTests=test_result_service.totalTestState(name);      		 // from result table
					totalCases=test_result_service.totalCasesState(name);            // from result table
			}
			if(type.equals("city")) {
				
				 totalActiveCases=latest_result_service.countActiveByCity(name);
				 totalTests=test_result_service.totalTestCity(name);
				totalCases=test_result_service.totalCasesCity(name);
	
			}
				
			if(type.equals("pincode")) {
					
				totalActiveCases=latest_result_service.CountActiveByPincode(Integer.parseInt(name));
				 totalTests=test_result_service.totalTestPincode(Integer.parseInt(name));
				totalCases=test_result_service.totalCasesPincode(Integer.parseInt(name));
			}

			positivityRate= (totalCases*100/totalTests);
			Stats st=new Stats(totalActiveCases,totalTests,totalCases,positivityRate); // stats class to store info at one place and send to JSP
			
		if(positivityRate>30) {
				st.setZone("Red");
			}
				
		else if(positivityRate<10) {
					st.setZone("Green");
			}
		else {
					st.setZone("Orange");
		    	}
				model.addAttribute("stats",st);
		
		return "g_entity/zonal_info_result";
	}
//---------------------------------------------------------------------------------------------------------------------------------
	
	@RequestMapping("/{id}/{type}/{tab}")   // ignore---- just for redirecting from tab to tab
	public String redirect(@PathVariable("id") int id,@PathVariable("type") String type,@PathVariable("tab") String tab) {
		return "redirect:/gov/"+id + "/"+ tab;
	}
	
	@RequestMapping("/{id}/{type}/{name}/{tab}")  // ignore ----just for redirecting from tab to tab
	public String redirect3(@PathVariable("id") int id,@PathVariable("type") String type,@PathVariable("name") String name,@PathVariable("tab") String tab) {
		return "redirect:/gov/"+ id +"/"+ tab;
	}
//-----------------------------------------------------------------------------------------------------------------------------------

	@RequestMapping("/{id}/view_contacts_list")  // view details of contacted person
		public String viewContact(@PathVariable("id") int id,Model model,HttpServletResponse response) throws DocumentException, IOException{
		
		model.addAttribute("id",id+"");
		List<ContactList> cl=contact_service.displayAll();
			   // from contactlist table
		model.addAttribute("state",gov_service.searchGov(id).getState());
		model.addAttribute("contact_list",cl);
		return "g_entity/view_contacts_list";
		}
	
	
	@RequestMapping("/users/export/pdf")
	 public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		
		 response.setContentType("application/pdf");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
	         
	        List<ContactList> cl=contact_service.displayAll();
	         
	        UserPDFExporter exporter = new UserPDFExporter(cl);
	        exporter.export(response);
	}
//---------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/{id}/test_results")  // Result TAB -----view all results of all patients and all hw
	public String testResults(@PathVariable("id") int id,Model model) {
		model.addAttribute("id",id+"");
		List<TestResult> result_list=test_result_service.displayAllResults(); // from result table
		Government gov=gov_service.searchGov(id);
		model.addAttribute("State",gov.getState()); 
		model.addAttribute("result_list",result_list);
		return "g_entity/test_results";
	}
//---------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/{id}/active_cases") // Active Cases TAB------
	public String activeCases(@PathVariable("id") int id,Model model) {
		model.addAttribute("id",id+"");
		Government gov=gov_service.searchGov(id);
		model.addAttribute("State",gov.getState());  // for displaying state name
		List<LatestResult> result_list=latest_result_service.displayActiveCases(gov.getState()); // from latest result table
		model.addAttribute("result_list",result_list);
		return "g_entity/active_cases";
	}
//---------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/{id}/test_requests")  //  Test Request tab-----display all current test requests by all patients
	public String displayAllRequest(@PathVariable("id") int id,Model model) {
		model.addAttribute("id",id+"");
		Government gov=gov_service.searchGov(id);
		model.addAttribute("State",gov.getState()); 
		List<joinclass> request_list=test_request_service.diplayAllRequest(gov.getState()); // from test request table
		
		model.addAttribute("request_list",request_list);
		return "g_entity/test_requests";
	}
//---------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/{id}/logout")
	public String logout(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response)throws IOException {
		HttpSession session= request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		return "redirect:/signin";
	}
}
