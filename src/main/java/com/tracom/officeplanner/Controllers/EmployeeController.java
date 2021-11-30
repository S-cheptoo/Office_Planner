package com.tracom.officeplanner.Controllers;

import com.tracom.officeplanner.Models.Department;
import com.tracom.officeplanner.Models.Employee;
import com.tracom.officeplanner.Models.Organization;
import com.tracom.officeplanner.Repository.EmployeeRepository;
import com.tracom.officeplanner.Services.DepartmentService;
import com.tracom.officeplanner.Services.EmployeeService;
import com.tracom.officeplanner.Services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/employees")
    public String getEmployeesPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees";
    }

    @GetMapping("/add_employees")
    public String getAddEmployee(Model model){
        List<Organization> listOrganizations = organizationService.listOrganizations();
        model.addAttribute("organizations", listOrganizations);

        List<Department> listDepartments = departmentService.listDepartments();
        model.addAttribute("departments", listDepartments);

        model.addAttribute("employee", new Employee());
        return "add_employee";
    }

    @PostMapping("/add_employees")
    public String addEmployee(@ModelAttribute Employee employee){
        employeeRepository.save(employee);
        return "redirect:/list_employees";
    }

    @GetMapping("/list_employees")
    public String getEmployeeList(Model model){
        List<Employee> listEmployees=employeeService.listEmployees();
        model.addAttribute("employee", listEmployees);
        return "list_employees";
    }

    @RequestMapping("/edit_employee/{id}")
    public ModelAndView showEditEmployee(@PathVariable(name="id") Long id){
        ModelAndView emv=new ModelAndView("/edit_employee");
        Employee e = employeeRepository.getEmployeeById(id);
        emv.addObject("e", e);
        return emv;
    }
    @RequestMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(name="id") Long id) {
        employeeRepository.deleteById(id);
        return "redirect:/list_employees";
    }
}
