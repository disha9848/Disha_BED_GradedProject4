package com.gl.springBootEmployeeManagementRestApi.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.gl.springBootEmployeeManagementRestApi.entity.Role;
import com.gl.springBootEmployeeManagementRestApi.service.RoleService;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	// displaying list of all roles
	@GetMapping
	public List<Role> getAllRole() {
		return roleService.getAllRoles();
	}

	// inserting role
	@PostMapping("/create")
	public void addRole(@RequestBody Role role) {
		roleService.addRoles(role);
	}

}
