package com.gl.springBootEmployeeManagementRestApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.gl.springBootEmployeeManagementRestApi.entity.Role;
import com.gl.springBootEmployeeManagementRestApi.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	// fetching all roles
	public List<Role> getAllRoles() {
		List<Role> roles = (List<Role>) roleRepository.findAll();
		return roles;
	}

	// inserting role
	@PreAuthorize("hasAuthority('ADMIN')")
	public void addRoles(Role d) {
		roleRepository.save(d);
	}
//	

}
