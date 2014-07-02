package com.bitsatom.schoolify.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@Entity
@Table(name="STUDENTS")
@ToString
public class Student extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter
	@JoinColumn(name="student_id")
    private String id;
	
	@Setter @Getter
	@Column(name="first_name")
    private String firstName;
	
	@Setter @Getter
	@Column(name="last_name")
	private String lastName;
	
	@Setter @Getter
	@ManyToOne
	@JoinColumn(name="clazz_id")
	private ClazzOfStudent clazzId_ref;
	
	@Setter @Getter
	@ManyToOne
	@JoinColumn(name="type_id")
	private StudentTypes studentType_ref;
    
	public Student(final String firstName, final String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}

}
