package org.sid;


import java.util.Date;

import org.sid.dao.PatientRepository;
import org.sid.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HopitalApplication implements CommandLineRunner{
  
	@Autowired
	private PatientRepository patientrepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HopitalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

		
		
		/*
		 * patientrepository.save(new Patient(null,"babani",new Date(),false,150));
		 * patientrepository.save(new Patient(null,"saddan",new Date(),false,350));
		 * patientrepository.save(new Patient(null,"diallo",new Date(),false,550));
		 */
		 
		
	}

}
