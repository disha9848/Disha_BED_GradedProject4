package com.gl.springBootEmployeeManagementRestApi.service.impl;

import com.gl.springBootEmployeeManagementRestApi.entity.Employee;
import com.gl.springBootEmployeeManagementRestApi.exception.ResourceNotFoundException;
import com.gl.springBootEmployeeManagementRestApi.payload.EmployeeDto;
import com.gl.springBootEmployeeManagementRestApi.payload.EmployeeResponse;
import com.gl.springBootEmployeeManagementRestApi.repository.EmployeeRepository;
import com.gl.springBootEmployeeManagementRestApi.service.EmployeeService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;

	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		// convert DTO to entity
		Employee employee = mapToEntity(employeeDto);
		Employee newEmployee = employeeRepository.save(employee);

		// convert entity to DTO
		EmployeeDto employeeResponse = mapToDTO(newEmployee);
		return employeeResponse;
	}

	@Override
	public List<EmployeeDto> getAllEmployeesList() {
		List<Employee> employees = employeeRepository.findAll();
		return employees.stream().map(employee -> mapToDTO(employee)).collect(Collectors.toList());
	}

	@Override
	public EmployeeResponse getAllEmployees(int pageNo, int pageSize, String sortBy, String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		// create Pageable instance
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<Employee> employees = employeeRepository.findAll(pageable);

		// get content for page object
		List<Employee> listOfPosts = employees.getContent();

		List<EmployeeDto> content = listOfPosts.stream().map(employee -> mapToDTO(employee))
				.collect(Collectors.toList());

		EmployeeResponse employeeResponse = new EmployeeResponse();
		employeeResponse.setContent(content);
		employeeResponse.setPageNo(employees.getNumber());
		employeeResponse.setPageSize(employees.getSize());
		employeeResponse.setTotalElements(employees.getTotalElements());
		employeeResponse.setTotalPages(employees.getTotalPages());
		employeeResponse.setLast(employees.isLast());

		return employeeResponse;
	}

	@Override
	public EmployeeDto getEmployeeById(long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		return mapToDTO(employee);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
	@Override
	public EmployeeDto updateEmployee(EmployeeDto employeeDto, long id) {
		// get employee by id from the database
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());

		Employee updatedEmployee = employeeRepository.save(employee);
		return mapToDTO(updatedEmployee);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
	@Override
	public void deleteEmployeeById(long id) {
		// get post by id from the database
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
		employeeRepository.delete(employee);
	}

	public List<Employee> findAllByFirstName(String firstName) {
		return (List<Employee>) employeeRepository.findAllByFirstName(firstName);
	}

	// convert Entity into DTO
	private EmployeeDto mapToDTO(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setId(employee.getId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());
		employeeDto.setEmail(employee.getEmail());
		return employeeDto;
	}

	// convert DTO to entity
	private Employee mapToEntity(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setEmail(employeeDto.getEmail());
		return employee;
	}

}
