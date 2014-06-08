package com.bitsatom.schoolify.dao;

import lombok.Getter;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class ClazzResource {

	@ApiModel(value = "Class Model", description = "Class Model for response of class")
	public static final class ClazzResponse extends ResourceSupport {
		@ApiModelProperty(value = "Student's Id", required = true)
		private @Id
		String id;

		@ApiModelProperty(value = "Class name", required = true)
		@Getter
		private String clazzName;
		

		public ClazzResponse(final String id, final String clazzName) {
			this.id = id;
			this.clazzName = clazzName;
		}
	}

}
