package com.library.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

	private Integer Uid;
	private String Uname;
	private String email;
	private Boolean deleted = false;
}
