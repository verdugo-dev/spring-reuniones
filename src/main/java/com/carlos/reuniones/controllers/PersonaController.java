package com.carlos.reuniones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carlos.reuniones.services.PersonaService;

@Controller
@RequestMapping("/personas")
public class PersonaController {

    private PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }


    @GetMapping
    public String getAllPersonas(Model model) {
        model.addAttribute("personas", personaService.getAllPersonas());
        return "personas";
    }

}
