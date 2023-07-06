package com.library.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Librarian;
import com.library.exception.ResorceNotFoundException;
import com.library.helper.LibrarianHelper;
import com.library.repository.LibrarianRepository;
import com.library.request.LibrarianRequest;
import com.library.responce.LibrarianResponce;
import com.library.serivce.LibrarianService;

@Service
public class LibrarianServiceImpl implements LibrarianService {

//	@Autowired 
//	private LibrarianRepository librarianRepository;

	@Autowired
	private LibrarianRepository librarianRepository;

	@Autowired
	private LibrarianHelper librarianHelper;

//	public LibrarianServiceImpl(LibrarianRepository librarianRepository, LibrarianHelper librarianHelper) {
//		this.librarianRepository = librarianRepository;
//		this.librarianHelper = librarianHelper;
//	}

	// save
	@Override
	public LibrarianResponce saveLibrarian(LibrarianRequest librarianRequest) {
	
		Librarian librarian = librarianHelper.toEntity(librarianRequest);
		this.librarianRepository.save(librarian);
		return librarianHelper.toDto(librarian);

//		Librarian librarian = librarianHelper.getRequest(librarianRequest);
//		Librarian librarian2 = librarianRepository.save(librarian);
//		return librarianHelper.getResponce(librarian2);
	}

//	//update
//	@Override
//	public LibrarianResponce updateById(int id, LibrarianRequest librarianRequest) {
//
//		Librarian librarian = librarianRepository.findById(id)
//				.orElseThrow(() -> new ResorceNotFoundException("Librarian", "id", id));
//		librarian.setLid(librarianRequest.getLid());
//		librarian.setLname(librarianRequest.getLname());
//		librarian.setAddress(librarianRequest.getAddress());
//		
//		librarianRepository.save(librarian);
//		return librarianHelper.getResponce(librarian);
//		
//		
//	}

	// get all
	@Override
	public List<LibrarianResponce> getAllLibrarian() {
		List<Librarian> librarianList = librarianRepository.findAll();
		List<LibrarianResponce> librarianResponces1 = librarianList.stream().map(l -> {
			LibrarianResponce librarianResponce2 = new LibrarianResponce(l.getLid(), l.getLname(), l.getAddress());
			return librarianResponce2;
		}).collect(Collectors.toList());
		return librarianResponces1;
	}

	@Override
	public LibrarianResponce getLibrarianById(int id) throws ResorceNotFoundException {
		Librarian librarian = librarianRepository.findById(id)
				.orElseThrow(() -> new ResorceNotFoundException("Librarian not found this id :: "+ id));
		LibrarianHelper librarianHelper = new LibrarianHelper();
		LibrarianResponce librarianResponce = librarianHelper.toDto(librarian);
		return librarianResponce;

	}

	@Override
	public void deletById(int id) throws ResorceNotFoundException {
		 librarianRepository.findById(id)
				.orElseThrow(() -> new ResorceNotFoundException("Librarian not found this id :: "+ id));
		librarianRepository.deleteById(id);

	}

	@Override
	public void softDeleteById(Integer id) throws ResorceNotFoundException {
		Librarian librarian = librarianRepository.findById(id).orElseThrow(()-> new ResorceNotFoundException("Librarian not found this id :: "+ id));
		librarian.setDeleted(true);
		librarianRepository.save(librarian);
		
	}

	@Override
	public List<LibrarianResponce> findAllByDeleted() {
		List<Librarian> findAllByDeleted = librarianRepository.findAllByDeleted(false);
		List<LibrarianResponce> librarianResponces1 = findAllByDeleted.stream().map(l -> {
			LibrarianResponce librarianResponce2 = new LibrarianResponce(l.getLid(), l.getLname(), l.getAddress());
			return librarianResponce2;
		}).collect(Collectors.toList());
		return librarianResponces1;
	}

}
