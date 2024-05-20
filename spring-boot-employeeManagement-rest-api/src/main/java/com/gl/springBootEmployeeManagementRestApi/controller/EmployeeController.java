package com.gl.springBootEmployeeManagementRestApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.gl.springBootEmployeeManagementRestApi.entity.Employee;
import com.gl.springBootEmployeeManagementRestApi.payload.EmployeeDto;
import com.gl.springBootEmployeeManagementRestApi.payload.EmployeeResponse;
import com.gl.springBootEmployeeManagementRestApi.repository.EmployeeRepository;
import com.gl.springBootEmployeeManagementRestApi.service.EmployeeService;
import com.gl.springBootEmployeeManagementRestApi.utils.AppConstants;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// create employee post rest api
	@PostMapping("/create")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
	}

	// get all employees rest api
	@GetMapping
	public List<EmployeeDto> getAllEmployeesList() {
		return employeeService.getAllEmployeesList();
	}

	// get all employees rest api
	@GetMapping("/sort")
	public EmployeeResponse getAllEmployees(
			@RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
		return employeeService.getAllEmployees(pageNo, pageSize, sortBy, sortDir);
	}

	@GetMapping("/firstName/{firstName}")
	public ResponseEntity<List<Employee>> getAllByFirstName(@PathVariable(name = "firstName") String firstName) {
		return new ResponseEntity<List<Employee>>(employeeRepository.findAllByFirstName(firstName), HttpStatus.OK);
	}

	// get post by id
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable(name = "id") long id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}

	// update employee by id rest api
	@PutMapping("/update/{id}")
	public ResponseEntity<EmployeeDto> updatePost(@RequestBody EmployeeDto employeeDto,
			@PathVariable(name = "id") long id) {

		EmployeeDto employeeResponse = employeeService.updateEmployee(employeeDto, id);

		return new ResponseEntity<>(employeeResponse, HttpStatus.OK);
	}

	// delete employee rest api
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable(name = "id") long id) {

		employeeService.deleteEmployeeById(id);

		return new ResponseEntity<>("Delete employee id - " + id, HttpStatus.OK);

	}
}
