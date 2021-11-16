/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.controllers;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kts.restaurant_application.model.Drink;
import kts.restaurant_application.services.DrinkService;

@Transactional
@RestController
@RequestMapping("/drinks")
public class DrinkController {
    private static final Logger logger = LoggerFactory.getLogger(DrinkController.class);

    private final DrinkService service;

    @Autowired
    public DrinkController(DrinkService service) {
        this.service = service;
    }

    @GetMapping
    public Iterable<Drink> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Drink findOne(@PathVariable("id") Long id) {
        return service.findOne(id);
    }

    @PostMapping
    public Drink create(@RequestBody @Valid Drink entity) {
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}