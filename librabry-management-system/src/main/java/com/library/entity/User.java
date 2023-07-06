package com.library.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // automatically generate unique identifier values for entities
														// or database records.
	private Integer uid;

	@Column(name = "user name")
	private String uname;

	@Column(name = "user email")
	private String email;

	@Column(name = "deleted")
	@ColumnDefault(value = "0")
	private boolean deleted = false;
	
}
