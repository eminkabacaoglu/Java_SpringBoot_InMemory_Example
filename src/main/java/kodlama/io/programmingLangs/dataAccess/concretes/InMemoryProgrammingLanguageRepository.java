package kodlama.io.programmingLangs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.programmingLangs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.programmingLangs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository{

	List<ProgrammingLanguage> programmingLanguages;
	
	
	
	
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages = new ArrayList<>();
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguages;
	}

	@Override
	public void insertLang(String name) {
		int indexNo;
		if(programmingLanguages.size()==0) {
			indexNo=1;
		}
		else {
			indexNo=programmingLanguages.get(programmingLanguages.size()-1).getId()+1;
		}
		
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(indexNo,name);
		programmingLanguages.add(programmingLanguage);
		
	}

	@Override
	public void deleteLang(ProgrammingLanguage programmingLanguage) {
		programmingLanguages.remove(programmingLanguage);
	
	}

	@Override
	public void updateLang(ProgrammingLanguage programmingLanguage,String name) {
		programmingLanguage.setName(name);
		
		
	}

	@Override
	public ProgrammingLanguage findLanguageById(int id) {
		for(ProgrammingLanguage programmingLanguage:programmingLanguages) {
			if(programmingLanguage.getId()==id) {
				return programmingLanguage;
			}
		}

		return null;
	}

	@Override
	public boolean isNotContaining(String name) {
		for(ProgrammingLanguage programmingLanguage:programmingLanguages) {
			if(programmingLanguage.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}
}
