package br.com.moller.restwithspringbootandjavamoller.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import br.com.moller.restwithspringbootandjavamoller.data.vo.v1.PersonVO;
import br.com.moller.restwithspringbootandjavamoller.exceptions.ResourceNotFoundException;
import br.com.moller.restwithspringbootandjavamoller.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonVO> findAll() {

        logger.info("Finding all people!");

        return repository.findAll();
    }

    public PersonVO findById(Long id) {

        logger.info("Finding one person!");

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public PersonVO create(PersonVO person) {

        logger.info("Creating one person!");
        return repository.save(person);
    }

    public PersonVO update(PersonVO person) {

        logger.info("Updating one person!");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return repository.save(person);
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }

}
