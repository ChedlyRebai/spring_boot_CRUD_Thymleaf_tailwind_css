package in.chedly.courseproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.chedly.courseproject.entity.Employee;
import in.chedly.courseproject.repository.Employeerepository;

@Controller
public class Employeecontroller {
	@Autowired
	private Employeerepository emRepo;
	
	@GetMapping({"/showEmployees","/"})
	public ModelAndView showEmployees() {
		ModelAndView mav=new ModelAndView("list_employees");
		List<Employee> listOfEmployees= emRepo.findAll();
		mav.addObject("employees",listOfEmployees);
		return mav;
	}
	
	@GetMapping("/addEmployee")
	public ModelAndView addEmployee() {
		ModelAndView mav=new ModelAndView("addEmployee");
		Employee newEmployee=new Employee();
		mav.addObject("employee",newEmployee);
		return mav;
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute Employee newEmployee) {
		emRepo.save(newEmployee);
		return "redirect:/";
	}
	
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam Long employeeid ) {
    	emRepo.deleteById(employeeid);
    	return "redirect:/";
    }
	
	
		
	
	@GetMapping("/showupdate")
	public ModelAndView updateEmployee(@RequestParam Long employeeid) { //epmloyeeid in the url
		ModelAndView mav=new ModelAndView("updateEmployee");
		Employee uptEmployee= emRepo.findById(employeeid).get();
		mav.addObject("employee",uptEmployee);
		return mav;
	}
	 
}
