package com.carlos.reuniones.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos.reuniones.models.Reunion;

public interface ReunionRepository extends JpaRepository<Reunion, Long> {

}
