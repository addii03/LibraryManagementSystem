package com.library.responce;

import com.library.entity.Book;
import com.library.entity.Librarian;
import com.library.entity.User;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookUserResponce {

	Integer book_user_id;
	boolean deleted = false;

	Integer bid;
	String bname;
	float price;
	Integer lid;
	String lname;
	String address;
	Integer uid;
	String uname;
	String email;
}
