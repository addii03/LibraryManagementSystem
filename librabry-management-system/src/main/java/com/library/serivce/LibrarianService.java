package com.library.serivce;

import java.util.List;

import com.library.entity.Librarian;
import com.library.exception.ResorceNotFoundException;
import com.library.request.LibrarianRequest;
import com.library.responce.LibrarianResponce;

public interface LibrarianService {

	 LibrarianResponce saveLibrarian (LibrarianRequest librarianRequest);
	 List<LibrarianResponce>getAllLibrarian ();
	 LibrarianResponce getLibrarianById (int id) throws ResorceNotFoundException;
	// LibrarianResponce updateById (int id, LibrarianRequest librarianRequest);
	 void deletById (int id)throws ResorceNotFoundException;
	 
	 void softDeleteById(Integer id) throws ResorceNotFoundException;
	 
	 List<LibrarianResponce> findAllByDeleted();
	//List<LibrarianResponce> findAllByDeleted();
}
