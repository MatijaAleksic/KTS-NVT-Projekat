/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.services;


import kts.restaurant_application.model.Admin;
import kts.restaurant_application.model.Barman;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Cook;
import kts.restaurant_application.repositories.CookRepository;

import java.util.ArrayList;

@Service
public class CookService {
    private static final Logger logger = LoggerFactory.getLogger(CookService.class);

    private final CookRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public CookService(CookRepository repository) {
        this.repository = repository;
    }

    public Iterable<Cook> findAll() {
        Iterable<Cook> all = repository.findAll();
        ArrayList<Cook> notDeleted = new ArrayList<>();

        for(Cook b : all){
            if(!b.getIsDeleted()){
                notDeleted.add(b);
            }
        }
        return notDeleted;
    }

    public Cook findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find Cook by " + id));
    }

    public Cook save(Cook entity) {
        return repository.save(entity);
    }

    public Cook update(Cook entity){
        Cook existingCook = findOne(entity.getId());

        existingCook.setFirstName(entity.getFirstName());
        existingCook.setLastName(entity.getLastName());
        existingCook.setPassword(passwordEncoder.encode(entity.getPassword()));
        existingCook.setDateOfBirth(entity.getDateOfBirth());
        existingCook.setSalary(entity.getSalary());

        return save(existingCook);
    }

    public Cook delete(Cook entity) {
        Cook existingCook = findOne(entity.getId());
        existingCook.setIsDeleted(true);
        return save(existingCook);
    }

    public Cook delete(Long id) {
        return delete(findOne(id));
    }
}