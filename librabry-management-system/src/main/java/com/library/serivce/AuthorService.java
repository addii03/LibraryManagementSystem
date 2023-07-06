package com.library.serivce;

import java.util.List;

import com.library.exception.ResorceNotFoundException;
import com.library.request.AuthorRequest;
import com.library.responce.AuthorResponce;

public interface AuthorService {

	AuthorResponce saveAuthors(AuthorRequest authorRequest) throws ResorceNotFoundException;
	List< AuthorResponce >getAllAuthors();
	AuthorResponce FindById(Integer id) throws ResorceNotFoundException;
	void deleteById(Integer id) throws ResorceNotFoundException;
	
	void softDeleteById(Integer id) throws ResorceNotFoundException;
	List<AuthorResponce>findByIdAllDeletedFalse();
}
