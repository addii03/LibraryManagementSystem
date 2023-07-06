package com.library.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.entity.Librarian;
import com.library.repository.LibrarianRepository;
import com.library.request.LibrarianRequest;
import com.library.responce.LibrarianResponce;

@Component
public class LibrarianHelper {

	@Autowired
	LibrarianRepository librarianRepository;

	public Librarian toEntity(LibrarianRequest libraryRequest) {
		Librarian librarian = new Librarian();
		if (libraryRequest.getLid() != null) {
			librarian = this.librarianRepository.findById(libraryRequest.getLid())
					.orElseThrow(() -> new RuntimeException("Librarian not found"));
		}

		// librarian.setLid(libraryRequest.getLid());
		librarian.setLname(libraryRequest.getLname());
		librarian.setAddress(libraryRequest.getAddress());
		return librarian;

	}

	public LibrarianResponce toDto(Librarian librarian) {
		LibrarianResponce librarianResponce = new LibrarianResponce();
		librarianResponce.setLid(librarian.getLid());
		librarianResponce.setLname(librarian.getLname());
		librarianResponce.setAddress(librarian.getAddress());
		return librarianResponce;
	}
}
