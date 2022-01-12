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
	public String getStartPage(Model model) {
		model.addAttribute("projects", projectRepository.findAll());
		return "index";
	}
	
	@GetMapping("/project/{id}")
	public String getProjectPage(Model model , @PathVariable("id")Integer id) {
		model.addAttribute("project", projectRepository.findById(id).get());
		return "project";
	}
}
