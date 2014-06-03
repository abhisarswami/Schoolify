/**
 * 
 */
package com.bitsatom.schoolify.dao.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.bitsatom.schoolify.controller.UserController;
import com.bitsatom.schoolify.dao.StudentResource;
import com.bitsatom.schoolify.dao.UserResource;
import com.bitsatom.schoolify.model.User;

/**
 * @author 30155174
 * 
 */
@Component
public class UserResourceAssembler extends
		ResourceAssemblerSupport<User, UserResource.UserResponse> {

	public UserResourceAssembler() {
		super(UserController.class, UserResource.UserResponse.class);
	}

	@Override
	public UserResource.UserResponse toResource(User user) {
		UserResource.UserResponse resource = createResourceWithId(
				user.getId(), user);
		return resource;
	}

	@Override
	protected UserResource.UserResponse instantiateResource(
			User user) {
		return new UserResource.UserResponse(user);
	}

}
