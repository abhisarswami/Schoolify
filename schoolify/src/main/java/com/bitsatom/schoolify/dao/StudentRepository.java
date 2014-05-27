package com.bitsatom.schoolify.dao;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.bitsatom.schoolify.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

    public Student findByFirstName(String firstName);
    public List<Student> findByLastName(String lastName);

}
