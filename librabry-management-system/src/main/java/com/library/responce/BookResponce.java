package com.library.responce;

import com.library.entity.Author;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponce {

	private Integer bid;
	private String bname;
	private float price;
	boolean isdeleted =false;
	private Integer aid;
	private String name;
	private String email;
	
	//private Author author;
}
