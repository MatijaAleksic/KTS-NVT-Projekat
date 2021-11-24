/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.services;


import kts.restaurant_application.model.Barman;
import kts.restaurant_application.model.MainCook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Manager;
import kts.restaurant_application.repositories.ManagerRepository;

@Service
public class ManagerService {
    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    private final ManagerRepository repository;

    @Autowired
    public ManagerService(ManagerRepository repository) {
        this.repository = repository;
    }

    public Iterable<Manager> findAll() {
        return repository.findAll();
    }

    public Manager findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find Manager by " + id));
    }

    public Manager save(Manager entity) {
        return repository.save(entity);
    }

    public Manager update(Manager entity){
        Manager existingManager = findOne(entity.getId());

        existingManager.setFirstName(entity.getFirstName());
        existingManager.setLastName(entity.getLastName());
        existingManager.setPassword(entity.getPassword());
        existingManager.setDateOfBirth(entity.getDateOfBirth());
        existingManager.setSalary(entity.getSalary());
        existingManager.setIsDeleted(entity.getIsDeleted());

        return save(existingManager);
    }

    public void delete(Manager entity) {
        repository.delete(entity);
    }

    public void delete(Long id) {
        delete(findOne(id));
    }
}