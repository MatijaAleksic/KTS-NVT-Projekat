/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.services;


import kts.restaurant_application.model.Drink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import kts.restaurant_application.model.Order;
import kts.restaurant_application.repositories.OrderRepository;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Iterable<Order> findAll() {
        return repository.findAll();
    }

    public Order findOne(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cannot find Order by " + id));
    }

    public Order save(Order entity) {
        return repository.save(entity);
    }

    public Order update(Order entity){
        Order existingOrder = findOne(entity.getId());

        existingOrder.setPrice(entity.getPrice());
        existingOrder.setWaiter(entity.getWaiter());
        existingOrder.setNote(entity.getNote());
        existingOrder.setTable(entity.getTable());

        return save(existingOrder);
    }

    public void delete(Order entity) {
        repository.delete(entity);
    }

    public void delete(Long id) {
        delete(findOne(id));
    }
}