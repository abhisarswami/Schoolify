package com.bitsatom.schoolify.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitsatom.schoolify.model.Clazz;

public interface ClazzRepository extends JpaRepository<Clazz, Integer> {

	

}
