/**
 * 
 */
package com.bitsatom.schoolify.dao.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.bitsatom.schoolify.controller.ClazzController;
import com.bitsatom.schoolify.dao.ClazzResource;
import com.bitsatom.schoolify.model.Clazz;

/**
 * @author 30155174
 * 
 */
@Component
public class ClazzResourceAssembler extends
		ResourceAssemblerSupport<Clazz, ClazzResource.ClazzResponse> {

	public ClazzResourceAssembler() {
		super(ClazzController.class, ClazzResource.ClazzResponse.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ClazzResource.ClazzResponse toResource(Clazz clazz) {
		ClazzResource.ClazzResponse resource = createResourceWithId(
				clazz.getId(), clazz);
		return resource;
	}

	@Override
	protected ClazzResource.ClazzResponse instantiateResource(
			Clazz clazz) {
		return new ClazzResource.ClazzResponse(clazz.getId(),
				clazz.getName());
	}

}
