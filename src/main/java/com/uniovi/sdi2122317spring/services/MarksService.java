package com.uniovi.sdi2122317spring.services;

import com.uniovi.sdi2122317spring.entities.Mark;
import com.uniovi.sdi2122317spring.repositories.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class MarksService {
    @Autowired
    private MarksRepository marksRepository;

    /* Example of Constructor-Based Dependency Injection*/
    private final HttpSession httpSession;
    public MarksService(HttpSession httpSession) {
        this.httpSession = httpSession;
    }

    /**
     * Antes: public Mark getMark(Long id) {
     *         return marksRepository.findById(id).get();
     *     }
     * @param id
     * @return
     */
    public Mark getMark(Long id){
        Set<Mark> consultedList = (Set<Mark>) httpSession.getAttribute("consultedList");
        if ( consultedList == null ) {
            consultedList = new HashSet<Mark>();
        }
        Mark obtainedMark = marksRepository.findById(id).get();
        consultedList.add(obtainedMark);
        httpSession.setAttribute("consultedList", consultedList);
        return obtainedMark;
    }
    public void setMarkResend(boolean revised, Long id) {
        marksRepository.updateResend(revised, id);
    }
    public List<Mark> getMarks() {
        List<Mark> marks = new ArrayList<Mark>();
        marksRepository.findAll().forEach(marks::add);
        return marks;
    }


    public void addMark(Mark mark) {
        // Si en Id es null le asignamos el último + 1 de la lista
        marksRepository.save(mark);
    }
    public void deleteMark(Long id) {
        marksRepository.deleteById(id);
    }

}