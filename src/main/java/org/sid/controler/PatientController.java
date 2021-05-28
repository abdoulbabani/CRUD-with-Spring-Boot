package org.sid.controler;

import java.util.List;
import java.util.Optional;

import org.sid.dao.PatientRepository;
import org.sid.entities.DecimalMin;
import org.sid.entities.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller

public class PatientController {
	@Autowired
	private PatientRepository patientrepository;
	
	
	@GetMapping(path="/index")

	public  String totalite(Model model,
			@RequestParam(name="Motcle",defaultValue="") String Motcle,
		    @RequestParam(name="page",defaultValue="0") int page,
		    @RequestParam(name="size", defaultValue="5") int size) {
		
		   Page <Patient> patient =patientrepository.findByNameContains(Motcle, PageRequest.of(page, size));
	 
	model.addAttribute("page", new int[patient.getTotalPages()]);
	model.addAttribute("currentPage", page);
	model.addAttribute("size",size);
	model.addAttribute("Motcle",Motcle);
	 
	model.addAttribute("patient", patient);
	
	return "index";
		
	}
	
	
	@GetMapping(path= "/delesupprimer")
	  
	 public String suppression(Long id,String Motcle,int page,int size,Model model) {
	 
	 patientrepository.deleteById(id);
	 
	 return "redirect:/index?Motcle="+Motcle+"&page="+page+"&size="+size;
	
	}
	
	/*
	 * @GetMapping(path= "/delesupprimer")
	 * 
	 * public String suppression(Long id,String Motcle,int page,int size,Model
	 * model) {
	 * 
	 * patientrepository.deleteById(id);
	 * 
	 * return totalite(model, Motcle,page,size);
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 */
	
	@GetMapping(path= "/Update")
	  
	 public String Update(Long id, Model model) {
		
		
		
		model.addAttribute("patient",patientrepository.findById(id).get());
	 
	return "editer";
	
	}
	
	@GetMapping(path= "/Ajouter")
	
	public String chercher(Model model) {
		
		model.addAttribute("patient", new Patient());
		
		return "Ajouter";
				
				
				
	}
	
	@PostMapping(path= "/save")
	
	public String savep(Patient patient,Model model) {
		
		patientrepository.save(patient);
		
		model.addAttribute("patient", patient);
		
		/* return "index"; */
		
		 return "ConfirmationAjouter";
				
				
	}
	
	
	

}
