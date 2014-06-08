package com.bitsatom.schoolify.model;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
@Table(name = "SCHOOLIFY_USERS")
public class User extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter
	@Setter
	@Column(name = "id")
	private int id;

	@Setter
	@Getter
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Setter
	@Getter
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Setter
	@Getter
	@Column(nullable = false, unique = true)
	private String email;

	@Setter
	@Getter
	@Column(nullable = false)
	private String password;

	@Setter
	@Getter
	private Date dob;

	@Getter
	@Setter
	@ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<Role>();

	public User() {
	}

	public User(String firstName,String lastName, String email, String password, Date dob) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}

	public void addRoles(Role... roles) {
		this.roles.addAll(Arrays.asList(roles));
	}
	
	@Transient
    public String getName() {
        StringBuilder name = new StringBuilder();
        name.append(firstName);
        name.append(" ");
        name.append(lastName);
        return name.toString();
    }

}
