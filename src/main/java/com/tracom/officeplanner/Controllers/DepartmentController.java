package com.tracom.officeplanner.Controllers;

import com.tracom.officeplanner.Models.*;
import com.tracom.officeplanner.Repository.DepartmentRepository;
import com.tracom.officeplanner.Services.DepartmentService;
import com.tracom.officeplanner.Services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
     private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/departments")
    public String getDepartments(Model model){
        List<Department> listDepartments = departmentService.listDepartments();
        model.addAttribute("departments", new Department());
        return "departments";
    }
    @GetMapping("/add_department")
    public String getAddMeeting(Model model){
        List<Organization> listOrganizations = organizationService.listOrganizations();
        model.addAttribute("organizations",listOrganizations);
        model.addAttribute("department", new Department());
        return "add_department";
    }
    @PostMapping("/create_depart")
    public String addDepartment(@ModelAttribute Department department){
        departmentRepository.save(department);
        return "departments";
    }

    @RequestMapping("/edit_department/{id}")
    public String showEditDepartment(@PathVariable(name = "dp_id")Long id, Model model) {
        Department department = departmentRepository.getDepartmentById(id);
        model.addAttribute("departments", department);
        return "edit_department";
    }

    @PostMapping("/update_department")
    public String updateDepartment(Department department){
        departmentService.saveDepartment(department);
        return "redirect:/departments";
    }

    @RequestMapping("/delete_meeting/{id}")
    public String deleteDepartment(@PathVariable(name = "dp_id") Long id) {
        departmentRepository.deleteById(id);
        return "redirect:/departments";
    }
}
