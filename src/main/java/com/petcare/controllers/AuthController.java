package com.petcare.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petcare.payload.request.LoginRequest;
import com.petcare.payload.request.SignupRequest;
import com.petcare.payload.response.JwtResponse;
import com.petcare.payload.response.MessageResponse;
import com.petcare.services.IUserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	IUserService userService;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
		JwtResponse jwt = userService.signin(loginRequest);
		return ResponseEntity.ok(jwt);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
		String result = userService.signup(signUpRequest);
		return ResponseEntity.ok(new MessageResponse(result));
	}
}
