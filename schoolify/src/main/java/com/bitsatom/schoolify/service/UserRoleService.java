package com.bitsatom.schoolify.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitsatom.schoolify.model.Role;
import com.bitsatom.schoolify.persistence.RoleRepository;

@Service
@Transactional(readOnly = true)
public class UserRoleService {

	private RoleRepository roleRepository;
	
	@Inject
	public UserRoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	@Transactional
	public Role createRole(Role role){
		return roleRepository.save(role);
	}

	public List<Role> findAll(){
		return roleRepository.findAll();
	}
	
	public Role getRole(String roleName){
		return roleRepository.findByRoleName(roleName);
	}
}
