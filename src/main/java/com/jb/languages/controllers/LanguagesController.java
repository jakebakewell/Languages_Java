package com.jb.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jb.languages.models.Language;
import com.jb.languages.services.LanguageService;

@Controller
public class LanguagesController {
	private final LanguageService languageService;
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }
    
    @RequestMapping("/")
    public String toIndex() {
    	return "redirect:/languages";
    }
    
    @RequestMapping("/languages")
    public String index(Model model) {
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        model.addAttribute("language", new Language());
        return "index.jsp";
    }
    
    @RequestMapping(value="/languages", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
    	if (result.hasErrors()) {
            return "index.jsp";
        }
    	else {
    	languageService.createLanguage(language);
    	return "redirect:/languages";
    	}
    }
    
    @RequestMapping("/languages/{id}")
    public String showLanguage(@PathVariable("id") Long id, Model model) {
    	Language language = languageService.findLanguage(id);
    	model.addAttribute("language", language);
    	return "show.jsp";
    }
    
    @RequestMapping("/languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model) {
        Language language = languageService.findLanguage(id);
        model.addAttribute("language", language);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/languages/{id}/edit", method=RequestMethod.POST)
    public String edit(@RequestParam(value="id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
    	languageService.updateLanguage(id, name, creator, version);
    	return "redirect:/languages";
    }
    
    @RequestMapping("/languages/{id}/delete")
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}
