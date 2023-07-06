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
@Table(name="Authors")
public class Author {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer aid;
	
	@Column(name ="name")
	private String name;
	
	@Column(name ="email")
	private String email;
	
	@Column(name = "deleted")
	@ColumnDefault(value = "0")
	private Boolean deleted = false;

}
