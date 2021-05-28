package org.sid.entities;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Data @AllArgsConstructor @NoArgsConstructor @ToString



public class Patient {
	
	@Id @GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Temporal(TemporalType.DATE)
	
	@DateTimeFormat(pattern= "yyyy-MM-dd")
	private Date dateNaissance;
	private boolean malade;
	
	/* @DecimalMin=("4") */
	
	private int score;
	
	
	
	

}
