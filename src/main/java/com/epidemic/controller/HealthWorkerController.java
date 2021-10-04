
package com.epidemic.controller;

import java.io.IOException;
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
import com.epidemic.joinclass;
import com.epidemic.model.HealthWorker;
import com.epidemic.model.Patient;
import com.epidemic.model.TestRequest;
import com.epidemic.model.TestResult;
import com.epidemic.repositories.PatientRepo;
import com.epidemic.services.HealthWorkerService;
import com.epidemic.services.LatestResultService;
import com.epidemic.services.PatientService;
import com.epidemic.services.TestRequestService;
import com.epidemic.services.TestResultService;


@Controller
@RequestMapping("/hw")
public class HealthWorkerController {
	
	@Autowired
	TestRequestService test_request_service;
	
	@Autowired
	HealthWorkerService hw_service;
	
	@Autowired
	PatientRepo patient_repo;
	
	@Autowired
	TestResultService test_result_service;
	
	@Autowired
	LatestResultService latest_result_service;
	
	@Autowired
	PatientService patient_service;

//--------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping ("/{id}/hdash")    // HW HOME-----------display hw info
	public String home(@PathVariable("id")  int id,Model model) {
		
		HealthWorker hw=hw_service.searchWorker(id);    // get all details to display in home page
		model.addAttribute("name", hw.getName());		
		model.addAttribute("id",hw.getId()+"");
		model.addAttribute("city",hw.getCity());
		model.addAttribute("state",hw.getState());
		model.addAttribute("pincode",hw.getPincode());
		model.addAttribute("type",hw.getType());
		
		int active=latest_result_service.getCountByHwId(id); //total active cases-->  count positive in latestresult by hwId
		int totalTests=test_result_service.totalTestsByHw(id); //total tests--> result table  by hwId
		int totalPending=test_request_service.countPendingByHw(id); //total pending --> test request table  by hwId
		
		model.addAttribute("active",active+"");
		model.addAttribute("pending",totalPending+"");
		model.addAttribute("totalTests",totalTests+"");
	
		
		return "h_worker/hdash";
	}
//----------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/{id}/find_request")            // find request TAB--------get all requests by patient
	public String findRequest(@PathVariable("id") int id,Model model,HttpServletRequest request) {
		HealthWorker hw=hw_service.searchWorker(id);    
		model.addAttribute("name", hw.getName());
		model.addAttribute("id",id+"");
		String result=(String)request.getParameter("test_result_update");  // dropdown id of positive/negative
		List<joinclass> request_list=test_request_service.getInformation(id); //from test request JOIN_CLASS TYPE (patient+request)
		model.addAttribute("request_list",request_list); 
		String button=(String)request.getParameter("getbutton"); // buttonId = reportId 
		
		if(result==null || button==null) {   // when page opened first time
			return "h_worker/find_request";
		}
		
		//add method performs following operations--->
		//insert into result table with all data
		// delete from test request
		// insert/update in latest_result table 
		
		test_result_service.add(Long.parseLong(button), result); // method in result table---->little complicated
		return "redirect:/hw/{id}/find_request"; 
	}
//--------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/{id}/Upload_results")  // uploaded_result TAB -----------display uploaded result by that HW
	public String uploadResult(@PathVariable("id") int id,Model model) {
		HealthWorker hw=hw_service.searchWorker(id);    
		model.addAttribute("name", hw.getName());
		model.addAttribute("id",id+"");

		List<UpdatedResult> result_list=test_result_service.findAllResultsByHW(id); // get all uploaded result from result table sorted by newest resultId on top
		model.addAttribute("ur",result_list);

		
		return "h_worker/Upload_results";
	}
//----------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping ("/{id}/hsettings")  //Settings TAB
	public String settings(@PathVariable("id") int id,Model model,HttpServletRequest request) {
		model.addAttribute("id",id+"");
		HealthWorker hw=hw_service.searchWorker(id);   // for displaying info in JSP page
		model.addAttribute("name",hw.getName());
		model.addAttribute("mobile",hw.getMobile()+"");
		model.addAttribute("email",hw.getEmail());
		model.addAttribute("type",hw.getType());
		
		String name=(String)request.getParameter("name");  // for getting data entered in JSP
		String mobile=(String)request.getParameter("mobile");
		String newpassword=(String)request.getParameter("newpassword");
		String oldpassword=(String)request.getParameter("oldpassword");
		
		if(name!=null ||  mobile!=null && (!mobile.equals(hw.getMobile()))  || newpassword!=null ) { // to be submitted only if something is not null
			
			if(name!="") {
				hw.setName(name);
			
			}
			if(mobile!="" ) {
				hw.setMobile(Long.parseLong(mobile));
			}
		
			if(oldpassword!="" && oldpassword.equals(hw.getPassword())) {
				if(newpassword!="") {
					hw.setPassword(newpassword);
				}
			}
		hw_service.update(hw);  // update in DB
		}
		
		return "h_worker/hsettings";
	}
//---------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping ("/{id}/status&recommend")
	public String recommendations(@PathVariable("id") int id,Model model) {
		HealthWorker hw=hw_service.searchWorker(id);   
		model.addAttribute("name", hw.getName());
		model.addAttribute("id",id+"");
		return "h_worker/status&recommend";
	}
//-------------------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/{id}/logout")
	public String logout(@PathVariable("id") int id,HttpServletRequest request,HttpServletResponse response)throws IOException {
		HttpSession session= request.getSession();
		session.removeAttribute("username");
		session.invalidate();
		return "redirect:/signin";
	}

}

