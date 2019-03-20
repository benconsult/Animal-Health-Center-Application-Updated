package animalhealthcenterapplicationupdated.controllers;

import animalhealthcenterapplicationupdated.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
    private final VetService vetService;

    public VetController(VetService vetService) {
        this.vetService = vetService;
    }
    @RequestMapping({"/vets", "/vets.html","/vets/index.html"})
    public String vets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
