package com.gl.springBootEmployeeManagementRestApi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usersTable")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Users {

	@Id
	@Column(name = "usersId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long usersId;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "userRoleMapping", joinColumns = {
			@JoinColumn(name = "user_Id", referencedColumnName = "usersId") }, inverseJoinColumns = {
					@JoinColumn(name = "role_Id", referencedColumnName = "roleId") })
	private List<Role> roles = new ArrayList<>();

}