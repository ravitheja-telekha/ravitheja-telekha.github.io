package com.telekha.empinfo.controller;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import com.telekha.empinfo.model.Employee;
import com.telekha.empinfo.model.EmployeeDesig;
import com.telekha.empinfo.model.EmployeeReport;
import com.telekha.empinfo.model.EmployeeStatus;
import com.telekha.empinfo.model.Leaverequest;
import com.telekha.empinfo.repository.EmployeeRepository;
import com.telekha.empinfo.repository.LeaveRepository;


@Controller
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private LeaveRepository leaveRepository;
	
	@RequestMapping("/")
	public String home(Model model){
		return "home";
	}	
	@RequestMapping("/login")
	public String login(Model model){		
		return "login";
	}
	@RequestMapping("/loginauth")
	public String loginaction(String email,String password,Model model){
		 String errormessage=" Invalid Credentials";
		       
		Employee emp=employeeRepository.findByEmailId(email);
		System.out.println("before decode:"+emp.getPassword());
			String decodedpassword=Base64Coder.decodeString(emp.getPassword());
			System.out.println("after decode:"+decodedpassword);


		if (emp==null)
		{
			model.addAttribute( "errormessage"  , errormessage);
			return "login";
		}
		else if(emp != null && decodedpassword.equals(password))
		{      	      			
		return "employeesinformation";
	    }
		else 			
		 {
			model.addAttribute( "errormessage"  , errormessage);
			return "login";
		}		
	}
	
	@RequestMapping("/forgetpassword")
	public String forget(Model model){
		model.addAttribute("Employee", new Employee());

		return "forgetpassword";
	}

	
	@RequestMapping("/registeredmail")

	public String forgetpassword(Model model,String email){
		String errormsg="Email Id Not Exists";
		Employee emp=employeeRepository.findByEmailId(email);
		if(emp==null)
		{
			model.addAttribute( "errormsg" ,errormsg);
         System.out.println(errormsg);
			return"forgetpassword";
		}
		else 
		{
			model.addAttribute("emp", emp);

		   return"resetpassword";
		}		
	}			
	@RequestMapping("/resetpassword")
	public String resetpassword(Model model){
		return "resetpassword";
		
	}
	@RequestMapping("/updatepassword")
	public String updatepassword(String id, String password,Model model){		
	 System.out.println(id);
	 Employee emp=employeeRepository.findbyid(id);
	  String encodedpassword=Base64Coder.encodeString(password);
	  emp.setPassword(encodedpassword);	
	  	employeeRepository.update(emp);
           return"login";
         
}
    
   @RequestMapping("/changepasswordpage")
   public String changepasswordpage(Model model){
   return "changepasswordpage";

   }
		          
	@RequestMapping("/changepassword")
	public String changepassword(Model model){
		return "changepassword";
		
	}
	@RequestMapping("/changepasswordaction")
	public String changepassword(String id,String oldpassword,String password,Model model){
		 String errormessage=" Invalid Oldpassword";
		    String id1="57f1d547e4b0453f028eb8f8"; 
		Employee emp=employeeRepository.findbyid(id1);
		String decodedpassword=Base64Coder.decodeString(emp.getPassword());
		System.out.println("after decode:"+decodedpassword);		
	
	   if( decodedpassword.equals(oldpassword))
		{  
		   
		   String encodedpassword=Base64Coder.encodeString(password);
		   emp.setPassword(encodedpassword);	
		  
			  employeeRepository.update(emp);
		    return "login";
	    }
		else 			
		 {
			model.addAttribute( "errormessage"  , errormessage);
			return "changepassword";
		}		
	}
	
	@RequestMapping("/employeesinformation")
	public String empinfo(Model model){
		return "employeesinformation";
	}
	
	@RequestMapping("/empregform")
	public String empreg(Model model){
		model.addAttribute("Employee", new Employee());
		return "empregform";
	}
	
	@RequestMapping(value="/register")
	public String employee1(@ModelAttribute("Employee") Employee employee, Model model){
		 String errormsg="Employee ID Already Existed";
			if( employeeRepository.findByempId(employee.getEmpid()) ==  null){
		Employee employee1= new Employee();
	    employee1.setEmpid(employee.getEmpid());
	    employee1.setFirstname(employee.getFirstname());
        employee1.setLastname(employee.getLastname());		
		employee1.setSalary(employee.getSalary());
		employee1.setDesigopt(employee.getDesigopt());
		employee1.setMobilenumber(employee.getMobilenumber());
        employee1.setEmail(employee.getEmail());
        String encodedpassword=Base64Coder.encodeString(employee.getPassword());

       //  String encodedpassword=Base64Coder.encodeString(employee.getPassword());
         System.out.println("At register:"+encodedpassword);
        employee1.setPassword(encodedpassword);       
        employee1.setBloodgrp(employee.getBloodgrp());
        employee1.setAddress(employee.getAddress());
		employee1.setReportusers(employee.getReportusers());
		employee1.setGender(employee.getGender());
	    employee1.setStatus(EmployeeStatus.ACTIVE);

	              if(employee.getDesigopt().equals(EmployeeDesig.DEVELOPER)){
		          employee1.setDesigopt(EmployeeDesig.DEVELOPER);
	              }
		   
		          else if(employee.getDesigopt().equals(EmployeeDesig.TESTER)){
			      employee1.setDesigopt(EmployeeDesig.TESTER);
			      }
		          else if(employee.getDesigopt().equals(EmployeeDesig.TRAINEE)){
			      employee1.setDesigopt(EmployeeDesig.TRAINEE);
		          }
	       	         	          
	              if(employee.getReportusers().equals(EmployeeReport.ADMIN)){
			        employee1.setReportusers(EmployeeReport.ADMIN);
		           }			   
			      else if(employee.getReportusers().equals(EmployeeReport.MANAGER)){
				    employee1.setReportusers(EmployeeReport.MANAGER);
				    }
			      else if(employee.getReportusers().equals(EmployeeReport.TEAMLEADER)){
				   employee1.setReportusers(EmployeeReport.TEAMLEADER);
			       }
	          
	          	          	          	                            
        employeeRepository.create(employee1);
        System.out.println(employee1);

		return"empregform";
		}
		else
		{
			model.addAttribute( "errormsg"  , errormsg);							
	           return "empregister";
		}
		
 }	
	
	@RequestMapping("/leaverequest")
	public String leaverequest(Model model){
		model.addAttribute("Leaverequest", new Leaverequest());

		return "leaverequest";
	}
	
	@RequestMapping("/leaveaction")
	public String leaveaction(@ModelAttribute("Leaverequest") Leaverequest leaverequest, String id,Model model){
		   Date currentdate=new Date();
		String createdid="57f4f04fb96065456504206b"; 
        String createdname="jathin";
	 	//employeeRepository.findbyid(createdid);
	    Leaverequest leave= new Leaverequest();
		leave.setCreateTS(currentdate);
		leave.setUpdateTS(currentdate);
		leave.setCreatedid(createdid);
		leave.setCreatedname(createdname);
		leave.setFromdate(leaverequest.getFromdate());
		leave.setTodate(leaverequest.getTodate());
		leave.setReason(leaverequest.getReason());
		leave.setReportusers(leaverequest.getReportusers());
 		if(leaverequest.getReportusers().equals(EmployeeReport.ADMIN)){
 			leave.setReportusers(EmployeeReport.ADMIN);
	           }			   
		      else if(leaverequest.getReportusers().equals(EmployeeReport.MANAGER)){
		    	  leave.setReportusers(EmployeeReport.MANAGER);
			    }
		      else if(leaverequest.getReportusers().equals(EmployeeReport.TEAMLEADER)){
		    	  leave.setReportusers(EmployeeReport.TEAMLEADER);
		       }
         leaveRepository.update(leave);
         return "leaverequest";
	}

	@RequestMapping("/searchempbyid")
	public String employeesearch(Model model){
		return "searchempbyid";
	}
	@RequestMapping(value="/searchempid")
	public String searchid(String searchbyid,  Model model){
		
		System.out.println("searchbyid:"+searchbyid);
		Employee employee=employeeRepository.findByempId(searchbyid);
		
		model.addAttribute("employee", employee);
		
		return "searchempbyid";
	}
	
	@RequestMapping("/employeeslist")
	public String allemployees1(Model model){
		List<Employee> allemployeesList =employeeRepository.getallemployeesList();
		model.addAttribute("allemployeesList",allemployeesList);
		model.addAttribute("Employees", new Employees());

		return "employeeslist";
	}
	
	@RequestMapping(value="/deleteid")
	public String deleteid(String id, Model model){
		 employeeRepository.deleteById(id);
		return "redirect:/employeeslist";
	}
	@RequestMapping(value="/changeemployeestatus")
	public String changeemployeeStatus(String id, Model model){
		Employee employee =employeeRepository.findbyid(id);
		EmployeeStatus status=employee.getStatus();
		if(status == null){
			employee.setStatus(EmployeeStatus.INACTIVE);
		}else if((employee.getStatus().equals(EmployeeStatus.ACTIVE))){ 
			 employee.setStatus(EmployeeStatus.INACTIVE);
		 }else{
			 employee.setStatus(EmployeeStatus.ACTIVE);
		 }
	     employeeRepository.update(employee);
		return "redirect:/employeeslist";
				 
	}
	
	@RequestMapping(value="/editempdetails")
	public String edit( Model model, String id){		
		model.addAttribute("Employee", new Employee());
		System.out.println("id:"+id);		
	    Employee employee=employeeRepository.findbyid(id);
	    System.out.println(employee.getStatus());
	   System.out.println(employee.getGender());
	   System.out.println(employee.getAddress());

		model.addAttribute("employee", employee);
		return"editemployeedetails";				         
		}
	
	@RequestMapping(value="/update")
	public String update(@ModelAttribute("Employee") Employee employee, Model model){	    				
		employee.setStatus(EmployeeStatus.ACTIVE);
		employee.setAddress(employee.getAddress());
		//employee.setGender(employee.getGender());
		employeeRepository.update(employee);
		return"redirect:/employeeslist";	
	}
	
	@RequestMapping(value="/deletemultipleids")
	public String deleteMultipleIds(@ModelAttribute("Employees") Employees employees,Model model){
		List<String> deleteMultipleIds = employees.getallemployeesLists();
		Iterator<String> deleteId=deleteMultipleIds.iterator();
		while(deleteId.hasNext()){
			String Id=deleteId.next();
			employeeRepository.deleteById(Id);
		}
		return "redirect:/employeeslist";
	}
}
	class Employees{
		private List<String> allemployeesLists;
		public List<String> getallemployeesLists() {
			return allemployeesLists;
		}
		public void setallemployeesLists(List<String> allemployeesLists) {
			this.allemployeesLists = allemployeesLists;
		}	
	
	}

	

