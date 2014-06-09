package com.bitsatom.schoolify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitsatom.schoolify.model.ClazzOfStudent;
import com.bitsatom.schoolify.persistence.ClazzRepository;

@Service
@Transactional(readOnly = true) 
public class ClazzService {

	private ClazzRepository repository;
	
	@Autowired
	public ClazzService(ClazzRepository repository) {
		this.repository = repository;
	}

	public List<ClazzOfStudent> getClassList(){
		return repository.findAll();
	}
}
