/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Admin;
import kts.restaurant_application.repositories.AdminRepository;

@Service
public class AdminService {
    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    private final AdminRepository repository;

    @Autowired
    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }

    public Iterable<Admin> findAll() {
        return repository.findAll();
    }

    public Admin findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find Admin by " + id));
    }

    public Admin save(Admin entity) {
        return repository.save(entity);
    }

    public Admin update(Admin entity){
        Admin existingAdmin = findOne(entity.getId());

        existingAdmin.setFirstName(entity.getFirstName());
        existingAdmin.setLastName(entity.getLastName());
        existingAdmin.setPassword(entity.getPassword());
        existingAdmin.setDateOfBirth(entity.getDateOfBirth());
        existingAdmin.setSalary(entity.getSalary());
        existingAdmin.setIsDeleted(entity.getIsDeleted());

        return save(existingAdmin);
    }

    public Admin delete(Admin entity) {
        Admin existingAdmin = findOne(entity.getId());
        existingAdmin.setIsDeleted(true);
        return save(existingAdmin);
    }

    public void delete(Long id) {
        delete(findOne(id));
    }
}