package com.gl.springBootEmployeeManagementRestApi.service;

import com.gl.springBootEmployeeManagementRestApi.payload.LoginDto;

public interface AuthService {

	String login(LoginDto loginDto);

}
