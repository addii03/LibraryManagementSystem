package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.entity.Librarian;

@Repository
public interface LibrarianRepository extends JpaRepository<Librarian, Integer>{

	List<Librarian>findAllByDeleted (boolean deleted);
	
	@Query("select b from Librarian b where b.lname LIKE (%:query%) and b.id= :id")
	Librarian findByIdAllDeletedFalse (Integer id);

	
}
