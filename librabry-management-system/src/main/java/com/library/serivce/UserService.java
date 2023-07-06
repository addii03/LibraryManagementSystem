package com.library.serivce;

import java.util.List;

import com.library.exception.ResorceNotFoundException;
import com.library.request.UserRequest;
import com.library.responce.UserResponce;

public interface UserService {

	UserResponce saveUser(UserRequest userRequest);
	List<UserResponce>getAllUsers();
	UserResponce getUserById(int id) throws ResorceNotFoundException;
	void deleteById (int id) throws ResorceNotFoundException;
	
	void softDelete(Integer id) throws ResorceNotFoundException;
	List<UserResponce> findAllByDeleted ();
}
