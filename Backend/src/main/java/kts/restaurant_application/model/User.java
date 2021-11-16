/*
* This code has been generated by the Rebel: a code generator for modern Java.
*
* Drop us a line or two at feedback@archetypesoftware.com: we would love to hear from you!
*/
package kts.restaurant_application.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.swagger.annotations.ApiModel;


// ----------- << imports@AAAAAAF9CThr25WiQC8= >>
// ----------- >>

@Entity
@Table(name = "_users")
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		property = "type"
)
@JsonSubTypes({
		@JsonSubTypes.Type(value = Manager.class, name = "manager"),
		@JsonSubTypes.Type(value = Waiter.class, name = "waiter"),
		@JsonSubTypes.Type(value = Admin.class, name = "admin"),
		@JsonSubTypes.Type(value = MainCook.class, name = "mainCook"),
		@JsonSubTypes.Type(value = Barman.class, name = "barman")
})
@ApiModel(description = "")
// ----------- << class.annotations@AAAAAAF9CThr25WiQC8= >>
// ----------- >>
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// ----------- << id.annotations@AAAAAAF9CThr25WiQC8= >>
	// ----------- >>
	private Long id;

	@Version
	// ----------- << version.annotations@AAAAAAF9CThr25WiQC8= >>
	// ----------- >>
	private Long version;

	@NotNull
	@Column(nullable = true)
	// ----------- << attribute.annotations@AAAAAAF9CTs4IpXYIDI= >>
	// ----------- >>
	private String firstName;

	@NotNull
	@Column(nullable = true)
	
	// ----------- << attribute.annotations@AAAAAAF9CTusq5XfqQM= >>
	// ----------- >>
	private String lastName;

	@NotNull
	@Column(nullable = false, unique = true)
	// ----------- << attribute.annotations@AAAAAAF9CTvMrZXmze8= >>
	// ----------- >>
	private String username;

	@NotNull
	@Column(nullable = false)
	// ----------- << attribute.annotations@AAAAAAF9CTv7KpXtOHY= >>
	// ----------- >>
	private String password;

	@NotNull
	@Column(nullable = true)
	// ----------- << attribute.annotations@AAAAAAF9CTwsvJX0AbA= >>
	// ----------- >>
	private Date dateOfBirth;

	@NotNull
	@Column(nullable = true)
	// ----------- << attribute.annotations@AAAAAAF9CTx89JX7n5A= >>
	// ----------- >>
	private Long salary;

	@NotNull
	@Column(nullable = false)
	// ----------- << attribute.annotations@AAAAAAF9CYX29lqJGl8= >>
	// ----------- >>
	private Boolean isDeleted;

	// ----------- << getId.annotations@AAAAAAF9CThr25WiQC8= >>
	// ----------- >>
	public Long getId(){
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public Long getSalary() {
		return salary;
	}

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public User setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public User setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public User setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
		return this;
	}

	public User setSalary(Long salary) {
		this.salary = salary;
		return this;
	}

	public User setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
		return this;
	}

	// ----------- << equals.annotations@AAAAAAF9CThr25WiQC8= >>
	// ----------- >>
	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj)) return true;
		if (getId() == null) return false;
		return obj instanceof User && (getId().equals(((User) obj).getId()));
	}

	// ----------- << hashCode.annotations@AAAAAAF9CThr25WiQC8= >>
	// ----------- >>
	@Override
	public int hashCode() {
		return 218;
	}

// ----------- << class.extras@AAAAAAF9CThr25WiQC8= >>
// ----------- >>
}