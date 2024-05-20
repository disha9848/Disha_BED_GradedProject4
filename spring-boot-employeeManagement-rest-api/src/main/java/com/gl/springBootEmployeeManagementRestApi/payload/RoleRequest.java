package com.gl.springBootEmployeeManagementRestApi.payload;

import com.gl.springBootEmployeeManagementRestApi.entity.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RoleRequest {

	private Users usersWithRoles;

}
