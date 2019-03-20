package animalhealthcenterapplicationupdated.controllers;

import animalhealthcenterapplicationupdated.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }
    @RequestMapping({"/owners.html","/owners"})
    public String owners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
    @RequestMapping({"/owners/find"})
    public String findOwners(){

        return "notimplemented";
    }
}
