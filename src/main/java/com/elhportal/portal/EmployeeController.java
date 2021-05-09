package com.elhportal.portal;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.elhportal.portal.entity.Employee;
import com.elhportal.portal.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService empServobj;
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Model model){
		Employee emp=new Employee();
		model.addAttribute(emp);
		System.out.println("Redirecting to empoyee form");
		return "employeeform";
	}
	
	@RequestMapping(value="/saveEmployee",method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee){
		System.out.println("Before saving");
		empServobj.saveEmployee(employee);
		System.out.println("Before redirecting");
		return "redirect:/getEmployeeDetails";	
		
	}
	@RequestMapping(value="/getEmployeeDetails",method=RequestMethod.GET)
	public String getEmployeeDetails(Model model){
		List<Employee> empDetails=empServobj.getEmployeeDetails();
		model.addAttribute("employeedetails", empDetails);
		return "employeelist";
	}
	@RequestMapping(value="/editEmployee/{eid}")
	public String editEmployeeDetails(@PathVariable int eid,Model model){
		List<Employee> empDetailsUpdated = empServobj.getEmployeeByid(eid);
		System.out.println("inside editemployee method");
	    model.addAttribute("employeedetailsupdated", empDetailsUpdated);
		return "employeelistUpdate";
	}
	@RequestMapping(value="/showUpdateEmployees",method=RequestMethod.POST)
	public ModelAndView showUpdateEmployees(@ModelAttribute(value="employeelist") Employee employeelist){
		System.out.println("inside showUpdateEmployees method");
		ModelAndView mv=new ModelAndView();
		List<Employee> updatedDetails=empServobj.saveUpdatedEmployee(employeelist);
		mv.addObject("updatedDetails",updatedDetails);
		mv.setViewName("updatedDetails");
		return mv;	
		
	}
	
//	@RequestMapping(value="/showUpdateEmployees",method=RequestMethod.POST)
//	public ModelAndView showUpdateEmployees(@RequestParam("name")String name,@RequestParam("projectDetails")String projectDetails,@RequestParam("email") String email,@RequestParam("phone") String phone){
//		System.out.println("inside showUpdateEmployees method");
//		ModelAndView mv=new ModelAndView();
//		List<Employee> updatedDetails=empServobj.saveUpdatedEmployee(name,projectDetails,email,phone);
//		mv.addObject("updatedDetails",updatedDetails);
//		mv.setViewName("updatedDetails");
//		return mv;	
//		
//	}
	
}
