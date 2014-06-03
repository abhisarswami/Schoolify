package com.bitsatom.schoolify.dao;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.springframework.data.annotation.Id;
import org.springframework.hateoas.ResourceSupport;

import com.bitsatom.schoolify.model.User;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class UserResource {

	@ApiModel(value = "Student Model", description = "Student Model for creation of Student")
	@ToString
	public static final class NewUser {

		@ApiModelProperty(value = "User's details", required = true)
		@Getter
		private User user;

		public NewUser(final User user) {
			user.setId(0);
			this.user = user;
		}
	}

	@ApiModel(value = "User Model", description = "User Model for response of Student")
	public static final class UserResponse extends ResourceSupport {
		@ApiModelProperty(value = "User's details", required = true)
		@Getter
		private User user;

		public UserResponse(final User user) {
			this.user = user;
		}
	}

}
