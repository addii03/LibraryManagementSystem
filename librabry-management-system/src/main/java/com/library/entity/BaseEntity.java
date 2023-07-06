package com.library.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level= AccessLevel.PRIVATE)
public class BaseEntity {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Integer id;
//	
	@Column (name="created_on")
	@Temporal (TemporalType.TIMESTAMP)
	Date createdOn;
	
	@Column (name="updated_on")
	@Temporal(TemporalType.TIMESTAMP)
	Date updatedOn;
	
	@Column (name="deleted")
	Boolean deleted = false;
	
	@Column (name="active")
	Boolean active = true;
	
	@Column (name="created_by")
	Long createdBy;
	
	@Column (name="updated_by")
	Long updatedBy;
	
	@PrePersist
	public void prePersist() {
		if (createdOn == null) {
			createdOn = new Date(createdBy);
		}
	}

	@PreUpdate
	public void preUpdate() {
		updatedOn = new Date(createdBy);
	}
}
