package com.cognizant.menuitem.model;

import java.util.Set;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
@Table(name = "user")
public class User {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(User.class);
	
	//@NotNull
	//@Size(min=3, max=20, message="minimium 3 characters required")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="us_id")
	private int id;
	
	@Column(name="us_first_name")
	private String firstName;
	
	@NotNull
	@Size(min=2, max=20, message="minimium 2 characters required")
	@Column(name="us_last_name")
	private String lastName;
	
	@NotNull
	@Size(min=2, max=20, message="minimium 2 characters required")
	@Column(name="us_name")
	private String userName;
	
	@NotNull
	@Column(name="us_password")
	private String password;
	
	@ManyToMany(fetch=  FetchType.EAGER)
    @JoinTable(name = "cart",
        joinColumns = @JoinColumn(name = "ct_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ct_me_id"))
	private Set<MenuItem> menuItemList;
	
	@ManyToMany(fetch=  FetchType.EAGER)
    @JoinTable(name = "user_role",
        joinColumns = @JoinColumn(name = "ur_us_id"), 
        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	private Set<Role> userRoleList;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	
	public Set<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(Set<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public Set<Role> getUserRoleList() {
		return userRoleList;
	}
	public void setUserRoleList(Set<Role> userRoleList) {
		this.userRoleList = userRoleList;
	}
		
	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName
				+ ", password=" + password + ", menuItemList=" + menuItemList + ", userRoleList=" + userRoleList + "]";
	}
	
}
