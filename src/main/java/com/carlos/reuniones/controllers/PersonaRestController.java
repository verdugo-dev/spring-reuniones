package com.carlos.reuniones.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos.reuniones.models.Persona;
import com.carlos.reuniones.services.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaRestController {

    private PersonaService personaService;

    public PersonaRestController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return this.personaService.getAllPersonas();
    }

}
