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
@Table(name="GUARDIAN")
@ToString
public class Guardian extends BaseEntity{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
	private String guardian_id;
	
	@Getter @Setter
	@Column(name="first_name")
	private String firstName;
	
	@Getter @Setter
	@Column(name="last_name")
	private String lastName;
	
	@Getter @Setter
	@Column(name="contact_name_1")
	private String contactNumber1;
	
	@Getter @Setter
	@Column(name="contact_name_2")
	private String contactNumber2;
	
	@Getter @Setter
	@Column(name="home_address")
	private String homeAddress1;
	
	@Getter @Setter
	@Column(name="office_address")
	private String officeAddress;
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student student_ref;
}
