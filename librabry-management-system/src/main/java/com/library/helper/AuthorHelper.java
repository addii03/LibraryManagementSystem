package com.library.helper;

import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.library.entity.Author;
import com.library.exception.ResorceNotFoundException;
import com.library.repository.AuthorRepository;
import com.library.request.AuthorRequest;
import com.library.responce.AuthorResponce;

@Component
public class AuthorHelper {

	@Autowired
	AuthorRepository authorRepository;

	public Author toEntity(AuthorRequest authorRequest) throws ResorceNotFoundException {
		Author author = new Author();
		if (authorRequest.getAid() != null) {
			author = authorRepository.findById(authorRequest.getAid())
					.orElseThrow(() -> new ResorceNotFoundException("Author Not Found"));
		}

		author.setAid(authorRequest.getAid());
		author.setEmail(authorRequest.getEmail());
		author.setName(authorRequest.getName());
		return author;

	}

	public AuthorResponce toDto(Author author) {
		AuthorResponce authorResponce = new AuthorResponce();
		authorResponce.setAid(author.getAid());
		authorResponce.setName(author.getName());
		authorResponce.setEmail(author.getEmail());
		return authorResponce;

	}

}
