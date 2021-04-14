package com.jb.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jb.languages.models.Language;
import com.jb.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }
	
	public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
	
	public Language createLanguage(Language l) {
        return languageRepository.save(l);
    }
	
	public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
	
	public Language updateLanguage(Long id, String name, String creator, String version) {
    	Optional<Language> updateLanguage = languageRepository.findById(id);
    	if (updateLanguage.isPresent()) {
    		Language l = updateLanguage.get();
    		l.setName(name);
            l.setCreator(creator);
            l.setVersion(version);
            return languageRepository.save(l);
    	}
    	else {
    		return null;
    	}
    }
	
	public Language updateLanguage(Language language) {
        return languageRepository.save(language);
    }
	
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    }
}
