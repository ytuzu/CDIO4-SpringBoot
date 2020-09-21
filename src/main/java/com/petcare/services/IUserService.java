package com.petcare.services;

import org.springframework.stereotype.Service;

import com.petcare.payload.request.LoginRequest;
import com.petcare.payload.request.SignupRequest;
import com.petcare.payload.response.JwtResponse;
@Service
public interface IUserService {
	JwtResponse signin(LoginRequest loginRequest);
	String signup(SignupRequest signUpRequest);
}
