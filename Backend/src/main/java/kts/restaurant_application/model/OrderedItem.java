/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package kts.restaurant_application.model;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;

// ----------- << imports@AAAAAAF9CZEscm2ODeQ= >>
// ----------- >>

@Entity
@Table(name = "_orderedItems")
@ApiModel(description = "")
// ----------- << class.annotations@AAAAAAF9CZEscm2ODeQ= >>
// ----------- >>
public class OrderedItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// ----------- << id.annotations@AAAAAAF9CZEscm2ODeQ= >>
	// ----------- >>
	private Long id;

	@Version
	// ----------- << version.annotations@AAAAAAF9CZEscm2ODeQ= >>
	// ----------- >>
	private Long version;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(nullable = false)
	// ----------- << attribute.annotations@AAAAAAF9CZK032/34ZA= >>
	// ----------- >>
	private State state;

	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(nullable = false)
	// ----------- << attribute.annotations@AAAAAAF9CZLEIXA95Wc= >>
	// ----------- >>
	private Status status;

	@NotNull
	@Column(nullable = false)
	// ----------- << attribute.annotations@AAAAAAF9Ct0EpCrKZrs= >>
	// ----------- >>
	private Integer number;

	@NotNull
	@Column(nullable = false)
	// ----------- << attribute.annotations@AAAAAAF9Ct2UpivQ38g= >>
	// ----------- >>
	private LocalDateTime dateTime;

	@NotNull
	@OneToOne
	@JoinColumn(name = "item_id")
	// ----------- << attribute.annotations@AAAAAAF9CZSVQnOWt9A= >>
	// ----------- >>
	private Item item;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "staff_id")
	// ----------- << attribute.annotations@AAAAAAF9CZXrMnjEqhA= >>
	// ----------- >>
	private Staff staff;

	// ----------- << getId.annotations@AAAAAAF9CZEscm2ODeQ= >>
	// ----------- >>
	public Long getId(){
		return id;
	}

	public State getState() {
		return state;
	}

	public Status getStatus() {
		return status;
	}

	public Integer getNumber() {
		return number;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public Item getItem() {
		return item;
	}

	public Staff getStaff() {
		return staff;
	}

	public OrderedItem setState(State state) {
		this.state = state;
		return this;
	}

	public OrderedItem setStatus(Status status) {
		this.status = status;
		return this;
	}

	public OrderedItem setNumber(Integer number) {
		this.number = number;
		return this;
	}

	public OrderedItem setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
		return this;
	}

	public OrderedItem setItem(Item item) {
		this.item = item;
		return this;
	}

	public OrderedItem setStaff(Staff staff) {
		this.staff = staff;
		return this;
	}

	public OrderedItem linkItem(Item _item) {
		setItem(_item);
		return this;
	}

	public OrderedItem linkStaff(Staff _staff) {
		if (_staff != null) {
			_staff.getProcessed().add(this);
		}

		unlinkStaff();
		setStaff(_staff);
		return this;
	}

	public OrderedItem unlinkItem() {
		setItem(null);
		return this;
	}

	public OrderedItem unlinkStaff() {
		if (getStaff() != null) {
			getStaff().getProcessed().remove(this);
			setStaff(null);
		}
		return this;
	}

	// ----------- << equals.annotations@AAAAAAF9CZEscm2ODeQ= >>
	// ----------- >>
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof OrderedItem && (getId().equals(((OrderedItem) obj).getId()));
	}

	// ----------- << hashCode.annotations@AAAAAAF9CZEscm2ODeQ= >>
	// ----------- >>
	@Override
	public int hashCode() {
		return 214;
	}

// ----------- << class.extras@AAAAAAF9CZEscm2ODeQ= >>
// ----------- >>
}