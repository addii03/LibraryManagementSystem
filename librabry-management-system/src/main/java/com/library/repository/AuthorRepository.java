package com.library.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.entity.Author;
import com.library.entity.Book;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

	List<Author> findAllByDeleted(boolean deleted);

	@Query("select b from Author b where b.name LIKE (%:query%) and b.id= :id")
	Author findByIdAllDeletedFalse(Integer id);
}
