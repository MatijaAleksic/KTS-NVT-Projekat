/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.services;


import kts.restaurant_application.model.Admin;
import kts.restaurant_application.model.Authority;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Barman;
import kts.restaurant_application.repositories.BarmanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BarmanService {
    private static final Logger logger = LoggerFactory.getLogger(BarmanService.class);

    private final BarmanRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    public BarmanService(BarmanRepository repository) {
        this.repository = repository;
    }

    public Iterable<Barman> findAll() {
        Iterable<Barman> all = repository.findAll();
        ArrayList<Barman> notDeleted = new ArrayList<>();

        for(Barman b : all){
            if(!b.getIsDeleted()){
                notDeleted.add(b);
            }
        }
        return notDeleted;
    }

    public Barman findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find Barman by " + id));
    }

    public Barman save(Barman entity) {
        return repository.save(entity);
    }


    public Barman update(Barman entity){
        Barman existingBarman = findOne(entity.getId());

        existingBarman.setFirstName(entity.getFirstName());
        existingBarman.setLastName(entity.getLastName());
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        existingBarman.setDateOfBirth(entity.getDateOfBirth());
        existingBarman.setSalary(entity.getSalary());
        existingBarman.setIsDeleted(entity.getIsDeleted());

        return save(existingBarman);
    }

    public Barman delete(Barman entity) {
        Barman existingBarman = findOne(entity.getId());
        existingBarman.setIsDeleted(true);
        return save(existingBarman);
    }

    public Barman delete(Long id) {
        return delete(findOne(id));
    }
}