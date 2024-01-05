package br.com.moller.restwithspringbootandjavamoller.repositories;

import br.com.moller.restwithspringbootandjavamoller.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}