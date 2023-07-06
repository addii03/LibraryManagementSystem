package com.library.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.BookUser;
import com.library.exception.ResorceNotFoundException;
import com.library.helper.BookHelper;
import com.library.helper.BookUserHelper;
import com.library.repository.BookRepository;
import com.library.repository.BookUserRepository;
import com.library.request.BookUserRequest;
import com.library.responce.BookUserResponce;
import com.library.serivce.BookUserService;

@Service
public class BookUserServiceImpl implements BookUserService {

	@Autowired
	BookUserHelper bookUserHelper;
	@Autowired
	BookUserRepository bookUserRepository;

	@Override
	public BookUserResponce saveBookUsers(BookUserRequest bookUserRequest) throws ResorceNotFoundException {
		BookUser bookUser = bookUserHelper.toEntity(bookUserRequest);
		bookUserRepository.save(bookUser);
		return bookUserHelper.toDto(bookUser);
	}

	@Override
	public List<BookUserResponce> getAllBookUsers() {
		List<BookUser> list = bookUserRepository.findAll();
		return list.stream().map(bookUserHelper::toDto).collect(Collectors.toList());

	}

	@Override
	public BookUserResponce getBookUsersById(Integer id) {
		BookUser bookUser = bookUserRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("BookUser Not Found"));
		return bookUserHelper.toDto(bookUser);

	}

	@Override
	public void deleteById(Integer id) throws ResorceNotFoundException {
		 bookUserRepository.findById(id).orElseThrow(() -> new ResorceNotFoundException("book user not found"));
		
		bookUserRepository.deleteById(id);
	}

	@Override
	public void softDeleteById(Integer id) throws ResorceNotFoundException {
		BookUser bookUser = bookUserRepository.findById(id).orElseThrow(()-> new ResorceNotFoundException("BookUser Id not Found" + id));
		bookUser.setDeleted(true);
		bookUserRepository.save(bookUser);
	}

}
