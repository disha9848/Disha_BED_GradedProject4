package com.gl.springBootEmployeeManagementRestApi.payload;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class RoleResponse {

	private int id;
	private String roleName;

	public RoleResponse(int id, String roleName) {
		this.id = id;
		this.roleName = roleName;
	}

	private int price;

}
