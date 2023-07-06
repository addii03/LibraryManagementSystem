package com.library.entity;

import org.hibernate.annotations.DialectOverride.Where;
import org.hibernate.annotations.DialectOverride.Wheres;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

//import com.library.validation.ValidateBookName;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Books")

public class Book extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bid;

	@Column(name = "book tittle")
	
	private String bname;

	@Column(name = "book price")
	private float price;

	@Column(name = "deleted")
	@ColumnDefault(value = "0")
	private boolean deleted = false;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="author_id")
	private Author author;
	

}
