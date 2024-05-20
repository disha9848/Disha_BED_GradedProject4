package com.gl.springBootEmployeeManagementRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

import com.gl.springBootEmployeeManagementRestApi.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	List<Employee> findAllByFirstName(String firstName);

}
