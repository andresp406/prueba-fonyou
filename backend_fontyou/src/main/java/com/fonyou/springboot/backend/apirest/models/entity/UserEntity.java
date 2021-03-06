package com.fonyou.springboot.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="users")
public class UserEntity implements Serializable{




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="user_name", unique=true, length=20)
	private String userName;

	@Column(length=60)
	private String password;
	
	private Boolean enabled;
	
	@JoinTable(name="users_roles", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns=@JoinColumn(name="role_id"),
			   uniqueConstraints= {@UniqueConstraint(columnNames= {"user_id", "role_id"})})
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	private List<RoleEntity> roles;
	
	
	
	public UserEntity() {
		this.roles = new ArrayList<>();
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Boolean getEnabled() {
		return enabled;
	}



	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}



	public List<RoleEntity> getRoles() {
		return roles;
	}



	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}



	private static final long serialVersionUID = 1L;

}
