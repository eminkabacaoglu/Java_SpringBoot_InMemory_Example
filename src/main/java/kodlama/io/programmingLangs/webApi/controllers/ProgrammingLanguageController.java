package kodlama.io.programmingLangs.webApi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programmingLangs.business.abstracts.ProgrammingLanguageService;

@RestController
@RequestMapping("api/languages")
public class ProgrammingLanguageController {
	
	ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguageController(ProgrammingLanguageService programmingLanguageService) {
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public String getAll() {
		return programmingLanguageService.getAll();
	}
	
	@DeleteMapping("/delete")
	public String delete(@RequestParam int id) {
		return programmingLanguageService.deleteLang(id);
	}
	
	@PutMapping("/update")
	public String update(@RequestParam int id,@RequestParam String name) {
		return programmingLanguageService.updateLang(id,name);
	}
	
	@GetMapping("/getlang")
	public String getLang(@RequestParam int id) {
		return programmingLanguageService.findLanguageById(id);
	}
	
	@PostMapping("/addlang")
	public String insertLang(@RequestParam String name) {
		return programmingLanguageService.insertLang(name);
		
	}
	

}
