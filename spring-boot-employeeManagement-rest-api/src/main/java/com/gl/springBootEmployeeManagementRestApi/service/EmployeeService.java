package com.gl.springBootEmployeeManagementRestApi.service;

import java.util.List;
import java.util.Optional;

import com.gl.springBootEmployeeManagementRestApi.entity.Employee;
import com.gl.springBootEmployeeManagementRestApi.payload.EmployeeDto;
import com.gl.springBootEmployeeManagementRestApi.payload.EmployeeResponse;

public interface EmployeeService {

	EmployeeDto createEmployee(EmployeeDto employeeDto);

	List<EmployeeDto> getAllEmployeesList();

	EmployeeResponse getAllEmployees(int pageNo, int pageSize, String sortBy, String sortDir);

	List<Employee> findAllByFirstName(String firstName);

	EmployeeDto getEmployeeById(long id);

	EmployeeDto updateEmployee(EmployeeDto employeeDto, long id);

	void deleteEmployeeById(long id);

}
