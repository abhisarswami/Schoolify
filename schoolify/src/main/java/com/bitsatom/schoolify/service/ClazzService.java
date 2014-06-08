package com.bitsatom.schoolify.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitsatom.schoolify.model.Clazz;
import com.bitsatom.schoolify.persistence.ClazzRepository;

@Service
@Transactional(readOnly = true) 
public class ClazzService {

	private ClazzRepository repository;
	
	@Autowired
	public ClazzService(ClazzRepository repository) {
		this.repository = repository;
	}

	public List<Clazz> getClassList(){
		return repository.findAll();
	}
}
