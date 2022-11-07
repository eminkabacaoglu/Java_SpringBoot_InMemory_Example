package kodlama.io.programmingLangs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programmingLangs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.programmingLangs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.programmingLangs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService{

	ProgrammingLanguageRepository programmingLanguageRepository;

	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		this.programmingLanguageRepository = programmingLanguageRepository;
	}
	
	@Override
	public String getAll() {
		if(!programmingLanguageRepository.getAll().isEmpty()) {
			return programmingLanguageRepository.getAll().toString();
		}
		return "Kayıt Bulunamadı";

	}

	@Override
	public String insertLang(String name) {
		if(isNameNull(name)) {
			return " Dil adı boş olamaz...";
		}
		else {
			if(programmingLanguageRepository.isNotContaining(name)) {
				programmingLanguageRepository.insertLang(name);
				return name+" Başarıyla kaydedildi";
		}
			
		else {
				return name+" bu isimde dil mevcut";
		}
		}
		
	}

	@Override
	public String deleteLang(int id) {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findLanguageById(id);
		if(programmingLanguage!=null) {
			programmingLanguageRepository.deleteLang(programmingLanguage);
			return id+" id'li dil silindi";
		}
		return id+" id'li dil bulunamadı";
		
	}

	@Override
	public String updateLang(int id,String name) {
		if(isNameNull(name)) {
			return " Dil adı boş olamaz...";
		}
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findLanguageById(id);
		if(programmingLanguage!=null) {
			programmingLanguageRepository.updateLang(programmingLanguage,name);
			return id+" id'li dil güncellendi";
		}
		return id+" id'li dil bulunamadı";
		
	}

	@Override
	public String findLanguageById(int id) {
		ProgrammingLanguage programmingLanguage = programmingLanguageRepository.findLanguageById(id);
		if(programmingLanguage != null) {
			return programmingLanguage.toString();
		}
		return  id+" id'li kayıt bulunamadı";
	}

	@Override
	public boolean isNameNull(String name) {
		if(name.isEmpty()) {
			return true;
		}
		return false;
	}

	
	
	
}
