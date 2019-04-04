package animalhealthcenterapplicationupdated.controllers;

import animalhealthcenterapplicationupdated.model.Owner;
import animalhealthcenterapplicationupdated.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OwnerController {
    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    //to control web form data
    @InitBinder
    public void setAllallowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }

    //@RequestMapping({"/owners.html","/owners"})
   // public String owners(Model model){
    //    model.addAttribute("owners", ownerService.findAll());
   //     return "owners/index";
   // }
    //the not implemened yet template
    @RequestMapping({"/owners/find"})
    public String findOwners(Model model){
      model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }
    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model){

        // allow parameterless GET request for /owners to return all records
        if (owner.getLastName() == null) {
            owner.setLastName(""); // empty string signifies broadest possible search
        }

        // find owners by last name
        List<Owner> results = ownerService.findAllByLastNameLike("%" + owner.getLastName()+ "%");
        if (results.isEmpty()) {
            // no owners found
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "owners/ownersList";
        }

    }

    @GetMapping("/owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }
    @GetMapping("/owners/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", new Owner());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/owners/new")
    public String processCreationForm(@Valid Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        } else {
            Owner saveOwner = ownerService.save(owner);
            return "redirect:/owners/" + saveOwner.getId();
        }
    }
        @GetMapping("/owners/{ownerId}/edit")
        public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
            model.addAttribute(ownerService.findById(ownerId));
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }

        @PostMapping("/owners/{ownerId}/edit")
        public String processUpdateOwnerForm(@Valid Owner owner, BindingResult result, @PathVariable Long ownerId) {
            if (result.hasErrors()) {
                return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
            } else {
                owner.setId(ownerId);
                Owner saveOwner = ownerService.save(owner);
                return "redirect:/owners/" + saveOwner.getId();
            }
        }



}
