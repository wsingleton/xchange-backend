package com.xchange.models;

import java.io.Serializable;
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

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table(name="users")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // needed to avoid org.springframework.http.converter.HttpMessageNotWritableException
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="userID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;

	@Column(name="firstname")
	private String firstname;

	@Column(name="lastname")
	private String lastname;

	@Column(name="email", nullable=false, unique=true)
	private String email;

	@Column(name="username", nullable=false, unique=true)
	private String username;

	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="user_subscriptions",
			joinColumns=@JoinColumn(name="user1_id"),
			inverseJoinColumns=@JoinColumn(name="user2_id"))
	@JsonIgnore
	private Set<User> userSubscriptions;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="user_favorites",
			joinColumns=@JoinColumn(name="user_id"),
			inverseJoinColumns=@JoinColumn(name="company_id"))
	@JsonIgnore
	private Set<Company> userFavorites;


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userID) {
		this.userId = userID;
	}

	public String getUsername() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastName) {
		this.lastname = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<User> getUserSubscriptions() {
		return userSubscriptions;
	}

	public void setUserSubscriptions(Set<User> userSubscriptions) {
		this.userSubscriptions = userSubscriptions;
	}

	public Set<Company> getUserFavorites() {
		return userFavorites;
	}

	public void setUserFavorites(Set<Company> userFavorites) {
		this.userFavorites = userFavorites;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password="
				+ password + ", firstName=" + firstname + ", lastName=" + lastname + ", email=" + email + "]";
	}
	
}