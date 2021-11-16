package Backend.src.main.java.kts.restaurant_application.model;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;

@Entity
@Table(name="waiter_table")
public class Waiter extends User {

	private Set<Order> orders = new HashSet<>();

	public Waiter(Long id, String firstName, String lastName, String username, String password, Date dateOfBirth, Long salary, Boolean isDeleted) {
		super(id, firstName, lastName, username, password, dateOfBirth, salary, isDeleted);
	}

	public Waiter() {

	}

	public Set<Order> getOrders() {
		return orders;
	}

}