package com.springframework.petclinic.Controller;

import com.springframework.petclinic.Services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsController {

    private VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"/vets","/vets/","/vets/index","/vets/index.html","/vets.html"})
    public String listVets(Model model){
        model.addAttribute("vets" , vetService.findAll());
        return "vets/index";
    }
}
