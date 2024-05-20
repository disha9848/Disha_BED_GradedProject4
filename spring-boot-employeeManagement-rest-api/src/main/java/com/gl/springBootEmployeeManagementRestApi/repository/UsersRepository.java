package com.gl.springBootEmployeeManagementRestApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.springBootEmployeeManagementRestApi.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

	@Query("SELECT u FROM Users u WHERE u.username = ?1")
	public Users getUserByUsername(String username);

}