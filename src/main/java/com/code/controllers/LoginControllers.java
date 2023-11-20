package com.code.controllers;


import com.code.exception.LoginException;
import com.code.model.LogIn;
import com.code.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class LoginControllers {

	private final LoginService loginService;
	
	@PostMapping("/login")
	public ResponseEntity<String> loginHandler(@RequestBody LogIn loginData) throws LoginException {
		String login = loginService.logInAccount(loginData);
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
	
	@PatchMapping("/logout")
	public ResponseEntity<String> logOutFromAccount(@RequestParam String key) throws LoginException{
		String logout = loginService.logOutFromAccount(key);
		return new ResponseEntity<>(logout, HttpStatus.OK);
	}
	
	
	
}
