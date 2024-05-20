package com.gl.springBootEmployeeManagementRestApi.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gl.springBootEmployeeManagementRestApi.entity.Users;
import com.gl.springBootEmployeeManagementRestApi.repository.RoleRepository;
import com.gl.springBootEmployeeManagementRestApi.repository.UsersRepository;

import jakarta.validation.Valid;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersWithRolesRepository;

	@Autowired
	private RoleRepository roleRepository;

	// fetching all employees
	public List<Users> getAllUsers() {
		List<Users> emps = (List<Users>) usersWithRolesRepository.findAll();
		return emps;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	public Users createUser(@Valid @RequestBody Users user) {

		user.setRoles(new ArrayList<>(roleRepository.findAll()));
		return usersWithRolesRepository.save(user);
	}

}
