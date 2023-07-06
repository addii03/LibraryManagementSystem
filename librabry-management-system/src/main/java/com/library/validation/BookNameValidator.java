//package com.library.validation;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.library.repository.BookRepository;
//
//public class BookNameValidator implements ConstraintValidator<ValidateBookName, String> {
//
//	@Autowired
//	BookRepository bookRepository;
//
//	@Override
//	public void initialize(ValidateBookName constraintAnnotation) {
//
//	}
//
//	@Override
//	public boolean isValid(String bname, ConstraintValidatorContext context) {
//		System.out.println("in validatior <<<<<<<");
//		boolean status = bookRepository.existsBookByBname(bname);
//		return status;
//	}
//
//}
