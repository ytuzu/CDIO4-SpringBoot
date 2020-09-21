package com.petcare.entities;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(	name = "users", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username")
		})
public class User extends BaseEntity{

	@NotBlank
	private String username;

	@NotBlank
	private String fullname;

	@NotBlank
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	/*
	@NotBlank
	private Boolean isRemember;
	
	@NotBlank
	private Boolean status;
	*/
	
	public User() {
	}

	public User(String username, String fullname, String password) {
		this.username = username;
		this.fullname = fullname;
		this.password = password;
	}

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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
/*
	public Boolean getIsRemember() {
		return isRemember;
	}

	public void setIsRemember(Boolean isRemember) {
		this.isRemember = isRemember;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	*/
}
