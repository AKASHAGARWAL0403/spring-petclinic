package com.springframework.petclinic.Controller;

import com.springframework.petclinic.Services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetsController {

    private VetService vetService;

    public VetsController(VetService vetService) {
        this.vetService = vetService;
    }


    @RequestMapping({"","/","index","index.html"})
    public String listVets(Model model){
        model.addAttribute("vets" , vetService.findAll());
        return "vets/index";
    }
}
