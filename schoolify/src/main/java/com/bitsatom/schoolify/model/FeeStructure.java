package com.bitsatom.schoolify.model;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

public class FeeStructure extends BaseEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter
    private String fee_structure_id;
	
	@Setter @Getter
	@ManyToOne
	@JoinColumn(name="clazz_id")
	private ClazzOfStudent clazz;
	
	@Setter @Getter
	@ManyToOne
	@JoinColumn(name="type_id")
	private FeeTypes feetype;
	
	@Setter @Getter
	private float amount;
	
	@Setter @Getter
	private Date valid_till;
	
	@Setter @Getter
	private float late_fee_percent;

}
