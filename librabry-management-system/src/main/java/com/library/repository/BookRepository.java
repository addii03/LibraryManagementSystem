package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.library.entity.Book;
import com.library.responce.BookResponce;

import jakarta.transaction.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findAllByDeleted(boolean deleted);

	//@Query("SELECT p FROM Book p WHERE p.bname LIKE CONCAT('%',:query, '%')")
	
  @Query("select b from Book b where b.bname LIKE (%:query%) and b.id= :id")

	Book findByIdAllDeletedFalse(  Integer id);

	//Boolean existsBookByBname(String bname);
	
	List<Book> findByBnameLike(String bname);

	// List<Book> getAllBooks();

//	@Modifying
//	@Transactional
//	@Query(value = "update Book set deleted = true where id = ?1")
//	void doSoftDelete(Integer id);

	// List<Book> searchBook(String query);
}
