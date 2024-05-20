package com.gl.springBootEmployeeManagementRestApi.repository;

import java.util.List;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.springBootEmployeeManagementRestApi.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
