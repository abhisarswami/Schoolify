package com.bitsatom.schoolify.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@ToString
@Entity
@Table(name = "SCHOOLIFY_ROLES")
public class Role implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@Getter @Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Getter @Setter
	@Column(name="role_name",nullable=false)
	private String roleName;
	
	
	
	
	public Role() {
	}

	public Role(String roleName) {
		this.roleName = roleName;
	}
	public Role(Integer id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}
	
}
