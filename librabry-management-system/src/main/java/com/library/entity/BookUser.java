package com.library.entity;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "book_users")
public class BookUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer book_user_id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "book_id")
	Book book;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "librarian_id")
	Librarian librarian;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	User user;
	
	@Column(name = "deleted")
	@ColumnDefault(value = "0")
	 boolean deleted = false;
}
