package com.springwuelevateproject.hritik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springwuelevateproject.hritik.model.Student;

//repository that extends CrudRepository 
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	@Query(value="select * from student", nativeQuery = true)
	public List<Student> getAllRows();
}
