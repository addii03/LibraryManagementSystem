package com.library.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {

	private Integer aid;
	private String name;
	private String email;
	private Boolean deleted = false;
}
