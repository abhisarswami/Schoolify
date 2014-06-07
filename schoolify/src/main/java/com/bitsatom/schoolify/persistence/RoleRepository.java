package com.bitsatom.schoolify.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bitsatom.schoolify.model.Role;
import com.bitsatom.schoolify.model.User;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {

	public abstract Role findByRoleName(String rolename);
}
