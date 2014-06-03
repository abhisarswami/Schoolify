package com.bitsatom.schoolify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Entity
@Table(name="STUDENTS")
public class Student{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
    private String id;
	
	@Setter @Getter
	@Column(name="first_name")
    private String firstName;
	
	@Setter @Getter
	@Column(name="last_name")
	private String lastName;
	
	@Setter @Getter
	private String clazzId;
    
	public Student(final String firstName, final String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
