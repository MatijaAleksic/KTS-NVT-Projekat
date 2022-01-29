/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/

package kts.restaurant_application.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kts.restaurant_application.model.RestourantTables;

@Repository
public interface TableRepository extends JpaRepository<RestourantTables, Long> {

    RestourantTables[] findAllByFloor(Integer floor);

    Collection<RestourantTables> findAllByIsDeleted(Boolean isDeleted);

    Optional<RestourantTables> findByIdAndIsDeleted(Long id, Boolean isDeleted);

    RestourantTables[] findAllByFloorAndIsDeleted(Integer floor, Boolean isDeleted);

}