package com.gl.springBootEmployeeManagementRestApi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gl.springBootEmployeeManagementRestApi.entity.Role;
import com.gl.springBootEmployeeManagementRestApi.entity.Users;
import com.gl.springBootEmployeeManagementRestApi.repository.RoleRepository;
import com.gl.springBootEmployeeManagementRestApi.repository.UsersRepository;
import com.gl.springBootEmployeeManagementRestApi.service.UsersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UsersController {

	@Autowired
	UsersRepository usersWithRolesRepository;

	@Autowired
	RoleRepository rolesRepository;

	UsersService userService;

	public UsersController(UsersRepository usersWithRolesRepository, RoleRepository rolesRepository) {
		this.usersWithRolesRepository = usersWithRolesRepository;
		this.rolesRepository = rolesRepository;

	}

	@PostMapping("/create")
	public Users saveStudentWithCourse(@RequestBody Users student) {
		return usersWithRolesRepository.save(student);
	}

	@GetMapping
	public List<Users> findALlStudents() {
		return usersWithRolesRepository.findAll();
	}

	@PostMapping("/save")
	public Users createUser(@Valid @RequestBody Users user) {
		return userService.createUser(user);
	}

}
