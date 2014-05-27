package com.bitsatom.schoolify.model;

import lombok.Getter;
import lombok.Setter;

import org.springframework.hateoas.ResourceSupport;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;


@ApiModel(value = "Student Model", description = "Student Model")
public class Student extends ResourceSupport{

	@ApiModelProperty(value = "id", required = true)
    private String id;

	@ApiModelProperty(value = "Student's first name", required = true)
	@Setter @Getter
    private String firstName;
	@ApiModelProperty(value = "Student's last name", required = true)
	@Setter @Getter
	private String lastName;

    
}
