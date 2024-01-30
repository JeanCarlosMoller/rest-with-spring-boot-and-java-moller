package br.com.moller.restwithspringbootandjavamoller.controllers;

import java.util.List;
import br.com.moller.restwithspringbootandjavamoller.data.vo.v1.PersonVO;
import br.com.moller.restwithspringbootandjavamoller.data.vo.v2.PersonVOV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.moller.restwithspringbootandjavamoller.services.PersonServices;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonServices service;

    @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll() {
        return service.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVO findById(@PathVariable(value = "id") Long id) {
        return service.findById(id);
    }


    @PostMapping( consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public PersonVO create(
            @RequestBody PersonVO person) {

        return service.create(person);
    }

    @PostMapping(value = "/v2", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    public PersonVOV2 createV2(
            @RequestBody PersonVOV2 person) {

        return service.createV2(person);
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
