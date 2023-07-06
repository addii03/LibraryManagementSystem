package com.library.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Author;
import com.library.exception.ResorceNotFoundException;
import com.library.helper.AuthorHelper;
import com.library.repository.AuthorRepository;
import com.library.request.AuthorRequest;
import com.library.responce.AuthorResponce;
import com.library.serivce.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private AuthorHelper authorHelper;

	// save and update
	@Override
	public AuthorResponce saveAuthors(AuthorRequest authorRequest) throws ResorceNotFoundException {

		Author author = authorHelper.toEntity(authorRequest);
		authorRepository.save(author);
		return authorHelper.toDto(author);
	}

	@Override
	public List<AuthorResponce> getAllAuthors() {
		List<Author> authors = authorRepository.findAll();
		List<AuthorResponce> authorResponces = authors.stream().map(a -> {
			AuthorResponce authorResponce1 = new AuthorResponce(a.getAid(), a.getName(), a.getEmail(), false);
			return authorResponce1;
		}).collect(Collectors.toList());
		return authorResponces;
	}

	@Override
	public AuthorResponce FindById(Integer id) throws ResorceNotFoundException {
		Author author = authorRepository.findById(id)
				.orElseThrow(() -> new ResorceNotFoundException("Author Not Present with This Id :" + id));
		AuthorResponce authorResponce = authorHelper.toDto(author);
		return authorResponce;

	}

	@Override
	public void deleteById(Integer id) throws ResorceNotFoundException {
		Author author = authorRepository.findById(id)
				.orElseThrow(() -> new ResorceNotFoundException("Author Not Present with This Id :" + id));
		authorRepository.deleteById(id);

	}

	@Override
	public void softDeleteById(Integer id) throws ResorceNotFoundException {
		Author author = authorRepository.findById(id)
				.orElseThrow(() -> new ResorceNotFoundException("Author Not Present with This Id :" + id));
		author.setDeleted(true);
		authorRepository.save(author);

	}

	@Override
	public List<AuthorResponce> findByIdAllDeletedFalse() {
		List<Author> findAllByDeleted = authorRepository.findAllByDeleted(false);
		List<AuthorResponce> authorResponces = findAllByDeleted.stream().map(a -> {
			AuthorResponce authorResponce1 = new AuthorResponce(a.getAid(), a.getName(), a.getEmail(), false);
			return authorResponce1;
		}).collect(Collectors.toList());
		return authorResponces;
	}

}
