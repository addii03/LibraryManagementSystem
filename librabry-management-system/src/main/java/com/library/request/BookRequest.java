package com.library.request;


//import com.library.validation.ValidateBookName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

	private Integer bid;
	//@ValidateBookName
	private String bname;
	private float price;
	boolean isdeleted = false;
	private Integer aid;
	private String name;
	private String email;
	
	
}
