//package com.library.validation;
//
//import java.lang.annotation.Documented;
//import java.lang.annotation.ElementType;
//import java.lang.annotation.Retention;
//import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//
//@Target({ElementType.FIELD,ElementType.TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Constraint(validatedBy = BookNameValidator.class)
//public @interface ValidateBookName {
//
//	//error message
//	String message() default "Book is already registered";
//	
//	//represent group of constraint
//	 Class<?>[] groups() default {};
//	 
//	   //additional information abaout annotation
//	 Class<? extends Payload>[] payload() default {};
//}
