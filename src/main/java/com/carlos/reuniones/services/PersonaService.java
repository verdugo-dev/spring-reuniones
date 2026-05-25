package com.carlos.reuniones.services;

import java.util.List;
import org.springframework.stereotype.Service;

import com.carlos.reuniones.data.PersonaRepository;
import com.carlos.reuniones.models.Persona;

@Service
public class PersonaService {
    // private static final List<Persona> personas = new ArrayList<>();

    // static {
    //     for (int i = 0; i < 5; i++) {
    //         Persona persona = new Persona(i, "Nombre " + i, "Apellido " + i);
    //         personas.add(persona);
    //     }
    // }
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }
}
