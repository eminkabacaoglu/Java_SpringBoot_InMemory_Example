package kodlama.io.programmingLangs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.programmingLangs.entities.concretes.ProgrammingLanguage;



public interface ProgrammingLanguageRepository {
	List<ProgrammingLanguage> getAll();
	void insertLang(String name);
	void deleteLang(ProgrammingLanguage programmingLanguage);
	void updateLang(ProgrammingLanguage programmingLanguage,String name);
	ProgrammingLanguage findLanguageById(int id);
	boolean isNotContaining(String name);
}
