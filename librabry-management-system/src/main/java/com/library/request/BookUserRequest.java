package com.library.request;

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
public class BookUserRequest {

	Integer book_user_id;
	
	Integer bid;
	String bname;
	float price;
	Integer lid;
	String lname;
	String address;
	Integer uid;
	String uname;
	String email;
	boolean deleted;
}
