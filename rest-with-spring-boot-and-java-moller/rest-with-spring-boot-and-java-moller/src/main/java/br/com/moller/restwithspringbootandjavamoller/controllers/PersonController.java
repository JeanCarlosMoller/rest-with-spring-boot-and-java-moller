package br.com.moller.restwithspringbootandjavamoller.controllers;

import java.util.List;

import br.com.moller.restwithspringbootandjavamoller.data.vo.v1.PersonVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.moller.restwithspringbootandjavamoller.model.Person;
import br.com.moller.restwithspringbootandjavamoller.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public PersonVOfindById(
            @PathVariable(value = "id") Long id) throws Exception {

        return service.findById(id);
    }

    @PostMapping( consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(
            @RequestBody PersonVO person) {

        return service.create(person);
    }

    @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public PersonVO uptada(
            @RequestBody PersonVO person) {

        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(
            @PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}