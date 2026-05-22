package com.carlos.reuniones.controllers;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.carlos.reuniones.models.Reunion;

@Controller
@RequestMapping("/reuniones")
public class ReunionController {

    private static final List<Reunion> reuniones = new ArrayList<>();

    static {
        for (int i = 1; i <= 5; i++) {
            reuniones.add(new Reunion(i, "Reunion " + i,
                ZonedDateTime.now().plusDays(i)
            ));
        }
    }

    @GetMapping
    public String getAllReuniones(Model model) {
        model.addAttribute("reuniones", reuniones);
        return "reuniones";
    }

}
