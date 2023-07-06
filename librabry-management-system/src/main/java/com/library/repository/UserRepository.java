package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.entity.Book;
import com.library.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findAllByDeleted(boolean deleted);

	@Query("select b from User b where b.uname LIKE (%:query%) and b.id= :id")
	User findByIdAllDeletedFalse(Integer id);
}
