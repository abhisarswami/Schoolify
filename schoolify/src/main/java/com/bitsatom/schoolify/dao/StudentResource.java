package com.bitsatom.schoolify.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class StudentResource {

	@ApiModel(value = "Student Model", description = "Student Model for creation of Student")
	@ToString
	public static final class NewStudent {
		@ApiModelProperty(value = "Student's first name", required = true)
		@Getter
		private String firstName;
		@ApiModelProperty(value = "Student's last name", required = true)
		@Getter
		private String lastName;
		@ApiModelProperty(value = "Student's class", required = true)
		@Setter @Getter
		private String clazzId;
		
		public NewStudent(final String firstName, final String lastname) {
			this.firstName = firstName;
			this.lastName = lastname;
		}
	}

	@ApiModel(value = "Student Model", description = "Student Model for response of Student")
	public static final class StudentResponse extends ResourceSupport {
		@ApiModelProperty(value = "Student's Id", required = true)
		private @Id
		String id;

		@ApiModelProperty(value = "Student's first name", required = true)
		@Getter
		private String firstName;
		@ApiModelProperty(value = "Student's last name", required = true)
		@Getter
		private String lastName;
		
		@ApiModelProperty(value = "Student's class", required = true)
		@Setter @Getter
		private String clazzId;

		public StudentResponse(final String id, final String firstName,
				final String lastname) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastname;
		}
	}

}
