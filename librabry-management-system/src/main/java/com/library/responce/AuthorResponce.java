package com.library.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorResponce {

	private Integer aid;
	private String name;
	private String email;
	private Boolean deleted = false;
}
