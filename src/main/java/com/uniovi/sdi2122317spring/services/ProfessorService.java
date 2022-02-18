package com.uniovi.sdi2122317spring.services;

import com.uniovi.sdi2122317spring.entities.Mark;
import com.uniovi.sdi2122317spring.entities.Professor;
import com.uniovi.sdi2122317spring.repositories.ProfessorRepossitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepossitory professorsRepository;


    @PostConstruct
    public void init() {
        Professor p = new Professor(1L,"1234","Daniel","Pascual","Informatica");
        Professor p2 = new Professor(2L,"67834","Fernando","Lopez","asd");

        professorsRepository.save(p);
        professorsRepository.save(p2);
    }

    public List<Professor> getProfessors() {
        List<Professor> professor = new ArrayList<Professor>();
        professorsRepository.findAll().forEach(professor::add);
        return professor;
    }

    public Professor getProfessor(Long id) {
        return professorsRepository.findById(id).get();
    }
    public void addProfessor(Professor p) {
        professorsRepository.save(p);
    }
    public void deleteProfessor(Long id) {
        professorsRepository.deleteById(id);
    }



}
