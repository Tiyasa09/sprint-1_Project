package com.D_tech.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	@Id
	private int sid;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "please Enter your firstname")
	@Size(min = 3, message = "firstname should have atleast 3 characters")
	private String sfname;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "please Enter your lastname")
	@Size(min = 3, message = " surname should have atleast 3 characters")
	private String slname;
	
	
	@Min(value=18, message = "Age should not be less than 18")
	@Max(value=30, message = "Age should not be greater than 30")
	@Column(length = 2, nullable = false)
	@NotNull(message = "please Enter your age")
	private int sage;
	
	
	@Column(length = 6, nullable = false)
	@Size(min = 4, message = "gender should be male/female/other")
	@NotBlank(message = "please Enter your gender")
	private String sgender;
	
	
	@Column(length = 30, nullable = false, unique = true)
	@NotBlank(message = "please Enter your email id")
	@Email
	private String semail;
	
	@Column(length = 11, nullable = false, unique = true)
	@NotNull(message = "please Enter your phone number")
	private long sphone;
	
	
	@Column(length = 50, nullable = false)
	@Size(min = 4, message = "address should have atleast 4 characters")
	@NotBlank(message = "please Enter your address")
	private String saddress;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "please Enter your highest education qualification")
	private String squalification;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="managementid", referencedColumnName = "mid")
	@JsonBackReference
	private Management management;
	
}
