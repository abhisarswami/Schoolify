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
import lombok.ToString;


@Entity
@Table(name="CLAZZ")
@ToString
@NoArgsConstructor
public class ClazzOfStudent extends BaseEntity {
	
	@Getter
	@Setter
	@Column(name = "clazz_id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
	
	@Getter @Setter
	private String name;
	
	public ClazzOfStudent(final String id, final String clazzName) {
		this.id = id;
		this.name = clazzName;
	}
	
	public ClazzOfStudent(final String clazzName) {
		this.name = clazzName;
	}
}
