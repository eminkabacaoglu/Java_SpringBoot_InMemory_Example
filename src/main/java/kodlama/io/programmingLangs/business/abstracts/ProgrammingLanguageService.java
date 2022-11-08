package kodlama.io.programmingLangs.business.abstracts;

public interface ProgrammingLanguageService {

	String getAll();
	String insertLang(String name);
	String deleteLang(int id);
	String updateLang(int id,String name);
	String findLanguageById(int id);
	boolean isNameNull(String name);
}
