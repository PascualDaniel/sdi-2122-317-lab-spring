package com.uniovi.sdi2122317spring.repositories;

import com.uniovi.sdi2122317spring.entities.Mark;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MarksRepository extends CrudRepository<Mark, Long> {

}
