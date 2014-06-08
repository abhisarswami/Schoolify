package com.bitsatom.schoolify.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;

public class Clazz extends BaseEntity {
	@Id
	@Getter @Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
	
	@Getter @Setter
	private String name;
	
}
