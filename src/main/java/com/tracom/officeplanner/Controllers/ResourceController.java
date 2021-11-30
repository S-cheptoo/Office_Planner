package com.tracom.officeplanner.Controllers;

import com.tracom.officeplanner.Models.Resource;
import com.tracom.officeplanner.Models.Role;
import com.tracom.officeplanner.Models.Room;
import com.tracom.officeplanner.Models.User;
import com.tracom.officeplanner.Repository.ResourceRepository;
import com.tracom.officeplanner.Services.ResourceService;
import com.tracom.officeplanner.Services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ResourceController {
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private final ResourceService resourceService;
    @Autowired
    private RoomService roomService;

    //    @GetMapping("")
    //    public String showResourcesPage(){
    //        return "resources";
    //    }

    public ResourceController(){
        resourceService = new ResourceService();
    }

    @GetMapping("/add_resource")
    public String getAddResource(Model model) {
        List<Room> listRooms = roomService.listRooms();
        model.addAttribute("rooms", listRooms);

        model.addAttribute("resource", new Resource());
        return "add_resource";
    }

    @PostMapping("/create_resource")
    public String addResource(@ModelAttribute Resource resource) {
        resourceRepository.save(resource);
        return "redirect:/resources";
    }

    @GetMapping("/resources")
    public String showResourcesList(Model model) {
        List<Resource> listResources = resourceService.listResources();
        model.addAttribute("resources", listResources);
        return "resources";
    }

    @RequestMapping("/edit_resource/{rsc_id}")
    public String showEditResource(@PathVariable(name = "rsc_id")Long rsc_id, Model model) {
        Resource resource = resourceRepository.getResourceById(rsc_id);
        model.addAttribute("resource", resource);
        return "edit_resource";
    }

    @PostMapping("/update_resource")
    public String updateResource(Resource resource){
        resourceService.saveResource(resource);
        return "redirect:/resources";
    }

    @RequestMapping("/delete_resource/{rsc_id}")
    public String deleteResource(@PathVariable(name = "rsc_id") Long rsc_id) {
        resourceRepository.deleteById(rsc_id);
        return "redirect:/resources";
    }
}
