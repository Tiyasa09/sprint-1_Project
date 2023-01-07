package com.D_tech.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Management {
	
	@Id
	private int mid;
	
	@Column(length = 20, nullable = false)
	@Size(min = 2, message = "name should have atleast 3 characters")
	@NotBlank(message = "please Enter your name")
	private String mname;
	
	@Column(length = 6, nullable = false)
	@Size(min = 4, message = "gender should be male/female/other")
	@NotBlank(message = "please Enter your gender")
	private String mgender;
	
//    @Column(length = 20, nullable = false)
//	@Size(min = 3, message = "manager name should have atleast 3 characters")
//	@NotBlank(message = "please Enter your manager name")
//	private String manager;
	
	@Column(length = 11, nullable = false, unique = true)
	@NotNull(message = "please Enter employee phone number")
	private long mphone;
	
	@Column(length = 30, nullable = false, unique = true)
	@NotBlank(message = "please Enter employee email id")
	@Email
	private String memail;
	
//	@Column(length = 15, nullable = false, unique = true)
//	@NotNull(message = "please Enter your Aadhaar number")
//	private long mAadhaar;
	
	@Column(length = 20, nullable = false)
	@Size(min = 3, message = "city should have atleast 3 characters")
	@NotBlank(message = "please Enter your city")
	private String mcity;
	
	@Column(length = 10, nullable = false)
	@NotNull(message = "please Enter your salary")
	private double msalary;
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "management", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Student> student;
	
}
