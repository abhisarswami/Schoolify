package com.bitsatom.schoolify.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="SCHOOLIFY_USERS")
public class User 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	private int id;
	
	@Setter @Getter
	private String name;
	
	@Setter @Getter
	@Column(nullable=false, unique=true)
	private String email;
	
	@Setter @Getter
	@Column(nullable=false)
	private String password;
	
	@Setter @Getter
	private Date dob;
	
	@Getter @Setter
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Set<Role> roles = new HashSet<Role>();

	public User() {
	}

	public User(int id, String name, String email, String password, Date dob) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}

	public User(String name, String email, String password, Date dob) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
	}
	

}
