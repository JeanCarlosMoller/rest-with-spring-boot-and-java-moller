package br.com.moller.restwithspringbootandjavamoller.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.moller.restwithspringbootandjavamoller.model.Person;

@Service
public class PersonServices {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findById(String id) {

        logger.info("Finding one person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Jean Carlos");
        person.setLastName("Möller");
        person.setAddress("Blumenau - SC");
        person.setGender("Male");
        return person;
    }

}
