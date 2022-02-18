package com.uniovi.sdi2122317spring.controllers;

import com.uniovi.sdi2122317spring.entities.Mark;
import com.uniovi.sdi2122317spring.entities.Professor;

import com.uniovi.sdi2122317spring.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {
    @Autowired //Inyectar el servicio
    private ProfessorService professorService;

    @RequestMapping("/professor/list")
    public String getList() {
        return professorService.getProfessors().toString();

    }

    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor p) {
        professorService.addProfessor(p);
        return "Ok";
    }

    @RequestMapping("/professor/details/{id}")
    public String getDetail( @PathVariable Long id) {
        return professorService.getProfessor(id).toString();
        //return "professor/details";
    }

    @RequestMapping("/professor/delete/{id}")
    public String deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
        return "Ok";
    }

    @RequestMapping(value="/professor/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Professor professor, @PathVariable Long id){
        professor.setId(id);
        professorService.addProfessor(professor);
        return "Ok";
    }

}
