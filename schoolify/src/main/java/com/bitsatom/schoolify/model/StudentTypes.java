package com.bitsatom.schoolify.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Entity
@Table(name="STUDENTS_TYPES")
@ToString
public class StudentTypes extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
    private String type_id;
	
	@Getter @Setter
	private String student_type;
}
