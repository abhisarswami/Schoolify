package com.bitsatom.schoolify.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitsatom.schoolify.model.ClazzOfStudent;

public interface ClazzRepository extends JpaRepository<ClazzOfStudent, Integer> {

	

}
