package com.example.projects.resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.projects.repository.ImageRepository;
import com.example.projects.repository.ProjectRepository;

@Controller
public class ProjectController {

	
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	ProjectRepository projectRepository;
	
	
	@GetMapping("/")
	public String getStartPage() {
		return "index";
	}
	
	@GetMapping("/about")
	public String getAboutPage(Model model) {
		model.addAttribute("projects", projectRepository.findAll());
		return "about";
	}
	
	@GetMapping("/experience")
	public String getExperiencePage() {
		
		return "experience";
	}
	
	@GetMapping("/projects")
	public String getAllProjectsPage(Model model) {
		model.addAttribute("projects", projectRepository.findAll());
		return "projects";
	}
	
	
	@GetMapping("/project/{id}")
	public String getProjectPage(Model model , @PathVariable("id")Integer id) {
		model.addAttribute("project", projectRepository.findById(id).get());
		return "project";
	}
}
