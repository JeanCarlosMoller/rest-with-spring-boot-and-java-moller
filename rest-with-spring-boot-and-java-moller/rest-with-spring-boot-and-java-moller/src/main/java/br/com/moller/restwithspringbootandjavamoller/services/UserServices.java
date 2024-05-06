package br.com.moller.restwithspringbootandjavamoller.services;

import br.com.moller.restwithspringbootandjavamoller.controllers.PersonController;
import br.com.moller.restwithspringbootandjavamoller.data.vo.v1.PersonVO;
import br.com.moller.restwithspringbootandjavamoller.exceptions.ResourceNotFoundException;
import br.com.moller.restwithspringbootandjavamoller.mapper.DozerMapper;
import br.com.moller.restwithspringbootandjavamoller.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class UserServices implements UserDetailsService {

    private Logger logger = Logger.getLogger(UserServices.class.getName());

    @Autowired
    UserRepository repository;

    public UserServices(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Finding one user by name!" + username + "!");
        var user = repository.findByUsername(username);
        if(user != null){
            return user;
        } else {
            throw new UsernameNotFoundException("" + username + " not found!");
        }
    }
}
