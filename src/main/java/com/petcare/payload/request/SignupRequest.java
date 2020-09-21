package com.petcare.payload.request;

import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {
	@NotBlank
    private String username;
 
    @NotBlank
    private String fullname;
    
    private Set<String> role;
    
    @NotBlank
    private String password;
  
    public String getUsername() {
        return username;
    }
 
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Set<String> getRole() {
      return this.role;
    }
    
    public void setRole(Set<String> role) {
      this.role = role;
    }
}
