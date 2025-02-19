package com.nit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="EMPLOYEE_MANAGEMENT_SYSTEM")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Integer id;
	@Column(length = 30)
	private String firstName;
	@Column(length = 30)
	private String lastName;
	@Column(length = 60)
	private String email;
	@Column(length = 10)
	private Long mobileNo;
	@Column(length = 30)
	private String address;
	@Column(length = 30)
	private String job;
	private Double salary;
	@Column(length = 4)
	private int departmentNo;
}
