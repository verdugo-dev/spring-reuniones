package com.carlos.reuniones.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.reuniones.models.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
