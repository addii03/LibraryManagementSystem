package com.library.responce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponce {

	private Integer Uid;
	private String Uname;
	private String email;
	private Boolean deleted = false;
}
