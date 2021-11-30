package com.tracom.officeplanner.Controllers;

import com.tracom.officeplanner.Models.Organization;
import com.tracom.officeplanner.Models.Resource;
import com.tracom.officeplanner.Repository.OrganizationRepository;
import com.tracom.officeplanner.Services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class OrganizationController {
    @Autowired
    private OrganizationRepository organizationRepository;

    @Autowired
    private OrganizationService organizationService;

    public OrganizationController(){
        organizationService = new OrganizationService();
    }
//
//    @GetMapping("/organizations")
//    public String getOrganizationsPage(Model model){
//        model.addAttribute("organizations" , new Organization());
//        return "organizations";
//    }

    @GetMapping("/add_organization")
    public String getAddOrganization(Model model){
        model.addAttribute("organizations", new Organization());
        return "add_organization";
    }

    @PostMapping("/add_organization")
    public String getAddOrganization(@ModelAttribute Organization organization){
        organizationRepository.save(organization);
        return "organizations";
    }

    @GetMapping("/organizations")
    public String getOrganizations(Model model){
        List<Organization> listOrganizations = organizationService.listOrganizations();
        model.addAttribute("organizations", listOrganizations);
        return "organizations";
    }

    @RequestMapping("/edit_organization/{org_id}")
    public String showEditOrganization(@PathVariable(name = "org_id") Long org_id, Model model){
        Organization organization = organizationRepository.getOrganizationById(org_id);
        model.addAttribute("organizations", organization);
        return "edit_organization";
    }

    @PostMapping("/update_organization")
    public String updateOrganization(Organization organization){
        organizationService.saveOrganization(organization);
        return "redirect:/organizations";
    }

    @RequestMapping("/delete_organization/{org_id}")
    public String deleteOrganization(@PathVariable(name = "org_id") Long org_id) {
        organizationRepository.deleteById(org_id);
        return "organizations";
    }

    @ModelAttribute("organizations")
    public List<Organization> organizations(){
        return organizationRepository.findAll();
    }
}
